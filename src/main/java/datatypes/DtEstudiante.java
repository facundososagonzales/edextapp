package datatypes;

import java.util.Date;

public class DtEstudiante extends DtUsuario {
	Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public DtEstudiante() {
		// TODO Auto-generated constructor stub
	}

	public DtEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
		// TODO Auto-generated constructor stub
	}
	
	public DtEstudiante(String nick, String nombre, String apellido, String correo, Date fechaNac, Estado estado) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.estado=estado;
	}
	
	

}
