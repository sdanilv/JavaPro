import java.util.Date;

public class Main {
    private static final String USER_ID_1 = "JK888761";
    private static final String USER_ID_2 = "LF698132";
    private static DBBank db;
    private static ExchangeRate exchangeRate;

    public static void main(String[] args) {
        init();
        start();
    }

    private static void init() {

        db = new DBBank();
        exchangeRate = new ExchangeRate(new Date(), 26.16, 31.53, 1);
        User user = new User(USER_ID_1, "A", new Account(ExchangeRate.UAH, 2000));
        user.addAccount(new Account(ExchangeRate.EUR, 250));
        User user1 = new User(USER_ID_2, "B", new Account(ExchangeRate.UAH, 2000));
        db.addUser(user);
        db.addUser(user1);

    }

    private static void start() {
        try {
            db.persistExchangeRate(exchangeRate);
            db.upBalance(USER_ID_1, 100, ExchangeRate.UAH);//пополнение счета
            db.transfer(USER_ID_1, USER_ID_2, 112.12, ExchangeRate.UAH);//перевод со счета на счета
            db.currencyConversion(USER_ID_1, ExchangeRate.EUR, ExchangeRate.UAH, 100, exchangeRate);//конвертация валюты
            db.allMoneyOfUser(USER_ID_1, exchangeRate);//вывести все деньги
        } finally {
            db.close();
        }
    }
}
