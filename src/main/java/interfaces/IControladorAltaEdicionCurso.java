package interfaces;

import java.util.List;

import datatypes.DtEdicionDetalle;
import excepciones.EdicionRepetidaException;
import excepciones.SinDocenteAsignadoException;
import excepciones.UsuarioRepetidoException;

public interface IControladorAltaEdicionCurso {

	public String[] listarInstitutos();
	
	public void ingresarInstituto(String nombre);
	
	public String[] listarCursos();
	
	public void ingresarCurso(String nombre);
	
	public void ingresarDocentes(String docente) throws UsuarioRepetidoException;
	
	public boolean ingresarEdicionCurso(DtEdicionDetalle edicion);
	
	public boolean darAltaEdicionCurso();
	
	public String[] listarDocentes();
	
	public void ingresarDocentes(String[] docentes);
	
	public void limpiarDatos();

	public String getNombre();

	public DtEdicionDetalle getEdicion();

	public List<String> getDocentes();
	
}
