package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	

}