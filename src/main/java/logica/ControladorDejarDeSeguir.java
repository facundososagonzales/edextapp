package logica;

import java.util.ArrayList;
import java.util.List;

import excepciones.UsuarioNoExisteException;
import interfaces.IControladorDejarDeSeguir;

public class ControladorDejarDeSeguir implements IControladorDejarDeSeguir {
	private Usuario user;

	@Override
	public List<String> listarSeguidos(String nick) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario user=mu.buscarUsuario(nick);
		List<Usuario> seguidos = user.getSeguidos();
		List<String> nicks = new ArrayList<>();
		for(Usuario u : seguidos) {
			nicks.add(u.getNick());
		}
		return nicks;
	}
	
	@Override
	public void ingresarUser(String nick) throws UsuarioNoExisteException{
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario user=mu.buscarUsuario(nick);
		if (user==null) {
			throw new UsuarioNoExisteException("El usuario no existe");
		}
		this.user=user;
	}

	@Override
	public void dejarDeSeguir() {
		Usuario logueado = new Estudiante();
		logueado.dejarSeguirUsuario(this.user);

	}

}
