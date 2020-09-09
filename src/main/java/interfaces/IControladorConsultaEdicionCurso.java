package interfaces;

import java.util.List;

import datatypes.DtCursoDetalle;
import datatypes.DtEdicionDetalle;
import excepcion.InstitutoNoCargadoException;
import excepcion.InstitutoVacioException;
import excepcion.CursoNoCargadoException;
import excepcion.CursoSinEdicionException;
import excepcion.EdicionNoCargadaException;

public interface IControladorConsultaEdicionCurso {
	public void ingresarInstituto(String nomInstituto);
	public List<String> listarInstituto();
	public List<String> listarCurso();
	public void ingresarCurso(String codCur);
	public List<String> listarEdicion();
	public void ingresarEdicion(String nomEdi);
	public DtEdicionDetalle SeleccionarEdicion();
	public List<String> listarDocentes();
	

}
