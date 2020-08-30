package logica;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import datatypes.DtEdicionBase;

public class Edicion {
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;
	private List<Docente>docentesAsignados = new ArrayList<>();

	public Edicion() {
		super();
	}
	
	public Edicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.cupo = cupo;
		this.fechaPub = fechaPub;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaI() {
		return fechaI;
	}
	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}
	public Date getFechaF() {
		return fechaF;
	}
	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public Date getFechaPub() {
		return fechaPub;
	}
	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
	}

	public List<Docente> getDocentesAsignados() {
		return docentesAsignados;
	}

	public void setDocentesAsignados(List<Docente> docentesAsignados) {
		this.docentesAsignados = docentesAsignados;
	}
	
	public DtEdicionBase getDtEdicionBase() {
		return new DtEdicionBase(this.getNombre(),this.getFechaI(),this.getFechaF(),this.getCupo());
	}
	

}
