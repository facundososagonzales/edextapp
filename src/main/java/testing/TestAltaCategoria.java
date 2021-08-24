package testing;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datatypes.DtDocente;
import excepciones.ExisteCategoriaException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCategoria;
import logica.Categoria;
import logica.Docente;
import logica.Instituto;
import logica.ManejadorCategoria;
import persistencia.Conexion;

public class TestAltaCategoria {
	Conexion c; 
	EntityManager e;
	
	@Before
	public void inicilizarTest() {
		c = Conexion.getInstancia();
		e = c.getEntityManager();
	}
	
	
	@Test
	public void test1_AltaCatExitosaTest() throws ExisteCategoriaException {
		Fabrica fab = Fabrica.getInstancia();
		IControladorAltaCategoria icon = fab.getIControladorAltaCategoria();
		String nombreCat = "CategoriaTest";
		icon.altaCategoria(nombreCat);
		ManejadorCategoria mc = ManejadorCategoria.getInstancia(); 
		Categoria cat = mc.buscarCategoria(nombreCat);//e.find(Categoria.class, nombreCat);
		assertEquals(nombreCat,cat.getNombre());			
	}
	
	@After
	public void finalizar() {
		 	e.getTransaction().begin();
			Query q = e.createQuery("DELETE FROM Categoria c where c.nombre = :nombreCat ");
			q.setParameter("nombreCat", "CategoriaTest");
			int catEliminada =  q.executeUpdate();
			System.out.println("Eliminado: "+catEliminada);
			e.getTransaction().commit();
			//e.close();
			//c.close();
	 }	 
}
