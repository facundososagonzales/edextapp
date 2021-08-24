package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;
import excepciones.ExisteCursoException;
import excepciones.ExisteProgramaException;

public interface IControladorAgregarCursoAProgDeFormacion {
	public ArrayList<DtInfoPFormacion> listarProgsFormacion();
	public String[] listarProgsFormacion2();
	public ArrayList<DtCursoBase> seleccionarProgFormacion(String nombrePf);
	public String[] seleccionarProgFormacion2(String nombrePf);
	public boolean seleccionarCurso(String nombreC);
	public boolean confirmar();
	
}