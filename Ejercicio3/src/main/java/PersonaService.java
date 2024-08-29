import java.sql.SQLException;
import java.util.List;

public class PersonaService {
    private final PersonaDAO personaDAO;

    public PersonaService(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void crearTablaPersona() throws SQLException {
        personaDAO.crearTablaPersona();
    }

    public void agregarPersona(Persona persona) throws SQLException {
        personaDAO.agregarPersona(persona);
    }

    public List<Persona> obtenerTodasLasPersonas() throws SQLException {
        return personaDAO.obtenerTodasLasPersonas();
    }
}