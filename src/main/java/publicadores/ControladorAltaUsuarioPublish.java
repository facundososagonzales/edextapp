package publicadores;
import java.util.ArrayList;

import javax.jws.WebMethod;


import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtCursoBase;
import datatypes.DtDocente;
import datatypes.DtEstudiante;
import datatypes.DtUsuario;
import excepciones.InstitutoNoCargadoException;
import excepciones.PasswordRepetidaException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorAltaUsuarioPublish {
	private Fabrica fabrica;
	private IControladorAltaUsuario iconAu;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	
	public ControladorAltaUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		iconAu = fabrica.getIControladorAltaUsuario();
		
		try {
			configuracion = new WebServiceConfiguracion();
		}catch(Exception ex) {
			
		}
	}

	@WebMethod(exclude=true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/controladorAltaUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/controladorAltaUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	@WebMethod
	public boolean ingresarUser(DtUsuario usuario)  {
		return iconAu.ingresarUser(usuario);
	}
	
	@WebMethod
	public boolean ingresarInstituto(String nombre) { 
		return iconAu.ingresarInstituto(nombre);
	}
	
	@WebMethod
	public void ingresarPassword(String password) {
		iconAu.ingresarPassword(password);
	}
	
	@WebMethod
	public void verificarPassword(String password) {
		iconAu.verificarPassword(password);
	}
	
	@WebMethod
	public void altaUsuario() {
		iconAu.altaUsuario();
	}
	

	@WebMethod
	public boolean ingresarUserDoc(DtDocente usuario)  {
		return iconAu.ingresarUserDoc(usuario);
	}
	

	@WebMethod
	public boolean ingresarUserEst(DtEstudiante usuario)  {
		return iconAu.ingresarUserEst(usuario);
	}
	
	
}
