import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/Product";

    public static void main(String[] args) {
        createTable();
        insertProduct(new Product(0, "Product1", 10.5, true));
        insertProduct(new Product(0, "Product2", 20.0, false));
        List<Product> products = getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Product (" +
                "id SERIAL PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "price_per_unit REAL NOT NULL, " +
                "active_for_sell BOOLEAN NOT NULL" +
                ");";

        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Product table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertProduct(Product product) {
        String sql = "INSERT INTO Product(name, price_per_unit, active_for_sell) VALUES(?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPricePerUnit());
            pstmt.setBoolean(3, product.isActiveForSell());
            pstmt.executeUpdate();
            System.out.println("Product inserted: " + product);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Product> getAllProducts() {
        String sql = "SELECT id, name, price_per_unit, active_for_sell FROM Product";
        List<Product> products = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPricePerUnit(rs.getDouble("price_per_unit"));
                product.setActiveForSell(rs.getBoolean("active_for_sell"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
}
