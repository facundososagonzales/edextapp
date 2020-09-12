package interfaces;

import java.util.List;

import excepciones.EstudianteInscriptoException;

import java.util.Date;


public interface IControladorInsEdicionCurso {
	public abstract List<String> listarInstitutos();
	public abstract void ingresarInstituto(String nombre);
	public abstract List<String> listarCursos();
	public abstract void ingresarCurso(String nombre);
	public List<String> listarEdicion();
	public abstract void inscripcionEstudiante(String nick, Date fechaIns, String edicion)throws EstudianteInscriptoException;
	public abstract List<String> listarEstudiantes();
}
