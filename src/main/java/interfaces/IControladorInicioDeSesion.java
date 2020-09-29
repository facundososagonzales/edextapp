package interfaces;

import excepciones.UsuarioNoExisteException;

public interface IControladorInicioDeSesion {

	public void ingresarUsuario(String usuario, String contrasenia) throws UsuarioNoExisteException;
	
}
