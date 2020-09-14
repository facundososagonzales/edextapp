package interfaces;

import java.util.List;

import excepciones.EstudianteInscriptoException;

import java.util.Date;


public interface IControladorInsEdicionCurso {
	public List<String> listarInstitutos();
	public void ingresarInstituto(String nombre);
	public List<String> listarCursos();
	public void ingresarCurso(String nombre);
	public List<String> listarEdicion();
	public void inscripcionEstudiante(String nick, Date fechaIns, String edicion)throws EstudianteInscriptoException;
	public List<String> listarEstudiantes();
}
