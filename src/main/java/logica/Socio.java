package logica;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Socio {
	@Id
	private String nombre;
	
	public Socio(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

