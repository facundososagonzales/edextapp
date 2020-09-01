package logica;

import java.util.ArrayList;

import datatypes.DtCursoBase;
import datatypes.DtInfoPFormacion;
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
	
	public ArrayList<DtCursoBase> seleccionarProgFormacion(String nombrePf){
		this.setNombrePf(nombrePf);
		ManejadorCursos mc = ManejadorCursos.getInstancia();
		ArrayList<Curso> cursos = mc.obtenerCursos();
		ArrayList<DtCursoBase> dtCursos = new ArrayList<>();
		
		for(Curso c: cursos) {
			dtCursos.add(c.getDtCursoBase());
		}
		
		return dtCursos;
	}
	
	public void seleccionarCurso(String nombreC) {
		this.setNombreC(nombreC);
	}
	
	public void confirmar() {
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion p = mpf.buscarProgFormacion(this.getNombrePf());
		ManejadorCursos mc = ManejadorCursos.getInstancia();
		Curso c = mc.buscarCurso(this.getNombreC());
		p.addCurso(c);
				
	}
	
}
