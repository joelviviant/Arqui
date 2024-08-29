import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Select {

    public static void main(String[] args) {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String uri = "jdbc:derby:MyDerbyDb;create=true";

        try {
            Connection conn = DriverManager.getConnection(uri);
            String sql = "select * from persona";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
