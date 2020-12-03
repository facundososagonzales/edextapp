package logica;

import java.util.ArrayList;



//import java.util.Date fecha= new Date();

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import excepciones.EstudianteInscriptoException;
import interfaces.IControladorInsEdicionCurso;
import persistencia.Conexion;
import datatypes.DtEdicionDetalle;
import datatypes.Estado;



public class ControladorInsEdicionCurso implements IControladorInsEdicionCurso {
	private String nombreI;
	private String nombreC;
	private String nombreCat;
	private String nomEdicion;
	
	public ControladorInsEdicionCurso() {
		super();
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
	public void ingresarInstituto(String nombreI){
	/*	ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		
		if(mI.buscarInstituto(nombreI)!=null)
			this.nombreI=nombreI;*/
		// TODO Auto-generated method stub
				ManejadorInstituto mI = ManejadorInstituto.getInstancia();
				Instituto instituto=mI.buscarInstituto(nombreI);
				if (instituto!=null) {
					this.nombreI = nombreI;
			
				}	
	}
	
	@Override
	public String[] listarCategorias(){
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		List<Categoria> categorias = mC.getCategorias();
		List<String> catretornar = new ArrayList<>();
		
		for(Categoria c: categorias){
			catretornar.add(c.getNombre());
		}

		String[] ret = catretornar.stream().toArray(String[]::new);
		
		return ret;
	}
	
	@Override
	public void ingresarCategoria(String nombreCat) {
		/*ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		if(mC.buscarCategoria(nombreCat)!=null)
			this.nombreCat=nombreCat;*/
		
		
			// TODO Auto-generated method stub
			ManejadorCategoria mC = ManejadorCategoria.getInstancia();
			Categoria categoria=mC.buscarCategoria(nombreCat);
			if (categoria!=null) 
				this.nombreCat = nombreCat;
		
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
	public String[] listarCursosCategoria(){
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(this.nombreCat);
		List<String> nomCurso = new ArrayList<>();
		List<Curso> curso = new ArrayList<>();
		curso = categoria.getCursos();
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				nomCurso.add(c.getNombre());
			}
		}

		String[] ret = nomCurso.stream().toArray(String[]::new);
		
		return ret;
	}


	@Override
	public void ingresarCursoInstituto(String codCur) {
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
	public void ingresarCursoporCat(String codCur) {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria = mC.buscarCategoria(this.nombreCat);
		List<Curso> curso = categoria.getCursos();
		if(!curso.isEmpty()) {
			for(Curso c: curso) {
				if(c.getNombre().equals(codCur)) {
					this.nombreC=c.getNombre();
				}
			}
		}
	}
	
	@Override
	public String[] listarEdicion() {
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


		String[] ret = nomEdicion.stream().toArray(String[]::new);
		
		return ret;
	}
	
	@Override
	public void ingresarEdicion(String nomEdi) {
		
		ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion=mE.buscarEdicion(nomEdi);
		if (edicion!=null) {
			this.nomEdicion= nomEdi;
			System.out.println(this.nomEdicion+"Soy el de ingresarEdi");
			}
		}	

	
	@Override
	public DtEdicionDetalle SeleccionarEdicion() {
		System.out.println("llegue a selEdicion");
		System.out.println(this.nomEdicion);
		ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion=mE.buscarEdicion(this.nomEdicion);
		System.out.println("llegue a selEdicion/ buscar edicion del controlador");
		DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
		return dtEdicionReturn;
		
	}

	
	
	@Override
	public String[] listarEstudiantes(){
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<Usuario> usuarios = mU.obtenerListUsuarios();
		List<String> estudiantes = new ArrayList<>();
		
		for(Usuario u: usuarios) {
			if(u instanceof Estudiante) {
				estudiantes.add(((Estudiante)u).getNick());
			}
		}
		
		String[] ret = estudiantes.stream().toArray(String[]::new);
		
		return ret;
		/*ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> est = mU.listarEstudiantes();
		if(est!=null)

			{String[] ret = est.stream().toArray(String[]::new);
			
			return ret;}
		return null;*/
	}
	
	@Override
	public boolean inscripcionEstudiante(String nick, Date fechaIns, String edicion){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion ed = mEC.buscarEdicion(edicion);
		Estudiante e = (Estudiante)mU.buscarUsuario(nick);
		boolean inscripto=false;
		if (ed.estudianteEstaInscripto(nick))
		return inscripto=true;
		ed.agregarInscripcion(e, fechaIns);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(ed);
		em.getTransaction().commit();
		return inscripto;
		
	}
	
	@Override
	public void inscripcionEstudianteW(String nick, String edicion) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion ed = mEC.buscarEdicion(edicion);
		Estudiante e = (Estudiante)mU.buscarUsuario(nick);
		java.util.Date fecha= new Date();
		Estado estado = Estado.Inscripto;
		ed.agregarInscripcionWeb(e, fecha, estado);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(ed);
		em.getTransaction().commit();
	}
	
	@Override
	public String[] listarEdicionCat() {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(this.nombreCat);
		List<Edicion> edicion = new ArrayList<>();
		List<Curso> curso =categoria.getCursos();
		List<String> nomEdicion = new ArrayList<>();
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(this.nombreC))
				{
					edicion = c.getEdiciones();
				}
				
			}
			
		}
	
		if (!edicion.isEmpty()) {
			for (Edicion e: edicion) {
				nomEdicion.add(e.getNombre());
			}
		}


		String[] ret = nomEdicion.stream().toArray(String[]::new);
		
		return ret;
	}
	
}