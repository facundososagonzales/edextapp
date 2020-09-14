package logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstituto {
	private static ManejadorInstituto instancia = null;
	//private List<Instituto> institutos = new ArrayList<>();
	
	private ManejadorInstituto(){}
	
	public static ManejadorInstituto getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstituto();
		return instancia;
	}

	public void agregarInstituto(Instituto instituto) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(instituto);
		e.getTransaction().commit();
		
		//institutos.add(instituto);
	}
	
	public Instituto buscarInstituto(String nombre) {
		//Instituto aretornar=null;
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Instituto i = e.find(Instituto.class, nombre);
		
		/*for(Instituto i: institutos) {
			if ( i.getNombre().equals(nombre))
				aretornar=i;
		}
		return aretornar;*/
		return i;
	}
	
	public List<Instituto> getInstancias(){
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select i from Instituto i");
		List<Instituto> institutos = (List<Instituto>) q.getResultList();
		
		//return this.institutos;
		
		return institutos;
		
	}
	
	
}
