package logica;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import excepciones.InstitutoNoCargadoException;
import excepciones.UsuarioRepetidoException;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private String nombre;
	
	public ControladorAltaUsuario() {
		super();
	}

	@Override

public void ingresarUser(DtUsuario usuario) throws UsuarioRepetidoException {
	ManejadorUsuario mu = ManejadorUsuario.getInstancia();
	if (mu.buscarUsuario(usuario.getNick())!=null) {
		throw new UsuarioRepetidoException("El nick "+ usuario.getNick() +" ya existe en el sistema\n");
	}else if(mu.buscarCorreo(usuario.getCorreo())!=null) {
		throw new UsuarioRepetidoException("El correo "+usuario.getCorreo() +" ya existe en el sistema\n");
	}else {
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
	public void altaUsuario() {
		if (this.usuario instanceof DtDocente) {
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto instituto=mI.buscarInstituto(this.nombre);
			Docente u = new Docente(this.usuario.getNick(),this.usuario.getNombre(),this.usuario.getApellido()
				,this.usuario.getCorreo(),this.usuario.getFechaNac(),instituto);
				ManejadorUsuario mU = ManejadorUsuario.getInstancia();
				mU.agregarUsuario(u);
		}else if (this.usuario instanceof DtEstudiante) {
			Estudiante u = new Estudiante(this.usuario.getNick(),this.usuario.getNombre(),this.usuario.getApellido()
			,this.usuario.getCorreo(),this.usuario.getFechaNac());
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			mU.agregarUsuario(u);
		}
	}

}	
