package logica;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private String nombre;
	
	public ControladorAltaUsuario() {
		super();
	}

	@Override
	public void ingresarUser(DtUsuario usuario) {
		this.usuario=usuario;
	}
	
	@Override
	public void ingresarInstituto(String nombre) {
		this.nombre=nombre;
	}
	
	@Override
	public boolean verificar() {
		//Si el nick o correo ya existe devuelve un false
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if (mu.buscarUsuario(this.usuario.getNick())==null || mu.buscarCorreo(this.usuario.getCorreo())==null) {
			return false;
		}else
			return true;
	}

	@Override
	public boolean modificarUser(String nick, String correo) {
		this.usuario.setNick(nick);
		this.usuario.setCorreo(correo);
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		if (mu.buscarUsuario(this.usuario.getNick())==null || mu.buscarCorreo(this.usuario.getCorreo())==null) {
			return false;
		}else
			return true;
	}

	@Override
	public void altaUsuario() {
		Usuario u =null;
		if (this.usuario instanceof DtDocente) {
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto instituto=mI.buscarInstituto(this.nombre);
			u = new Docente(this.usuario.getNick(),this.usuario.getNombre(),this.usuario.getApellido()
				,this.usuario.getCorreo(),this.usuario.getFechaNac(),instituto);
		}else if (this.usuario instanceof DtEstudiante) {
			u = new Estudiante(this.usuario.getNick(),this.usuario.getNombre(),this.usuario.getApellido()
				,this.usuario.getCorreo(),this.usuario.getFechaNac());
		}
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.agregarUsuario(u);
	}	

}
