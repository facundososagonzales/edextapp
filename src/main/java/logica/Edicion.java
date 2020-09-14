package logica;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtEdicionBase;
import datatypes.DtEdicionBasico;
import datatypes.DtEdicionDetalle;

@Entity
public class Edicion {
	@Id
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Docente>docentesAsignados = new ArrayList<>();
	@ManyToOne
	private Curso curso;
	@OneToMany(mappedBy = "edicion", cascade = CascadeType.ALL)
	private List<InscripcionEdi> ediciones = new ArrayList<>();

	public Edicion() {
		super();
	}
	
	public Edicion(String nombre, Date fechaI, Date fechaF,int cupo, Date fechaPub) {

		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaPub = fechaPub;
		
	}
	
	public boolean estudianteEstaInscripto(String nick) {
		int i = 0;
		InscripcionEdi inscripcion;
		boolean encontre=false;
		while ((i < this.ediciones.size()) && (!encontre)) {
		    inscripcion=ediciones.get(i);
		    if (inscripcion.getEstudiante().getNick().equals(nick)) {
		    	encontre=true;
		    }	
		    i++;
		}
		return encontre;
	}
	
	public void agregarInscripcion(Estudiante estudiante, Date fecha) {
		InscripcionEdi i = new InscripcionEdi(estudiante,this,fecha);
		ediciones.add(i);
		estudiante.getInsEdi().add(i);
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public DtEdicionBase getDtEdicionBase() {
		return new DtEdicionBase(this.getNombre(),this.getFechaI(),this.getFechaF(),this.getCupo());
	}
	public DtEdicionDetalle getDtEdicionDetalle() {
		return new DtEdicionDetalle(this.getNombre(),this.getFechaI(),this.getFechaF(),this.getCupo(),this.getFechaPub());
	}
	
	public DtEdicionBasico getInfoBase() {
		return new DtEdicionBasico(this.getNombre());
	}

}
