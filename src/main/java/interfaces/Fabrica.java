package interfaces;

import logica.ControladorAgregarCursoAProgDeFormacion;
import logica.ControladorAltaCategoria;
import logica.ControladorAltaEdicionCurso;
import logica.ControladorAltaInstituto;
import logica.ControladorAltaUsuario;
import logica.ControladorAltaCurso;
import logica.ControladorConsultaDeCurso;
import logica.ControladorConsultaEdicionCurso;
import logica.ControladorCrearProgFormacion;
import logica.ControladorDejarDeSeguir;
import logica.ControladorInicioDeSesion;
import logica.ControladorInsEdicionCurso;
import logica.ControladorListaCursoPrograma;
import logica.ControladorModificarDatosUsuario;
import logica.ControladorSeguirUsuario;
import logica.ControladorSeleccionarEstEdiCurso;

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
	public IControladorConsultaDeCurso getIControladorConsultaDeCurso() {
		return new ControladorConsultaDeCurso();
	}
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
	
	public IControladorSeguirUsuario getIControladorSeguirUsuario() {
		return new ControladorSeguirUsuario();
	}
	
	public IControladorDejarDeSeguir getIControladorDejarDeSeguir() {
		return new ControladorDejarDeSeguir();
	}
	
	public IControladorAltaCategoria getIControladorAltaCategoria() {
		return new ControladorAltaCategoria();
	}

	public IControladorInicioDeSesion getIControladorIniciodeSesion() {
		return new ControladorInicioDeSesion();
	}
	public IControladorListaCursoPrograma getIControladorListaCursoPrograma() {
		return new ControladorListaCursoPrograma();
	}
	
	public IControladorSeleccionarEstEdiCurso getIControladorSeleccionarEstEdiCurso() {
		return new ControladorSeleccionarEstEdiCurso();
	}
}