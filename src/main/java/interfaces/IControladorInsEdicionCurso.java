package interfaces;

import java.util.List;




import excepciones.EstudianteInscriptoException;
import datatypes.DtEdicionDetalle;

import java.util.Date;


public interface IControladorInsEdicionCurso {
	public String[] listarInstitutos();
	public void ingresarInstituto(String nombre);
	public String[] listarCategorias();
	public void ingresarCategoria(String nombre);
	public String[] listarCursos();
	public String[] listarCursosCategoria();
	public void ingresarCursoInstituto(String nombre);
	public void ingresarCursoporCat(String nombre);
	public String[] listarEdicion();
	public void ingresarEdicion(String nomEdi);
	public DtEdicionDetalle SeleccionarEdicion();
	public boolean inscripcionEstudiante(String nick, Date fechaIns, String edicion);
	public void inscripcionEstudianteW(String nick, String edicion);
	public String[] listarEstudiantes();
	public String[] listarEdicionCat();
	
}