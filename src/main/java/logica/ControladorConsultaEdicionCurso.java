package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import datatypes.DtEdicionDetalle;
import interfaces.IControladorConsultaEdicionCurso;

public class ControladorConsultaEdicionCurso implements IControladorConsultaEdicionCurso {
	
	
	

	private String nomIns;
	private String codCur;
	private String nomEdicion;
	private String nomCat;


	public ControladorConsultaEdicionCurso() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] listarInstituto() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		List<Instituto> inst = mI.getInstancias();
		List<String> instituto = new ArrayList<>();
		
		for (Instituto i: inst) {
			instituto.add(i.getNombre());
		}
		
		
		String[] ret = instituto.stream().toArray(String[]::new);// esta bien esto?
		
		return ret;
		
}
	
	@Override
	public String[] listarCategoria() {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		List<Categoria> cat = mC.getCategorias();
		List<String> categoria = new ArrayList<>();
		
		for (Categoria c: cat) {
			categoria.add(c.getNombre());
		}
		
	
		String[] ret = categoria.stream().toArray(String[]::new);// esta bien esto?
		
		return ret;
		
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
	public void ingresarCategoria(String nomCategoria) {
		// TODO Auto-generated method stub
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(nomCategoria);
		if (categoria!=null) {
			this.nomCat = nomCategoria;
	
		}	
	}	
	
	@Override
	public String[] listarCursoPorCategoria() {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(this.nomCat);
		List<String> nomCurso = new ArrayList<>();
		List<Curso> curso = new ArrayList<>();
		curso = categoria.getCursos();
		
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				nomCurso.add(c.getNombre());
			}
		}
	
		String[] ret = nomCurso.stream().toArray(String[]::new);// esta bien esto?
		
		return ret;
		
	}	
	
	
	
	@Override
	public String[] listarCurso() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nomIns);
		List<String> nomCurso = new ArrayList<>();
		List<Curso> curso = new ArrayList<>();
		curso = instituto.getCursos();
		
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				nomCurso.add(c.getNombre());
			}
		}
		
		String[] ret = nomCurso.stream().toArray(String[]::new);// esta bien esto?
		
		return ret;
		
	}	
	
	
	
	/*@Override
	public void ingresarCurso(String codCur) {
		// TODO Auto-generated method stub
		ManejadorCurso mC = ManejadorCurso.getInstancia();
		Curso curso=mC.buscarCursos(codCur);
		if (curso!=null) {
			this.codCur = codCur;
			}
		}	*/
	
	
	@Override
	public void ingresarCurso(String codCur) {
		// TODO Auto-generated method stub
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nomIns);
		List<Curso> curso =instituto.getCursos();
		
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(codCur))
				{
					this.codCur=c.getNombre();
				}
				
			}
		}
	
	}
			
	
	@Override
	public void ingresarCursoporCat(String codCur) {
		// TODO Auto-generated method stub
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(this.nomCat);
		List<Curso> curso =categoria.getCursos();
		
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(codCur))
				{
					this.codCur=c.getNombre();
				}
				
			}
		}
	
	}
	
	/*@Override
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

		*/
	@Override
	public String[] listarEdicion() {
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(this.nomIns);
		List<Edicion> edicion = new ArrayList<>();
		List<Curso> curso =instituto.getCursos();
		List<String> nomEdicion = new ArrayList<>();
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(this.codCur))
				{
					edicion = c.getEdiciones();
				}
				
			}
			
		}
	
		if (!edicion.isEmpty()) {
			for (Edicion e: edicion) {
				nomEdicion.add(e.getNombre());
			}
		}
		String[] ret = nomEdicion.stream().toArray(String[]::new);
		return ret;
	}
	@Override
	public String[] listarEdicionCat() {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Categoria categoria=mC.buscarCategoria(this.nomCat);
		List<Edicion> edicion = new ArrayList<>();
		List<Curso> curso =categoria.getCursos();
		List<String> nomEdicion = new ArrayList<>();
		if (!curso.isEmpty()) {
			for (Curso c: curso) {
				if (c.getNombre().equals(this.codCur))
				{
					edicion = c.getEdiciones();
				}
				
			}
			
		}
	
		if (!edicion.isEmpty()) {
			for (Edicion e: edicion) {
				nomEdicion.add(e.getNombre());
			}
		}
		String[] ret = nomEdicion.stream().toArray(String[]::new);
		return ret;
	}
	
	@Override
		public String[] listarDocentes() {
		
			ManejadorEdicionesCurso mE = ManejadorEdicionesCurso.getInstancia();
			Edicion edicion= mE.buscarEdicion(this.nomEdicion);
			String[] ret = null;
			List<String> nomDocente = new ArrayList<>();
			List<Docente> docentes = new ArrayList<>();
			docentes = edicion.getDocentesAsignados();
			
			if (!docentes.isEmpty()) {
				for (Docente d: docentes) {
					nomDocente.add(d.getNombre());
					System.out.println(nomDocente);
				
				}
			}
			
			ret = nomDocente.stream().toArray(String[]::new);
		
			return ret;
			//System.out.println(ret);
			
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
		System.out.println(dtEdicionReturn);
		return dtEdicionReturn;
		
	}
	
	

}