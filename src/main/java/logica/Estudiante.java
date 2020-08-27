package logica;

import datatypes.DtFecha;

public class Estudiante extends Usuario{

	public Estudiante() {
		super();
	
	}

	public Estudiante(String nick, String nombre, String apellido, String correo, DtFecha fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
		
	}
	

}
