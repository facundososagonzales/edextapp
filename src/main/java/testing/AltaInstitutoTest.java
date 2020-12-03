package testing;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.InstitutoCargadoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaInstituto;
import logica.Instituto;
import logica.ManejadorInstituto;
import persistencia.Conexion;

public class AltaInstitutoTest {
	Conexion c; 
	EntityManager e;
	
	@Before
	public void inicilizarTest() {
		c = Conexion.getInstancia();
		e = c.getEntityManager();
	}
	
	@Test
	public void test1_altaInstExitosa() throws InstitutoCargadoException{
		Fabrica fab = Fabrica.getInstancia();
		IControladorAltaInstituto icon = fab.getIControladorAltaInstituto();
		String nombreI= "institutoTest";
		icon.darDeAltaInstituto(nombreI);
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		Instituto i = mi.buscarInstituto(nombreI);
		assertEquals(nombreI,i.getNombre());
		
	}
	
	@After
	public void finalizar() {
		 	e.getTransaction().begin();
			Query q = e.createQuery("DELETE FROM Instituto i where i.nombre = :nombreInst ");
			q.setParameter("nombreInst", "institutoTest");
			int instElim =  q.executeUpdate();
			System.out.println("Eliminado: "+instElim);
			e.getTransaction().commit();
			//e.close();
			//c.close();
	 }	 

}
