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
	
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) throws ExisteInstitutoException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		mI.cargarInst();
		Instituto ins = mI.buscarInstituto(nombre);
		if(ins==null) {
			throw new  ExisteInstitutoException("El curso de nombre: "+nombre+" no existe.");
		}
		this.setNombreI(nombre);
		ArrayList<DtCursoBase> cursosI = ins.listarCursos();
		return cursosI;
	}
	
	public DtCursoDetalle seleccionarCurso(String nombreC) throws ExisteCursoException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		DtCursoDetalle dt = ins.obtenerInformacionDeCurso(nombreC);
		if(dt==null) {
			throw new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
		}
		this.setNombreC(nombreC);
		return dt;
		
	}
	
	//OPERACION EXTERNA DEL CU CONSULTAPROGFORMACION
	public DtProgCurso seleccionarPrograma(String nombreP) throws ExisteProgramaException {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		Curso c = ins.obtenerCurso(this.getNombreC());
		DtProgCurso dtP = c.obtenerDtProgCurso(nombreP);
				
		if(dtP==null) {
			throw new ExisteProgramaException("El programa de formacion de nombre: "+nombreP+" no existe.");
		}
		System.out.println(dtP);
		return dtP; 
		
	}

	
	//FALTA OPERACION EXTERNA DEL CU CONSULTAEDICION



}
