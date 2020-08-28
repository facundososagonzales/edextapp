package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.Curso;

import java.sql.Time;

public class DtCursoDetalle extends DtCursoBase {
	private String duracion;
	private Time cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	private List<Curso>previas = new ArrayList<>();
	
	public DtCursoDetalle() {}
	
	public DtCursoDetalle(String duracion, Time cantHoras, int creditos, Date fechaR, String url, List<Curso> previas) {
		super();
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.previas = previas;
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

	public List<Curso> getPrevias() {
		return previas;
	}

	public void setPrevias(List<Curso> previas) {
		this.previas = previas;
	}
	
	

}
