package testing;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorModificarDatosUsuario;
import logica.Categoria;
import logica.Curso;
import logica.ManejadorUsuario;
import logica.Usuario;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;


import java.util.ArrayList;
import java.util.List;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModificarDatosDeUsuarioTest {
	
	@Test
	
	public void listarUsuario() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorModificarDatosUsuario icac = fabrica.getIControladorM();
		
		ArrayList<String> usuario;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usuario = mU.obtenerUsuarios();
		String[] lista = icac.listarUsuario();
		
		
		int c=0;
		for (String i : lista) {
			for (String in : usuario) {
				if (i.equals(in)) {
					c++;
				}
			}
		}
		
		int total = mU.obtenerUsuarios().size();
		assertEquals(total,c);
		
	}

	
	@Test
	
	public void elegirUsuario() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorModificarDatosUsuario icac = fabrica.getIControladorM();
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usu = mU.buscarUsuario("e1");
		DtUsuario dtUsu = new DtUsuario(usu.getNombre(),usu.getApellido());
	
		DtUsuario dtUsu1 = icac.elegirUsuario("e1");
		
		assertNotEquals(dtUsu,dtUsu1);
	}
	
	@Test 
	
	public void modificar() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorModificarDatosUsuario icac = fabrica.getIControladorM();
		
		DtUsuario usuario = icac.elegirUsuario("e1");
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		String nombreAnterior = usuario.getNombre();
		icac.modificar(usuario);	
		String nombreNuevo = usuario.getNombre();
		
		assertEquals(nombreAnterior,nombreNuevo);
	}
	
	@Test
	
	public void listarUsuarios() {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorModificarDatosUsuario icac = fabrica.getIControladorM();
		
		List<Usuario> usuario;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usuario = mU.obtenerListUsuarios();
		String[] lista = icac.listarUsuarios();
		
		
		int c=0;
		for (String i : lista) {
			for (Usuario in : usuario) {
				if (i.equals(in.getNombre())) {
					c++;
				}
			}
		}
		int total = mU.obtenerListUsuarios().size();
		assertEquals(total,c);
		
	}
	
	@Test
	
	public void DatosUsuario() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorModificarDatosUsuario icac = fabrica.getIControladorM();
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usu = mU.buscarUsuario("e1");
		DtUsuario dtUsu = new DtUsuario(usu.getNick(),usu.getNombre(),usu.getApellido(),usu.getCorreo(),usu.getFechaNac());
		
		DtUsuario dt = icac.datosUsuario("e1");
		
		assertNotEquals(dtUsu,dt);
		
		
	}
		
}
