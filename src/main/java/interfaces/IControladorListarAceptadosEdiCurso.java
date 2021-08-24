package interfaces;

import java.util.List;

import datatypes.DtEdicionDetalle;


public interface IControladorListarAceptadosEdiCurso {
	
	
		public String[] listarInstitutos();
		public void ingresarInstituto(String nombre);
		public String[] listarCursos();
		public void ingresarCurso(String nombre);
		public String[] listarEdicion();
		public void ingresarEdicion(String nombre);
		public String[] listarEstudiantesInscriptos();
		public DtEdicionDetalle seleccionarEdicion(String nomE);
		public String getNombreI();
		public String getNombreC();
		public String getNombreEdi();
}
