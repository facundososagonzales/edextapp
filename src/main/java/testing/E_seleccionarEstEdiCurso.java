package testing;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtEdicionDetalle;
import datatypes.DtEstudiante;
import datatypes.Estado;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;

import interfaces.Fabrica;
import interfaces.IControladorListarAceptadosEdiCurso;
import interfaces.IControladorSeleccionarEstEdiCurso;
import logica.Curso;
import logica.Edicion;
import datatypes.Estado;
import logica.Estudiante;
import logica.InscripcionEdi;
import logica.Instituto;

import logica.ManejadorEdicionesCurso;
import logica.ManejadorInstituto;
import logica.ManejadorUsuario;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class E_seleccionarEstEdiCurso {
	
	@Test
	
	public void test1_listarInstitutos() throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
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
	public void test2_ingresarInstituto() throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
		
		
		String nombreI = "i1";
		String nombreN;
		icac.ingresarInstituto(nombreI);
		nombreN = icac.getNombreI();
		
		
		assertEquals(nombreI, nombreN);
	}
	
	@Test
	
	public void test3_listarCursos() throws Exception{
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
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
		IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
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
		IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		icac.ingresarInstituto("i1");
		icac.ingresarCurso("biologia");
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
		IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
		
		String nombreI = "ed1";
		String nombreN;
		icac.ingresarEdicion(nombreI);
		nombreN = icac.getNombreEdi();
		
		
		assertEquals(nombreI, nombreN);
	}
	
	@Test
	
	public void test7_listarEstudiantes() throws Exception {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
		icac.ingresarInstituto("i1");
		icac.ingresarCurso("pav");
		icac.ingresarEdicion("ed2");
		ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion = mEC.buscarEdicion(icac.getNombreEdi());
		List<InscripcionEdi> edi = edicion.getEdiciones();
		List<String> estudiantes = new ArrayList<>();
		String[] list = icac.listarEstudiantes();
		
		
		for (InscripcionEdi ie: edi) {
			if(ie.getEstado().equals(Estado.Inscripto))
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

public void test8_listarEstudiantesInscriptos() {
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
	icac.ingresarInstituto("i1");
	icac.ingresarCurso("biologia");
	icac.ingresarEdicion("ed1");
	ManejadorEdicionesCurso mEC = ManejadorEdicionesCurso.getInstancia();
	Edicion edicion = mEC.buscarEdicion(icac.getNombreEdi());
	List<InscripcionEdi> edi = edicion.getEdiciones();
	ArrayList<DtEstudiante> estudiantes = new ArrayList<>();
	DtEstudiante[] list = icac.listarEstudiantesInscriptos();
	
	
	for (InscripcionEdi ie: edi) {
		DtEstudiante estudiantes1= new DtEstudiante(ie.getEstudiante().getNick(),ie.getEstudiante().getNombre(),ie.getEstudiante().getApellido(),ie.getEstudiante().getCorreo(),ie.getEstudiante().getFechaNac(),ie.getEstado());
		estudiantes.add(estudiantes1);
	}
	
	assertNotEquals(list,estudiantes);
}

@Test

public void test9_ingresarEstudiante() {
	
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
	
	String nombreI = "e1";
	String nombreN;
	icac.ingresarEstudiante(nombreI);
	nombreN = icac.getNomEst();
	
	
	assertEquals(nombreI, nombreN);
}

@Test

public void test91_seleccionarEstadoEstudiante() {
	
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorSeleccionarEstEdiCurso icac = fabrica.getIControladorSeleccionarEstEdiCurso();
	
	ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	icac.ingresarEstudiante("e1");
	Estudiante estudiante = (Estudiante)mU.buscarUsuario(icac.getNomEst());
	List<InscripcionEdi> est = estudiante.getInsEdi();
		
	
	for(InscripcionEdi ie: est) {
		if(ie.getEstudiante().getNick().equals(icac.getNomEst())) {
				ie.setEstado(Estado.Aceptado);
				}
					
	}
	
	
	icac.seleccionarEstadoEstudiante("Aceptado");
	
	InscripcionEdi ie = new InscripcionEdi();
	ie.setEstudiante(estudiante);
	Estado uno = ie.getEstado();
	
	
	assertFalse(uno==Estado.Aceptado);
	
	}


}



