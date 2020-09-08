package interfaces;

import datatypes.DtUsuario;

import excepciones.InstitutoNoCargadoException;
import excepciones.UsuarioRepetido;

public interface IControladorAltaUsuario {

	public void ingresarUser(DtUsuario usuario) throws UsuarioRepetido;
	
	public void ingresarInstituto(String nombre)throws InstitutoNoCargadoException;
		
	public void altaUsuario();
	
}
