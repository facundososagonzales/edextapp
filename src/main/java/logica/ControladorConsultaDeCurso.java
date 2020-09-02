package logica;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;
import datatypes.DtProgCurso;
import interfaces.IControladorConsultaDeCurso;

public class ControladorConsultaDeCurso implements IControladorConsultaDeCurso { //NUEVO
	private String nombreI;
	
	public String getNombreI() {
		return nombreI;
	}

	public void setNombreI(String nombreI) {
		this.nombreI = nombreI;
	}
	
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre){
		this.setNombreI(nombre);
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(nombre);
		ArrayList<DtCursoBase> cursosI = ins.listarCursos();
		return cursosI;
	}
	
	public DtCursoDetalle seleccionarCurso(String nombreC) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		return ins.obtenerInformacionDeCurso(nombreC);
		
	}
	
	//OPERACION EXTERNA DEL CU CONSULTAPROGFORMACION
	public DtProgCurso seleccionarPrograma(String nombreP) {
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mp.buscarProgFormacion(nombreP);
		DtProgCurso dtpc = p.getProgCurso();
		return dtpc; 
		
	}
	
	//FALTA OPERACION EXTERNA DEL CU CONSULTAEDICION



}
