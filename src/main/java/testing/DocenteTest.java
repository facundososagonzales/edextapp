package testing;

import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import logica.Docente;
import logica.Estudiante;
import logica.InscripcionEdi;
import logica.Instituto;
import logica.Usuario;


public class DocenteTest {
	
	@Before
	public void inicializarTest() {
		
	}
	
	@Test
	public void altaDocente() {
		Docente doc = new Docente();
		doc.setApellido("Apellido");
		doc.setCorreo("correo1.com");
		Date fechaNac = new Date();
		doc.setFechaNac(fechaNac);
		Instituto ins = new Instituto();
		ins.setNombre("insti");
		doc.setInstituto(ins);
		doc.setNombre("Pepito");
		doc.setNick("prueba");
		doc.setPassword("contra123");
		Docente doc1 = new Docente(doc.getNick(), doc.getNombre(), doc.getApellido(), doc.getNick(), doc.getFechaNac(), doc.getInstituto());
		assertNotSame(doc, doc1);
	}
	
	@Test
	public void altaEstudiante() {
		Estudiante est= new Estudiante();
		est.setApellido("Apellido");
		est.setCorreo("correo1.com");
		Date fechaNac = new Date();
		est.setFechaNac(fechaNac);
		Instituto ins = new Instituto();
		ins.setNombre("insti");
		est.setNombre("Pepito");
		est.setNick("prueba");
		est.setPassword("contra123");
		Estudiante doc1 = new Estudiante(est.getNick(), est.getNombre(), est.getApellido(), est.getNick(), est.getFechaNac());
		List<InscripcionEdi> inscrip = est.getInsEdi();
		List<Usuario> seguidores = new ArrayList<>();
		seguidores.add(doc1);
		est.setSeguidores(seguidores);
		assertNotSame(est, doc1);
		
	}
	
	@After
	public void finalizar() {
		
	}

}
