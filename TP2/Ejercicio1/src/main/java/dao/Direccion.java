package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Direccion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String ciudad;
	@Column
	private String calle;
	@OneToMany(mappedBy="domicilio", fetch=FetchType.LAZY)
	private List<Persona> habitantes;
	
	public Direccion() {
		super();
		this.habitantes = new ArrayList<Persona>();
	}

	public Direccion(String ciudad, String calle) {
		super();
		this.ciudad = ciudad;
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getId() {
		return id;
	}

	public List<Persona> getHabitante() {
		return habitantes;
	}

	public void setHabitante(Persona habitante) {
		habitantes.add(habitante);
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", calle=" + calle + "]";
	}

}
