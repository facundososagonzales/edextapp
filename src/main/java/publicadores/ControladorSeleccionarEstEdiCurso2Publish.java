package publicadores;

import java.util.ArrayList;
import java.util.List;

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
public class ControladorSeleccionarEstEdiCurso2Publish {
	private Fabrica fabrica;
	private IControladorSeleccionarEstEdiCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorSeleccionarEstEdiCurso2Publish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSeleccionarEstEdiCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorSeleccionarEstEdiCurso2Publish", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorSeleccionarEstEdiCurso2Publish");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	
	
	
	@WebMethod
	public void ingresarEdicion(String nomEdi) {
		icon.ingresarEdicion(nomEdi);
		
	}

	
	@WebMethod
	public DtEdicionDetalle seleccionarEdicion() {
		
		return icon.SeleccionarEdicion();
		
	}
	
	
	
	
	
}
