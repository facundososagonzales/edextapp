package logica;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import datatypes.Estado;

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
	
	private Estado estado;
	
	public InscripcionEdi() {
		super();
	}
	
	

	public InscripcionEdi(Estudiante estudiante, Edicion edicion, Date fechaIns) {
		super();
		this.estudiante = estudiante;
		this.edicion = edicion;
		this.fechaIns = fechaIns;
	}
	
	

	public InscripcionEdi(Estudiante estudiante, Edicion edicion, Date fechaIns, Estado estado) {
		super();
		this.estudiante = estudiante;
		this.edicion = edicion;
		this.fechaIns = fechaIns;
		this.estado = estado;
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



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	
}
