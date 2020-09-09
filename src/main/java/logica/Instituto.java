package logica;

import java.util.ArrayList;
import java.util.List;
import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;

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
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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
	public void setCurso(Curso c) {
		this.cursos.add(c);
	}
	
	public List<Curso> getCursos() {
		return cursos;
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
	
	public Curso obtenerCurso(String nombre) {
		Curso aux = null;
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre)) {
				aux = c;
			}
			
		}
		return aux;
	}



}
