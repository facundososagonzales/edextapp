package logica;

import datatypes.DtFecha;

public class ProgFormacion {
	private String nombre;
	private String descripcion; 
	private DtFecha fechaI;
	private DtFecha fechaF;
	private DtFecha fechaAlta;
	//falta link
	public ProgFormacion() {
		super();
	}
	public ProgFormacion(String nombre, String descripcion, DtFecha fechaI, DtFecha fechaF, DtFecha fechaAlta) {
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public DtFecha getFechaI() {
		return fechaI;
	}
	public void setFechaI(DtFecha fechaI) {
		this.fechaI = fechaI;
	}
	public DtFecha getFechaF() {
		return fechaF;
	}
	public void setFechaF(DtFecha fechaF) {
		this.fechaF = fechaF;
	}
	public DtFecha getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(DtFecha fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
	
	

}
