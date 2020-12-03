package testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;
import interfaces.IControladorDejarDeSeguir;
import logica.Instituto;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import logica.Usuario;

public class ControladorDejarDeSeguirTest {

	public ControladorDejarDeSeguirTest() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void listarSeguidosTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorDejarDeSeguir icds = fab.getIControladorDejarDeSeguir();
		
		String nick = "u1";
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario user=mu.buscarUsuario(nick);
		List<Usuario> seguidos = user.getSeguidos();
		
		String[] ret = icds.listarSeguidos(nick);
		
		int resObtenido= seguidos.size();
		
		int resultadoEsperado = ret.length;
		
	
		assertEquals(resultadoEsperado,resObtenido);
	}
	
	@Test
	public void ingresarUserTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorDejarDeSeguir icds = fab.getIControladorDejarDeSeguir();
		
		String nick = "u1";
		
		boolean resultadoEsperado=true;
		
		
		
		boolean resultadoObtenido= icds.ingresarUser(nick);
		
	
		
	
		assertEquals(resultadoEsperado,resultadoObtenido);
	}
	
	
	
	
	
	
	
	
	
}
