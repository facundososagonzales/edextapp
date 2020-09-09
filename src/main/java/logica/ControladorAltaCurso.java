package logica;

import java.util.ArrayList;
import java.util.List;


import datatypes.DtCursoDetalle;

import excepciones.CursoRepetido;
import excepciones.InstitutoNoCargadoException;
import excepciones.PreviaYaExiste;

import interfaces.IControladorAltaCurso;

	public class ControladorAltaCurso implements IControladorAltaCurso {
		
		private DtCursoDetalle cursos;
		private String nombreCurso;
		private String instituto;  
		private List<Curso>previas = new ArrayList<>(); 
		
		
		public ControladorAltaCurso() {
			super();
		}
		
		public void ingresarNombreCurso(String nombreCurso) {
			this.nombreCurso=nombreCurso;
		
		}
	
		
		
		public void ingresarDatos(DtCursoDetalle dcursos) {
			this.setCursos(dcursos);
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			ManejadorInstituto mI= ManejadorInstituto.getInstancia();
			Instituto inst =mI.buscarInstituto(this.instituto);
			Curso curso = new Curso (nombreCurso, dcursos.getDescripcion(), dcursos.getDuracion(), dcursos.getCantHoras(), dcursos.getCreditos(), dcursos.getFechaR(), dcursos.getUrl(), inst);
			curso.setPrevias(this.previas);
			inst.setCurso(curso);
			mc.agregarCursos(curso);
		
		}
		
	
		
		public void ingresarInstituto(String nombre) throws InstitutoNoCargadoException {
			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			if(mI.buscarInstituto(nombre)!=null) {
				this.instituto =nombre;
			}else {
				throw new InstitutoNoCargadoException("El Instituto "+nombre +" no existe en el sistema\n");
			}
		}

		
		
		
		public void ingresarCurso(String nombreCurso) throws CursoRepetido {
			this.nombreCurso=nombreCurso;
			ManejadorCurso mc = ManejadorCurso.getInstancia();
		
			if (mc.buscarCursos(nombreCurso)!=null) {
				throw new CursoRepetido("El Curso "+ nombreCurso +" ya existe en el sistema\n");
			}
		}
		
		
		public void AgregarPrevias(String nombreprevia) throws PreviaYaExiste {
			
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			
		
			if (mc.buscarCursos(nombreprevia)!=null) {
			Boolean existe = false;
				for(Curso p: previas) {
					if (p.getNombre().equals(nombreprevia)) {
						existe = true;
					} 
				}
					
				if (!existe) {
					Curso cur = mc.buscarCursos(nombreprevia);
					previas.add(cur);
				} else {
					throw new PreviaYaExiste("La previa "+ nombreprevia +" ya fue ingresada como previa del curso en el sistema\n");
				}
				
			} else {
				throw new PreviaYaExiste("El curso "+ nombreprevia + " no existe en el sistema\n");
			}
		}
		
		public List<Curso> getPrevias() {
			return previas;
		}
		
		public void limpiarDatos() {
			this.previas = new ArrayList<>();
		
		}

		public DtCursoDetalle getCursos() {
			return cursos;
		}

		public void setCursos(DtCursoDetalle cursos) {
			this.cursos = cursos;
		}

		

	}
		
	

