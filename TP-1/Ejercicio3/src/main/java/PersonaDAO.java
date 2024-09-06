import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    public void crearTablaPersona() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS persona (" +
                "id INT PRIMARY KEY, " +
                "nombre VARCHAR(500), " +
                "edad INT)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }

    public void agregarPersona(Persona persona) throws SQLException {
        String sql = "INSERT INTO persona(id, nombre, edad) VALUES(?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getNombre());
            ps.setInt(3, persona.getEdad());
            ps.executeUpdate();
        }
    }

    public List<Persona> obtenerTodasLasPersonas() throws SQLException {
        String sql = "SELECT * FROM persona";
        List<Persona> personas = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                personas.add(new Persona(id, nombre, edad));
            }
        }
        return personas;
    }
}