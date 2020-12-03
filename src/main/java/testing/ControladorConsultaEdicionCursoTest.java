package testing;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
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
import logica.Categoria;
import logica.Curso;
import logica.Docente;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.ManejadorEdicionesCurso;
import logica.ManejadorInstituto;
import persistencia.Conexion;

public class ControladorConsultaEdicionCursoTest {
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
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List<Instituto> inst = mI.getInstancias();

		String[] ret = iccec.listarInstituto();
		
		int resObtenido= inst.size();
		
		int resultadoEsperado = ret.length;
		
	
		assertEquals(resultadoEsperado,resObtenido);
	}
	

	
	@Test
	public void listarCategoriaTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		List<Categoria> cat = mC.getCategorias();

		String[] ret = iccec.listarCategoria();
		
		int resObtenido= cat.size();
		
		int resultadoEsperado = ret.length;
		
	
		assertEquals(resultadoEsperado,resObtenido);
	}
	
	@Test
	public void ListarCursosPorCatTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		String nombre="cat1";
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Categoria cat = e.find(Categoria.class,nombre);
		List<Curso> cursos=cat.getCursos();
		iccec.ingresarCategoria(nombre);
		String[] curCat= iccec.listarCursoPorCategoria();
		
		int resObtenido= cursos.size();
		int resEsperado=curCat.length;
		
		
		assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void ListarCursosPorInsTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		String nombre="a1";
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Instituto ins = e.find(Instituto.class, nombre);
		List<Curso> cursos= ins.getCursos();
		
		
		
		iccec.ingresarInstituto(nombre);
		String[] curIns= iccec.listarCurso();
		
		int resObtenido= cursos.size();
		int resEsperado=curIns.length;
		
		
		assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void ListarEdicionTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
		String nombre="a1";
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(nombre);
		String nomCur="c1";
		Curso curso= instituto.obtenerCurso(nomCur);
		List<Edicion> ediciones= curso.getEdiciones();
		
		int resObtenido= ediciones.size();
		
		
		iccec.ingresarInstituto(nombre);
		iccec.ingresarCurso(nomCur);
		String[] listEdi= iccec.listarEdicion();
	
		int resEsperado=listEdi.length;

		assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void ListarEdicionPorCatTest() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
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
		iccec.ingresarCategoria(nombre);
		iccec.ingresarCursoporCat(nomCur);
		String[] listEdi= iccec.listarEdicionCat();
	
		int resEsperado=listEdi.length;

		assertEquals(resEsperado,resObtenido);
	}
	
		
}
	@Test
	public void ListarDocentesTest() {
		
	Fabrica fab = Fabrica.getInstancia();
	IControladorConsultaEdicionCurso iccec = fab.getIControladorConsultaEdicionCurso();
	ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
	
	String nomEdi ="ed1";
	Edicion edicion= mE.buscarEdicion(nomEdi);
	List<Docente> docentes = edicion.getDocentesAsignados();
	int resObtenido= docentes.size();
	
	iccec.ingresarEdicion(nomEdi);
	String[] doc= iccec.listarDocentes();
	int resEsperado=doc.length;
	
	assertEquals(resEsperado,resObtenido);
	}
	
	@Test
	public void DtDetalleTest() {
		
		

	Fabrica fabrica = Fabrica.getInstancia();
	IControladorConsultaEdicionCurso iccec = fabrica.getIControladorConsultaEdicionCurso();
	iccec.ingresarEdicion("ed1");
	String nombre="ed1";
	ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
	Edicion edicion=mE.buscarEdicion(nombre);
	DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
	DtEdicionDetalle dt = iccec.SeleccionarEdicion();

	assertNotEquals(dt,dtEdicionReturn);


		}



	}
	
	



