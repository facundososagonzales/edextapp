package interfaces;

import java.util.List;

import excepciones.EstudianteInscriptoException;

import java.util.Date;


public interface IControladorInsEdicionCurso {
	public List<String> listarInstitutos();
	public void ingresarInstituto(String nombre);
	public List<String> listarCategorias();
	public void ingresarCategoria(String nombre);
	public List<String> listarCursos();
	public List<String> listarCursosCategoria();
	public void ingresarCurso(String nombre);
	public List<String> listarEdicion();
	public void inscripcionEstudiante(String nick, Date fechaIns, String edicion)throws EstudianteInscriptoException;
	public void inscripcionEstudianteW(String nick, String edicion)throws EstudianteInscriptoException;
	public List<String> listarEstudiantes();
}
