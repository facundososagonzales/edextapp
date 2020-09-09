package logica;

import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtEdicionBase;
import datatypes.DtEdicionDetalle;
import datatypes.DtPFormacion;
import datatypes.DtProgCurso;

public class Curso {
	private String nombre;
	private String descripcion;
	private String duracion;
	private Time cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	private List<Curso>previas = new ArrayList<>();
	private List<ProgFormacion> progsFormacion = new ArrayList<>();
	private List<Edicion>ediciones = new ArrayList<>();
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
	
	public void setPFormacion(ProgFormacion p) {
		this.progsFormacion.add(p);
	}
	
	public DtCursoBase getDtCursoBase() {
		return new DtCursoBase(this.getNombre(),this.getDescripcion());
	}
	
	public DtCursoDetalle1 getDtCursoDetalle() {
		ArrayList<DtEdicionBase> dtEdiciones = new ArrayList <>();
		ArrayList<DtPFormacion> dtProgramas = new ArrayList <>();
		for(Edicion e: ediciones) {
			dtEdiciones.add(e.getDtEdicionBase());
		}
		
		for(ProgFormacion p: progsFormacion) {
			dtProgramas.add(p.getDtPFormacion());			
		}
		
		return new DtCursoDetalle1(this.getNombre(),this.getDescripcion(),this.getDuracion(),this.getCantHoras(),this.getCreditos(),this.getFechaR(),this.getUrl(),dtProgramas, dtEdiciones);
		
	}
	
	public DtProgCurso obtenerDtProgCurso(String nom) {
		DtProgCurso aux = null;
		for(ProgFormacion p: progsFormacion) {
			if(p.getNombre().equals(nom)) {
				aux = p.getProgCurso();
			}
		}
		return aux;
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
