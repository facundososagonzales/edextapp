package interfaces;

import logica.ControladorAgregarCursoAProgDeFormacion;
import logica.ControladorAltaEdicionCurso;
import logica.ControladorAltaInstituto;
import logica.ControladorAltaUsuario;
import logica.ControladorAltaCurso;
//import logica.ControladorConsultaDeCurso;
import logica.ControladorConsultaEdicionCurso;
import logica.ControladorCrearProgFormacion;
import logica.ControladorInsEdicionCurso;
import logica.ControladorModificarDatosUsuario;

public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica(){}
	
	public static Fabrica getInstancia() {
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IControladorAltaUsuario getIControladorAltaUsuario() {
		return new ControladorAltaUsuario();
	}
	/*public IControladorConsultaDeCurso getIControladorConsultaDeCurso() {
		return new ControladorConsultaDeCurso();
	}*/
	public IControladorAgregarCursoAProgDeFormacion getIControladorAgregarCursoAProgDeFormacion() {
		return new ControladorAgregarCursoAProgDeFormacion();
	}
	public IControladorAltaEdicionCurso getIControladorAltaEdicionCurso() {
		return new ControladorAltaEdicionCurso();
	}
	public IControladorAltaInstituto getIControladorAltaInstituto() {
		return new ControladorAltaInstituto();
	}
	
	public IControladorConsultaEdicionCurso getIControladorConsultaEdicionCurso() {
		return new ControladorConsultaEdicionCurso();
	}
	
	public IControladorAltaCurso getIControladorAltaCurso() {
		return new ControladorAltaCurso();
	}
	
	public IControladorCrearProgFormacion getIControladorCrearProgFormacion() {
		return new ControladorCrearProgFormacion();
	}
	
	public IControladorModificarDatosUsuario getIControladorM() {
		return new ControladorModificarDatosUsuario();
	}
	
	public IControladorInsEdicionCurso getIControladorInsEdicionCurso() {
		return new ControladorInsEdicionCurso();
	}
}