package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtCursoDetalle;
import datatypes.DtEdicionDetalle;
import excepcion.CursoNoCargadoException;
import excepcion.CursoSinEdicionException;
import excepcion.EdicionNoCargadaException;
import excepcion.InstitutoCargadoException;
import excepcion.InstitutoNoCargadoException;
import excepcion.InstitutoVacioException;
import interfaces.IControladorConsultaEdicionCurso;

public class ControladorConsultaEdicionCurso implements IControladorConsultaEdicionCurso {
	
	
	

	private String nomIns;
	private String codCur;
	private String nomEdicion;


	public ControladorConsultaEdicionCurso() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> listarInstituto() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List<Instituto> inst = mI.getInstancias();
		List<String> instituto = new ArrayList<>();
		
		for (Instituto i: inst) {
			instituto.add(i.getNombre());
		}
		
		return instituto;
		
}
	@Override
	public void ingresarInstituto(String nomInstituto) {
		// TODO Auto-generated method stub
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(nomInstituto);
		if (instituto!=null) {
			this.nomIns = nomInstituto;
	
		}	
	}	
	@Override
	public List<String> listarCurso() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nomIns);
		List<String> nomCurso = new ArrayList<>();
		List<Curso> curso = new ArrayList<>();
		curso = instituto.getCursos();
		
		if (!curso.isEmpty()) {
		for (Curso c: curso) {
			nomCurso.add(c.getNombre());
			System.out.println("Nick: " + c.getNombre());
		}
		}

		return nomCurso;

	}	
	
	@Override
	public void ingresarCurso(String codCur) {
		// TODO Auto-generated method stub
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso curso=mC.buscarCursos(codCur);
		if (curso!=null) {
			this.codCur = codCur;
			}
		}	
	
	
	
	@Override
	public List<String> listarEdicion() {
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso curso= mC.buscarCursos(this.codCur);
		List<String> nomEdicion = new ArrayList<>();
		List<Edicion> edicion = new ArrayList<>();
		edicion = curso.getEdiciones();
		
		if (!edicion.isEmpty()) {
		for (Edicion e: edicion) {
			nomEdicion.add(e.getNombre());
			System.out.println("Nick: " + e.getNombre());
		}
		}

		return nomEdicion;
	}

		
		
		public List<String> listarDocentes() {
			ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
			Edicion edicion= mE.buscarEdicion(this.nomEdicion);
			List<String> nomDocente = new ArrayList<>();
			List<Docente> docentes = new ArrayList<>();
			docentes = edicion.getDocentesAsignados();
			
			if (!docentes.isEmpty()) {
			for (Docente d: docentes) {
				nomDocente.add(d.getNombre());
				
			}
			}

			return nomDocente;

	}	
	@Override
	public void ingresarEdicion(String nomEdi) {
		// TODO Auto-generated method stub
		ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion=mE.buscarEdicion(nomEdi);
		if (edicion!=null) {
			this.nomEdicion= nomEdi;
			
			}
		}	
	
	
	
	@Override
	public DtEdicionDetalle SeleccionarEdicion() {
		ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
		Edicion edicion=mE.buscarEdicion(this.nomEdicion);
		DtEdicionDetalle dtEdicionReturn = new DtEdicionDetalle(edicion.getNombre(), edicion.getFechaI(), edicion.getFechaF(),edicion.getCupo(), edicion.getFechaPub());
		return dtEdicionReturn;
		
	}
	
	

}