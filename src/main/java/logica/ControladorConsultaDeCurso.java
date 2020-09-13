package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import datatypes.DtProgCurso;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteNomEdicionException;
import excepciones.ExisteProgramaException;
import excepciones.ListaDeCursosVaciaException;
import interfaces.IControladorConsultaDeCurso;

public class ControladorConsultaDeCurso implements IControladorConsultaDeCurso { //NUEVO
	private String nombreI;
	private String nombreC;
	
	public String getNombreI() {
		return nombreI;
	}

	public void setNombreI(String nombreI) {
		this.nombreI = nombreI;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) throws ExisteInstitutoException,ListaDeCursosVaciaException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(nombre);
		if(ins==null) {
			throw new  ExisteInstitutoException("El instituto de nombre: "+nombre+" no existe.");
		}
		this.setNombreI(nombre);
		ArrayList<DtCursoBase> 	cursosI = ins.listarCursos();
		if(cursosI.isEmpty()) {
			throw new ListaDeCursosVaciaException("No existen cursos en el sistema");
		}
		return cursosI;
	}
	
	public DtInfoProgCurso seleccionarCurso(String nombreC) throws ExisteCursoException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		DtCursoDetalle1 dt = ins.obtenerInformacionDeCurso(nombreC);
		if(dt==null) {
			throw new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
		}
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> progs = mp.obtenerProgramas();
		String texto = "Programas de Formacion";
		for(ProgFormacion p: progs) {
			Curso c = p.buscarCurso(nombreC);
			if(c!=null) {
				texto = "\n-"+p.getNombre();
			}			
		}
		
		this.setNombreC(nombreC);
		return new DtInfoProgCurso(dt,texto);
		
	}
	
	//OPERACION EXTERNA DEL CU CONSULTAPROGFORMACION
	public DtProgCurso seleccionarPrograma(String nombreP) throws ExisteProgramaException {
		//ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		//Instituto ins = mI.buscarInstituto(this.getNombreI());
		//Curso c = ins.obtenerCurso(this.getNombreC());
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mp.buscarProgFormacion(nombreP);	
		if(p==null) {
			throw new ExisteProgramaException("El programa de formacion de nombre: "+nombreP+" no existe.");
		}
		DtProgCurso dtP = p.getProgCurso();
		return dtP; 
		
	}

	
	//FALTA OPERACION EXTERNA DEL CU CONSULTAEDICION

	
	public DtEdicionDetalle seleccionarEdicion(String nomE) throws ExisteNomEdicionException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		Curso c = ins.obtenerCurso(this.getNombreC());
		DtEdicionDetalle aux = c.obtenerDtEdicionDetalle(nomE);
		if(aux==null) {
			throw new ExisteNomEdicionException("La edicion de nombre: "+nomE+" no existe.");
		}
		
		return aux;
	}
}