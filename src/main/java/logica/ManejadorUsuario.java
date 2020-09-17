package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

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
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(usuario);
		e.getTransaction().commit();
		
		usuarios.add(usuario);
	}
	
	public Usuario buscarUsuario(String nick) {
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Usuario u = e.find(Usuario.class, nick);
		return u;
	}
	
	public Usuario buscarCorreo(String correo) {
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Usuario u = e.find(Usuario.class, correo);
		
		return u;
	}
	
	public ArrayList<String> obtenerUsuarios(){
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) q.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Usuario u: usuarios) {
			aRetornar.add(new String(u.getNick()));
		}
		return aRetornar;
	}
	
	public ArrayList<String> obtenerCorreos(){
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select u from Usuario u");
		List<Usuario> usuarios = (List<Usuario>) q.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Usuario u: usuarios) {
			aRetornar.add(new String(u.getCorreo()));
		}
		return aRetornar;
	}
	
	public List<String> listarEstudiantes(){
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select i from usuario i");
		List<Usuario> usuarios = (List<Usuario>) q.getResultList();
		
		List<String> estudiantes = new ArrayList<>();
		for(Usuario u: usuarios) {
			if(u instanceof Estudiante) {
				estudiantes.add(u.getNick());
			}
		}
		return estudiantes;
	}
}
