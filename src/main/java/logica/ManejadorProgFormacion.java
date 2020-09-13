package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtInfoPFormacion;
import persistencia.Conexion;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia = null;
	
	private ManejadorProgFormacion() {}
	
	public static ManejadorProgFormacion getInstancia() {
		if(instancia == null) {
			instancia = new ManejadorProgFormacion();
		}
		return instancia;
	}
	
	public void agregarProgformacion(ProgFormacion p) {
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(p);
		e.getTransaction().commit();
		
		//progsFormacion.add(p);
	}
	
	public ProgFormacion buscarProgFormacion(String nombre) {
		//ProgFormacion aRet = null;
				
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		ProgFormacion p = e.find(ProgFormacion.class, nombre);
		return p;
			
	}
	
	public ArrayList<DtInfoPFormacion> datosProgsFormacion(){
		ArrayList<DtInfoPFormacion> aRet = new ArrayList<>();
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select p from ProgFormacion p");
		List<ProgFormacion> progsFormacion = (List<ProgFormacion>) q.getResultList();
		
		for(ProgFormacion p: progsFormacion) {
			aRet.add(p.getDtInfoPFormacion());
		}
		return aRet;
	}
		
	public List<ProgFormacion> obtenerProgramas(){
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select p from ProgFormacion p");
		List<ProgFormacion> progsFormacion = (List<ProgFormacion>) q.getResultList();
		return progsFormacion;
	}
}
