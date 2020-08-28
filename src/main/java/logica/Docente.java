package logica;

import java.util.Date;

public class Docente extends Usuario{
	Instituto instituto;

	public Docente() {
		super();
		
	}

	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac,Instituto instituto) {
		super(nick, nombre, apellido, correo, fechaNac);
		
	}

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	

}
