package datatypes;

import java.util.Date;

public class DtEdicionDetalle extends DtEdicionBase {
	private Date fechaPub;

	public DtEdicionDetalle() {}

	public DtEdicionDetalle(String nombre, Date fechaI, Date fechaF, int cupos, Date fechaPub) {
		super(nombre, fechaI, fechaF, cupos);
	}

	public Date getFechaPub() {
		return fechaPub;
	}

	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
	}
	@Override
	public String toString() {
		return super.toString()+" fechaPublicacion"+fechaPub+"\n";
	}

}
