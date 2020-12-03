package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtCursoDetalle;

import interfaces.IControladorAltaCurso;
import persistencia.Conexion;

	public class ControladorAltaCurso implements IControladorAltaCurso {
		
		private DtCursoDetalle cursos;
		private String nombreCurso;
		private String instituto;  
		private List<Curso>previas = new ArrayList<>(); 
		private List<Categoria> categorias = new ArrayList<>();
		
		
		public ControladorAltaCurso() {
			super();
		}
		
		public void ingresarNombreCurso(String nombreCurso) {
			this.nombreCurso=nombreCurso;
		
		
		}
		
	
		public List<Categoria> getCats() {
			return this.categorias;
		}
		
		public String getNombre() {
			return this.nombreCurso;
		}
		
		public String getInstituto() {
			return this.instituto;
		}
		
		public void ingresarDatos(DtCursoDetalle dcursos) {
			this.setCursos(dcursos);
			/*ManejadorInstituto mI= ManejadorInstituto.getInstancia();
			Instituto inst =mI.buscarInstituto(this.instituto);
			*/
			Conexion c = Conexion.getInstancia();
			EntityManager e = c.getEntityManager();
			Instituto i = e.find(Instituto.class, this.instituto);
			
			Curso curso = new Curso (this.nombreCurso, dcursos.getDescripcion(), dcursos.getDuracion(), dcursos.getCantHoras(), dcursos.getCreditos(), dcursos.getFechaR(), dcursos.getUrl(), i);
			curso.setPrevias(this.previas);
			
			for(Categoria cat: categorias) {
				curso.agregarCategoria(cat);
			}
			i.setCurso(curso);
			e.getTransaction().begin();
			e.persist(i);
			e.getTransaction().commit();
			
			limpiarDatos();
			this.cursos=null;
			this.instituto=null;
			this.categorias=null;
		
		}
		
	
		
		public boolean ingresarInstituto(String nombre) {
			//ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			boolean coincide=false;
			Conexion c = Conexion.getInstancia();
			EntityManager e = c.getEntityManager();
			Instituto i = e.find(Instituto.class, nombre);
			
			//if(mI.buscarInstituto(nombre)!=null) {
			if(i!=null) {
			this.instituto =nombre;
				coincide = false;
				return coincide;
			}else {
				coincide = true;
				return coincide;
				
				//throw new InstitutoNoCargadoException("El Instituto "+nombre +" no existe en el sistema\n");
		}
		}

	
		
		public boolean ingresarCurso(String nombreCurso) {
			//this.nombreCurso=nombreCurso;
			/*ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto inst = mI.buscarInstituto(this.instituto);*/
			boolean coincide = false;
			Conexion c = Conexion.getInstancia();
			EntityManager e = c.getEntityManager();
			Curso cur = e.find(Curso.class, nombreCurso);
			
			if (cur!=null) {
				coincide=true;
				return coincide;
				//throw new CursoRepetido("El Curso "+ nombreCurso +" ya existe en el sistema\n");
			}else {
			this.nombreCurso=nombreCurso;
			coincide=false;
			return coincide;}
			
			//LO CAMBIE POR QUE NO ME SERVIRIA SETEARME UN NOMBRE QUE NO ME SIRVA
		}
		
		
		public boolean AgregarPrevias(String nombreprevia) {
			
			boolean coincide=false;
/*			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto inst = mI.buscarInstituto(this.instituto);
			Curso cur = inst.obtenerCurso(nombreprevia);
*/
			Conexion c = Conexion.getInstancia();
			EntityManager e = c.getEntityManager();
			Instituto i = e.find(Instituto.class, this.instituto);
			Curso cur = i.obtenerCurso(nombreprevia);
			System.out.println(nombreprevia);
			
			if (cur!=null) {
				System.out.println("n");
				coincide = false;
				previas.add(cur);
				return coincide;
			} 
			else {
				System.out.println("s");
				coincide = true;
				return coincide;
				//throw new PreviaYaExiste("La previa  "+ nombreprevia + " no existe como curso en este instituto\n");
			}
		}
			
			//if (cur!=null) {
			//Boolean existe = false;
				//for(Curso p: previas) {
					//if (p.getNombre().equals(nombreprevia)) {
						//existe = true;
					//} 
				//}
					
				//if (!existe) {
		/*		previas.add(cur);
				
				else {
					throw new PreviaYaExiste("La previa "+ nombreprevia +" ya fue ingresada como previa del curso en el sistema\n");
				}
				
			} else {
				throw new PreviaYaExiste("La previa  "+ nombreprevia + " no existe como curso en este instituto\n");
			}
				
			
		}
	*/	
		
public boolean AgregarPrevias2(String nombreprevia) {
			
			boolean coincide=false;
/*			ManejadorInstituto mI = ManejadorInstituto.getInstancia();
			Instituto inst = mI.buscarInstituto(this.instituto);
			Curso cur = inst.obtenerCurso(nombreprevia);
*/
			Conexion c = Conexion.getInstancia();
			EntityManager e = c.getEntityManager();
			Instituto i = e.find(Instituto.class, this.instituto);
			Curso cur = i.obtenerCurso(nombreprevia);
			
			Boolean existe = false;
			if (cur!=null) {
			
				for(Curso p: previas) {
					if (p.getNombre().equals(nombreprevia)) {
						existe = true;
						coincide=true;
					} 
				}
					
				if (!existe) {
					previas.add(cur);
					coincide=false;
					return coincide;
					
				}
				else {
					coincide=true;
					return coincide;
					//throw new PreviaYaExiste("La previa "+ nombreprevia +" ya fue ingresada como previa del curso en el sistema\n");
				}
				
			} else {
				coincide=true;
				return coincide;
				//throw new PreviaYaExiste("La previa  "+ nombreprevia + " no existe como curso en este instituto\n");
			}
				
			
		}
		
		
		public String[] getPrevias() {
			
			List<Curso> lista = this.previas;
			
			List<String>nombscurs = new ArrayList<>();
			for(Curso c: lista) {
				nombscurs.add(c.getNombre());
			}
			
			int i = 0;
			String[] ret = new String[nombscurs.size()];
	        for(String c : nombscurs) {
	            ret[i]=c;
	            i++;
	        }
	        return ret;
			
			
			
		}
		
			
		public String[] getCategorias() {
			
			List<Categoria> lista = this.categorias;
			
			List<String>nombscurs = new ArrayList<>();
			for(Categoria c: lista) {
				nombscurs.add(c.getNombre());
			}
			
			int i = 0;
			String[] ret = new String[nombscurs.size()];
	        for(String c : nombscurs) {
	            ret[i]=c;
	            i++;
	        }
	        return ret;
			
			
			
		}
		
		
		
		public void limpiarDatos() {
			this.previas = new ArrayList<>();
			this.categorias = new ArrayList<>();
		
		}

		public DtCursoDetalle getCursos() {
			return cursos;
		}

		public void setCursos(DtCursoDetalle cursos) {
			this.cursos = cursos;
		}

		public String[] listarCategorias() {
			ManejadorCategoria mc = ManejadorCategoria.getInstancia();
			System.out.print("ANTES DEL GET");
			List<Categoria> cats = mc.getCategorias();
			System.out.print("DESPUES DEL GET");
			List<String>nombsCats = new ArrayList<>();
			for(Categoria c: cats) {
				nombsCats.add(c.getNombre());
			}
			
			int i = 0;
			String[] ret = new String[nombsCats.size()];
	        for(String c : nombsCats) {
	            ret[i]=c;
	            i++;
	        }
	        return ret;
		}
		
		public String[] listarCursos() {
			ManejadorCurso mc = ManejadorCurso.getInstancia();
			List<Curso> curs = mc.getCursos();
			List<String>nombscurs = new ArrayList<>();
			for(Curso c: curs) {
				nombscurs.add(c.getNombre());
			}
			
			int i = 0;
			String[] ret = new String[nombscurs.size()];
	        for(String c : nombscurs) {
	            ret[i]=c;
	            i++;
	        }
	        return ret;
		
		}
	
		
		public boolean agregarCategoria(String nomCat) {
			boolean coincide=false;
			ManejadorCategoria mc = ManejadorCategoria.getInstancia();
			Categoria cat = mc.buscarCategoria(nomCat);
			for(Categoria cate: categorias) {
				if(cate.getNombre().equals(nomCat)) {
					coincide=true;
					//throw new ExisteCategoriaException("La categoria"+nomCat+" ya ha sido ingresada");
				}
				
			}
			if (!coincide)
				this.categorias.add(cat);	

			return coincide;
		}

	}