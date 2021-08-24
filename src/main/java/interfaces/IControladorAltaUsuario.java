package interfaces;

import java.util.ArrayList;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import excepciones.InstitutoNoCargadoException;
import excepciones.PasswordRepetidaException;
import excepciones.UsuarioRepetidoException;


public interface IControladorAltaUsuario {


	public boolean ingresarUser(DtUsuario usuario);
	
	public boolean ingresarUserDoc(DtDocente dtDoc);
	
	public boolean ingresarUserEst(DtEstudiante dtEst);
	
	public boolean ingresarInstituto(String nombre);
	
	public void ingresarPassword(String password);
	
	public void verificarPassword(String password);
		
	public void altaUsuario();
	
	public ArrayList<DtUsuario> obtenerUsuarios();
}
