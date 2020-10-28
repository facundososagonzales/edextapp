package interfaces;

import java.util.List;




import excepciones.EstudianteInscriptoException;
import datatypes.DtEdicionDetalle;

import java.util.Date;


public interface IControladorInsEdicionCurso {
	public List<String> listarInstitutos();
	public void ingresarInstituto(String nombre);
	public List<String> listarCategorias();
	public void ingresarCategoria(String nombre);
	public List<String> listarCursos();
	public List<String> listarCursosCategoria();
	public void ingresarCursoInstituto(String nombre);
	public void ingresarCursoporCat(String nombre);
	public List<String> listarEdicion();
	public void ingresarEdicion(String nomEdi);
	public DtEdicionDetalle SeleccionarEdicion();
	public void inscripcionEstudiante(String nick, Date fechaIns, String edicion)throws EstudianteInscriptoException;
	public void inscripcionEstudianteW(String nick, String edicion);
	public List<String> listarEstudiantes();
	
}
