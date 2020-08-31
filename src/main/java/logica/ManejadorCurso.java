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
			String nombre = "1";
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
		}
	}
}