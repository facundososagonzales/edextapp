package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;
import datatypes.DtProgCurso;

public interface IControladorConsultaDeCurso {//NUEVO
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre);
	public DtCursoDetalle seleccionarCurso(String nombreC);
	public DtProgCurso seleccionarPrograma(String nombreP);
}
