package logica;

import java.util.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
	
	public void cargarCurso() {
		if(cursos.isEmpty()) {
			String nombre = "Curso nro 1";
			String descripcion = "1";
			String duracion = "1";
			Time cantHoras= new Time(3600000);
			int creditos = 1;
			Date fechaR = new GregorianCalendar(2000,1,1).getTime();
			String url = "www";
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto inst = mI.buscarInstituto("Instituto nro 1");
			Curso c1 = new Curso(nombre,descripcion,duracion,cantHoras,creditos,fechaR,url,inst);
			cursos.add(c1);
			String nombre1 = "Curso nro 2";
			String descripcion1 = "1";
			String duracion1 = "1";
			Time cantHoras1= new Time(3600000);
			int creditos1 = 1;
			Date fechaR1 = new GregorianCalendar(2000,1,1).getTime();
			String url1 = "www";
			Instituto inst1 = mI.buscarInstituto("Instituto nro 1");
			Curso c11 = new Curso(nombre1,descripcion1,duracion1,cantHoras1,creditos1,fechaR1,url1,inst1);
			cursos.add(c11);
		}
	}
}