package logica;

import datatypes.DtUsuario;
import excepciones.UsuarioNoExisteException;
import interfaces.IControladorSeguirUsuario;

public class ControladorSeguirUsuario implements IControladorSeguirUsuario {

	private Usuario user;
	
	
	public void ingresarUser(String nick) throws UsuarioNoExisteException  {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario user=mu.buscarUsuario(nick);
		if (user==null) {
			throw new UsuarioNoExisteException("El usuario no existe");
		}
		this.user=user;
	}
	
	
	public void seguirUsuario() {
		
		Usuario logueado = new Estudiante();
		logueado.seguirUsuario(user);
		
	}
	
	
}
