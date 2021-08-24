package testing;

import static org.junit.Assert.*;

import java.util.Date;


import org.junit.Before;

import org.junit.Test;

import datatypes.Estado;

import logica.Edicion;
import logica.Estudiante;
import logica.InscripcionEdi;




public class InscripcionEdiTest {
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
	public void Constructor1Test() {
	
	
	InscripcionEdi insc = new InscripcionEdi();
	Estudiante est = new Estudiante();
	Edicion edi = new Edicion();
	Date fechaIns = new Date();
	String nombre = est.getNombre();
	insc.setEdicion(edi);
	insc.setEstudiante(est);
	insc.setFechaIns(fechaIns);
	
	
	insc.getEdicion();
	insc.getEstudiante();
	insc.getFechaIns();
	Estudiante est2 = new Estudiante();
	String nombre2 = est2.getNombre();
	
	InscripcionEdi insc2 = new InscripcionEdi(est, edi, fechaIns);
		
	assertNotEquals(insc, insc2);
	

	}
	

	@Test
	public void Constructor2Test() {
	
	
	InscripcionEdi insc = new InscripcionEdi();
	Estudiante est = new Estudiante();
	Edicion edi = new Edicion();
	Date fechaIns = new Date();
	String nombre = est.getNombre();
	insc.setEdicion(edi);
	insc.setEstudiante(est);
	insc.setFechaIns(fechaIns);
	
	
	insc.getEdicion();
	insc.getEstudiante();
	insc.getFechaIns();
	Estudiante est2 = new Estudiante();
	String nombre2 = est2.getNombre();
	Estado estado = Estado.Aceptado;
	
	InscripcionEdi insc3 = new InscripcionEdi(est,edi, fechaIns, estado);	
	insc3.setEstado(estado);
	assertNotEquals(insc, insc3);
	

	}
	}