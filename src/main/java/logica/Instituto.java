package logica;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
	private String nombre;
	private List<Curso> cursos = new ArrayList<>();

	public Instituto() {
		super();
	}

	public Instituto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
}
