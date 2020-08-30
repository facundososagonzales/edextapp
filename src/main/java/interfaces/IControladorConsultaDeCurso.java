package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;

public interface IControladorConsultaDeCurso {//NUEVO
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre);
	public DtCursoDetalle seleccionarCurso(String nombreC);
	
}
