package publicadores;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import javax.jws.WebMethod;

import configuraciones.WebServiceConfiguracion;

import interfaces.Fabrica;
import interfaces.IControladorInicioDeSesion;

@WebService// pueden ser soap o rest. Los rest se hacen con jsons.
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)  //indican como se va a hacer la serializacion de los datos, como se van a enviar de una tecnologia a otra.
public class ControladorIniciarSesion {
	private Fabrica fabrica;
	private IControladorInicioDeSesion icis;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


public ControladorIniciarSesion() {
	fabrica= Fabrica.getInstancia();
	icis = fabrica.getIControladorIniciodeSesion();
	try {
		configuracion = new WebServiceConfiguracion();
	}catch (Exception ex) {
}
}
@WebMethod(exclude = true) // porque no voy a publicar el metodo
public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
	
	endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorIniciarSesion", this);
	System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorIniciarSesion");
}


@WebMethod(exclude = true) 
public Endpoint getEndpoint() {
	return endpoint;
}

@WebMethod 
public boolean ingresarUsuario(String usuario, String pwd) {
	boolean usu;
	usu=icis.ingresarUsuario(usuario,pwd);
	return usu;
}

@WebMethod 
public String tipoUsuario(String nick) { 
	String usu;
	usu= icis.tipoUsuario(nick);
	return usu;
}

}

