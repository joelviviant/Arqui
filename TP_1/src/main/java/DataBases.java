import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBases {

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
            createTables(conn);
            agregarPersona(conn, 1, "Juan", 20);
            agregarPersona(conn, 2, "Maria", 30);
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void agregarPersona(Connection conn, int id, String nombre, int edad) throws SQLException {
        String insert = "INSERT INTO persona(id, nombre, edad) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setInt(3, edad);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }

    private static void createTables(Connection conn) throws SQLException {
        String table = "CREATE TABLE persona(" + " id INT," + "nombre VARCHAR(500)," + "edad INT," + "PRIMARY KEY (id))";
        conn.prepareStatement(table).execute();
        conn.commit();
    }
}
