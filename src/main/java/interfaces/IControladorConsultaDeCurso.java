package interfaces;

import java.util.ArrayList;


import datatypes.DtCursoBase;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import datatypes.DtProgCurso;
import excepciones.ExisteCategoriaException;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteNomEdicionException;
import excepciones.ExisteProgramaException;
import excepciones.ListaDeCursosVaciaException;

public interface IControladorConsultaDeCurso {//NUEVO
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) throws ExisteInstitutoException,ListaDeCursosVaciaException;
	public DtInfoProgCurso seleccionarCurso(String nombreC) throws ExisteCursoException;
	public DtProgCurso seleccionarPrograma(String nombreP)throws ExisteProgramaException;
	public DtEdicionDetalle seleccionarEdicion(String nomE) throws ExisteNomEdicionException;
	public ArrayList<DtCursoBase> ingresarCategoria(String nombre) throws ExisteCategoriaException,ListaDeCursosVaciaException;
	public DtInfoProgCurso seleccionarCursoEnCat(String nombreC) throws ExisteCursoException;
}