package publicadores;



import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;

import datatypes.DtProgFormacion;

import interfaces.Fabrica;
import interfaces.IControladorCrearProgFormacion;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorCrearProgFormacion {
	private Fabrica fabrica;
	private IControladorCrearProgFormacion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorCrearProgFormacion() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorCrearProgFormacion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorCrearProgDeFormacion", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorCrearProgDeFormacion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	@WebMethod
	public void ingresarDatos(DtProgFormacion dprog) {
		icon.ingresarDatos(dprog);
	}
	
	
	@WebMethod
	public boolean ingresarNombreProgFor(String nombreProg)  {
		return icon.ingresarNombreProgFor(nombreProg);
	}
}