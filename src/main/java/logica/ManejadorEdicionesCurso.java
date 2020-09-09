package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorEdicionesCurso {
	private static ManejadorEdicionesCurso instancia = null;
	private List<Edicion> ediciones = new ArrayList<>();
	
	private ManejadorEdicionesCurso(){}
	
	public static ManejadorEdicionesCurso getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEdicionesCurso();
		return instancia;
	}

	public void agregarEdicion(Edicion edicion) {
		ediciones.add(edicion);
	}
	
	public Edicion buscarEdicion(String nombre) {
		Edicion aretornar=null;
		for(Edicion e: ediciones) {
			if (e.getNombre().equals(nombre))
				aretornar=e;
		}
		return aretornar;
	}
	
}
	
	
	
	