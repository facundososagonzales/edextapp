package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(InscripcionEdiId.class)
public class InscripcionEdi {
	@Id
	@ManyToOne
	/*@JoinColumn(
		insertable=false,
		updatable=false
	)*/
	private Estudiante estudiante;
	@Id
	@ManyToOne
	/*@JoinColumn(
		insertable=false,
		updatable=false
	)*/
	private Edicion edicion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaIns;
	
	public InscripcionEdi() {
		super();
	}
	
	public InscripcionEdi(Date fechaIns) {
		super();
		this.fechaIns = fechaIns;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Edicion getEdicion() {
		return edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}

	public Date getFechaIns() {
		return fechaIns;
	}

	public void setFechaIns(Date fechaIns) {
		this.fechaIns = fechaIns;
	}


	
}
