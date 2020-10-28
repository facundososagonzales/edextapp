package datatypes;

import java.util.Date;

public class DtWebProgF {
	private String nombre;
	private Date fechaPub;
	public DtWebProgF() {
		super();
	}
	
	
	public DtWebProgF(String nombre, Date fechaPub) {
		super();
		this.nombre = nombre;
		this.fechaPub = fechaPub;
	}


	public String getNombre() {
		return nombre;
	}
	public Date getFechaPub() {
		return fechaPub;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nFecha de Publicacion: " + fechaPub+"\n";
	}

}
