import javax.persistence.*;

import java.util.Date;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne()
    Account fromAccount;
    @ManyToOne()
    Account toAccount;
    Date date;
    double transferSize;
    byte course;

    public Transfer() {
    }

    public Transfer(Account fromAccount, Account toAccount, double match, byte course) {
        this.fromAccount = fromAccount;
        fromAccount.transactions.add(this);
        this.toAccount = toAccount;
        toAccount.transactions.add(this);
        this.date = new Date();
        this.transferSize = match;
        this.course = course;

    }
}
