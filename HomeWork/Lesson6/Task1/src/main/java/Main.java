import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    static RoomData rooms;

    public static void main(String[] args) {
        rooms = new RoomData();
        mainCircle();
    }

    private static void mainCircle() {
        try {
            while (true) {
                System.out.println("Search for:\n" +
                        " address press 1\n" +
                        " district press 2\n" +
                        " price press 3\n" +
                        " count of room press 4\n" +
                        " area  press 5\n");
                switch (readIntFromConsole()) {
                    case 1:
                        System.out.println("Enter address:");
                        rooms.searchApartmentForAddress(readFromConsole());
                        break;
                    case 2:
                        System.out.println("Enter district:");
                        rooms.searchApartmentForDistrict(readFromConsole());
                        break;
                    case 3:
                        System.out.println("Enter price:");
                        rooms.searchApartmentForPrice(readIntFromConsole());
                        break;
                    case 4:
                        System.out.println("Enter count of room:");
                        rooms.searchApartmentForCountRoom(readIntFromConsole());
                        break;
                    case 5:
                        System.out.println("Enter area:");
                        rooms.searchApartmentForArea(readIntFromConsole());
                        break;
                    default:
                        rooms.close();
                }
            }
        } finally {
            rooms.close();
        }
    }

    private static String readFromConsole() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int readIntFromConsole() {
        try {
            return Integer.parseInt(readFromConsole());
        } catch (NumberFormatException e) {
            return 99;
        }
    }

}
