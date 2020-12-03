package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtInfoPFormacion;
import datatypes.DtProgCurso;
import interfaces.Fabrica;
import interfaces.IControladorConsultaProgFormacion;
import logica.ControladorConsultaProgFormacion;
import logica.ManejadorProgFormacion;
import logica.ProgFormacion;
import persistencia.Conexion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestConsultaProgFormacion {
	
	@Before
	public void inicilizarTest() {
		
	}
	
	@Test
	public void test1_ListadoCorrecto() {
		Fabrica fab = Fabrica.getInstancia();
		ControladorConsultaProgFormacion icon = new ControladorConsultaProgFormacion();
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> progsFormacion = mp.obtenerProgramas();
		if(programas.isEmpty()) {
			int resObtenido = programas.size();
			int resEsperado = progsFormacion.size();
			assertEquals(resObtenido, resEsperado);
		}else {
			int resObtenido = programas.size();
			int resEsperado = progsFormacion.size();
			assertEquals(resObtenido, resEsperado);
		}
	}
	
	@Test
	public void test2_resultadoEsperado() {
		Fabrica fab = Fabrica.getInstancia();
		ControladorConsultaProgFormacion icon = new ControladorConsultaProgFormacion();
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		if(programas.isEmpty()) {
			DtProgCurso dt = icon.seleccionarPrograma("Programa1");
			assertNull(dt);
		}else {
			DtProgCurso dt = icon.seleccionarPrograma("Programa1");
			assertNotNull(dt);
		}
	}
	
	@Test
	public void test3_resultadoEsperadoConsulta() {
		Fabrica fab = Fabrica.getInstancia();
		ControladorConsultaProgFormacion icon = new ControladorConsultaProgFormacion();
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		if(!programas.isEmpty()) {
			DtProgCurso dt = icon.seleccionarPrograma("Programa1");
			ArrayList<DtCursoBase> cursos = dt.getDtCursos();
			int i = 0;
			String nom = null;
			if(!cursos.isEmpty()) {
				for(DtCursoBase d: cursos) {
					if(i==0) {
						nom = d.getNombre();
						i +=1;
					}
					DtCursoDetalle1 d1 = icon.seleccionarCurso(nom);
					assertNotNull(d1);
				}
			}else {
				DtCursoDetalle1 d1 = icon.seleccionarCurso("CursobuscError");
				assertNull(d1);
			}
			
		}else {
			DtProgCurso dt1 = icon.seleccionarPrograma("Programa1");
			assertNull(dt1);
		}
	}
	
	
	@After
	public void finalizarTest() {
		
	}
	
}
