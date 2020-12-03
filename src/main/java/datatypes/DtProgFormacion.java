package datatypes;


import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class DtProgFormacion{
	private String descripcion; 
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	
	public DtProgFormacion() {}

	public DtProgFormacion(String descripcion, Date fechaI, Date fechaF, Date fechaAlta) {
		this.setDescripcion(descripcion);
		this.setFechaAlta(fechaAlta);
		this.setFechaF(fechaF);
		this.setFechaI(fechaI);
		}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}