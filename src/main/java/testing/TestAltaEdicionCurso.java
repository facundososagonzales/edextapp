package testing;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import datatypes.DtCursoBase;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoPFormacion;
import excepciones.ExisteCursoException;
import excepciones.ExisteProgramaException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAProgDeFormacion;
import interfaces.IControladorAltaEdicionCurso;
import logica.Curso;
import logica.Docente;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCurso;
import logica.ManejadorEdicionesCurso;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import persistencia.Conexion;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAltaEdicionCurso {
	Conexion c; 
	EntityManager e;
	Boolean bool;
	
	@Before
	public void inicilizarTest() {
		c = Conexion.getInstancia();
		e = c.getEntityManager();
	}
	
	@Test 
	public void test1_listadoCorrectoInstitutos() {
		bool = false;
		Fabrica fab = Fabrica.getInstancia(); 
		IControladorAltaEdicionCurso icon =fab.getIControladorAltaEdicionCurso(); 
		String [] insti = icon.listarInstitutos();
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		List<Instituto> instiBase = mi.getInstancias();
		int cantControlador = insti.length;
		int cantBase= instiBase.size();
		
		assertEquals(cantControlador, cantBase);
	}
	
	@Test
	public void test2_ListadoCorrectoDeCursos()  {
		bool = false;
		//bool = false;
		Fabrica fab = Fabrica.getInstancia();
		IControladorAltaEdicionCurso icon =fab.getIControladorAltaEdicionCurso(); 
		String [] insti = icon.listarInstitutos();
		icon.ingresarInstituto("Instituto1");
		String [] cursosControlador = icon.listarCursos();
		//ManejadorCurso mc = ManejadorCurso.getInstancia(); 
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto insti1=mI.buscarInstituto("Instituto1");
		List<Curso> cursosBase = insti1.getCursos();
		
		int resControlador = cursosControlador.length;
		int resBase = cursosBase.size();
		assertEquals(resControlador,resBase);
	}
	
	@Test
	public void test3_AltaCorrecta(){
		bool = true;
		Fabrica fab = Fabrica.getInstancia();
		IControladorAltaEdicionCurso icon =fab.getIControladorAltaEdicionCurso(); 
		String [] insti = icon.listarInstitutos();
		icon.ingresarInstituto(insti[0]);
		String [] cursosControlador = icon.listarCursos();
		icon.ingresarCurso(cursosControlador[0]);
		String [] docentes = icon.listarDocentes();
		icon.ingresarDocentes(docentes);
			
		Date fechaI = new Date();
		Date fechaF = new Date();
		Date fechaPub = new Date();
		DtEdicionDetalle dted = new DtEdicionDetalle("EdicionTest31221",fechaI,fechaF,15,fechaPub);
		boolean bool1 =icon.ingresarEdicionCurso(dted);
		if(bool1) {
			boolean resEsperado = true;
			boolean resAlta;
			resAlta = icon.darAltaEdicionCurso();
			assertEquals(resEsperado, resAlta);
		}
	}
	
	@Test
	public void ListarDocentesTest() {
	bool = false;
	Fabrica fab = Fabrica.getInstancia();
	IControladorAltaEdicionCurso icaec = fab.getIControladorAltaEdicionCurso();
	ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	
	
	
	
	Conexion c = Conexion.getInstancia();
	EntityManager e = c.getEntityManager();
	Query q = e.createQuery("select d from Docente d");
	List<Docente> docente = (List<Docente>) q.getResultList();
	
	int resObtenido= docente.size();
	
	
	String[] doc= icaec.listarDocentes();
	int resEsperado=doc.length;
	
	assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void ingresarCurso () {
	bool = false;
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorAltaEdicionCurso icac = fabrica.getIControladorAltaEdicionCurso();
	icac.ingresarInstituto("i1");
	String nombreC = "pav";
	String nombreN;
	icac.ingresarCurso(nombreC);
	nombreN = icac.getNombre();


	assertEquals(nombreC, nombreN);

	}

	@Test
	public void ingresarEdicionCurso() {
	bool = false;
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorAltaEdicionCurso icac = fabrica.getIControladorAltaEdicionCurso();

	DtEdicionDetalle dt = new DtEdicionDetalle ("ed",null,null,0,null);
	icac.ingresarEdicionCurso(dt);
	DtEdicionDetalle dt1 = icac.getEdicion();

	assertEquals(dt,dt1);

	}
	
	/*@Test

	public void ingresarDocentes () throws Exception {

	Fabrica fabrica = Fabrica.getInstancia();
	IControladorAltaEdicionCurso icac = fabrica.getIControladorAltaEdicionCurso();
	
	Docente doc =  new Docente();
	doc.setNick("doc12");
	Docente u1 =  new Docente();
	doc.setNick("u1");
	icac.ingresarDocentes("doc12");
	List <String> lista = icac.getDocentes();
	lista.add(u1.getNick());
	lista.add(doc.getNick());
	String nom = icac.getNombre();

	assertNotEquals(doc.getNick(),nom);

	}*/
	
	
	@After
	public void finalizarTest() {
		if(bool==true) {
		 	e.getTransaction().begin();
		 	/*Query q = e.createQuery("DELETE FROM Edicion_Docente e where e.edicion_nombre = :nombreEdi ");
		 	q.setParameter("nombreEdi", "EdicionTest");
		 	int nombreEdiElim1 =  q.executeUpdate();
			q = e.createQuery("DELETE FROM Edicion e where e.nombre = :nombreEdi ");
			q.setParameter("nombreEdi", "EdicionTest");
			int nombreEdiElim =  q.executeUpdate();
			System.out.println("Eliminado: "+nombreEdiElim+nombreEdiElim1);*/
			e.getTransaction().commit();
			e.close();
			c.close();

		}
	}

}
