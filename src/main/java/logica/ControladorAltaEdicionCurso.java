package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEdicionDetalle;
import excepciones.EdicionRepetidaException;
import excepciones.SinDocenteAsignadoException;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorAltaEdicionCurso;
import persistencia.Conexion;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String nombreC;
	private String nombreI;
	private List<String> docentes = new ArrayList<>();
	private DtEdicionDetalle edicion;
	
	public ControladorAltaEdicionCurso() {
		super();
	}

	@Override
	public void ingresarInstituto(String nombreI){
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(mI.buscarInstituto(nombreI)!=null)
			this.nombreI=nombreI;
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
	public void ingresarCurso(String nombreC) {
		/*ManejadorCurso mC = ManejadorCurso.getInstancia();
		if(mC.buscarCursos(nombreC)!=null) {
			this.nombreC=nombreC;
		}*/
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.buscarInstituto(nombreI);
		Curso c = i.obtenerCurso(nombreC);
		if(c!=null) {
			this.nombreC=nombreC;
		}
		
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
	public void ingresarDocentes(String docente) throws UsuarioRepetidoException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarCorreo(docente);
		if(u!=null) {
			if(u instanceof Docente) {
					for(String s: docentes) {
						if (s.equals(docente)) {
							throw new UsuarioRepetidoException("El correo "+docente +" pertenece a un docente ya ingresado\n");
						}
					}
					docentes.add(docente);
			}else {
				throw new UsuarioRepetidoException("El correo "+docente +" pertenece a un estudiante\n");
			}
		}else {
			throw new UsuarioRepetidoException("El correo "+docente +" no existe en el sistema\n");
		}
	}
	
	@Override
	public void ingresarEdicionCurso(DtEdicionDetalle edicion) throws EdicionRepetidaException {
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		if(mEC.buscarEdicion(edicion.getNombre())==null){
			this.edicion=edicion;
		}else {
			throw new EdicionRepetidaException("La edicion "+edicion.getNombre()+" ya existe en el sistem\n");
		}
	}
	
	@Override
	public void darAltaEdicionCurso() throws SinDocenteAsignadoException{
		//ManejadorCurso mC = ManejadorCurso.getInstancia();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.buscarInstituto(nombreI);
		Curso c = i.obtenerCurso(nombreC);		
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Edicion e = new Edicion(this.edicion.getNombre(),this.edicion.getFechaI(),this.edicion.getFechaF(),0,this.edicion.getFechaPub());
		//Curso c = mC.buscarCursos(this.nombreC);
		e.setCurso(c);
		c.setEdicion(e);
		List<Docente> docentes = e.getDocentesAsignados();
		for(String s: this.docentes) {
			Usuario usuario = mU.buscarCorreo(s);
			if (usuario instanceof Docente)
				docentes.add((Docente) usuario);
		}
		
		if(this.edicion.getCupos()!=0) {
			e.setCupo(this.edicion.getCupos());
		}
		if(this.docentes.isEmpty()) {
			throw new SinDocenteAsignadoException("No hay docentes cargados en la edicion\n");
		}
		e.setDocentesAsignados(docentes); //TENDRIA QUE SETEARSE LOS DOCENTES
		mEC.agregarEdicion(e);
		
		//CREO QUE VA POR QUE CURSO DEPENDE DEL INSTITUTO ENTONCES SI HAY UN CAMBIO EN CURSO HAY QUE VOLVER A PERSISTIR EL INSTITUTO
		
		Conexion co = Conexion.getInstancia();
		EntityManager en = co.getEntityManager();
		
		en.getTransaction().begin();
		en.persist(i);
		en.getTransaction().commit();
		
	}	
	
	public void limpiarDatos() {
		this.docentes = new ArrayList<>();
		this.edicion = null;
		this.nombreC = null;
		this.nombreI = null;
	}
	
	
	
	
}