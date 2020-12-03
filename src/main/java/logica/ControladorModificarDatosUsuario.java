package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.IControladorModificarDatosUsuario;
import persistencia.Conexion;
import datatypes.DtUsuario;

public class ControladorModificarDatosUsuario implements IControladorModificarDatosUsuario {
	private Usuario usu;
	

	@Override
	public String[] listarUsuario() {
		ArrayList<String> usuario;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usuario = mU.obtenerUsuarios();
		String[] usu = new String[usuario.size()];
        int i=0;
        for(String u:usuario) {
        	usu[i]=u;
        	i++;
        }
        return usu;
	}
	
	@Override
	public DtUsuario elegirUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usu = mU.buscarUsuario(nick);
		DtUsuario dtUsu = new DtUsuario(usu.getNombre(),usu.getApellido());
		return dtUsu;
	}
	
	@Override
	public void modificar(DtUsuario usuario) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usu = mU.buscarUsuario(usu.getNick());
		usu.setNombre(usuario.getNombre());
		usu.setApellido(usuario.getApellido());
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(usu);
		e.getTransaction().commit();	
		
	}
	
	@Override
	public String[] listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<Usuario> usu = mU.obtenerListUsuarios();
		List<String> usuario = new ArrayList<>();
		
		for (Usuario i: usu) {
			usuario.add(i.getNick());
		}
String[] ret = usuario.stream().toArray(String[]::new);// esta bien esto?
		
		return ret;
	}
	
	@Override
	public DtUsuario datosUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usu = mU.buscarUsuario(nick);
		DtUsuario dtUsu = new DtUsuario(usu.getNick(),usu.getNombre(),usu.getApellido(),usu.getCorreo(),usu.getFechaNac());
		return dtUsu;
	}
}