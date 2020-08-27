package logica;

import datatypes.DtFecha;
import datatypes.DtTime;

public class Curso {
	private String nombre;
	private String descripcion;
	private String duracion;
	private DtTime cantHoras;
	private int creditos;
	private DtFecha fechaR;
	private String url;
		
	public Curso() {
		super();
	}

	public Curso(String nombre, String descripcion, String duracion, DtTime cantHoras, int creditos, DtFecha fechaR,
			String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public DtTime getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(DtTime cantHoras) {
		this.cantHoras = cantHoras;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public DtFecha getFechaR() {
		return fechaR;
	}

	public void setFechaR(DtFecha fechaR) {
		this.fechaR = fechaR;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
}
