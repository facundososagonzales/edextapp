package interfaces;

import java.util.List;

import datatypes.DtEdicionDetalle;
import excepcion.EdicionRepetidaException;
import excepcion.UsuarioRepetidoException;

public interface IControladorAltaEdicionCurso {

	public List<String> listarInstitutos();
	
	public void ingresarInstituto(String nombre);
	
	public List<String> listarCursos();
	
	public void ingresarCurso(String nombre);
	
	public void ingresarDocentes(String docente) throws UsuarioRepetidoException;
	
	public void ingresarEdicionCurso(DtEdicionDetalle edicion) throws EdicionRepetidaException;
	
	public void darAltaEdicionCurso();
	
}
