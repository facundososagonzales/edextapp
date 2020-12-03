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

public class ControladorInsEdicionCursoTest {
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
	public void listarInstitutoTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List<Instituto> inst = mI.getInstancias();

		String[] ret = iciec.listarInstitutos();
		
		int resObtenido= inst.size();
		
		int resultadoEsperado = ret.length;
		
	
		assertEquals(resultadoEsperado,resObtenido);
	}
	

	
	@Test
	public void listarCategoriaTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		List<Categoria> cat = mC.getCategorias();

		String[] ret = iciec.listarCategorias();
		
		int resObtenido= cat.size();
		
		int resultadoEsperado = ret.length;
		
	
		assertEquals(resultadoEsperado,resObtenido);
	}
	
	@Test
	public void ListarCursosPorCatTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		String nombre="cat1";
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Categoria cat = e.find(Categoria.class,nombre);
		List<Curso> cursos=cat.getCursos();
		iciec.ingresarCategoria(nombre);
		String[] curCat= iciec.listarCursosCategoria();
		
		int resObtenido= cursos.size();
		int resEsperado=curCat.length;
		
		
		assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void ListarCursosPorInsTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		String nombre="a1";
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Instituto ins = e.find(Instituto.class, nombre);
		List<Curso> cursos= ins.getCursos();
		
		
		
		iciec.ingresarInstituto(nombre);
		String[] curIns= iciec.listarCursos();
		
		int resObtenido= cursos.size();
		int resEsperado=curIns.length;
		
		
		assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void ListarEdicionTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
		String nombre="a1";
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(nombre);
		String nomCur="c1";
		Curso curso= instituto.obtenerCurso(nomCur);
		List<Edicion> ediciones= curso.getEdiciones();
		
		int resObtenido= ediciones.size();
		
		
		iciec.ingresarInstituto(nombre);
		iciec.ingresarCursoInstituto(nomCur);
		String[] listEdi= iciec.listarEdicion();
	
		int resEsperado=listEdi.length;

		assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void ListarEdicionPorCatTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
		String nombre="cat1";
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(nombre);
		String nomCur="c4";
		
		List<Edicion> ediciones=new ArrayList<>();
		List<Curso> cursos= categoria.getCursos();
		List<String> nomEdicion=new ArrayList<>();
		if (!cursos.isEmpty()) {
			for (Curso c: cursos) {
				if (c.getNombre().equals(nomCur)) {
				nomCur=c.getNombre();
				
				ediciones= c.getEdiciones();
				}
				if (!ediciones.isEmpty()) {
					for (Edicion e: ediciones) {
						nomEdicion.add(e.getNombre());
					}
			}
		}
		int resObtenido= ediciones.size();
		iciec.ingresarCategoria(nombre);
		iciec.ingresarCursoporCat(nomCur);
		String[] listEdi= iciec.listarEdicionCat();
	
		int resEsperado=listEdi.length;

		assertEquals(resEsperado,resObtenido);
	}
	
		
}
	
	
	@Test 								
	public void ListarEstudiantesTest() { 
		
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
	
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		//List<String> estudiantes = mU.listarEstudiantes();
	
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select s from Estudiante s");
		List<Estudiante> estudiantes = (List<Estudiante>) q.getResultList();
	
	int resObtenido= estudiantes.size();
	
	
	String[] est= iciec.listarEstudiantes();
	int resEsperado=est.length;
	
	assertEquals(resEsperado,resObtenido);
	
	
	}
	
	/*@Test 									NO FUNCIONA
	public void ListarEstudiantesTest() { 
		
		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
	
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> est = new ArrayList<>();
		est=mU.listarEstudiantes();
	
	
	int resObtenido= est.size();
	
	String[] estEsperados= iciec.listarEstudiantes();

	int resEsperado=estEsperados.length;
	
	assertEquals(resEsperado,resObtenido);
	}*/
	
	
	@Test
	public void DtDetalleTest() {
		
		

		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
	iciec.ingresarEdicion("ed1");
	String nombre="ed1";
	ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
	Edicion edicion=mE.buscarEdicion(nombre);
	DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
	DtEdicionDetalle dt = iciec.SeleccionarEdicion();

	assertNotEquals(dt,dtEdicionReturn);


		}
	
	@Test
	public void InscripcionEscritorio() {
		
		

		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
	
		boolean resEsperado=false;
		String edicion = "ed1";
		String nombre = "user2";
		Date fecha=null;
		

		
		boolean resObtenido= iciec.inscripcionEstudiante(nombre, fecha, edicion);
	
		assertEquals(resEsperado,resObtenido);
	}

	/*@Test
	public void InscripcionWeb() {
		
		

		Fabrica fab = Fabrica.getInstancia();
		IControladorInsEdicionCurso iciec = fab.getIControladorInsEdicionCurso();
	
		
		String edicion = "ed1";
		String nombre = "user2";
		Date fecha=null;
		

		
		iciec.inscripcionEstudianteW(nombre, edicion);
		
	
		assertNotEquals(resEsperado,resObtenido);
	}*/
	}
	
	



