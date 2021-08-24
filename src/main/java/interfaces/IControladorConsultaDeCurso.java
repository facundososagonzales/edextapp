package interfaces;

import java.util.ArrayList;



import datatypes.DtCursoBase;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import datatypes.DtProgCurso;

public interface IControladorConsultaDeCurso {//NUEVO
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre);
	public DtInfoProgCurso seleccionarCurso(String nombreC) ;
	public DtProgCurso seleccionarPrograma(String nombreP);
	public DtEdicionDetalle seleccionarEdicion(String nomE) ;
	public ArrayList<DtCursoBase> ingresarCategoria(String nombre) ;
	public DtInfoProgCurso seleccionarCursoEnCat(String nombreC) ;
	public DtEdicionDetalle seleccionarEdicionCat(String nomE) ;
}