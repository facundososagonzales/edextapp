package interfaces;


import java.util.List;


import datatypes.DtCursoDetalle;
import logica.Categoria;
import logica.Curso;

public interface IControladorAltaCurso {

	public void ingresarDatos(DtCursoDetalle dcursos);
	public boolean ingresarInstituto(String nombre) ;
	public boolean ingresarCurso(String nombreCurso);
	public boolean AgregarPrevias2(String nombreprevia) ;
	public boolean AgregarPrevias(String nombreprevia) ;
	public String[] getPrevias();
	public void limpiarDatos();
	public String[] listarCategorias();
	public boolean agregarCategoria(String nomCat); 
	public String[] listarCursos();
	public String getNombre();
	public String getInstituto();
	public String[] getCategorias();
	public DtCursoDetalle getCursos();

	
}