import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DBBank {
    private EntityManager em;
    private EntityManagerFactory emf;

    DBBank() {
        emf = Persistence.createEntityManagerFactory("JDBC");
        em = emf.createEntityManager();
    }

    public void addUser(User user) {
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void upBalance(String passport, double amount, byte course) {
        Account account = getAccount(passport, course);
        account.appBalance(amount);
        em.getTransaction().begin();
        try {
            em.persist(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void transfer(String passportFrom,  String passportTo, double amount, byte course) {
        Account from = getAccount(passportFrom, course);
        Account to = getAccount(passportTo, course);
        addTransfer(new Transfer(from,to,amount,course));
        em.getTransaction().begin();
        try {
            from.appBalance(-amount);
            to.appBalance(amount);
            em.persist(from);
            em.persist(to);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void addTransfer(Transfer transfer) {
        em.getTransaction().begin();
        try {
            em.persist(transfer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }


    public void currencyConversion(String passport, byte courseFrom, byte courseTo, double amount, ExchangeRate exchangeRate){
        Account from = getAccount(passport, courseFrom);
        Account to = getAccount(passport, courseTo);
        addTransfer(new Transfer(from,to,amount,courseFrom));
        em.getTransaction().begin();
        try {
            from.appBalance(-amount);
            amount = exchangeRate.exchange(courseFrom, courseTo,amount);
            to.appBalance(amount);
            em.persist(from);
            em.persist(to);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void allMoneyOfUser(String passport, ExchangeRate exchangeRate){
        Query query = em.createQuery("select a from Account a where user.passport = :passport");
        query.setParameter("passport", passport);
        List<Account> accounts = query.getResultList();
        double sum = 0;
        for (Account account : accounts)
            sum += exchangeRate.exchangeToUAH(account.getCourse(), account.getCount());
        System.out.println(sum);
    }


    public void  persistExchangeRate(ExchangeRate exchangeRate){
        em.getTransaction().begin();
        try {
            em.persist(exchangeRate);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    private Account getAccount(String passport, byte course) {
        Query query = em.createQuery("select a from Account a where user.passport = :passport and course = :course");
        query.setParameter("passport", passport);
        query.setParameter("course", course);
        return (Account) query.getSingleResult();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
