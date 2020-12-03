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

import datatypes.DtEstudiante;

import interfaces.Fabrica;
import interfaces.IControladorSeleccionarEstEdiCurso;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorSeleccionarEstEdiCurso4Publish {
	private Fabrica fabrica;
	private IControladorSeleccionarEstEdiCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorSeleccionarEstEdiCurso4Publish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorSeleccionarEstEdiCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorSeleccionarEstEdiCurso4Publish", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorSeleccionarEstEdiCurso4Publish");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	
	@WebMethod
	public void ingresarInstituto(String nombreI){
		icon.ingresarInstituto(nombreI);
	}
	
	
	
	
	@WebMethod
	public void ingresarCurso(String codCur) {
		icon.ingresarCurso(codCur);
	}
	

	
	@WebMethod
	public void ingresarEdicion(String nomEdi) {
		icon.ingresarEdicion(nomEdi);
		
	}
	
	@WebMethod
	public void ingresarEstudiante(String nomEdi) {
		icon.ingresarEstudiante(nomEdi);
		
	}
	
	
	

	
	@WebMethod
	public String[] listarEstudiantes(){
		
		String [] aux;
		aux = icon.listarEstudiantes();   
		return aux;
	}
	

	
	@WebMethod
	public DtEstudiante[] listarEstudiantesInscriptos() {
	
	return icon.listarEstudiantesInscriptos();
	
	}
	
	@WebMethod
	public void seleccionarEstadoEstudiante(String estado) {
		icon.seleccionarEstadoEstudiante(estado);
		
	}
	
	
	
}
