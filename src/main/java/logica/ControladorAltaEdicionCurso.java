package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEdicionDetalle;
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
	public String[] listarInstitutos() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List<Instituto> institutos = mI.getInstancias();
		List<String> aretornar = new ArrayList<>();
		for(Instituto i: institutos) {
			aretornar.add(i.getNombre());
		}
		String[] ret = aretornar.stream().toArray(String[]::new);
		
		return ret;
	}

	@Override
	public void ingresarCurso(String nombreC) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.buscarInstituto(nombreI);
		Curso c = i.obtenerCurso(nombreC);
		if(c!=null) {
			this.nombreC=nombreC;
		}
		
	}

	@Override
	public String[] listarCursos() {
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
		
		String[] ret = nomCurso.stream().toArray(String[]::new);
		
		return ret;
	}
	
	@Override
	public void ingresarDocentes(String docente) throws UsuarioRepetidoException {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(docente);
		if(u!=null) {
			if(u instanceof Docente) {
					for(String s: docentes) {
						if (s.equals(docente)) {
							throw new UsuarioRepetidoException("El nick "+docente +" pertenece a un docente ya ingresado\n");
						}
					}
					docentes.add(docente);
			}else {
				throw new UsuarioRepetidoException("El nick "+docente +" pertenece a un estudiante\n");
			}
		}else {
			throw new UsuarioRepetidoException("El nick "+docente +" no existe en el sistema\n");
		}
	}
	
	public String[] listarDocentes() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<Usuario> usuarios = mU.obtenerListUsuarios();
		List<String> docentes = new ArrayList<>();
		
		for(Usuario u: usuarios) {
			if(u instanceof Docente) {
				docentes.add(((Docente)u).getNick());
			}
		}
		
		String[] ret = docentes.stream().toArray(String[]::new);
		
		return ret;
	}
	
	public void ingresarDocentes(String[] docentes1) {
		List<String> docentes = new ArrayList<>();
		for (String d: docentes1){
			docentes.add(d);
		}
		this.docentes=docentes;
	}
	
	@Override
	public boolean ingresarEdicionCurso(DtEdicionDetalle edicion){
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		if(mEC.buscarEdicion(edicion.getNombre())==null){
			this.edicion=edicion;
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean darAltaEdicionCurso(){
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto i = mI.buscarInstituto(nombreI);
		Curso c = i.obtenerCurso(nombreC);		
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<Docente> docentes = new ArrayList<>();
		for(String s: this.docentes) {
			Usuario usuario = mU.buscarCorreo(s);
			if (usuario instanceof Docente)
				docentes.add((Docente) usuario);
		}
		if(this.docentes.isEmpty()) {
			return false;
		}
		Edicion e = new Edicion(this.edicion.getNombre(),this.edicion.getFechaI(),this.edicion.getFechaF(),0,this.edicion.getFechaPub());
		if(this.edicion.getCupos()!=0) {
			e.setCupo(this.edicion.getCupos());
		}
		e.setCurso(c);
		c.setEdicion(e);
		e.setDocentesAsignados(docentes);
		mEC.agregarEdicion(e);
		
		Conexion co = Conexion.getInstancia();
		EntityManager en = co.getEntityManager();
		
		en.getTransaction().begin();
		en.persist(i);
		en.getTransaction().commit();
		limpiarDatos();
		return true;
		
	}
	
	public void limpiarDatos() {
		this.docentes = new ArrayList<>();
		this.edicion = null;
		this.nombreC = null;
		this.nombreI = null;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombreC;
	}

	@Override
	public DtEdicionDetalle getEdicion() {
		// TODO Auto-generated method stub
		return this.edicion;
	}

	@Override
	public List<String> getDocentes() {
		// TODO Auto-generated method stub
		return this.docentes;
	}
}