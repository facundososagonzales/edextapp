package logica;

import java.util.ArrayList;
import java.util.Date;
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
	protected void cargarDatos() {
		//public ProgFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaAlta)
		String nom = "p1";
		String des = "programa1";
		Date f1 = StringToDate("2020-03-06 17:03:00");
		Date f2 = StringToDate("2020-04-06 17:03:00");
		Date f3 = StringToDate("2020-10-06 17:03:00");
		ProgFormacion p1 = new ProgFormacion(nom,des,f1,f2,f3);
		this.agregarProgformacion(p1);
		String nom1 = "p2";
		String des1 = "programa2";
		Date f1a = StringToDate("2020-03-06 17:03:00");
		Date f2a = StringToDate("2020-04-06 17:03:00");
		Date f3a = StringToDate("2020-10-06 17:03:00");
		ProgFormacion p2 = new ProgFormacion(nom1,des1,f1a,f2a,f3a);
		this.agregarProgformacion(p2);
		
	}

	private Date StringToDate(String string) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
