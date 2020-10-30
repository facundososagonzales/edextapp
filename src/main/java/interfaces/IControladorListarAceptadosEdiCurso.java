package interfaces;

import java.util.List;

import datatypes.DtEdicionDetalle;
import excepciones.ExisteNomEdicionException;

public interface IControladorListarAceptadosEdiCurso {
	
	
		public List<String> listarInstitutos();
		public void ingresarInstituto(String nombre);
		public List<String> listarCursos();
		public void ingresarCurso(String nombre);
		public List<String> listarEdicion();
		public void ingresarEdicion(String nombre);
		public List<String> listarEstudiantesInscriptos();
		public DtEdicionDetalle seleccionarEdicion(String nomE) throws ExisteNomEdicionException;
}
