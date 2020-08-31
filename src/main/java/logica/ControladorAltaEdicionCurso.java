package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtDocente;
import datatypes.DtEdicionBase;
import excepcion.EdicionRepetidaException;
import excepcion.UsuarioRepetido;
import interfaces.IControladorAltaEdicionCurso;

public class ControladorAltaEdicionCurso implements IControladorAltaEdicionCurso {
	private String nombreC;
	private String nombreI;
	private List<DtDocente> docentes;
	private DtEdicionBase edicion;
	
	public ControladorAltaEdicionCurso() {
		super();
	}

	@Override
	public void ingresarInstituto(String nombreI){
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		//Quitar carga cuando Alta instituto este implementado
		mI.cargarInst();
		mC.cargarCurso();
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
		for(Curso c: cursos) {
			if(c.getInstituto().getNombre().equals(this.nombreI)) {
				aretornar.add(c.getNombre());
			}
		}
		return aretornar;
	}
	
	@Override
	public void ingresarDocentes(DtDocente docente) throws UsuarioRepetido {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.buscarCorreo(docente.getCorreo())!=null) {
			if(docente instanceof DtDocente) {
				docentes.add(docente);
			}else {
				throw new UsuarioRepetido("El correo "+docente.getCorreo() +" pertenece a un estudiante\n");
			}
		}else {
			throw new UsuarioRepetido("El correo "+docente.getCorreo() +" no existe en el sistema\n");
		}
	}
	
	@Override
	public void ingresarEdicionCurso(DtEdicionBase edicion) throws EdicionRepetidaException {
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		if(mEC.buscarEdicion(edicion.getNombre())==null){
			this.edicion=edicion;
		}else {
			throw new EdicionRepetidaException("La edicion "+edicion.getNombre()+"ya existe en el sistem\n");
		}
	}
	public void darAltaEdicionCurso() {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion e = new Edicion(this.edicion.getNombre(),this.edicion.getFechaI(),this.edicion.getFechaF());
		e.setCurso(mC.buscarCursos(this.nombreC));
		if(!Integer.toString(this.edicion.getCupos()).isEmpty()) {
			e.setCupo(this.edicion.getCupos());
		}
		mEC.agregarEdicion(e);
	}	
}