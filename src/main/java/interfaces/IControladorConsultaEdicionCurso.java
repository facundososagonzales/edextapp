package interfaces;

import java.util.List;

import datatypes.DtEdicionDetalle;

public interface IControladorConsultaEdicionCurso {
	public void ingresarInstituto(String nomInstituto);
	public String[] listarInstituto();
	public String[] listarCurso();
	public void ingresarCurso(String codCur);
	public String[] listarEdicion();
	public void ingresarEdicion(String nomEdi);
	public DtEdicionDetalle SeleccionarEdicion();
	public String[] listarDocentes();
	public void ingresarCategoria(String nomCategoria);
	public String[] listarCursoPorCategoria();
	public String[] listarCategoria();
	public String[] listarEdicionCat();
	public void ingresarCursoporCat(String codCur);

}
