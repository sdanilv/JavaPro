import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Course {
    @Id
    private String name;
    private Date date;
    private double usd;
    private double eur;
    private double uah;

    public Course() {
    }

    Course(String name, double USD, double EUR, double UAH) {
        name = name;
        usd = USD;
        eur = EUR;
        uah = UAH;
    }

    public double exchange(String to,int count){
        if (to.equalsIgnoreCase("usd"))
            return count*usd;
        if (to.equalsIgnoreCase("eur"))
            return count*eur;
        if(to.equalsIgnoreCase("uah"))
            return count*uah;
        return 0;
    }
}
