package logica;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtInfoPFormacion;
import datatypes.DtPFormacion;
import datatypes.DtProgCurso;
@Entity
public class ProgFormacion {
	@Id
	private String nombre;
	private String descripcion; 
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Curso> cursos = new ArrayList<>();
	
	public ProgFormacion() {
		super();
	}
	public ProgFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaAlta) {
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
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	public DtPFormacion getDtPFormacion() {
		return new DtPFormacion(this.getNombre(),this.getDescripcion(),this.getFechaI(),this.getFechaF(),this.getFechaAlta());
		
	}
	
	public DtInfoPFormacion getDtInfoPFormacion() {
		return new DtInfoPFormacion(this.getNombre(),this.getDescripcion());
	}
	
	public void addCurso(Curso c) {
		this.cursos.add(c);
	}
	
	public List<Curso> obtenerCursos() {
		return cursos;
	}
	
	public Curso buscarCurso(String nombre) {
		Curso aRet = null;
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre)) {
				aRet = c;
			}
	
		}
		return aRet;	
	}

	public DtProgCurso getProgCurso() {
		ArrayList<DtCursoBase> dtCursos = new ArrayList<>();
		for(Curso c: cursos) {
			dtCursos.add(c.getDtCursoBase());
		}		
		return new DtProgCurso(this.getNombre(), this.getDescripcion(), this.getFechaI(), this.getFechaF(), dtCursos);
		
	}
	
	public DtCursoDetalle1 obtenerInfoDeCurso(String nombre) {
		DtCursoDetalle1 aux = null;
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre)) {
				aux = c.getDtCursoDetalle();
			}
		}
	return aux;
	}
	
	
}
