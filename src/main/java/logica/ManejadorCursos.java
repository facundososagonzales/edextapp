package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorCursos {
	private static ManejadorCursos instancia = null;
	private List<Curso> cursos = new ArrayList<>();
	
	private ManejadorCursos(){}
	
	public static ManejadorCursos getInstancia() {
		if (instancia == null)
			instancia = new ManejadorCursos();
		return instancia;
	}
	
	public void agregarCurso(Curso curso) {
		cursos.add(curso);
	}
	
	public Curso buscarCurso(String nombreCurso) {
		Curso aretornar=null;
		for(Curso c: cursos) {
			if (c.getNombre().equals(nombreCurso))
				aretornar=c;
		}

		return aretornar;
	}
	
	public ArrayList<Curso> obtenerCursos() {
		ArrayList<Curso> aux = new ArrayList<>();
		for(Curso c: cursos) {
			aux.add(c);
		}
		return aux;
		
	}
	
}
