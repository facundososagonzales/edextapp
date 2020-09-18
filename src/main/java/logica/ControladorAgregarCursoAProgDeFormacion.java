package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;
import excepciones.ExisteCursoException;
import excepciones.ExisteProgramaException;
import interfaces.IControladorAgregarCursoAProgDeFormacion;
import persistencia.Conexion;

public class ControladorAgregarCursoAProgDeFormacion implements IControladorAgregarCursoAProgDeFormacion{
	private String nombrePf;
	private Curso curso;
	ArrayList<Curso> totCursos = new ArrayList<>();
	
	
	public String getNombrePf() {
		return nombrePf;
	}

	public void setNombrePf(String nombrePf) {
		this.nombrePf = nombrePf;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso c) {
		this.curso = c;
	}

	public ArrayList<DtInfoPFormacion> listarProgsFormacion(){
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ArrayList<DtInfoPFormacion> aRet = mpf.datosProgsFormacion();
		return aRet;			
	}
	
	public ArrayList<DtCursoBase> seleccionarProgFormacion(String nombrePf)throws ExisteProgramaException{
		
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion pf = mpf.buscarProgFormacion(nombrePf);
	
		if(pf==null) {
			throw new ExisteProgramaException("El Programa de Formacion de nombre: "+nombrePf+" no existe.");
		}
		this.setNombrePf(nombrePf);
		//ManejadorCurso mc = ManejadorCurso.getInstancia();		
		//ManejadorInstituto ins = ManejadorInstituto.getInstancia();
		//List<Instituto> institutos = ins.getInstancias();
		List<Curso> cursos = new ArrayList<>();
		ArrayList<DtCursoBase> dtCursos = new ArrayList<>();
		
		Conexion con = Conexion.getInstancia();
		EntityManager e = con.getEntityManager();
		Query q = e.createQuery("select c from Curso c");
		
		cursos = (List<Curso>) q.getResultList();
		
		for(Curso c: cursos) {	
			dtCursos.add(c.getDtCursoBase());
			this.totCursos.add(c);
		}
	
		return dtCursos;
	}
	
	public void seleccionarCurso(String nombreC) throws ExisteCursoException{
		//ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso c = null;
		for(Curso cu: this.totCursos) {
			if(cu.getNombre().equals(nombreC)) {
				c = cu; 
			}
		}
		
		if(c==null) {
			throw new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
		}
		this.setCurso(c);
	}
	
	public void confirmar() {
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mpf.buscarProgFormacion(this.getNombrePf());
		Curso c = this.getCurso();
		Conexion co = Conexion.getInstancia();
		EntityManager e = co.getEntityManager();
		e.getTransaction().begin();
		p.addCurso(c);
		e.persist(p);
		e.getTransaction().commit();
				
	}
	
}