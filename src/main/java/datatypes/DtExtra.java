package datatypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
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


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setFechaPub(Date fechaPub) {
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
