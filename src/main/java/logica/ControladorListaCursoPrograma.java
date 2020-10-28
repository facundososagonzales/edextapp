package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtWebCurso;
import datatypes.DtWebProgF;
import interfaces.IControladorListaCursoPrograma;
import persistencia.Conexion;

public class ControladorListaCursoPrograma implements IControladorListaCursoPrograma{

	@Override
	public ArrayList<DtWebCurso> listarCursos() {
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select c from Curso c");
		List<Curso> cursos = (List<Curso>) q.getResultList();
		ArrayList<DtWebCurso> cursosW = new ArrayList<>();
		
		for(Curso cu: cursos) {
			DtWebCurso dt = new DtWebCurso(cu.getNombre(),cu.getFechaR());
			cursosW.add(dt);
		}
				
		return cursosW;
	}

	@Override
	public ArrayList<DtWebProgF> listarProgramas() {
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select p from ProgFormacion p");
		List<ProgFormacion> progsFormacion = (List<ProgFormacion>) q.getResultList();
		ArrayList<DtWebProgF> progsW = new ArrayList<>();
		
		for(ProgFormacion pf: progsFormacion) {
			DtWebProgF dt = new DtWebProgF(pf.getNombre(),pf.getFechaAlta());
			progsW.add(dt);
		}
				
		return progsW;
	}

}
