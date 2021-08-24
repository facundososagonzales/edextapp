package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtCursoDetalle;
import datatypes.DtProgFormacion;
import excepciones.CursoRepetido;
import excepciones.ExisteCategoriaException;
import excepciones.InstitutoNoCargadoException;
import excepciones.PreviaYaExiste;
import excepciones.ProgForRepetido;
import interfaces.Fabrica;
import interfaces.IControladorAgregarCursoAProgDeFormacion;
import interfaces.IControladorCrearProgFormacion;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorAgregarCursoAProgFormacion {
	private Fabrica fabrica;
	private IControladorAgregarCursoAProgDeFormacion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorAgregarCursoAProgFormacion() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAgregarCursoAProgDeFormacion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorAgregarCursoProgFormacion", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorAgregarCursoProgFormacion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}

	
	@WebMethod
	public String[] listarProgsFormacion2() {
		return icon.listarProgsFormacion2();
	}
	
	
	@WebMethod
	public String[] seleccionarProgsFormacion2(String nombrePf) {
		return icon.seleccionarProgFormacion2(nombrePf);
	}
	
	@WebMethod
	public void seleccionarCurso(String nombreC) {
		 icon.seleccionarCurso(nombreC);
	}
	
	@WebMethod
	public void confirmar()  {
		icon.confirmar();
	}
	
	
	
}
