package Lesson2.Task2;

public class Address {
    public String country;
    public String city;
    public String street;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
