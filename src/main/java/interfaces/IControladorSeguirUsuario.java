package interfaces;

import excepciones.UsuarioNoExisteException;

public interface IControladorSeguirUsuario {
	
	public void ingresarUser(String nick) throws UsuarioNoExisteException;
	public void seguirUsuario(String nickLogueado);

}
