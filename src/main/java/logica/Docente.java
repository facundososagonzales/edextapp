package logica;

import datatypes.DtFecha;

public class Docente extends Usuario{

	public Docente() {
		super();
		
	}

	public Docente(String nick, String nombre, String apellido, String correo, DtFecha fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
		
	}
	

}
