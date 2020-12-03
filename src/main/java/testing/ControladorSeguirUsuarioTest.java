package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import interfaces.Fabrica;
import interfaces.IControladorDejarDeSeguir;
import interfaces.IControladorSeguirUsuario;

public class ControladorSeguirUsuarioTest {

	public ControladorSeguirUsuarioTest() {
		// TODO Auto-generated constructor stub
	}

	
	
	@Test
	public void ingresarUserTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorSeguirUsuario icds = fab.getIControladorSeguirUsuario();
		
		String nick = "u1";
		
		boolean resultadoEsperado=true;
		
		
		
		boolean resultadoObtenido= icds.ingresarUser(nick);
		
	
		
	
		assertEquals(resultadoEsperado,resultadoObtenido);
	}
}
