package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;

import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;
import datatypes.DtCursoDetalle1;
import datatypes.Estado;
import logica.Categoria;
import logica.Curso;
import logica.Edicion;
import logica.Estudiante;
import logica.InscripcionEdi;
import logica.Instituto;




public class InstitutoTest {
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
	public void ConstructorTest() {
	
	
	Instituto ins = new Instituto();
	String nombre = "i1";
	String nomCur = "c4";
	
	ins.setNombre(nombre);
	Instituto ins2 = new Instituto(nombre);
	Curso curso = new Curso();
	curso.setNombre(nomCur);
	String nombre2= ins.getNombre();
	ins.setCurso(curso);
	List<Curso> cursos = ins.getCursos();
	ArrayList<DtCursoBase> dtcurso = ins.listarCursos();
	DtCursoDetalle1 dtCurso = new DtCursoDetalle1();
	dtCurso=ins.obtenerInformacionDeCurso(nombre);
	
	
	assertNotEquals(ins, ins2);
	

	}
	

	}