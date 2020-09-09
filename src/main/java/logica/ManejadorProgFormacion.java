package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtInfoPFormacion;

public class ManejadorProgFormacion {
	private static ManejadorProgFormacion instancia = null;
	private List<ProgFormacion> progsFormacion = new ArrayList<>();
	
	private ManejadorProgFormacion() {}
	
	public static ManejadorProgFormacion getInstancia() {
		if(instancia == null) {
			instancia = new ManejadorProgFormacion();
		}
		return instancia;
	}
	
	public void agregarProgformacion(ProgFormacion p) {
		progsFormacion.add(p);
	}
	
	public ProgFormacion buscarProgFormacion(String nombre) {
		ProgFormacion aRet = null;
		
		for(ProgFormacion p: progsFormacion) {
			if(p.getNombre().equals(nombre)) {
				aRet = p;
			}
		}
		
		return aRet;
	}
	
	public ArrayList<DtInfoPFormacion> datosProgsFormacion(){
		ArrayList<DtInfoPFormacion> aRet = new ArrayList<>();
		for(ProgFormacion p: progsFormacion) {
			aRet.add(p.getDtInfoPFormacion());
		}
		return aRet;
	}
		
	public void modificarDatos(ProgFormacion progfor, String nombreProg) {
		for(ProgFormacion p: progsFormacion) {
			if (p.getNombre().equals(nombreProg)) {
				p.setDescripcion(progfor.getDescripcion());
				p.setFechaI(progfor.getFechaI());
				p.setFechaF(progfor.getFechaF());
				p.setFechaAlta(progfor.getFechaAlta());
			}
		}
	}
}
