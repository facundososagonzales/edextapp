package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;
import excepciones.ExisteCursoException;
import excepciones.ExisteProgramaException;

public interface IControladorAgregarCursoAProgDeFormacion {
	public ArrayList<DtInfoPFormacion> listarProgsFormacion();
	public ArrayList<DtCursoBase> seleccionarProgFormacion(String nombrePf)throws ExisteProgramaException;
	public void seleccionarCurso(String nombreC)throws ExisteCursoException;
	public void confirmar();
}
