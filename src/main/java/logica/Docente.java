package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Docente extends Usuario{
	@OneToOne
	Instituto instituto;

	public Docente() {
		super();
		
	}

	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac,Instituto instituto) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.instituto=instituto;
		
	}

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	

}
