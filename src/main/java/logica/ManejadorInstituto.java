package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManejadorInstituto {
	private static ManejadorInstituto instancia = null;
	private List<Instituto> institutos = new ArrayList<>();
	
	private ManejadorInstituto(){}
	
	public static ManejadorInstituto getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstituto();
		return instancia;
	}

	public void agregarInstituto(Instituto instituto) {
		institutos.add(instituto);
	}
	
	public Instituto buscarInstituto(String nombre) {
		Instituto aretornar=null;
		for(Instituto i: institutos) {
			if ( i.getNombre().equals(nombre))
				aretornar=i;
		}
		return aretornar;
	}
	public List<Instituto> getInstancias(){
		return this.institutos;
		
	}
	
	public void cargarInst() {
		
			String nombre= "Matematicas";
			String descripcion = "Obligatoria";
			String duracion = "6 meses";
			Time horas = StringToTime("10");
			int cre = 15;
			Date d = StringToDate("2020-04-06 17:03:00");
			String url = "curso.com";
			Curso c = new Curso(nombre, descripcion, duracion, horas, cre, d, url);

			String nom= "Biologia";
			String desc = "Obligatoria";
			String dur = "5 meses";
			Curso c1 = new Curso(nom, desc, dur, horas, cre, d, url);
			
			
			
			
			String nomp = "CursoM";
			String desc1 = "Dificil";
			String instituto1 = "Instituto1";
			Date d1 = StringToDate("2020-04-06 17:03:00");
			Date d2 = StringToDate("2020-04-06 17:03:00");
			Date d3 = StringToDate("2020-04-06 17:03:00");
			ProgFormacion pf = new ProgFormacion(nomp,desc1,d1,d2,d3);
			//public ProgFormacion(String nombre, String descripcion, Date fechaI, Date fechaF, Date fechaAlta)
			c1.setPFormacion(pf);
			
			Instituto inst = new Instituto(instituto1);
			inst.setCurso(c);
			inst.setCurso(c1);
			institutos.add(inst);
			String instituto2 = "Instituto2";
			Instituto inst2 = new Instituto(instituto2);
			inst2.setCurso(c1);
			institutos.add(inst2);
			
			
		
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
