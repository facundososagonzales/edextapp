package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
	


public void cargarEdicion() {
	if(ediciones.isEmpty()) {
		String nombre1 = "Edicion1";
    	Date fechaInicio = new GregorianCalendar(2,2-1,2).getTime();
    	Date fechaFin = new GregorianCalendar(2,2-1,2).getTime();
    	Date fechaPub = new Date();
    	int cupos1 = 1;
		String nombre2 = "Edicion2";
    	Date fechaInicio1 = new GregorianCalendar(2,2-1,2).getTime();
    	Date fechaFin1 = new GregorianCalendar(2,2-1,2).getTime();
    	Date fechaPub1 = new Date();
    	int cupos2 = 2;
    	ManejadorCurso mC = ManejadorCurso.getInstancia();
    	Curso curso = mC.buscarCursos("Curso nro 1");
    	Edicion edicion1 = new Edicion(nombre1, fechaInicio,fechaFin,cupos1,fechaPub);
    	Edicion edicion2 = new Edicion(nombre2, fechaInicio1,fechaFin1,cupos2,fechaPub1);
    	List<Edicion> ediciones = new ArrayList <>();
    	ediciones.add(edicion2);
    	ediciones.add(edicion1);
    	curso.setEdiciones(ediciones);
    	this.ediciones = ediciones;
	}
}
}
