package interfaces;

import java.util.List;

public interface IControladorListarAceptadosEdiCurso {
	
	
		public List<String> listarInstitutos();
		public void ingresarInstituto(String nombre);
		public List<String> listarCursos();
		public void ingresarCurso(String nombre);
		public List<String> listarEdicion();
		public void ingresarEdicion(String nombre);
		public List<String> listarEstudiantesInscriptos();
	
}
