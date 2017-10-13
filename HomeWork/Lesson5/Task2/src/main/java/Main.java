import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String name;
    static String phone;
    static DBOrder db;

    public static void main(String[] args) {
        start();
        end();
    }

    private static void mainAdminCircle() {
        while (readString().equals("y")) {
            System.out.println("You want add new product? (y/n)");
            System.out.println("What is the name of a product?");
            String name = readString();
            System.out.println("What is the price of a product?");
            int price = Integer.parseInt(readString());
            System.out.println("What is the count of a product?");
            int count = Integer.parseInt(readString());
            db.addProduct(name, price, count);
        }

    }

    private static void start() {
        db = new DBOrder();
        System.out.println("Write your name");
        name = readString();
        System.out.println("Write your telephone");
        phone = readString();
        if(name.equals("admin")&&phone.equals("admin"))
            mainAdminCircle();
        else mainClientCircle();
    }

    private static void mainClientCircle() {

        db.addUser(name, phone);
        while (true) {
            System.out.println("What do you wont to buy");
            db.productList();
            String product = readString();
            if (product.equals("")||!db.productIsExists(product)) break;
            db.addOrder(name, product);
        }
    }

    private static String readString() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            return bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void end() {
        db.close();
    }
}
