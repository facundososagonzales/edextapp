package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Time;

public class Curso {
	private String nombre;
	private String descripcion;
	private String duracion;
	private Time cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	private List<Edicion>ediciones = new ArrayList<>();
	private List<Curso>previas = new ArrayList<>();
		
	public Curso() {
		super();
	}

	public Curso(String nombre, String descripcion, String duracion, Time cantHoras, int creditos, Date fechaR,
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

	public Time getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(Time cantHoras) {
		this.cantHoras = cantHoras;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Date getFechaR() {
		return fechaR;
	}

	public void setFechaR(Date fechaR) {
		this.fechaR = fechaR;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}

	public List<Curso> getPrevias() {
		return previas;
	}

	public void setPrevias(List<Curso> previas) {
		this.previas = previas;
	}
	
	
	
	
	
}
