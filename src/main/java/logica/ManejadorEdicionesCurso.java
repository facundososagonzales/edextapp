package logica;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorEdicionesCurso {
	private static ManejadorEdicionesCurso instancia = null;
	//private List<Edicion> ediciones = new ArrayList<>();
	
	private ManejadorEdicionesCurso(){}
	
	public static ManejadorEdicionesCurso getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEdicionesCurso();
		return instancia;
	}

	public void agregarEdicion(Edicion edicion) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(edicion);
		e.getTransaction().commit();	
		
		
		//ediciones.add(edicion);
	}
	
	public Edicion buscarEdicion(String nombre) {
		Edicion aretornar=null;
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select e from Edicion e");
		List<Edicion> ediciones = (List<Edicion>) q.getResultList();
		
		
		for(Edicion ed: ediciones) {
			if (ed.getNombre().equals(nombre))
				aretornar=ed;
		}
		return aretornar;
	}
	
}
