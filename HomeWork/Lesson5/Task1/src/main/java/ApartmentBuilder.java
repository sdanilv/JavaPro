import java.util.Random;

public class ApartmentBuilder {
    static Random r = new Random();

    private ApartmentBuilder() {
    }

    public static Apartment createApartmentWithRandomParam() {

        return new Apartment(randomAddress(), randomWord(),
                (1 + r.nextInt(3)) * 1000, 1 + r.nextInt(2), (1 + r.nextInt(5)) * 10);
    }

    public static Apartment createApartmentForDistrict(String district) {
        return new Apartment(randomAddress(), district,
                (1 + r.nextInt(3)) * 1000, 1 + r.nextInt(4), (1 + r.nextInt(5)) * 10);
    }

    public static Apartment createApartmentForAddress(String address) {
        return new Apartment(address, randomWord(),
                (1 + r.nextInt(3)) * 1000, 1 + r.nextInt(2), (1 + r.nextInt(5)) * 10);
    }

    private static String randomAddress() {
        StringBuilder builder = new StringBuilder("Street ");
        builder.append(randomWord()).append(" " + r.nextInt(100)).append(", room " + r.nextInt(200));
        return builder.toString();
    }

    private static String randomWord() {
        StringBuilder stringBuilder = new StringBuilder();
        char c = (char) ('A' + r.nextInt(26));
        for (int i = 0; i < 3 + r.nextInt(10); i++) {
            stringBuilder.append(c);
            c = (char) ('a' + r.nextInt(26));
        }
        return stringBuilder.toString();
    }
}
