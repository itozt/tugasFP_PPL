import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// --- DatabaseUtil.java ---
public class DatabaseUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/PVT";
    private static final String USER = "postgres";
    private static final String PASSWORD = "christo888";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Gagal terhubung ke database PostgreSQL:");
            System.err.println("URL: " + URL);
            System.err.println("User: " + USER);
            System.err.println("Error: " + e.getMessage());
            throw e; 
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error menutup koneksi database: " + e.getMessage());
            }
        }
    }
}
