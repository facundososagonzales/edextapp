package datatypes;

import java.util.Date;
import java.sql.Time;

public class DtCursoDetalle extends DtCursoBase{
	private String duracion;
	private Time cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	
	public DtCursoDetalle() {}

	public DtCursoDetalle(String nombre, String descripcion, String duracion, Time cantHoras, int creditos, Date fechaR,
			String url) {
		super(nombre, descripcion);

		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;

	}
	
	public String getDuracion() {
		return duracion;
	}
	public Time getCantHoras() {
		return cantHoras;
	}
	public int getCreditos() {
		return creditos;
	}
	public Date getFechaR() {
		return fechaR;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
