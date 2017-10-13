
public class Apartment {

    private String adress;
    private String district;
    private int price;
    private int countRoom;
    private int area;

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

    public String getAdress() {
        return adress;
    }

    public String getDistrict() {
        return district;
    }

    public int getPrice() {
        return price;
    }

    public int getCountRoom() {
        return countRoom;
    }

    public int getArea() {
        return area;
    }

}
