package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEdicionDetalle;
import excepcion.EdicionRepetidaException;
import excepcion.UsuarioRepetidoException;
import interfaces.IControladorAltaEdicionCurso;

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
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		if(mC.buscarCursos(nombreC)!=null) {
			this.nombreC=nombreC;
		}
	}

	@Override
	public List<String> listarCursos() {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		List<Curso> cursos = mC.getInstancias();
		List<String> aretornar = new ArrayList<>();
		if(!cursos.isEmpty()) {
			for(Curso c: cursos) {
				if(c.getInstituto().getNombre().equals(this.nombreI)) { //posible error
					aretornar.add(c.getNombre());
				}
			}
		}
		return aretornar;
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
			throw new EdicionRepetidaException("La edicion "+edicion.getNombre()+"ya existe en el sistem\n");
		}
	}
	
	@Override
	public void darAltaEdicionCurso() {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion e = new Edicion(this.edicion.getNombre(),this.edicion.getFechaI(),this.edicion.getFechaF(),0,this.edicion.getFechaPub());
		e.setCurso(mC.buscarCursos(this.nombreC));
		if(this.edicion.getCupos()!=0) {
			e.setCupo(this.edicion.getCupos());
		}
		mEC.agregarEdicion(e);
	}	
}