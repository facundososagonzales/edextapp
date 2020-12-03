package publicadores;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;

import datatypes.DtEdicionDetalle;

import interfaces.Fabrica;
import interfaces.IControladorSeleccionarEstEdiCurso;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorSeleccionarEstEdiCursoPublish {
	private Fabrica fabrica;
	private IControladorSeleccionarEstEdiCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorSeleccionarEstEdiCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSeleccionarEstEdiCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorSeleccionarEstEdiCursoPublish", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorSeleccionarEstEdiCursoPublish");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] listarInstitutos() {
		
		String aux[];
		aux = icon.listarInstitutos();
		return aux;
		
		
	}
	
	@WebMethod
	public void ingresarInstituto(String nombreI){
		icon.ingresarInstituto(nombreI);
	}
	
	
	@WebMethod
	public String[] listarCursos() {
		
		String[] aux;
		aux = icon.listarCursos();
		return aux;
		
		
		
	}
	
	
	
	
	
	
	
}
