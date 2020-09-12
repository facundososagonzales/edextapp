/*package logica;

import java.util.ArrayList;

import datatypes.DtCursoDetalle1;
import datatypes.DtInfoPFormacion;
import datatypes.DtProgCurso;
import interfaces.IControladorConsultaProgFormacion;

public class ControladorConsultaProgFormacion implements IControladorConsultaProgFormacion {
	private String nombreP;
	
	public void setNombreP(String nom) {
		this.nombreP = nom;
	}
	
	public String getNombreP() {
		return this.nombreP;
	}
	
	public ArrayList<DtInfoPFormacion> listarProgsFormacion(){
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ArrayList<DtInfoPFormacion> aRet = mpf.datosProgsFormacion();
		return aRet;			
	}

	@Override
	public DtProgCurso seleccionarPrograma(String nombreP) {
		this.setNombreP(nombreP);
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mp.buscarProgFormacion(nombreP);
		DtProgCurso dtpc = p.getProgCurso();
		return dtpc; 
		
	}
	
	//OPERACION EXTERNA DEL CU CONSULTA DE CURSO
	public DtCursoDetalle1 seleccionarCurso(String nombreC) {
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mp.buscarProgFormacion(this.getNombreP());
		return p.obtenerInfoDeCurso(nombreC);
		
	}
	

}*/
