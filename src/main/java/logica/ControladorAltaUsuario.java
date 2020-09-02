package logica;

import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import excepcion.InstitutoNoCargadoException;
import excepcion.UsuarioRepetido;
import interfaces.IControladorAltaUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {
	private DtUsuario usuario;
	private String nombre;
	
	public ControladorAltaUsuario() {
		super();
	}

	@Override
	public void ingresarUser(DtUsuario usuario) throws UsuarioRepetido {
		this.usuario=usuario;
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		System.out.println("Nick: " + this.usuario.getNick());
		System.out.println("Nombre: " + this.usuario.getNombre());
		System.out.println("Apellido: " + this.usuario.getApellido());
		System.out.println("Correo: " +this.usuario.getCorreo());
		System.out.println("Fecha: " + this.usuario.getFechaNac().toString());
		if (mu.buscarUsuario(this.usuario.getNick())!=null) {
			throw new UsuarioRepetido("El nick "+ this.usuario.getNick() +" ya existe en el sistema\n");
		}else if(mu.buscarCorreo(this.usuario.getCorreo())!=null) {
			throw new UsuarioRepetido("El correo "+this.usuario.getCorreo() +" ya existe en el sistema\n");
		}
	}
	
	@Override
	public void ingresarInstituto(String nombre) throws InstitutoNoCargadoException {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		if(mI.buscarInstituto(nombre)!=null)
			this.nombre=nombre;
		else
			throw new InstitutoNoCargadoException("El Instituto "+ nombre +" no existe en el sistema\n");
	}

	@Override
	public void altaUsuario() {
		Usuario u=null;
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
