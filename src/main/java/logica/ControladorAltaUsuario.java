package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import excepciones.InstitutoNoCargadoException;
import excepciones.PasswordRepetidaException;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorAltaUsuario;
import persistencia.Conexion;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private String nombre;
	private String password;
	
	public ControladorAltaUsuario() {
		super();
	}

	@Override
	public boolean ingresarUser(DtUsuario usuario) {
		ArrayList<DtUsuario> usuariosAux = obtenerUsuarios();
		boolean encontre = false;
		
		for(DtUsuario dt: usuariosAux) {
			if(dt.getNick().equals(usuario.getNick())){
				encontre = true;
				System.out.println("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
			}
			else if(dt.getCorreo().equals(usuario.getCorreo())) {
				encontre = true;
				System.out.println("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
			}
		}
		this.usuario=usuario;
		return encontre;
	}
	
	@Override
	public boolean ingresarInstituto(String nombre) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		boolean ret = false;
		if(mI.buscarInstituto(nombre)!=null)
			this.nombre=nombre;
		else {
			System.out.println("El Instituto "+nombre +" no existe en el sistema\n");
			ret = true;
		}
		return ret;
	}
	
	@Override
	public void ingresarPassword(String password) {
		this.password=password;
	}
	
	@Override
	public void verificarPassword(String password) {
		if(!this.password.equals(password)) {
			System.out.println("Las passwords no coinciden");
		}
	}

	@Override
	public void altaUsuario() {
		if (this.usuario instanceof DtDocente) {
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto instituto=mI.buscarInstituto(this.nombre);
			Docente u = new Docente(this.usuario.getNick(),this.usuario.getNombre(),this.usuario.getApellido()
			,this.usuario.getCorreo(),this.usuario.getFechaNac(),instituto);
			u.setPassword(password);
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			mU.agregarUsuario(u);
		}else if (this.usuario instanceof DtEstudiante) {
			Estudiante u = new Estudiante(this.usuario.getNick(),this.usuario.getNombre(),this.usuario.getApellido()
			,this.usuario.getCorreo(),this.usuario.getFechaNac());
			u.setPassword(password);
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			mU.agregarUsuario(u);
		}
	}
	

	@Override
	public boolean ingresarUserDoc(DtDocente usuario) {
		
		ArrayList<DtUsuario> usuariosAux = obtenerUsuarios();
		boolean encontre = false;
		
		for(DtUsuario dt: usuariosAux) {
			if(dt.getNick().equals(usuario.getNick())){
				encontre = true;
				System.out.println("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
			}
			else if(dt.getCorreo().equals(usuario.getCorreo())) {
				encontre = true;
				System.out.println("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
			}
		}
		this.usuario=usuario;
		return encontre;
		
	}
	
	@Override
	public boolean ingresarUserEst(DtEstudiante usuario) {
		ArrayList<DtUsuario> usuariosAux = obtenerUsuarios();
		boolean encontre = false;
		
		for(DtUsuario dt: usuariosAux) {
			if(dt.getNick().equals(usuario.getNick())){
				encontre = true;
				System.out.println("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
			}
			else if(dt.getCorreo().equals(usuario.getCorreo())) {
				encontre = true;
				System.out.println("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
			}
		}
		this.usuario=usuario;
		return encontre;
		
	}

	@Override
	public ArrayList<DtUsuario> obtenerUsuarios() {
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select d from Docente d");
		List<Docente> usuarios = (List<Docente>) q.getResultList();
		
		Query q1 = e.createQuery("select e from Estudiante e");
		List<Estudiante> usuarios1 = (List<Estudiante>) q1.getResultList();
		
		ArrayList<DtUsuario> usuariosAux = new ArrayList<>();
		for(Docente u: usuarios) {
			DtUsuario aux = new DtUsuario(u.getNick(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getFechaNac());
			usuariosAux.add(aux);
		}
		
		for(Estudiante u: usuarios1) {
			DtUsuario aux = new DtUsuario(u.getNick(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getFechaNac());
			usuariosAux.add(aux);
		}
		
		return usuariosAux;
	}

	
	

}	
