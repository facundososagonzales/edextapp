package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private List<Usuario> usuarios = new ArrayList<>();
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public Usuario buscarUsuario(String nick) {
		Usuario aretornar=null;
		for(Usuario c: usuarios) {
			if (c.getNick().equals(nick))
				aretornar=c;
		}
		return aretornar;
	}
	
	public Usuario buscarCorreo(String correo) {
		Usuario aretornar=null;
		for(Usuario c: usuarios) {
			if (c.getCorreo().equals(correo))
				aretornar=c;
		}
		return aretornar;
	}
}
