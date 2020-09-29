package logica;

import java.util.List;

import javax.persistence.EntityManager;

import persistencia.Conexion;
import javax.persistence.Query;

public class ManejadorCategoria {
	private static ManejadorCategoria instancia=null;
	
	private ManejadorCategoria() {}
	
	public static ManejadorCategoria getInstancia() {
		if(instancia==null) {
			instancia = new ManejadorCategoria();
		}
		return instancia;
	}
	
	public void agregarCategoria(Categoria cat) {
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		e.getTransaction().begin();
		e.persist(cat);
		e.getTransaction().commit();
	}
	
	public Categoria buscarCategoria(String nombre) {
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Categoria cat = e.find(Categoria.class,nombre);
		return cat;		
	}
	
	public List<Categoria> getCategorias(){
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select c from Categoria c");
		List<Categoria> categorias = (List<Categoria>) q.getResultList();
		return categorias;
		
	}

}

