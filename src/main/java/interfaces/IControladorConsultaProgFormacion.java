package interfaces;

import java.util.ArrayList;

import datatypes.DtCursoDetalle;
import datatypes.DtCursoDetalle1;
import datatypes.DtInfoPFormacion;
import datatypes.DtProgCurso;

public interface IControladorConsultaProgFormacion {
	public ArrayList<DtInfoPFormacion> listarProgsFormacion();
	public DtProgCurso seleccionarPrograma(String nombreP);
	public DtCursoDetalle1 seleccionarCurso(String nombreC);
}
