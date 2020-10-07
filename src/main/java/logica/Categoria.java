package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;

@Entity
public class Categoria {
	@Id
	private String nombre;
	@ManyToMany(mappedBy = "categorias")
	List<Curso> cursos = new ArrayList<>();

	public Categoria() {
		super();
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCurso(Curso c) {
		this.cursos.add(c);
	}
	
	public List<Curso> getCursos() {
		return this.cursos;
	}
	
	public ArrayList<DtCursoBase> listarCursos(){ //NUEVO
		ArrayList<DtCursoBase> aux = new ArrayList<>();
		for(Curso c: cursos) {
			aux.add(c.getDtCursoBase());
		}
		if(aux.isEmpty()) {
			aux= null;
		}
		return aux;
		
	}
	
	public DtCursoDetalle1 obtenerInformacionDeCurso(String nombre) {
		DtCursoDetalle1 aux = null;
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre)) {
				aux = c.getDtCursoDetalle();
			}
			
		}
		return aux;
	}

}