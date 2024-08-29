import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConnectionFactory {
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String URI = "jdbc:mysql://localhost:3306/db";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        static {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Error loading JDBC Driver", e);
            }
        }

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URI, USER, PASSWORD);
        }
    }

