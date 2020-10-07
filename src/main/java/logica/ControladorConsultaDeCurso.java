package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import datatypes.DtProgCurso;
import excepciones.ExisteCategoriaException;
import excepciones.ExisteCursoException;
import excepciones.ExisteInstitutoException;
import excepciones.ExisteNomEdicionException;
import excepciones.ExisteProgramaException;
import excepciones.ListaDeCursosVaciaException;
import interfaces.IControladorConsultaDeCurso;

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
	
	public ArrayList<DtCursoBase> ingresarInstituto(String nombre) throws ExisteInstitutoException,ListaDeCursosVaciaException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(nombre);
		if(ins==null) {
			throw new  ExisteInstitutoException("El instituto de nombre: "+nombre+" no existe.");
		}
		this.setNombreI(nombre);
		ArrayList<DtCursoBase> 	cursosI = ins.listarCursos();
		if(cursosI.isEmpty()) {
			throw new ListaDeCursosVaciaException("No existen cursos en el sistema");
		}
		return cursosI;
	}
	
	public DtInfoProgCurso seleccionarCurso(String nombreC) throws ExisteCursoException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		DtCursoDetalle1 dt = ins.obtenerInformacionDeCurso(nombreC);
		if(dt==null) {
			throw new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
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
	
	//OPERACION EXTERNA DEL CU CONSULTAPROGFORMACION
	public DtProgCurso seleccionarPrograma(String nombreP) throws ExisteProgramaException {	
		boolean encontre = false;
		for(ProgFormacion p: this.programas) {
			if(p.getNombre().equals(nombreP)) {
				encontre = true;
			}
		}
		if(encontre==false) {
			throw new ExisteProgramaException("El programa de formacion de nombre: "+nombreP+" no existe.");
		}
	
		ManejadorProgFormacion mp = ManejadorProgFormacion.getInstancia();
		ProgFormacion aux = mp.buscarProgFormacion(nombreP);
		DtProgCurso dtP = aux.getProgCurso();
		
		return dtP; 
		
		
	}

	
	//FALTA OPERACION EXTERNA DEL CU CONSULTAEDICION

	
	public DtEdicionDetalle seleccionarEdicion(String nomE) throws ExisteNomEdicionException{
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto ins = mI.buscarInstituto(this.getNombreI());
		Curso c = ins.obtenerCurso(this.getNombreC());
		DtEdicionDetalle aux = c.obtenerDtEdicionDetalle(nomE);
		if(aux==null) {
			throw new ExisteNomEdicionException("La edicion de nombre: "+nomE+" no existe.");
		}
		
		return aux;
	}
	
	public ArrayList<DtCursoBase> ingresarCategoria(String nombre) throws ExisteCategoriaException,ListaDeCursosVaciaException{
		ManejadorCategoria mCat = ManejadorCategoria.getInstancia();
		Categoria cat = mCat.buscarCategoria(nombre);
		if(cat==null) {
			throw new  ExisteCategoriaException("La categoria de nombre: "+nombre+" no existe.");
		}
		this.nombreCat=nombre;
		ArrayList<DtCursoBase> 	cursosCat = cat.listarCursos();
		if(cursosCat.isEmpty()) {
			throw new ListaDeCursosVaciaException("No existen cursos en el sistema");
		}
		return cursosCat;
	}
	
	public DtInfoProgCurso seleccionarCursoEnCat(String nombreC) throws ExisteCursoException{
		ManejadorCategoria mCat = ManejadorCategoria.getInstancia();
		Categoria cat = mCat.buscarCategoria(nombreCat);
		DtCursoDetalle1 dt = cat.obtenerInformacionDeCurso(nombreC);
		if(dt==null) {
			throw new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
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
}