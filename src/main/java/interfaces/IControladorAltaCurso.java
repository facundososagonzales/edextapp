package interfaces;


import java.util.List;

import datatypes.DtCursoDetalle;
import excepciones.CursoRepetido;
import excepciones.InstitutoNoCargadoException;
import excepciones.PreviaYaExiste;
import logica.Curso;

public interface IControladorAltaCurso {

	public void ingresarNombreCurso(String nombreCurso);
	public void ingresarDatos(DtCursoDetalle dcursos);
	public void ingresarInstituto(String nombre) throws InstitutoNoCargadoException;
	public void ingresarCurso(String nombreCurso) throws CursoRepetido;
	public void AgregarPrevias(String nombreprevia) throws PreviaYaExiste;
	public List<Curso> getPrevias();
	public void limpiarDatos();
	

	
}
