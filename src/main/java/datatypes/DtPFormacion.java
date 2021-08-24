package datatypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class DtPFormacion {
	private String nombre;
	private String descripcion; 
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	public DtPFormacion() {
		super();
	}
	public DtPFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaAlta = fechaAlta;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Date getFechaI() {
		return fechaI;
	}
	public Date getFechaF() {
		return fechaF;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	@Override
	public String toString() {
		return "\nNombre: " + nombre +" Descripcion:"+ descripcion +" Fecha inicio: " + fechaI+" Fecha final:"+fechaF+"Fecha Alta:"+fechaAlta+"\n";
	}
	
	
}
