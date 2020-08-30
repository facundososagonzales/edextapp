package interfaces;

import datatypes.DtUsuario;
import excepcion.UsuarioRepetido;

public interface IControladorAltaUsuario {

	public void ingresarUser(DtUsuario usuario) throws UsuarioRepetido;
	
	public void ingresarInstituto(String nombre);
		
	public void altaUsuario();
	
}
