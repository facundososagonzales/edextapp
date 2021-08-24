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
	
	
	public String[] listarProgsFormacion2(){
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ArrayList<DtInfoPFormacion> aRet = mpf.datosProgsFormacion();
		List<String> aRet2 = new ArrayList<>();
		
		for(DtInfoPFormacion c: aRet) {	
			String nom = c.getNombre();
			aRet2.add(nom);
			
		}

		int i = 0;
		String[] ret = new String[aRet2.size()];
        for(String c : aRet2) {
            ret[i]=c;
            i++;
        }
        return ret;
				
	}
	
	
	
	public ArrayList<DtCursoBase> seleccionarProgFormacion(String nombrePf){
		
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion pf = mpf.buscarProgFormacion(nombrePf);
	
		if(pf==null) {
			//throw new ExisteProgramaException("El Programa de Formacion de nombre: "+nombrePf+" no existe.");
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
	
	
public String[] seleccionarProgFormacion2(String nombrePf){
		
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion pf = mpf.buscarProgFormacion(nombrePf);
	
		if(pf==null) {
			//throw new ExisteProgramaException("El Programa de Formacion de nombre: "+nombrePf+" no existe.");
		}
		this.setNombrePf(nombrePf);
		//ManejadorCurso mc = ManejadorCurso.getInstancia();		
		//ManejadorInstituto ins = ManejadorInstituto.getInstancia();
		//List<Instituto> institutos = ins.getInstancias();
		List<Curso> cursos = new ArrayList<>();
		List<String> dtCursos = new ArrayList<>();
		
		Conexion con = Conexion.getInstancia();
		EntityManager e = con.getEntityManager();
		Query q = e.createQuery("select c from Curso c");
		
		cursos = (List<Curso>) q.getResultList();
		
		for(Curso c: cursos) {	
			dtCursos.add(c.getNombre());
			this.totCursos.add(c);
		}
	
		
		int i = 0;
		String[] ret = new String[dtCursos.size()];
        for(String c : dtCursos) {
            ret[i]=c;
            i++;
        }
        return ret;
	}
	
	
	
	public boolean seleccionarCurso(String nombreC) {
		boolean coincide;
		//ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso c = null;
		for(Curso cu: this.totCursos) {
			if(cu.getNombre().equals(nombreC)) {
				c = cu; 
			}
		}
		
		if(c==null) {
			coincide=true;
			return coincide;
			//throw new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
		}
		this.setCurso(c);
		coincide=false;
		return coincide;
	}
	
	public boolean confirmar(){
		boolean coincide = false;
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mpf.buscarProgFormacion(this.getNombrePf());
		Curso c = this.getCurso();
		boolean condicion=true;
		for(Curso c1: p.getCursos()) {
			if(c.getNombre().equals(c1.getNombre())) {
				condicion=false;
				coincide=true;
				return coincide;
			}
		}
		if(condicion) {
			Conexion co = Conexion.getInstancia();
			EntityManager e = co.getEntityManager();
			e.getTransaction().begin();
			p.addCurso(c);
			e.persist(p);
			e.getTransaction().commit();
			coincide=false;
			
		}
		return coincide;
			//throw new ExisteProgramaException("El curso "+c.getNombre()+" ya existe en el prog formacion."); 
	}
	
}