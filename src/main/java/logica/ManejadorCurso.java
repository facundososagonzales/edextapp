package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorCurso {
	private static ManejadorCurso instancia = null;
	private List<Curso> cursos = new ArrayList<>();
	
	private ManejadorCurso(){}
	
	public static ManejadorCurso getInstancia() {
		if (instancia == null)
			instancia = new ManejadorCurso();
		return instancia;
	}

	public void agregarCursos(Curso curso) {
		cursos.add(curso);
	}
	
	public Curso buscarCursos(String nombre) {
		Curso aretornar=null;
		for(Curso c: cursos) {
			if (c.getNombre().equals(nombre))
				aretornar=c;
		}
		return aretornar;
	}
	
	public List<Curso> getInstancias(){
		return this.cursos;
		
	}
	
	public ArrayList<Curso> obtenerCursos() {
		ArrayList<Curso> aux = new ArrayList<>();
		for(Curso c: cursos) {
			aux.add(c);
		}
		return aux;
	}
	
	public void modificarDatos(Curso curso, String nombreCurso) {
		for(Curso c: cursos) {
			if (c.getNombre().equals(nombreCurso)) {
				c.setDescripcion(curso.getDescripcion());
				c.setDuracion(curso.getDuracion());
				c.setCantHoras(curso.getCantHoras());
				c.setCreditos(curso.getCreditos());
				c.setFechaR(curso.getFechaR());
				c.setPrevias(curso.getPrevias());
			}	
		}
	}
}
