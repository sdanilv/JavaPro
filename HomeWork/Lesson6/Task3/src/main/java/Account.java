import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double count;
    private byte course;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @OneToMany(mappedBy = "fromAccount"/*,cascade = CascadeType.ALL*/)
    List<Transfer> transactions = new ArrayList<>();

    public  Account(){}

    public Account(byte course, int startCount) {
        this.count = startCount;
        this.course = course;
    }

    public double getCount(){
        return count;
    }

    public byte getCourse() {
        return course;
    }

    public void appBalance(double amount){
        count = count+amount;
    }
}
