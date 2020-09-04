package interfaces;

import logica.ControladorAltaEdicionCurso;
import logica.ControladorAltaInstituto;
import logica.ControladorAltaUsuario;

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
		
	public IControladorAltaEdicionCurso getIControladorAltaEdicionCurso() {
		return new ControladorAltaEdicionCurso();
	}
	
	public IControladorAltaInstituto getIControladorAltaInstituto() {
		return new ControladorAltaInstituto();
	}
}