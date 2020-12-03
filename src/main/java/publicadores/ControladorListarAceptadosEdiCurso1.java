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
import interfaces.IControladorListarAceptadosEdiCurso;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorListarAceptadosEdiCurso1 {
	private Fabrica fabrica;
	private IControladorListarAceptadosEdiCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorListarAceptadosEdiCurso1() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorListarAceptadosEdiCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorListarAceptadosEdiCurso1", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorListarAceptadosEdiCurso1");
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
	
	@WebMethod
	public void ingresarCurso(String codCur) {
		icon.ingresarCurso(codCur);
	}
	
	@WebMethod
	public String[] listarEdicion() {
		
		String[] aux;
		aux = icon.listarEdicion();
		return aux;
	}
	
	@WebMethod
	public void ingresarEdicion(String nomEdi) {
		icon.ingresarEdicion(nomEdi);
		
	}
	
	@WebMethod
	public String[] listarEstudiantesInscriptos(){
		
		String [] aux;
		aux = icon.listarEstudiantesInscriptos();   
		return aux;
	}
	
	
	@WebMethod
	public DtEdicionDetalle seleccionarEdicion(String nomE) {
		
		return icon.seleccionarEdicion(nomE);
		
	}
	
	
	
	
	
}
