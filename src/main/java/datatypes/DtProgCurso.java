package datatypes;

import java.util.ArrayList;
import java.util.Date;

public class DtProgCurso {
	private String nombre;
	private String descripcion;
	private Date fechaI;
	private Date fechaF;
	private ArrayList<DtCursoBase> dtCursos;
	
	public DtProgCurso(String nombre, String descripcion, Date fechaI, Date fechaF, ArrayList<DtCursoBase> dtCursos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.dtCursos = dtCursos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaI() {
		return fechaI;
	}

	public Date getFechaF() {
		return fechaF;
	}

	public ArrayList<DtCursoBase> getDtCursos() {
		return dtCursos;
	}
	
	protected String imprimirCursos() {
		String datob = "";
		for(DtCursoBase d: dtCursos) {
			datob= datob + d.toString() +"\n";
		}
		return datob;
	}
	
	
	@Override
	public String toString() {
		String a = this.imprimirCursos();
		return  "Nombre: "+nombre+" Descripcion: "+descripcion+" FechaInicio: "+fechaI+" FechaFin: "+fechaF+" \nCursos:"+a;
		
	}
	
	
}
