package datatypes;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtWebCurso {
	private String nombre;
	private Date fechaPub;
	public DtWebCurso() {
		super();
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
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
