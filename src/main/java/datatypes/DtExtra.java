package datatypes;

import java.util.Date;

public class DtExtra implements Comparable<DtExtra>{
	private String nombre;
	private Date fechaPub;
	public DtExtra() {
		super();
	}
	
	
	public DtExtra(String nombre, Date fechaPub) {
		super();
		this.nombre = nombre;
		this.fechaPub = fechaPub;
	}


	public String getNombre() {
		return nombre;
	}
	public Date getFechaPub() {
		return fechaPub;
	}


	@Override
	public int compareTo(DtExtra dt) {
		// TODO Auto-generated method stub
		return fechaPub.compareTo(dt.getFechaPub());
	}

}
