package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Estudiante extends Usuario{
	@OneToMany(mappedBy = "estudiante",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<InscripcionEdi> insEdi= new ArrayList<>();
	
	public Estudiante() {
		super();
	}

	public Estudiante(String nick, String nombre, String apellido, String correo, Date fechaNac) {
		super(nick, nombre, apellido, correo, fechaNac);
	}
	
	public List<InscripcionEdi> getInsEdi() {
		return insEdi;
	}

	public void setInsEdi(List<InscripcionEdi> insEdi) {
		this.insEdi = insEdi;
	}

	public void setEdi(InscripcionEdi ins) {
		this.insEdi.add(ins);
		
	}
}