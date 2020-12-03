


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
public class ControladorConsultaEdicionCurso1Publish {
	private Fabrica fabrica;
	private IControladorConsultaEdicionCurso ices1;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


public ControladorConsultaEdicionCurso1Publish() {
	fabrica= Fabrica.getInstancia();
	ices1 = fabrica.getIControladorConsultaEdicionCurso();
	try {
		configuracion = new WebServiceConfiguracion();
	}catch (Exception ex) {
}
}
@WebMethod(exclude = true) // porque no voy a publicar el metodo
public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
	
	endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCurso1Publish", this);
	System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCurso1Publish");
}


@WebMethod(exclude = true) 
public Endpoint getEndpoint() {
	return endpoint;
}


@WebMethod 
public void ingresarInstituto(String nomInstituto){
	
	ices1.ingresarInstituto(nomInstituto);;

}

@WebMethod 
public void ingresarCategoria(String nomCategoria) {
	
	ices1.ingresarCategoria(nomCategoria);
	
}
@WebMethod 
public String[] listarCursoPorCategoria() {
	String[] aux;
	aux= ices1.listarCursoPorCategoria();
	return aux;
}

@WebMethod 
public String[] listarCurso() {
	String[] aux;
	aux= ices1.listarCurso();
	return aux;
}
}