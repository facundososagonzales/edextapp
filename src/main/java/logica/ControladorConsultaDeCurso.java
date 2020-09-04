package logica;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;
import datatypes.DtProgCurso;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteProgramaException;
import interfaces.IControladorConsultaDeCurso;

public class ControladorConsultaDeCurso implements IControladorConsultaDeCurso { //NUEVO
	private String nombreI;
	
	public String getNombreI() {
		return nombreI;
	}

	public void setNombreI(String nombreI) {
		this.nombreI = nombreI;
	}
	
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) throws ExisteInstitutoException{
		this.setNombreI(nombre);
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(nombre);
		if(ins==null) {
			new  ExisteInstitutoException("El curso de nombre: "+nombre+" no existe.");
		}
		ArrayList<DtCursoBase> cursosI = ins.listarCursos();
		return cursosI;
	}
	
	public DtCursoDetalle seleccionarCurso(String nombreC) throws ExisteCursoException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		DtCursoDetalle dt = ins.obtenerInformacionDeCurso(nombreC);
		if(dt==null) {
			new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
		}
		return dt;
		
	}
	
	//OPERACION EXTERNA DEL CU CONSULTAPROGFORMACION
	public DtProgCurso seleccionarPrograma(String nombreP) throws ExisteProgramaException {
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mp.buscarProgFormacion(nombreP);
		if(p==null) {
			new ExisteProgramaException("El programa de formacion de nombre: "+nombreP+" no existe.");
		}
		DtProgCurso dtpc = p.getProgCurso();
		return dtpc; 
		
	}
	
	//FALTA OPERACION EXTERNA DEL CU CONSULTAEDICION



}
