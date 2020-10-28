package interfaces;

import java.util.List;

import datatypes.DtEdicionDetalle;
import excepciones.EdicionRepetidaException;
import excepciones.SinDocenteAsignadoException;
import excepciones.UsuarioRepetidoException;

public interface IControladorAltaEdicionCurso {

	public List<String> listarInstitutos();
	
	public void ingresarInstituto(String nombre);
	
	public List<String> listarCursos();
	
	public void ingresarCurso(String nombre);
	
	public void ingresarDocentes(String docente) throws UsuarioRepetidoException;
	
	public void ingresarEdicionCurso(DtEdicionDetalle edicion) throws EdicionRepetidaException;
	
	public void darAltaEdicionCurso() throws SinDocenteAsignadoException;
	
	public List<String> listarDocentes();
	
	public void ingresarDocentes(List<String> docentes);
	
	public void limpiarDatos();
	
}
