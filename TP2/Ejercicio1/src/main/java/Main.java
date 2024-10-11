import dao.Direccion;
import dao.Persona;
import dao.Socio;
import dao.Turno;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			// Insertar una nueva dirección
			Direccion direccion = insertarDireccion(em, "Calle 123", "Ciudad ABC");

			// Insertar una nueva persona vinculada a la dirección
			Persona persona = insertarPersona(em, "Juan Pérez", 30, direccion);

			// Insertar un nuevo socio asociado a la persona
			Socio socio = insertarSocio(em, persona, "Regular");

			// Insertar un nuevo turno
			Turno turno = insertarTurno(em, new Date());

			em.getTransaction().commit();
			System.out.println("Datos insertados exitosamente.");

		} catch (Exception e) {
			System.err.println("Error durante la transacción: " + e.getMessage());
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

	// Método para insertar una dirección
	public static Direccion insertarDireccion(EntityManager em, String calle, String ciudad) {
		Direccion direccion = new Direccion();
		direccion.setCalle(calle);
		direccion.setCiudad(ciudad);
		em.persist(direccion);
		System.out.println("Dirección persistida: " + calle + ", " + ciudad);
		return direccion;
	}

	// Método para insertar una persona
	public static Persona insertarPersona(EntityManager em, String nombre, int años, Direccion direccion) {
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setEdad(años);
		persona.setDomicilio(direccion); // Asegúrate de que este método funcione correctamente
		em.persist(persona);
		System.out.println("Persona persistida: " + nombre);
		return persona;
	}

	// Método para insertar un socio
	public static Socio insertarSocio(EntityManager em, Persona persona, String tipo) {
		Socio socio = new Socio();
		socio.setPersona(persona);
		socio.setTipo(tipo);
		em.persist(socio);
		System.out.println("Socio persistido: " + tipo);
		return socio;
	}

	// Método para insertar un turno
	public static Turno insertarTurno(EntityManager em, Date fecha) {
		Turno turno = new Turno();
		turno.setFecha(LocalDate.from(fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())); // Convierte Date a LocalDateTime
		em.persist(turno);
		System.out.println("Turno persistido en la fecha: " + fecha);
		return turno;
	}
}