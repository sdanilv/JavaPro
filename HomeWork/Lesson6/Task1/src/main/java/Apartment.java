import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Apartment {
    @Id
    String adress;
    String district;
    int price;
    int countRoom;
    int area;

    public Apartment() {
    }

    public Apartment(String adress, String district, int price, int countRoom, int area) {
        this.adress = adress;
        this.district = district;
        this.price = price;
        this.countRoom = countRoom;
        this.area = area;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "adress='" + adress + '\'' +
                ", district='" + district + '\'' +
                ", price=" + price +
                ", countRoom=" + countRoom +
                ", area=" + area +
                '}';
    }

}
