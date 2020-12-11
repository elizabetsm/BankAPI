import org.junit.Test;
import sber.api.User;

import java.sql.*;

public class TestDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String CREATE_TABLES = "DROP TABLE IF EXISTS cards; DROP TABLE IF EXISTS users; " +

            "CREATE TABLE users( user_id INT GENERATED ALWAYS AS IDENTITY,"  +
            "user_name VARCHAR(255) NOT NULL, PRIMARY KEY(user_id) );" +

            "CREATE TABLE cards( card_id INT," +
             "customer_id INT, PRIMARY KEY(card_id)," +
                "FOREIGN KEY(card_id) REFERENCES users(user_id));" +

            "INSERT INTO users(user_name) VALUES('Lizka'), ('pipiska'), ('Masha'); " +
            "INSERT INTO cards(card_id, customer_id) " +
            "VALUES(1, 1), " +
            "(2, 2), " +
            "(3, 3);";

    private static final String GET_ALL = "SELECT * FROM users , cards";

    @Test
    public void Test1() {
        try (java.sql.Connection conn = DriverManager.getConnection(URL)) {
            PreparedStatement ps = conn.prepareStatement(CREATE_TABLES);
                int rs = ps.executeUpdate();
                if (rs == 0) {
                    System.out.println("Succes");
                }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try (java.sql.Connection conn = DriverManager.getConnection(URL)) {
            PreparedStatement ps = conn.prepareStatement(GET_ALL);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User(rs.getString(2), rs.getInt(3),
                            rs.getInt(4));
                    System.out.println(user.toString());
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
