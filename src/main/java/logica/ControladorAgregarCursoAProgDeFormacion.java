package logica;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;
import excepciones.ExisteCursoException;
import excepciones.ExisteProgramaException;
import interfaces.IControladorAgregarCursoAProgDeFormacion;

public class ControladorAgregarCursoAProgDeFormacion implements IControladorAgregarCursoAProgDeFormacion{
	private String nombrePf;
	private String nombreC;
	
	
	public String getNombrePf() {
		return nombrePf;
	}

	public void setNombrePf(String nombrePf) {
		this.nombrePf = nombrePf;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public ArrayList<DtInfoPFormacion> listarProgsFormacion(){
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ArrayList<DtInfoPFormacion> aRet = mpf.datosProgsFormacion();
		return aRet;			
	}
	
	public ArrayList<DtCursoBase> seleccionarProgFormacion(String nombrePf)throws ExisteProgramaException{
		
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion pf = mpf.buscarProgFormacion(nombrePf);
	
		if(pf==null) {
			throw new ExisteProgramaException("El Programa de Formacion de nombre: "+nombrePf+" no existe.");
		}
		this.setNombrePf(nombrePf);
		ManejadorCurso mc = ManejadorCurso.getInstancia();		
		ArrayList<Curso> cursos = mc.obtenerCursos();
		ArrayList<DtCursoBase> dtCursos = new ArrayList<>();

		for(Curso c: cursos) {
			dtCursos.add(c.getDtCursoBase());
		}
		return dtCursos;
	}
	
	public void seleccionarCurso(String nombreC) throws ExisteCursoException{
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso c = mc.buscarCursos(nombreC);
		if(c==null) {
			throw new ExisteCursoException("El curso de nombre: "+nombreC+" no existe.");
		}
		this.setNombreC(nombreC);
	}
	
	public void confirmar() {
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mpf.buscarProgFormacion(this.getNombrePf());
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso c = mc.buscarCursos(this.getNombreC());
		p.addCurso(c);
				
	}
	
}
