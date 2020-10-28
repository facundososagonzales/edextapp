package interfaces;


import java.util.List;

import datatypes.DtCursoDetalle;
import excepciones.CursoRepetido;
import excepciones.ExisteCategoriaException;
import excepciones.InstitutoNoCargadoException;
import excepciones.PreviaYaExiste;
import logica.Curso;

public interface IControladorAltaCurso {

	public void ingresarDatos(DtCursoDetalle dcursos);
	public void ingresarInstituto(String nombre) throws InstitutoNoCargadoException;
	public void ingresarCurso(String nombreCurso) throws CursoRepetido;
	public void AgregarPrevias(String nombreprevia) throws PreviaYaExiste;
	public List<Curso> getPrevias();
	public void limpiarDatos();
	public List<String> listarCategorias();
	public void agregarCategoria(String nomCat) throws ExisteCategoriaException; 
	public List<String> listarCursos();

	
}