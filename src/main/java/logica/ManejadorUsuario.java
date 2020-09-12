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
	
	public ArrayList<String> obtenerUsuarios(){
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Usuario u: usuarios) {
			aRetornar.add(new String(u.getNick()));
		}
		return aRetornar;
	}
	
	public List<String> listarEstudiantes(){
		List<String> estudiantes = new ArrayList<>();
		for(Usuario u: usuarios) {
			if(u instanceof Estudiante) {
				estudiantes.add(u.getNick());
			}
		}
		return estudiantes;
	}
}
