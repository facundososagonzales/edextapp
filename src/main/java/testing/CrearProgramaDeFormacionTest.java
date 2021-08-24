package testing;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtProgFormacion;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorCrearProgFormacion;
import logica.Curso;
import logica.ManejadorProgFormacion;
import logica.ProgFormacion;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;


import java.util.ArrayList;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrearProgramaDeFormacionTest {

	@Test
	
	public void ingresarNombreProg() {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorCrearProgFormacion icac = fabrica.getIControladorCrearProgFormacion();
		String nombreC = "prog18965";
		String nombreN;
		icac.ingresarNombreProg(nombreC);
		nombreN = icac.getNombre();
		
		
		assertNotEquals(nombreC, nombreN);
		
	}
	
	@Test 
	
	public void ingresarNombreProgFor() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorCrearProgFormacion icac = fabrica.getIControladorCrearProgFormacion();
		
		String nombreC = "prog3213";
		String nombreN;
		icac.ingresarNombreProgFor(nombreC);
		nombreN = icac.getNombre();
		
		
		assertNotEquals(nombreC, nombreN);
	
		
	}
	
	
	@Test
	
	public void ingresarDatos() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorCrearProgFormacion icac = fabrica.getIControladorCrearProgFormacion();
		icac.ingresarNombreProgFor("prog32222221132");
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> lista = mpf.obtenerProgramas();
		DtProgFormacion progfor = new DtProgFormacion ("asdas", null, null, null);
		
		int num = lista.size();
		
		icac.ingresarDatos(progfor);
		List<ProgFormacion> lista1 = mpf.obtenerProgramas();
		int num1 = lista1.size();
		
		assertNotEquals(num, num1);
	}
	
	
	}
	

