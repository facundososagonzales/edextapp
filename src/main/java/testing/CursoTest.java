package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datatypes.DtCursoDetalle1;
import datatypes.DtEdicionDetalle;
import excepciones.InstitutoCargadoException;
import interfaces.Fabrica;
import logica.Curso;
import logica.Edicion;
import persistencia.Conexion;


public class CursoTest {
	
	@Before
	public void inicilizarTest() {
		
	}
	
	@Test
	public void test1_ExisteCurso() {
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		String nom = "Curso1";
		Curso curso = e.find(Curso.class,nom);
		
		if(!curso.equals(null)) {
			assertEquals(curso.getNombre(), nom);
		}else {
			assertNull(curso.getPrevias());
		}
	}
	
	@Test
	public void test2_NoExisteCurso(){
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		String nom = "Curso1";
		Curso curso = e.find(Curso.class,nom);
		
		if(!curso.equals(null)) {
			assertNotNull(curso.getDtCursoDetalle());
		}else {
			assertNull(curso.getPrevias());
		}
	}
	

	@Test
	public void test3_CrearCurso(){
		Curso cur = new Curso();
		cur.setNombre("CursoPrueba");
		cur.setCantHoras(null);
		cur.setDuracion("10:02:05");
		Edicion ed = new Edicion();
		ed.setNombre("EdicionTest");
		cur.setEdicion(ed);
		Date fechaR = new Date();
		cur.setFechaR(fechaR);
		cur.setDescripcion("cursonuevo");
		cur.setUrl("url.com");
		List<Curso> previas = new ArrayList<>();
		Curso cursoP = new Curso();
		previas.add(cursoP);
		cur.setPrevias(previas);
		List<Curso> previasRes = cur.getPrevias();
		DtCursoDetalle1 dt = cur.getDtCursoDetalle();
		DtEdicionDetalle dtd = cur.obtenerDtEdicionDetalle(ed.getNombre());
		assertEquals(previas.size(), previasRes.size());
	}
	
	
	
	@After
	public void finalizar() {
		
	 }	 
	

}
