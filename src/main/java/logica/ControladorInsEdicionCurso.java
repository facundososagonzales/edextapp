package logica;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import interfaces.IControladorInsEdicionCurso;



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
	public void ingresarCurso(String nombreC) {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso curso=mC.buscarCursos(nombreC);
		if (curso!=null) {
			this.nombreC = nombreC;
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
	public void inscripcionEstudiante(String nick, Date fechaIns, String edicion) {
		/*ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion ed = mEC.buscarEdicion(edicion);
		Estudiante e = (Estudiante)mU.buscarUsuario(nick);
		InscripcionEdi ins = new InscripcionEdi(fechaIns);
		e.setEdi(ins); //link entre estudiante e inscripcionedi
		
		ins.setEdicion(ed); //link entre inscripcionEdi y Edicion*/
		
	}
	
}