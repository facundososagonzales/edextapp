package testing;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datatypes.DtEdicionDetalle;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;
import interfaces.IControladorInicioDeSesion;
import interfaces.IControladorInsEdicionCurso;
import logica.Categoria;
import logica.Curso;
import logica.Docente;
import logica.Edicion;
import logica.Estudiante;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicionesCurso;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import persistencia.Conexion;

public class IniciarSesionTest {
	//Auto a;
	
//	@BeforeClass
//Metodo que se ejecuta antes de todos los before
//	public void antesDeTodo() {
//		
//	}
	
//Método que se ejecuta antes de realizarse los tests	
//Se ejecuta antes de cualquier test unitario
	@Before
	public void inicializarTest() {
			
	
	}
	
	@Test
	public void ingresarUsuarioTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInicioDeSesion icis = fab.getIControladorIniciodeSesion();
		String user = "u1";
		String contrasenia = "u1";
		boolean resultadoEsperado=true;
		boolean resObtenido= icis.ingresarUsuario(user, contrasenia);
		
		
		
	
		assertEquals(resultadoEsperado,resObtenido);
	}
	
	@Test
	public void tipoUsuarioTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInicioDeSesion icis = fab.getIControladorIniciodeSesion();
		String tipo = "docente";
		String user = "u1";
		String tipoObtenido=icis.tipoUsuario(user);
		
		
		
	
		assertNotEquals(tipo,tipoObtenido);
	}
	
	

	
	}
	
	



