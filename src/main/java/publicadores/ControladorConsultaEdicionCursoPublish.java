


package publicadores;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import javax.jws.WebMethod;

import configuraciones.WebServiceConfiguracion;

import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;


@WebService// pueden ser soap o rest. Los rest se hacen con jsons.
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)  //indican como se va a hacer la serializacion de los datos, como se van a enviar de una tecnologia a otra.
public class ControladorConsultaEdicionCursoPublish {
	private Fabrica fabrica;
	private IControladorConsultaEdicionCurso ices;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


public ControladorConsultaEdicionCursoPublish() {
	fabrica= Fabrica.getInstancia();
	ices = fabrica.getIControladorConsultaEdicionCurso();
	try {
		configuracion = new WebServiceConfiguracion();
	}catch (Exception ex) {
}
}
@WebMethod(exclude = true) // porque no voy a publicar el metodo
public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
	
	endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCursoPublish", this);
	System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCursoPublish");
}


@WebMethod(exclude = true) 
public Endpoint getEndpoint() {
	return endpoint;
}


@WebMethod 
public String[] listarInstituto() {
	String[] aux;
	aux=ices.listarInstituto();
	return aux;
}

@WebMethod 
public String[] listarCategoria() {
	String[] aux;
	aux=ices.listarCategoria();
	return aux;
}
}