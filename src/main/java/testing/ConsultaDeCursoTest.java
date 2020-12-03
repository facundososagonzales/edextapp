package testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoBase;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import interfaces.Fabrica;
import interfaces.IControladorConsultaDeCurso;
import logica.Categoria;
import logica.Curso;
import logica.Edicion;
import logica.Instituto;
import logica.ManejadorCategoria;
import logica.ManejadorEdicionesCurso;
import logica.ManejadorInstituto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsultaDeCursoTest {
	
	@Before
	public void inicilizarTest() {
		
	}
	
	@Test
	public void test1_ResultadoEsperadoListar() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaDeCurso icon = fab.getIControladorConsultaDeCurso();
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		Instituto i = mi.buscarInstituto("Instituto1");
		ArrayList<DtCursoBase> cursos = icon.ingresarInstituto("Instituto1");
		List<Curso> cursosIns = i.getCursos();
		if(!i.equals(null)) {
			if(cursosIns.isEmpty()) {
				assertNull(cursos);
			}else {
				assertNotNull(cursos);
			}
			
		}else {
			assertNull(cursos);
		}
	}
	
	@Test
	public void test2_ResultadoEsperadoSeleccionarCurso() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaDeCurso icon = fab.getIControladorConsultaDeCurso();
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		Instituto i = mi.buscarInstituto("Instituto1");
		ArrayList<DtCursoBase> cursos = icon.ingresarInstituto("Instituto1");
		List<Curso> cursosIns = i.getCursos();
		
		if(!i.equals(null)) {
			if(cursosIns.isEmpty()) {
				assertNull(cursos);
			}else {
				int x = 0;
				String nombreC=null;
				for(DtCursoBase dt: cursos) {
					if(x==0) {
						nombreC = dt.getNombre();
						x +=1;
					}
				}
				DtInfoProgCurso dtinfo = icon.seleccionarCurso(nombreC);
				assertNotNull(dtinfo);
			}
			
		}else {
			assertNull(cursos);
		}
	}
	
	
	@Test
	public void test3_ResultadoEsperadoListarEnCat() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaDeCurso icon = fab.getIControladorConsultaDeCurso();
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		Categoria c = mc.buscarCategoria("Categoria1");
		ArrayList<DtCursoBase> cursos = icon.ingresarCategoria("Categoria1");
		List<Curso> cursosCat = c.getCursos();
		if(!c.equals(null)) {
			if(cursosCat.isEmpty()) {
				assertNull(cursos);
			}else {
				assertNotNull(cursos);
			}
			
		}else {
			assertNull(cursos);
		}
	}
	
	@Test
	public void test4_ResultadoEsperadoSeleccionarCursoEnCat() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorConsultaDeCurso icon = fab.getIControladorConsultaDeCurso();
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		Categoria c = mc.buscarCategoria("Categoria1");
		ArrayList<DtCursoBase> cursos = icon.ingresarCategoria("Categoria1");
		List<Curso> cursosCat = c.getCursos();
		
		if(!c.equals(null)) {
			if(cursosCat.isEmpty()) {
				assertNull(cursos);
			}else {
				int x = 0;
				String nombreC=null;
				for(DtCursoBase dt: cursos) {
					if(x==0) {
						nombreC = dt.getNombre();
						x +=1;
					}
				}
				DtInfoProgCurso dtinfo = icon.seleccionarCursoEnCat(nombreC);
				assertNotNull(dtinfo);
			}
			
		}else {
			assertNull(cursos);
		}
	}
	
	@Test

	public void seleccionarEdicion() throws Exception{

	Fabrica fabrica = Fabrica.getInstancia();
	IControladorConsultaDeCurso icac = fabrica.getIControladorConsultaDeCurso();
	icac.ingresarInstituto("i1");
	icac.seleccionarCurso("biologia");
	String nom = "ed1";
	ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
	Edicion edicion=mE.buscarEdicion(nom);
	DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
	DtEdicionDetalle dt = icac.seleccionarEdicion(nom);
	assertNotEquals(dt,dtEdicionReturn);


	}

	@Test
	public void seleccionarEdicionCat() throws Exception {

	Fabrica fabrica = Fabrica.getInstancia();
	IControladorConsultaDeCurso icac = fabrica.getIControladorConsultaDeCurso();
	icac.ingresarInstituto("i1");
	icac.seleccionarCurso("biologia");
	String nom = "ed1";
	ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
	Edicion edicion=mE.buscarEdicion(nom);
	DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
	DtEdicionDetalle dt = icac.seleccionarEdicionCat(nom);
	assertNotEquals(dt,dtEdicionReturn);
	}

	
	
	@After
	public void finalizarTest() {
		
	}
	

}
