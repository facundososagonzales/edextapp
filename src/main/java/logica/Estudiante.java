package logica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Estudiante extends Usuario{

	public Estudiante() {
		super();
	}

	public Estudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
		
	}
	

}
