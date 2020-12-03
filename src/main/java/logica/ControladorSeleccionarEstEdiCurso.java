package logica;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtEdicionDetalle;
import datatypes.DtEstudiante;
import datatypes.Estado;

import interfaces.IControladorSeleccionarEstEdiCurso;
import persistencia.Conexion;

public class ControladorSeleccionarEstEdiCurso implements IControladorSeleccionarEstEdiCurso {
	private String nombreI;
	private String nombreC;
	private String nombreEdi;
	private String nomEstudiante;
	
	public ControladorSeleccionarEstEdiCurso() {
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
		
		int i = 0;
		String[] ret = new String[aretornar.size()];
        for(String c : aretornar) {
            ret[i]=c;
            i++;
        }
        return ret;
		
		
	}
	
	@Override
	public boolean ingresarInstituto(String nombreI){
		boolean coincide;
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		
		if(mI.buscarInstituto(nombreI)!=null) {
			coincide = false;
			this.nombreI=nombreI;
			return coincide; }
		else {
			coincide = true;
			return coincide;
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
		int i = 0;
		String[] ret = new String[nomCurso.size()];
        for(String c :nomCurso) {
            ret[i]=c;
            i++;
        }
        return ret;
	}
	
	@Override
	public boolean ingresarCurso(String codCur) {
		boolean coincide;
		// TODO Auto-generated method stub
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nombreI);
		List<Curso> curso =instituto.getCursos();
		
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(codCur))
				{
					this.nombreC=c.getNombre();
					coincide = false;
					return coincide;
				}
				
			}
		}
		coincide = true;
		return coincide;
	
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
		
		int i = 0;
		String[] ret = new String[nomEdicion.size()];
        for(String c : nomEdicion) {
            ret[i]=c;
            i++;
        }
        return ret;
		

	}
	
	@Override
	public boolean ingresarEdicion(String nomEdi) {
		boolean coincide;
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		if(mEC.buscarEdicion(nomEdi)!=null) {
			coincide = false;
			this.nombreEdi=nomEdi;
			return coincide;
		}else {
			coincide= true;
			return coincide;
			}
			
		
	}
	
	@Override
	public String[] listarEstudiantes(){
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion = mEC.buscarEdicion(this.nombreEdi);
		List<InscripcionEdi> edi = edicion.getEdiciones();
		List<String> estudiantes = new ArrayList<>();
		if(!edi.isEmpty()) {
			for (InscripcionEdi ie: edi) {
				if(ie.getEstado().equals(Estado.Inscripto)) {
					System.out.println("ENTRO A INSCRIPTO");
					estudiantes.add(ie.getEstudiante().getNick());
				}
			}
		}
		int i = 0;
		String[] ret = new String[estudiantes.size()];
        for(String c : estudiantes) {
            ret[i]=c;
            i++;
        }
        return ret;
	}

	
	@Override 
	public DtEstudiante[] listarEstudiantesInscriptos(){
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion = mEC.buscarEdicion(this.nombreEdi);
		List<InscripcionEdi> edi = edicion.getEdiciones();
		ArrayList<DtEstudiante> estudiantes = new ArrayList<>();
		if(!edi.isEmpty()) {
			for (InscripcionEdi ie: edi) {
				DtEstudiante estudiantes1= new DtEstudiante(ie.getEstudiante().getNick(),ie.getEstudiante().getNombre(),ie.getEstudiante().getApellido(),ie.getEstudiante().getCorreo(),ie.getEstudiante().getFechaNac(),ie.getEstado());
				estudiantes.add(estudiantes1);

			}
		}
		
		int i = 0;
		DtEstudiante[] ret = new DtEstudiante[estudiantes.size()];
        for(DtEstudiante c : estudiantes) {
            ret[i]=c;
            i++;
        }
        return ret;
		
	}
	
	@Override
	public boolean ingresarEstudiante(String nombre) {
		boolean coincide;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.buscarUsuario(nombre)!=null) {
			this.nomEstudiante=nombre;
			coincide = false;
			return coincide;
		} else {
			coincide = true;
			return coincide;
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
					if(estado.equals("Aceptado")) {
						ie.setEstado(Estado.Aceptado);
						Conexion c = Conexion.getInstancia();
						EntityManager e = c.getEntityManager();
						e.getTransaction().begin();
						e.persist(ie);
						e.getTransaction().commit();
					}else {
						ie.setEstado(Estado.Rechazado);
						Conexion c = Conexion.getInstancia();
						EntityManager e = c.getEntityManager();
						e.getTransaction().begin();
						e.persist(ie);
						e.getTransaction().commit();
					}
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

	@Override
	public String getNombreI() {
		return this.nombreI;
	}

	@Override
	public String getNombreC() {
		// TODO Auto-generated method stub
		return this.nombreC;
	}

	@Override
	public String getNombreEdi() {
		// TODO Auto-generated method stub
		return this.nombreEdi;
	}

	@Override
	public String getNomEst() {
		// TODO Auto-generated method stub
		return this.nomEstudiante;
	}
}
