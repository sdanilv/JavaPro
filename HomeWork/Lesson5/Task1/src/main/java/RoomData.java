import javax.persistence.Query;
import java.sql.*;
import java.util.List;


public class RoomData {
    Connection connection;

    RoomData() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addApartmentWithRandomParam(int count) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Apartment VALUES (?,?,?,?,?)");
            for (int i = 0; i < count; i++) {
                Apartment apartment = ApartmentBuilder.createApartmentWithRandomParam();
                ps.setString(1, apartment.getAdress());
                ps.setString(2, apartment.getDistrict());
                ps.setInt(3, apartment.getPrice());
                ps.setInt(4, apartment.getCountRoom());
                ps.setInt(5, apartment.getArea());
            }
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchApartmentForPrice(int price) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * FROM Apartment WHERE price = ?");
            ps.setInt(1, price);
            ResultSet rs = ps.executeQuery();
            seeApartment(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void searchApartmentForArea(int area) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * FROM Apartment WHERE area = ?");
            ps.setInt(1, area);
            ResultSet rs = ps.executeQuery();
            seeApartment(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void searchApartmentForCountRoom(int countRoom) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * FROM Apartment WHERE countRoom = ?");
            ps.setInt(1, countRoom);
            ResultSet rs = ps.executeQuery();
            seeApartment(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchApartmentForDistrict(String district) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * FROM Apartment WHERE district = ?");
            ps.setString(1, district);
            ResultSet rs = ps.executeQuery();
            seeApartment(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchApartmentForAddress(String address) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * FROM Apartment WHERE adres = ?");
            ps.setString(1, address);
            ResultSet rs = ps.executeQuery();
            seeApartment(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void seeApartment(ResultSet rs) {
        try {
            System.out.println("---------------------------------------------------------------------------------");
            while (rs.next()) {
                Apartment apartment = new Apartment(rs.getString("adress"), rs.getString("district"),
                        rs.getInt("price"), rs.getInt("countRoom"), rs.getInt("area"));
                System.out.println(apartment);
            }
            System.out.println("---------------------------------------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //    public void searchApartmentForParam(String param, int count) {

    //        query.setParameter("param", "a."+param);
    //        Query query = em.createQuery("select a from Apartment a where :param=:count", Apartment.class);
    //        query.setParameter("count", count);
    //        List<Apartment> apartments = (List<Apartment>) query.getResultList();
    //        for (Apartment apartment : apartments) {
    //            System.out.println(apartment);
    //        }
    //    }
}
