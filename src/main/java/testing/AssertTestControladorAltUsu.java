package testing;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.runners.MethodSorters;
import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import logica.Docente;
import logica.Instituto;
import logica.Usuario;
import persistencia.Conexion;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssertTestControladorAltUsu {
	Fabrica fab;
	IControladorAltaUsuario icon; 
	Docente u;
	DtDocente dt;
	Instituto i;
	String insti;
	Conexion c; 
	EntityManager e;
	boolean inicio ;
	boolean fin ;
	
	
	
	@Before
	public void inicilizarTest() {
		if((inicio!=true)) {
			i = new Instituto();
			i.setNombre("Instituto1");
			u = new Docente("test1","pepe","perez","correo.com",null,i);
			dt = new DtDocente(u.getNick(),u.getNombre(),u.getApellido(),u.getCorreo(),u.getFechaNac()); 
			dt.setNick(u.getNick());
			insti = "Instituto1";
			c = Conexion.getInstancia();
			e = c.getEntityManager();
			fab = Fabrica.getInstancia();
			icon = fab.getIControladorAltaUsuario();
			inicio = true;
			fin = false;	
		}
		
		
	}
	
	@Test
	public void test1_resultadoEsperadoTest() {
		boolean resEsperado = false;
		boolean resultado0 = icon.ingresarUser(dt);
		assertEquals(resEsperado,resultado0);
	}
	
	@Test
	public void test2_resultadoEsperadoIngresarInstituto() {
		boolean resEsperado = false;
		boolean resultado1 = icon.ingresarInstituto(i.getNombre());		
		assertEquals(resEsperado,resultado1);
		
	}
	
	@Test 
	public void test3_altaExitosaTest() {
		fin = true;
		boolean resultado0 = icon.ingresarUser(dt);
		boolean resultado = icon.ingresarInstituto(i.getNombre());
		icon.ingresarPassword("12345");
		icon.verificarPassword("12345");
		icon.altaUsuario();
		Docente uAux = e.find(Docente.class, u.getNick());
		System.out.println(uAux.getNick());
		assertEquals(u.getNick(),uAux.getNick());
	}
	
	@Test
	public void test4_resultadoEsperadoTestIngresoWeb() {
	boolean resEsperado = false;
	boolean resultado0 = icon.ingresarUserDoc(dt);
	assertEquals(resEsperado,resultado0);
	}

	@Test
	public void test5_resultadoEsperadoTestIngresoWeb() {
	DtEstudiante dt1 = new DtEstudiante(u.getNick(),u.getNombre(),u.getApellido(),u.getCorreo(),u.getFechaNac());
	boolean resEsperado = false;
	boolean resultado0 = icon.ingresarUserEst(dt1);
	assertEquals(resEsperado,resultado0);
	}
	
	@After
	public void finalizar() {
		if(fin==true) {
			e.getTransaction().begin();
			Query q = e.createQuery("DELETE FROM Docente d where d.nick = :nick ");
			q.setParameter("nick", "test1");
			int usEliminado =  q.executeUpdate();
			System.out.println("Eliminado: "+usEliminado);
			e.getTransaction().commit();
			//e.close();
		//	c.close();
		}
	}
	
}
