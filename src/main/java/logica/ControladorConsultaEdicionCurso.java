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
	
	private List<Curso> curso = new ArrayList<>();
	private List<Edicion> ediciones = new ArrayList<>();
	private List<DtEdicionDetalle> dtEdicion = new ArrayList<>();
	private String nomIns;
	private String codCur;


	public ControladorConsultaEdicionCurso() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void ingresarInstituto(String nomInstituto)throws InstitutoNoCargadoException {
		// TODO Auto-generated method stub
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(nomInstituto);
		if (instituto!=null) 
			{
			this.nomIns = nomInstituto;
	
			}	
			
		else 
		{
			throw new InstitutoNoCargadoException("El Instituto "+ nomInstituto +" no existe en el sistema\n");
			 
		}
		
	}

	@Override
	public List<DtCursoDetalle> consultarCurso() throws InstitutoVacioException {
		// TODO Auto-generated method stub
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nomIns);
		
			if (!this.curso.isEmpty()) {
				this.curso=instituto.getCursos();
			
				List<DtCursoDetalle> dtCurso = new ArrayList<>();
				for (Curso c: curso) {
					DtCursoDetalle dtCurso1= new DtCursoDetalle(c.getNombre(), c.getDescripcion(),c.getDuracion(),c.getCantHoras(),c.getCreditos(),c.getFechaR(), c.getUrl());
					dtCurso.add(dtCurso1);
	
				}
			return dtCurso;
			}
			else {
				throw new InstitutoVacioException("El Instituto "+ this.nomIns +" no tiene cursos asociados\n");
			}
		}
	
	
	
	
	@Override
	public void ingresarCurso(String codCurso)throws CursoNoCargadoException {
		// TODO Auto-generated method stub
		ManejadorCurso cu = ManejadorCurso.getInstancia();
		Curso curso = cu.buscarCursos(codCurso);
		if (curso!=null) 
			{
			this.codCur = codCurso;
	
			}	
			
		else 
		{
			throw new CursoNoCargadoException("El Curso "+ this.codCur +" no existe en el sistema\n");
			 
		}
		
	}

	@Override
	public List<DtEdicionDetalle> consultarEdicion() throws CursoSinEdicionException {
		// TODO Auto-generated method stub
		ManejadorCurso cu = ManejadorCurso.getInstancia();
		Curso curso = cu.buscarCursos(codCur);
		
			if (!this.codCur.isEmpty()) {
				this.ediciones=curso.getEdiciones();
			
				
				for (Edicion e: ediciones) {
					DtEdicionDetalle dtEdicion1= new DtEdicionDetalle(e.getNombre(), e.getFechaI(), e.getFechaF(), e.getCupo(), e.getFechaPub());
					dtEdicion.add(dtEdicion1);
				}
				
			return dtEdicion;
			}
			else {
				throw new CursoSinEdicionException("El curso "+ this.codCur +" no tiene ediciones asociadas\n");
			}
		}
	
	
	
	@Override
	public DtEdicionDetalle SeleccionarEdicion(String codEdicion)throws EdicionNoCargadaException {
		// TODO Auto-generated method stub

		for (DtEdicionDetalle e: dtEdicion) {
			if (e.getNombre().equals(codEdicion)) {
				DtEdicionDetalle dtEdicionReturn= e;
				return dtEdicionReturn;
			}
			}
			
		
			
			
			throw new EdicionNoCargadaException("La Edicion"+ codEdicion +" no está asociada a este curso\n");
			 
			
		
	}
	

	
}

