package publicadores;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import javax.jws.WebMethod;

import configuraciones.WebServiceConfiguracion;
import interfaces.Fabrica;
import interfaces.IControladorDejarDeSeguir;

@WebService// pueden ser soap o rest. Los rest se hacen con jsons.
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)  //indican como se va a hacer la serializacion de los datos, como se van a enviar de una tecnologia a otra.
public class ControladorDejarDeSeguir {
	private Fabrica fabrica;
	private IControladorDejarDeSeguir icsu;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


public ControladorDejarDeSeguir() {
	fabrica= Fabrica.getInstancia();
	icsu = fabrica.getIControladorDejarDeSeguir();
	try {
		configuracion = new WebServiceConfiguracion();
	}catch (Exception ex) {}
}

@WebMethod(exclude = true) // porque no voy a publicar el metodo
public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
	
	endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorDejarDeSeguir", this);
	System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorDejarDeSeguir");
}


@WebMethod(exclude = true) 
public Endpoint getEndpoint() {
	return endpoint;
}

@WebMethod 
public boolean ingresarUser(String nick){
	return icsu.ingresarUser(nick);
}

@WebMethod 
public void dejarDeSeguir(String nickLogueado) {
	icsu.dejarDeSeguir(nickLogueado);
}

@WebMethod 
public String[] listarSeguidos(String nick) {
	return icsu.listarSeguidos(nick);
}

}
