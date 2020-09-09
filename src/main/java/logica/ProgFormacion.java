package logica;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtInfoPFormacion;
import datatypes.DtPFormacion;
import datatypes.DtProgCurso;

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
	/*	
		System.out.println("\n\n\n CONFIRMANDO ALTA");
		for(Curso cu: cursos) {
			System.out.println(cu.getDtCursoBase()+"\n\n\n*************************************\n\n");
			}*/
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
			System.out.println("\n\nEstoyEnProgFormacion ANTESDEPEDIRELDT");
			dtCursos.add(c.getDtCursoBase());
			System.out.println("\n\nEstoyEnProgFormacion DESPUESDEPEDIRELDT");
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
