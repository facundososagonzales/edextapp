package testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtWebCurso;
import datatypes.DtWebProgF;
import interfaces.Fabrica;
import interfaces.IControladorListaCursoPrograma;
import logica.Curso;
import logica.ManejadorCurso;
import logica.ManejadorProgFormacion;
import logica.ProgFormacion;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestListaCursoPrograma {
	@Before
	public void inicilizarTest() {
		
	}
	
	@Test
	public void test1_ListadoCorrectoCursos() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorListaCursoPrograma icon = fab.getIControladorListaCursoPrograma();
		ArrayList<DtWebCurso> cursosControlador = icon.listarCursos();
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursosBase = mc.getCursos();
		if(cursosBase.isEmpty()) {
			assertNull(cursosControlador);
		}else {
			int resEsperado = cursosBase.size();
			int resObtenido = cursosControlador.size();
			assertEquals(resEsperado, resObtenido);
		}
	}
	
	@Test
	public void test2_ListadoCorrectoProgramas() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorListaCursoPrograma icon = fab.getIControladorListaCursoPrograma();
		ArrayList<DtWebProgF> programasControlador = icon.listarProgramas();
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> programasBase = mp.obtenerProgramas();
		
		if(programasBase.isEmpty()) {
			assertNull(programasControlador);
		}else {
			int resEsperado = programasBase.size();
			int resObtenido = programasControlador.size();
			assertEquals(resEsperado, resObtenido);
		}
		
	}
	
	@After
	public void finalizarTest() {
		
	}
}
