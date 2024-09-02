import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        PersonaService personaService = new PersonaService(personaDAO);

        try {
            // Crear tabla persona
            personaService.crearTablaPersona();

            // Agregar personas
            personaService.agregarPersona(new Persona(1, "Juan", 20));
            personaService.agregarPersona(new Persona(2, "Maria", 30));

            // Obtener todas las personas
            List<Persona> personas = personaService.obtenerTodasLasPersonas();
            personas.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}