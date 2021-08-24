package testing;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoDetalle;
import datatypes.DtEdicionDetalle;
import datatypes.Estado;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;


import java.util.ArrayList;
import java.util.List;

import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;

import logica.Categoria;
import logica.Curso;

import logica.ManejadorCategoria;
import logica.ManejadorCurso;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaCursoTest {
	
	@Test
	
	public void test2_ingresarNombreCurso() {
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
		icac.ingresarInstituto("i1");
		String nombreC = "pav";
		String nombreN;
		icac.ingresarCurso(nombreC);
		nombreN = icac.getNombre();
		
		
		assertNotEquals(nombreC, nombreN);
		
	}
	
@Test
	
	public void test1_ingresarInstituto() {
	
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
	
	
	String nombreI = "i1";
	String nombreN;
	icac.ingresarInstituto(nombreI);
	nombreN = icac.getInstituto();
	
	
	assertEquals(nombreI, nombreN);
	

	}
	
@Test

public void test4_agregarPrevia() {
	
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
	
	icac.ingresarCurso("pav2");
	icac.ingresarInstituto("i1");
	String nombreP = "logica";
		
	String[] lista = icac.getPrevias();
	
	int num1 = lista.length;
	icac.AgregarPrevias("logica");
	int num2 = lista.length;
	
	assertEquals(num1,num2);
	
}

@Test

public void agregarPrevia() {
	
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
	
	icac.ingresarCurso("pav2");
	icac.ingresarInstituto("i1");
	String nombreP = "logica";
		
	String[] lista = icac.getPrevias();
	
	int num1 = lista.length;
	icac.AgregarPrevias("logica");
	int num2 = lista.length;
	
	assertEquals(num1,num2);
	
}


	@Test
	
	public void listarCategorias() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
		
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		List<Categoria> cats = mc.getCategorias();
		
		String[] lista = icac.listarCategorias();
		
		
		int c=0;
		for (String i : lista) {
			for (Categoria in : cats) {
				if (i.equals(in.getNombre())) {
					c++;
				}
			}
		}
		int total = mc.getCategorias().size();
		assertEquals(total,c);
	}
	
	@Test
	
	public void listarCursos()  {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> curs = mc.getCursos();
		
		String[] lista = icac.listarCursos();
		
		int c=0;
		for (String i : lista) {
			for (Curso in : curs) {
				if (i.equals(in.getNombre())) {
					c++;
				}
			}
		}
		int total = mc.getCursos().size();
		assertEquals(total,c);
		
	}
	
	@Test

	public void agregarPrevia2() {

	Fabrica fabrica = Fabrica.getInstancia();
	IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();

	icac.ingresarCurso("pav2");
	icac.ingresarInstituto("i1");
	String nombreP = "logica";

	String[] lista = icac.getPrevias();

	int num1 = lista.length;
	icac.AgregarPrevias2("logica");
	int num2 = lista.length;

	assertEquals(num1,num2);

	}

	@Test
	public void agregarCategoria() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
		String [] categorias = icac.getCategorias();
		
		String Categoria= "cat1";
		
		int num = categorias.length;
			
		icac.agregarCategoria(Categoria);
		
		int num2 = categorias.length;
		
		
		assertEquals(num,num2);
			}
		
	
	@Test
	public void ingresarDatos() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaCurso icac = fabrica.getIControladorAltaCurso();
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> curs = mc.getCursos();
		icac.ingresarInstituto("i1");
		
		int num = curs.size();
		
	
		DtCursoDetalle dcur = new DtCursoDetalle ("pavs2","sjds","1",null,0,null,"jn");
		icac.ingresarCurso("pavs222221");
		icac.AgregarPrevias("c1");
		icac.agregarCategoria("cat1");
		icac.ingresarDatos(dcur);
		
		int num1 = curs.size();
		
		assertEquals(num,num1);
		
	}
		
	}

