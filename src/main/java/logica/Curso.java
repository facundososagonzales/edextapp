package logica;

import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtEdicionBasico;
import datatypes.DtEdicionDetalle;

@Entity
public class Curso {
	@Id
	private String nombre;
	private String descripcion;
	private String duracion;
	private Time cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Curso>previas = new ArrayList<>();
	@OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
	private List<Edicion>ediciones = new ArrayList<>();
	@ManyToOne
	private Instituto instituto;
	
	public Curso() {
		super();
	}
	
	public Curso(String nombre, String descripcion, String duracion, Time cantHoras, int creditos, Date fechaR,
			String url,Instituto instituto) {
		
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.instituto=instituto;
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

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}
	
	public void setEdicion(Edicion e) {
		this.ediciones.add(e);
	}

	public List<Curso> getPrevias() {
		return previas;
	}

	public void setPrevias(List<Curso> previas) {
		this.previas = previas;
	}

	public List<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	
	public DtCursoBase getDtCursoBase() {
		return new DtCursoBase(this.getNombre(),this.getDescripcion());
	}
	
	public DtCursoDetalle1 getDtCursoDetalle() {
		ArrayList<DtEdicionBasico> dtEdiciones = new ArrayList <>();
		for(Edicion e: ediciones) {
			dtEdiciones.add(e.getInfoBase());
		}
		
		ArrayList<String> previasC= new ArrayList<>();
		for(Curso c: this.previas) {
			previasC.add(c.getNombre());
		}
		
		return new DtCursoDetalle1(this.getNombre(),this.getDescripcion(),this.getDuracion(),this.getCantHoras(),this.getCreditos(),this.getFechaR(),this.getUrl(),previasC,dtEdiciones);
		
	}
	
	public DtEdicionDetalle obtenerDtEdicionDetalle(String nom) {
		DtEdicionDetalle aux = null;
		for(Edicion e: ediciones) {
			if(e.getNombre().equals(nom)) {
				aux = e.getDtEdicionDetalle();
			}
		}
		return aux;
	}
	
}
