import java.io.Closeable;
import java.sql.*;

public class DBOrder implements Closeable {
    private Connection connection;

    DBOrder() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBOrder", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String name, String phone) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Client (Name, Telephone) VALUE (?,?)")) {
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(String name, int price, int count) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO Product (Name, Price,Count) VALUE (?,?,?)")) {
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, count);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addOrder(int idClient, int idProduct) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO `Order` (idClient, idProduct) VALUE (?,?)")) {
            ps.setInt(1, idClient);
            ps.setInt(2, idProduct);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(String clientName, String productName) {
        try (PreparedStatement psClient = connection.prepareStatement("SELECT id FROM Client WHERE Name = ?")) {
            try (PreparedStatement psProduct = connection.prepareStatement("SELECT id FROM Product WHERE Name = ?")) {
                psClient.setString(1, clientName);
                psProduct.setString(1, productName);
                addOrder(getIdFromResult(psClient), getIdFromResult(psProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIdFromResult(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void productList() {
        try (Statement s = connection.createStatement()) {
            ResultSet rs = s.executeQuery("SELECT * FROM Product");
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean productIsExists(String product) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Product WHERE Name = ?")){
            statement.setString(1,product);
            ResultSet rs =statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
