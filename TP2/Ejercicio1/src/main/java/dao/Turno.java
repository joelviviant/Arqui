package dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private LocalDate fecha;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Persona> jugadores;
	
	public Turno() {
		super();
	}

	public Turno(LocalDate fecha) {
		super();
		this.fecha = fecha;
		this.jugadores = new ArrayList<Persona>();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public List<Persona> getJugadores() {
		return jugadores;
	}

	@Override
	public String toString() {
		return "Turnos [id=" + id + ", fecha=" + fecha + ", jugadores=" + jugadores + "]";
	}


}
