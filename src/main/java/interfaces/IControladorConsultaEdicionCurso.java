package interfaces;

import java.util.List;

import datatypes.DtEdicionDetalle;

public interface IControladorConsultaEdicionCurso {
	public void ingresarInstituto(String nomInstituto);
	public List<String> listarInstituto();
	public List<String> listarCurso();
	public void ingresarCurso(String codCur);
	public List<String> listarEdicion();
	public void ingresarEdicion(String nomEdi);
	public DtEdicionDetalle SeleccionarEdicion();
	public List<String> listarDocentes();
	public void ingresarCategoria(String nomCategoria);
	public List<String> listarCursoPorCategoria();
	public List<String> listarCategoria();
	public List<String> listarEdicionCat();
	public void ingresarCursoporCat(String codCur);

}
