package logica;

import java.util.List;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import excepciones.InstitutoNoCargadoException;
import excepciones.PasswordRepetidaException;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private String nombre;
	private String password;
	
	public ControladorAltaUsuario() {
		super();
	}

	@Override
	public void ingresarUser(DtUsuario usuario) throws UsuarioRepetidoException {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		List<String> usuarios = mu.obtenerCorreos();
		if (mu.buscarUsuario(usuario.getNick())!=null) {
			throw new UsuarioRepetidoException("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
		}else {
			for(String s: usuarios) {
				if(usuario.getCorreo().equals(s))
					throw new UsuarioRepetidoException("El correo "+usuario.getCorreo() +" ya existe en el sistema\n");
			}
		this.usuario=usuario;
		}
	}
	
	@Override
	public void ingresarInstituto(String nombre) throws InstitutoNoCargadoException {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(mI.buscarInstituto(nombre)!=null)
			this.nombre=nombre;
		else
			throw new InstitutoNoCargadoException("El Instituto "+nombre +" no existe en el sistema\n");
	}
	
	@Override
	public void ingresarPassword(String password) {
		this.password=password;
	}
	
	@Override
	public void verificarPassword(String password) throws PasswordRepetidaException {
		if(!this.password.equals(password)) {
			throw new PasswordRepetidaException("Las passwords no coinciden");
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

}	
