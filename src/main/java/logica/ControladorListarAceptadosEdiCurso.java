package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEdicionDetalle;
import datatypes.Estado;
import interfaces.IControladorListarAceptadosEdiCurso;

public class ControladorListarAceptadosEdiCurso implements IControladorListarAceptadosEdiCurso {
	private String nombreI;
	private String nombreC;
	private String nombreEdi;
	
	public ControladorListarAceptadosEdiCurso() {
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
	public void ingresarInstituto(String nombreI){
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		
		if(mI.buscarInstituto(nombreI)!=null)
			this.nombreI=nombreI;
		
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
        for(String c : nomCurso) {
            ret[i]=c;
            i++;
        }
        return ret;
		
		
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
	public void ingresarEdicion(String nomEdi) {
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		if(mEC.buscarEdicion(nomEdi)!=null)
			this.nombreEdi=nomEdi;
			
		
	}
	
	
	@Override 
	public String[] listarEstudiantesInscriptos(){
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		System.out.print(this.nombreEdi);
		Edicion edicion = mEC.buscarEdicion(this.nombreEdi);
		edicion.setNombre(this.nombreEdi);
		System.out.print(edicion.getNombre());
		List<InscripcionEdi> edi = edicion.getEdiciones();
		List<String> estudiantes = new ArrayList<>();
		if(!edi.isEmpty()) {
			for (InscripcionEdi ie: edi) {
				if(ie.getEstado().equals(Estado.Aceptado))
					estudiantes.add(ie.getEstudiante().getNick());
			}
		}
		
		String[] ret = new String [0];
		
		int i = 0;
        ret = new String[estudiantes.size()];
        for(String c : estudiantes) {
            ret[i]=c;
            i++;
        } 
        return ret;
		 
		}
		
	
	
	public DtEdicionDetalle seleccionarEdicion(String nomE) {
		
		ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion=mE.buscarEdicion(nomE);
		System.out.print(nomE);
	//	System.out.print(edicion.getFechaI());
	//	System.out.print(edicion.getFechaF());
		System.out.print(edicion.getCupo());
	//	System.out.print(edicion.getFechaPub());
		DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(nomE, edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
		System.out.print("PASO SELECCIONAR");
		this.setNombreEdi(nomE);
		return dtEdicionReturn;
		
	}
	
	public void setNombreEdi(String nomE) {
		this.nombreEdi=nomE;
	}

	@Override
	public String getNombreI() {
		// TODO Auto-generated method stub
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

	
}
