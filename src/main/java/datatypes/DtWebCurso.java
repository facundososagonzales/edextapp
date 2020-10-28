package datatypes;

import java.util.Date;

public class DtWebCurso {
	private String nombre;
	private Date fechaPub;
	public DtWebCurso() {
		super();
	}
	
	
	public DtWebCurso(String nombre, Date fechaPub) {
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
