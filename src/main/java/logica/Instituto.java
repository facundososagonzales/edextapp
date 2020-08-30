package logica;

import java.util.ArrayList;
import java.util.List;
import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle;

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
	public ArrayList<DtCursoBase> listarCursos(){ //NUEVO
		ArrayList<DtCursoBase> aux = new ArrayList<>();
		for(Curso c: cursos) {
			aux.add(c.getDtCursoBase());
		}
	
		return aux;
		
	}
	
	public DtCursoDetalle obtenerInformacionDeCurso(String nombre) {
		DtCursoDetalle aux = null;
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre)) {
				aux = c.getDtCursoDetalle();
			}
			
		}
		return aux;
	}
	
}
