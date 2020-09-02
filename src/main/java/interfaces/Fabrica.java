package interfaces;

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
	
	public IControladorAltaInstituto getIControladorAltaInstituto() {
		return new ControladorAltaInstituto();
	}
}