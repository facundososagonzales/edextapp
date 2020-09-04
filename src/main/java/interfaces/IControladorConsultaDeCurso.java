package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;
import datatypes.DtProgCurso;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteProgramaException;

public interface IControladorConsultaDeCurso {//NUEVO
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) throws ExisteInstitutoException;
	public DtCursoDetalle seleccionarCurso(String nombreC) throws ExisteCursoException;
	public DtProgCurso seleccionarPrograma(String nombreP)throws ExisteProgramaException;
}
