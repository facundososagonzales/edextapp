package logica;

import java.util.Date;

public class InscripcionEdi {
	private Date fechaIns;
	private Edicion edicion;
	
	
	
	public InscripcionEdi(Date fechaIns) {
		super();
		this.fechaIns = fechaIns;
	}
	public Date getFechaIns() {
		return fechaIns;
	}
	public void setFechaIns(Date fechaIns) {
		this.fechaIns = fechaIns;
	}
	public Edicion getEdicion() {
		return edicion;
	}
	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}
	
	
}
