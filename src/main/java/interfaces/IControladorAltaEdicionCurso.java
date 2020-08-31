package interfaces;

import java.util.List;

import datatypes.DtDocente;
import datatypes.DtEdicionBase;
import excepcion.EdicionRepetidaException;
import excepcion.UsuarioRepetido;

public interface IControladorAltaEdicionCurso {

	public List<String> listarInstitutos();
	
	public void ingresarInstituto(String nombre);
	
	public List<String> listarCursos();
	
	public void ingresarCurso(String nombre);
	
	public void ingresarDocentes(DtDocente docente) throws UsuarioRepetido;
	
	public void ingresarEdicionCurso(DtEdicionBase edicion) throws EdicionRepetidaException;
	
	public void darAltaEdicionCurso();
	
}
