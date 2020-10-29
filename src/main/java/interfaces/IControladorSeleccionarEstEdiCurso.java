package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtEdicionDetalle;
import datatypes.DtEstudiante;

public interface IControladorSeleccionarEstEdiCurso {
	public List<String> listarInstitutos();
	public void ingresarInstituto(String nombre);
	public List<String> listarCursos();
	public void ingresarCurso(String nombre);
	public List<String> listarEdicion();
	public void ingresarEdicion(String nombre);
	public ArrayList<DtEstudiante> listarEstudiantesInscriptos();
	public void ingresarEstudiante(String nombre);
	public void seleccionarEstadoEstudiante(String estado);
	public DtEdicionDetalle SeleccionarEdicion();
}
