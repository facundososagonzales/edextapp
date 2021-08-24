package publicadores;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import javax.jws.WebMethod;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtUsuario;
import interfaces.Fabrica;

import interfaces.IControladorModificarDatosUsuario;


@WebService// pueden ser soap o rest. Los rest se hacen con jsons.
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)  //indican como se va a hacer la serializacion de los datos, como se van a enviar de una tecnologia a otra.
public class ControladorModificarDatosUsuarioPublish {
	private Fabrica fabrica;
	private IControladorModificarDatosUsuario icmdu;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


public ControladorModificarDatosUsuarioPublish() {
	fabrica= Fabrica.getInstancia();
	icmdu = fabrica.getIControladorM();
	try {
		configuracion = new WebServiceConfiguracion();
	}catch (Exception ex) {
}
}
@WebMethod(exclude = true) // porque no voy a publicar el metodo
public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
	
	endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorModificarDatosUsuarioPublish", this);
	System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorModificarDatosUsuarioPublish");
}


@WebMethod(exclude = true) 
public Endpoint getEndpoint() {
	return endpoint;
}


@WebMethod 
public DtUsuario elegirUsuario(String nick) {
	DtUsuario aux;
	aux=icmdu.elegirUsuario(nick);
	return aux;
}

@WebMethod 
public void modificar(DtUsuario usuario) {
	
	icmdu.modificar(usuario);
}



@WebMethod 
public DtUsuario datosUsuario(String nick) {
	DtUsuario aux;
	aux=icmdu.datosUsuario(nick);
	return aux;
}
}