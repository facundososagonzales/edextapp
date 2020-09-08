package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
	
	protected void cargarDatos() {
		//public Curso(String nombre, String descripcion, String duracion, Time cantHoras, int creditos, Date fechaR,
			//	String url) {
		String nombre= "Matematicas";
		String descripcion = "Obligatoria";
		String duracion = "6 meses";
		Time horas = StringToTime("10");
		int cre = 15;
		Date d = StringToDate("2020-04-06 17:03:00");
		String url = "curso.com";
		
		Curso c = new Curso(nombre, descripcion, duracion, horas, cre, d, url);
		this.agregarCurso(c);
	}

	private Date StringToDate(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private Time StringToTime(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
