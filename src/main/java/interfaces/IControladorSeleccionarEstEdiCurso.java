package interfaces;


import datatypes.DtEdicionDetalle;
import datatypes.DtEstudiante;


public interface IControladorSeleccionarEstEdiCurso {
	public String[] listarInstitutos();
	public boolean ingresarInstituto(String nombre);
	public String[] listarCursos();
	public boolean ingresarCurso(String nombre);
	public String[] listarEdicion();
	public boolean ingresarEdicion(String nombre);
	public DtEstudiante[] listarEstudiantesInscriptos();
	public boolean ingresarEstudiante(String nombre);
	public void seleccionarEstadoEstudiante(String estado);
	public DtEdicionDetalle SeleccionarEdicion();
	public String[] listarEstudiantes();
	public String getNombreI();
	public String getNombreC();
	public String getNombreEdi();
	public String getNomEst();
	
}
