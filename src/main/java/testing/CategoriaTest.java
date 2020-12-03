package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import logica.Categoria;
import logica.Curso;




public class CategoriaTest {
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
	
	
	Categoria cat = new Categoria();
	String nombre = "cat1";
	String nomCur = "c4";
	
	cat.setNombre(nombre);
	Categoria cat2 = new Categoria(nombre);
	Curso curso = new Curso();
	curso.setNombre(nomCur);
	String nombre2= cat.getNombre();
	cat.setCurso(curso);
	List<Curso> cursos = cat.getCursos();
	ArrayList<DtCursoBase> dtcurso = cat.listarCursos();
	DtCursoDetalle1 dtCurso = new DtCursoDetalle1();
	dtCurso=cat.obtenerInformacionDeCurso(nombre);
	
	
	assertNotEquals(cat, cat2);
	

	}
	

	}