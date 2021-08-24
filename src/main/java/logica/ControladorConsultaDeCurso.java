package logica;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import datatypes.DtProgCurso;
import interfaces.IControladorConsultaDeCurso;
import persistencia.Conexion;

public class ControladorConsultaDeCurso implements IControladorConsultaDeCurso { //NUEVO
	private String nombreI;
	private String nombreC;
	private String nombreCat;
	ArrayList<ProgFormacion> programas = new ArrayList<>();
	
	public String getNombreI() {
		return nombreI;
	}

	public void setNombreI(String nombreI) {
		this.nombreI = nombreI;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(nombre);
		if(ins==null) {
			System.out.println("El instituto de nombre: "+nombre+" no existe.");
		}
		ArrayList<DtCursoBase>	cursosI = new ArrayList<>(); 
		if(ins!=null) {
			this.setNombreI(nombre);
			cursosI = ins.listarCursos();
			if(cursosI.isEmpty()) {
				System.out.println("No existen cursos en el sistema");
			}
		}
		return cursosI;
	}
	
	public DtInfoProgCurso seleccionarCurso(String nombreC) {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		DtCursoDetalle1 dt = ins.obtenerInformacionDeCurso(nombreC);
		String texto = null;
		if(dt==null) {
			System.out.println("El curso de nombre: "+nombreC+" no existe.");
		}
		else {
			ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
			List<ProgFormacion> progs = mp.obtenerProgramas();
			texto = "\n**************\nProgramas de Formacion:";
			for(ProgFormacion p: progs) {
				Curso c = p.buscarCurso(nombreC);
				if(c!=null) {
					texto += "\n-"+p.getNombre();
					this.programas.add(p);
				}			
			}
		}
		this.setNombreC(nombreC);
		return new DtInfoProgCurso(dt,texto);
		
	}
	
	//OPERACION EXTERNA DEL CU CONSULTAPROGFORMACION
	public DtProgCurso seleccionarPrograma(String nombreP)  {	
		boolean encontre = false;
		DtProgCurso dtP = null;
		for(ProgFormacion p: this.programas) {
			if(p.getNombre().equals(nombreP)) {
				encontre = true;
			}
		}
		if(encontre==false) {
			System.out.println("El programa de formacion de nombre: "+nombreP+" no existe.");
		}else {
			ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
			ProgFormacion aux = mp.buscarProgFormacion(nombreP);
			 dtP = aux.getProgCurso();
		}
		return dtP; 
		
		
	}

	
	//FALTA OPERACION EXTERNA DEL CU CONSULTAEDICION

	
	public DtEdicionDetalle seleccionarEdicion(String nomE){
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		Curso c = ins.obtenerCurso(this.getNombreC());
		DtEdicionDetalle aux = c.obtenerDtEdicionDetalle(nomE);
		if(aux==null) {
			System.out.println("La edicion de nombre: "+nomE+" no existe.");
		}
		
		return aux;
	}
	
	public ArrayList<DtCursoBase> ingresarCategoria(String nombre) {
		ManejadorCategoria mCat = ManejadorCategoria.getInstancia();
		Categoria cat = mCat.buscarCategoria(nombre);
		if(cat==null) {
			System.out.println("La categoria de nombre: "+nombre+" no existe.");
		}
		this.nombreCat=nombre;
		ArrayList<DtCursoBase> 	cursosCat = cat.listarCursos();
		if(cursosCat.isEmpty()) {
			System.out.println("No existen cursos en el sistema");
		}
		return cursosCat;
	}
	
	public DtInfoProgCurso seleccionarCursoEnCat(String nombreC) {
		ManejadorCategoria mCat = ManejadorCategoria.getInstancia();
		Categoria cat = mCat.buscarCategoria(nombreCat);
		DtCursoDetalle1 dt = cat.obtenerInformacionDeCurso(nombreC);
		if(dt==null) {
			System.out.println("El curso de nombre: "+nombreC+" no existe.");
		}
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		List<ProgFormacion> progs = mp.obtenerProgramas();
		String texto = "\n**************\nProgramas de Formacion:";
		for(ProgFormacion p: progs) {
			Curso c = p.buscarCurso(nombreC);
			if(c!=null) {
				texto += "\n-"+p.getNombre();
				this.programas.add(p);
			}			
		}
		
		this.setNombreC(nombreC);
		return new DtInfoProgCurso(dt,texto);
		
	}
	
	public DtEdicionDetalle seleccionarEdicionCat(String nomE) {
		Edicion aret=null;
		
		Conexion c = Conexion.getInstancia();
		EntityManager e = c.getEntityManager();
		Query q = e.createQuery("select e from Edicion e");
		List<Edicion> ediciones = (List<Edicion>) q.getResultList();
		
		
		for(Edicion ed: ediciones) {
			if (ed.getNombre().equals(nomE))
				aret=ed;
		}
		
		
		DtEdicionDetalle aux = aret.getDtEdicionDetalle();
		if(aux==null) {
			System.out.println("La edicion de nombre: "+nomE+" no existe.");
		}
		
		return aux;
	}
	
	
}