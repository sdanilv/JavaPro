import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Menu")
public class Dish {
    @Id
    private String name;
    private int price;
    private int weight;
    private boolean sale;


    public int getWeight() {
        return weight;
    }

    public Dish() {
    }

    public Dish(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}

