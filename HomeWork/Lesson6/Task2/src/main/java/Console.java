import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static DBMenu db = new DBMenu();

    private static String readString() {
        try {
            return bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void start() {
        try {
            System.out.println("Please write number:\n" +
                    "1 for add dish\n" +
                    "2 for view dish in price range\n" +
                    "3 for view dish with sale\n" +
                    "4 view dish who weight sum = 1kg");
            switch (readInt()) {
                case 1:
                    add();
                    break;
                case 2:
                    range();
                    break;
                case 3:
                    db.lookWithSale();
                    break;
                case 4:
                    db.seeRandomKilo();
                    break;
            }
            System.out.println("Do you wont some thing else?(y/n)");
            if (readString().equals("y")) start();
        } finally {
            db.close();
        }
    }

    private static void range() {
        System.out.println("Set min price");
        int min = readInt();
        System.out.println("Set maximum");
        int max = readInt();
        db.lookFromToPrice(min, max);
    }

    private static void add() {
        System.out.println("write name");
        String name = readString();
        System.out.println("write price");
        int price = readInt();
        System.out.println("write weight");
        int weight = readInt();
        System.out.println("Have sail?");
        boolean sale = false;
        if (readString().equals("y")) sale = true;
        db.addDish(name, price, weight, sale);
    }
}
