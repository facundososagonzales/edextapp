package logica;

import java.util.ArrayList;

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
		usu.setFechaNac(usuario.getFechaNac());
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(usu);
		e.getTransaction().commit();	
		
	}
}