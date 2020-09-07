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
	public void ingresarInstituto(String nomInstituto)throws InstitutoNoCargadoException;
	public List<DtCursoDetalle> consultarCurso()throws InstitutoVacioException;
	public void ingresarCurso(String codCurso)throws CursoNoCargadoException;
	public List<DtEdicionDetalle> consultarEdicion() throws CursoSinEdicionException;
	public DtEdicionDetalle SeleccionarEdicion(String codEdicion) throws EdicionNoCargadaException;
}
