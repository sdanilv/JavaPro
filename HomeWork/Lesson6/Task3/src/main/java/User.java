import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private String passport;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List <Account> accounts  = new ArrayList<>();

    void addAccount(Account account){
        account.user = this;
        accounts.add(account);
    }

    public User(String passport, String name,Account account) {
        this.passport = passport;
        this.name = name;
        addAccount(account);
    }

    public User(){}
}
