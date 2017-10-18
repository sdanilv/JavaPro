import javax.persistence.*;
import java.util.Date;

@Entity
public class ExchangeRate {

    public static final byte USD = 0;
    public static final byte EUR = 1;
    public static final byte UAH = 2;

    @Id
    private Date date;
    private double USDCourse;
    private double EURCourse;
    private double UAHCourse;

    public double exchange(byte from, byte to, double count) {
        if (to == ExchangeRate.UAH)
            return exchangeToUAH(from, count);
        if (to == ExchangeRate.EUR)
            return exchangeToUAH(from, count);
        return exchangeToUAH(from, count);
    }


    private double exchangeToUSD(byte from, double count) {
        if (from == ExchangeRate.EUR)
            return count * EURCourse/USDCourse;
        if (from == ExchangeRate.UAH)
            return count / USDCourse;
        return count;
    }

    private double exchangeToEUR(byte from, double count) {
        if (from == ExchangeRate.USD)
            return count * USDCourse/UAHCourse;
        if (from == ExchangeRate.UAH)
            return count / EURCourse;
        return count;
    }

    public double exchangeToUAH(byte from, double count) {
        if (from == ExchangeRate.EUR)
            return count * EURCourse;
        if (from == ExchangeRate.USD)
            return count *USDCourse;
        return count;
    }

    public ExchangeRate() {
    }

    public ExchangeRate(Date date, double USDCourse, double EURCourse, double UAHCourse) {
        this.date = date;
        this.USDCourse = USDCourse;
        this.EURCourse = EURCourse;
        this.UAHCourse = UAHCourse;
    }
}
