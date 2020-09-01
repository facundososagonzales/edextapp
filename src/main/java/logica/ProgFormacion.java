package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtInfoPFormacion;
import datatypes.DtPFormacion;

public class ProgFormacion {
	private String nombre;
	private String descripcion; 
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	//falta link
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

}
