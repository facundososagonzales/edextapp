package testing;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtEdicionDetalle;
import datatypes.Estado;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;


import java.util.ArrayList;
import java.util.List;

import interfaces.Fabrica;

import interfaces.IControladorListarAceptadosEdiCurso;
import logica.Categoria;

import logica.ControladorListarAceptadosEdiCurso;
import logica.Curso;
import logica.Edicion;
import logica.InscripcionEdi;
import logica.Instituto;
import logica.ManejadorEdicionesCurso;
import logica.ManejadorInstituto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ListarAceptadosEdiCursoTest {


	@Test
	
	public void test1_listarInstitutos() throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List <Instituto> listaIns = mI.getInstancias();
		String[] ins = icac.listarInstitutos();
		int c=0;
		for (String i : ins) {
			for (Instituto in : listaIns) {
				if (i.equals(in.getNombre())) {
					c++;
				}
			}
		}
		int total = mI.getInstancias().size();
		assertEquals(total,c);
		
		
		
	}
	@Test
	public void test2_ingresarInstituto () throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
		
		
		String nombreI = "i1";
		String nombreN;
		icac.ingresarInstituto(nombreI);
		nombreN = icac.getNombreI();
		
		
		assertEquals(nombreI, nombreN);
	}
	
	@Test
	
	public void test3_listarCursos() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		icac.ingresarInstituto("i1");
		Instituto instituto=mI.buscarInstituto(icac.getNombreI());
		List<Curso> curso = new ArrayList<>();
		curso = instituto.getCursos();
		String[] lisCur = icac.listarCursos();
		
		int c=0;
		for (String i : lisCur) {
			for (Curso in : curso) {
				if (i.equals(in.getNombre())) {
					c++;
				}
			}
		}
		int total = instituto.getCursos().size();
		assertEquals(total,c);
		
	}
	
	
	@Test
	public void test4_ingresarCurso () throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
		icac.ingresarInstituto("i1");
		String nombreC = "pav";
		String nombreN;
		icac.ingresarCurso(nombreC);
		nombreN = icac.getNombreC();
		
		
		assertEquals(nombreC, nombreN);
		
	}
	
	@Test
	
	public void test5_listarEdicion() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		icac.ingresarInstituto("i1");
		icac.ingresarCurso("pav");
		Instituto instituto=mI.buscarInstituto(icac.getNombreI());
		List<Curso> curso =instituto.getCursos();
		String[] listEdi = icac.listarEdicion();
		List<Edicion> edicion = new ArrayList<>();
				for (Curso c: curso) {
					if (c.getNombre().equals(icac.getNombreC())){
						edicion = c.getEdiciones();
					}	
				}
		

			int c=0;
			for (String i : listEdi) {
				for (Edicion in : edicion) {
					if (i.equals(in.getNombre())) {
						c++;
					}
				}
			}
			int total = edicion.size();
			assertEquals(total,c);
				
		
	}
	
	@Test
	
	public void test6_ingresarEdicion () throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
		
		
		String nombreI = "ed1";
		String nombreN;
		icac.ingresarEdicion(nombreI);
		nombreN = icac.getNombreEdi();
		
		
		assertEquals(nombreI, nombreN);
	}
	
	
	@Test
	
	public void test7_listarEstudiantes() throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
		icac.ingresarInstituto("i1");
		icac.ingresarCurso("pav");
		icac.ingresarEdicion("ed2");
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion = mEC.buscarEdicion(icac.getNombreEdi());
		List<InscripcionEdi> edi = edicion.getEdiciones();
		List<String> estudiantes = new ArrayList<>();
		String[] list = icac.listarEstudiantesInscriptos();
		
		
		for (InscripcionEdi ie: edi) {
			if(ie.getEstado().equals(Estado.Aceptado))
				estudiantes.add(ie.getEstudiante().getNick());
		}
		
		
		int c=0;
		for (String i : list) {
			for (String in : estudiantes) {
				if (i.equals(in)) {
					c++;
				}
			}
		}
		int total = estudiantes.size();
		assertEquals(total,c);
	}	
		
		
		@Test
		
		public void test8_seleccionarEdicion() throws Exception{
			
			Fabrica fabrica = Fabrica.getInstancia();
			IControladorListarAceptadosEdiCurso icac = fabrica.getIControladorListarAceptadosEdiCurso();
			icac.ingresarEdicion("ed1");
			ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
			Edicion edicion=mE.buscarEdicion(icac.getNombreEdi());
			DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
			DtEdicionDetalle dt = icac.seleccionarEdicion("ed1");
			
			assertNotEquals(dt,dtEdicionReturn);
			
			
		}
		
		
		
	}
	
	

	



