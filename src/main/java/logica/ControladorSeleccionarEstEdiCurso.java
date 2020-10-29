package logica;

import java.util.ArrayList;

import java.util.List;

import datatypes.DtEdicionDetalle;
import datatypes.DtEstudiante;
import datatypes.Estado;

import interfaces.IControladorSeleccionarEstEdiCurso;

public class ControladorSeleccionarEstEdiCurso implements IControladorSeleccionarEstEdiCurso {
	private String nombreI;
	private String nombreC;
	private String nombreEdi;
	private String nomEstudiante;
	
	public ControladorSeleccionarEstEdiCurso() {
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
	public void ingresarEdicion(String nomEdi) {
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		if(mEC.buscarEdicion(nomEdi)!=null)
			this.nombreEdi=nomEdi;
			
		
	}
	
	
	@Override 
	public ArrayList<DtEstudiante> listarEstudiantesInscriptos(){
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion = mEC.buscarEdicion(this.nombreEdi);
		List<InscripcionEdi> edi = edicion.getEdiciones();
		ArrayList<DtEstudiante> estudiantes = new ArrayList<>();
		if(!edi.isEmpty()) {
			for (InscripcionEdi ie: edi) {
				
				DtEstudiante estudiantes1= new DtEstudiante(ie.getEstudiante().getNick(),ie.getEstudiante().getNombre(),ie.getEstudiante().getApellido(),ie.getEstudiante().getCorreo(),ie.getEstudiante().getFechaNac());
				estudiantes.add(estudiantes1);
			}
		}
		return estudiantes;
	}
	
	@Override
	public void ingresarEstudiante(String nombre) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.buscarUsuario(nombre)!=null) {
			this.nomEstudiante=nombre;
		}
	}
	
	@Override
	public void seleccionarEstadoEstudiante(String estado) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Estudiante estudiante = (Estudiante)mU.buscarUsuario(this.nomEstudiante);
		List<InscripcionEdi> est = estudiante.getInsEdi();
		if(!est.isEmpty()) {
			for(InscripcionEdi ie: est) {
				if(ie.getEstudiante().getNick().equals(this.nomEstudiante)) {
					if(estado.equals("Aceptado"))
						ie.setEstado(Estado.Aceptado);
					else
						ie.setEstado(Estado.Rechazado);
				}
				
			}
		}
	}
	@Override
	public DtEdicionDetalle SeleccionarEdicion() {
		ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion=mE.buscarEdicion(this.nombreEdi);
		DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
		return dtEdicionReturn;
		
	}
}
