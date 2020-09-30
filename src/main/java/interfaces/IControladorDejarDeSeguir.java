package interfaces;

import java.util.List;

import excepciones.UsuarioNoExisteException;

public interface IControladorDejarDeSeguir {
	
	public void ingresarUser(String nick) throws UsuarioNoExisteException;

	public List<String> listarSeguidos(String nick);

	public void dejarDeSeguir();
}
