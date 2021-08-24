package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;
import excepciones.ExisteCursoException;
import excepciones.ExisteProgramaException;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAProgDeFormacion;
import logica.Curso;
import logica.ManejadorCurso;
import logica.ManejadorProgFormacion;
import logica.ProgFormacion;
import persistencia.Conexion;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgregarCursoAProgTest {
	Conexion c; 
	EntityManager e;
	boolean bool;
	@Before
	public void inicilizarTest() {
		c = Conexion.getInstancia();
		e = c.getEntityManager();
	}
	
	@Test
	public void test1_ListadoCorrectoDeProgramas() {
		Fabrica fab = Fabrica.getInstancia();
		IControladorAgregarCursoAProgDeFormacion icon = fab.getIControladorAgregarCursoAProgDeFormacion();
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> progsBase = mpf.obtenerProgramas();
		int resControlador = programas.size();
		int resBase = progsBase.size();
		assertEquals(resControlador,resBase);
		
	}
	
	@Test
	public void test2_ListadoCorrectoDeCursos() throws ExisteProgramaException, ExisteCursoException {
		Fabrica fab = Fabrica.getInstancia();
		IControladorAgregarCursoAProgDeFormacion icon = fab.getIControladorAgregarCursoAProgDeFormacion();
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		String nombre = "Programa1";
		String nombreC = "Curso1";
		ArrayList<DtCursoBase> cursos = icon.seleccionarProgFormacion(nombre);
		ManejadorCurso mc = ManejadorCurso.getInstancia(); 
		List<Curso> cursosBase = mc.getCursos();
		int resControlador = cursos.size();
		int resBase = cursosBase.size();
		assertEquals(resControlador,resBase);
	}
	
	@Test
	public void test3_ProgramaContieneCursoAgregado() throws ExisteProgramaException, ExisteCursoException {
		bool = true;
		Fabrica fab = Fabrica.getInstancia();
		IControladorAgregarCursoAProgDeFormacion icon = fab.getIControladorAgregarCursoAProgDeFormacion();
		ArrayList<DtInfoPFormacion> programas = icon.listarProgsFormacion();
		String nombre = "Programa1";
		String nombreCurso = "Curso1";
		ArrayList<DtCursoBase> cursos = icon.seleccionarProgFormacion(nombre);
		icon.seleccionarCurso(nombreCurso);
		icon.confirmar();
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion pf = mpf.buscarProgFormacion(nombre);
		
		//Busco en los cursos del programa de formacion el curso agregado recientemente
		//Si encontro el programa el test va a ser Exitosos
		List<Curso> cursosDelPorg = pf.obtenerCursos();
		Curso cursoDelPrograma = null;
		for(Curso c: cursosDelPorg) {
			if(c.getNombre().equals(nombreCurso)) {
				cursoDelPrograma = c;
			}
		}
		
		assertEquals(nombreCurso, cursoDelPrograma.getNombre());
		
	}
	
	@Test
	public void listarProgsFormacion2Test() {
		
	Fabrica fab = Fabrica.getInstancia();
	IControladorAgregarCursoAProgDeFormacion icaec = fab.getIControladorAgregarCursoAProgDeFormacion();
	ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
	List<ProgFormacion> progFor = mpf.obtenerProgramas();
	
	
	
	
	int resObtenido= progFor.size();
	
	
	String[] list2= icaec.listarProgsFormacion2();
	int resEsperado=list2.length;
	
	assertEquals(resEsperado,resObtenido);
	}
	
		
	@After
	public void finalizar() {
			if(bool==true) {
				e.getTransaction().begin();          
				/*Query q = e.createQuery("DELETE FROM PROGFORMACION_CURSO pf where pf.progformacion_nombre = :nombrePrograma ");
				q.setParameter("nombrePrograma", "Programa1");
				int progElim =  q.executeUpdate();
				System.out.println("Eliminado: "+progElim);*/
				e.getTransaction().commit();
				//e.close();
				//c.close();
			}
	 }	 

	

}
