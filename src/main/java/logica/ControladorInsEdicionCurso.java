package logica;

import java.util.ArrayList;

//import java.util.Date fecha= new Date();

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import excepciones.EstudianteInscriptoException;
import interfaces.IControladorInsEdicionCurso;
import persistencia.Conexion;



public class ControladorInsEdicionCurso implements IControladorInsEdicionCurso {
	private String nombreI;
	private String nombreC;
	
	public ControladorInsEdicionCurso() {
		super();
	}
	
	@Override
	public List<String> listarInstitutos() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List<Instituto> institutos = mI.getInstancias();
		List<String> aretornar = new ArrayList<>();
		for(Instituto i: institutos) {
			aretornar.add(i.getNombre());
		}
		return aretornar;
	}
	
	@Override
	public void ingresarInstituto(String nombreI){
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		
		if(mI.buscarInstituto(nombreI)!=null)
			this.nombreI=nombreI;
		
	}
	
	@Override
	public List<String> listarCategorias(){
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		List<Categoria> categorias = mC.getCategorias();
		List<String> catretornar = new ArrayList<>();
		for(Categoria c: categorias){
			catretornar.add(c.getNombre());
		}
		return catretornar;
	}
	
	@Override
	public void ingresarCategoria(String nombreC) {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		if(mC.buscarCategoria(nombreC)!=null)
			this.nombreC=nombreC;
	}
	
	@Override
	public List<String> listarCursos() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nombreI);
		List<String> nomCurso = new ArrayList<>();
		List<Curso> curso = new ArrayList<>();
		curso = instituto.getCursos();
		
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				nomCurso.add(c.getNombre());
			}
		}
		return nomCurso;
	}
	
	@Override 
	public List<String> listarCursosCategoria(){
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(this.nombreC);
		List<String> nomCurso = new ArrayList<>();
		List<Curso> curso = new ArrayList<>();
		curso = categoria.getCursos();
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				nomCurso.add(c.getNombre());
			}
		}
		return nomCurso;
	}


	@Override
	public void ingresarCurso(String codCur) {
		// TODO Auto-generated method stub
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nombreI);
		List<Curso> curso =instituto.getCursos();
		
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(codCur))
				{
					this.nombreC=c.getNombre();
				}
				
			}
		}
	
	}
	
	@Override
	public List<String> listarEdicion() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nombreI);
		List<Edicion> edicion = new ArrayList<>();
		List<Curso> curso =instituto.getCursos();
		List<String> nomEdicion = new ArrayList<>();
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(this.nombreC)){
					edicion = c.getEdiciones();
				}	
			}
		}
	
		if (!edicion.isEmpty()) {
			for (Edicion e: edicion) {
				nomEdicion.add(e.getNombre());
			}
		}

		return nomEdicion;
	}
	
	
	@Override
	public List<String> listarEstudiantes(){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> est = mU.listarEstudiantes();
		if(est!=null)
			return est;
		return null;
	}
	
	@Override
	public void inscripcionEstudiante(String nick, Date fechaIns, String edicion)throws EstudianteInscriptoException{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion ed = mEC.buscarEdicion(edicion);
		Estudiante e = (Estudiante)mU.buscarUsuario(nick);
		if (ed.estudianteEstaInscripto(nick))
			throw new EstudianteInscriptoException("El usuario " + nick + " ya esta inscripto en la edicion " + edicion);
		ed.agregarInscripcion(e, fechaIns);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(ed);
		em.getTransaction().commit();
		
	}
	
	@Override
	public void inscripcionEstudianteW(String nick, String edicion)throws EstudianteInscriptoException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion ed = mEC.buscarEdicion(edicion);
		Estudiante e = (Estudiante)mU.buscarUsuario(nick);
		java.util.Date fecha= new Date();
		if (ed.estudianteEstaInscripto(nick))
			throw new EstudianteInscriptoException("El usuario " + nick + " ya esta inscripto en la edicion " + edicion);
		ed.agregarInscripcion(e, fecha);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(ed);
		em.getTransaction().commit();
	}
	
}