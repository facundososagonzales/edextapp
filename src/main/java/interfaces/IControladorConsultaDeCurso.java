package interfaces;

import java.util.ArrayList;


import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtEdicionDetalle;
import datatypes.DtProgCurso;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteNomEdicionException;
import excepciones.ExisteProgramaException;

public interface IControladorConsultaDeCurso {//NUEVO
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) throws ExisteInstitutoException;
	public DtCursoDetalle1 seleccionarCurso(String nombreC) throws ExisteCursoException;
	public DtProgCurso seleccionarPrograma(String nombreP)throws ExisteProgramaException;
	public DtEdicionDetalle seleccionarEdicion(String nomE) throws ExisteNomEdicionException;
}
