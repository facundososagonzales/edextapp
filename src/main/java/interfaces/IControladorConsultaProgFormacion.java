package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoDetalle;
import datatypes.DtInfoPFormacion;
import datatypes.DtProgCurso;

public interface IControladorConsultaProgFormacion {
	public ArrayList<DtInfoPFormacion> listarProgsFormacion();
	public DtProgCurso seleccionarPrograma(String nombreP);
	public DtCursoDetalle seleccionarCurso(String nombreC);
}
