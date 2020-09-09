package interfaces;

import datatypes.DtUsuario;

import excepcion.InstitutoNoCargadoException;
import excepcion.UsuarioRepetidoException;

public interface IControladorAltaUsuario {


	public void ingresarUser(DtUsuario usuario) throws UsuarioRepetidoException;
	
	public void ingresarInstituto(String nombre)throws InstitutoNoCargadoException;
		
	public void altaUsuario();
	
}
