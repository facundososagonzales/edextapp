package logica;

import javax.persistence.EntityManager;

import excepciones.UsuarioNoExisteException;
import interfaces.IControladorSeguirUsuario;
import persistencia.Conexion;

public class ControladorSeguirUsuario implements IControladorSeguirUsuario {

	private Usuario user;
	
	
	public void ingresarUser(String nick) throws UsuarioNoExisteException  {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario user=mu.buscarUsuario(nick);
		if (user==null) {
			throw new UsuarioNoExisteException("No existe un usuario con ese nick");
		}
		this.user=user;
	}
	
	
	public void seguirUsuario(String nickLogueado) {
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario logueado=mu.buscarUsuario(nickLogueado);
		logueado.seguirUsuario(this.user);
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(logueado);
		e.persist(this.user);
		e.getTransaction().commit();
		
	}
	
	
}
