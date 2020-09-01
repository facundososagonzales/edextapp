package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;

public interface IControladorAgregarCursoAProgDeFormacion {
	public ArrayList<DtInfoPFormacion> listarProgsFormacion();
	public ArrayList<DtCursoBase> seleccionarProgFormacion(String nombrePf);
	public void seleccionarCurso(String nombreC);
	public void confirmar();
}
