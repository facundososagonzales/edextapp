package datatypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtEdicionBase {
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupos;
	
	public DtEdicionBase() {}

	public DtEdicionBase(String nombre, Date fechaI, Date fechaF, int cupos) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.cupos = cupos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaI() {
		return fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	public Date getFechaF() {
		return fechaF;
	}

	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}
	
	@Override
	public String toString() {
		return "\nNombre: " + nombre + " Fecha inicio: " + fechaI+" Fecha final:"+fechaF+" Cantidad de cupos:"+cupos+"\n";
	}
	
}
