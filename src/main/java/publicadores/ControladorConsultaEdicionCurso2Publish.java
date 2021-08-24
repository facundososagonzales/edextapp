


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
public class ControladorConsultaEdicionCurso2Publish {
	private Fabrica fabrica;
	private IControladorConsultaEdicionCurso ices2;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


public ControladorConsultaEdicionCurso2Publish() {
	fabrica= Fabrica.getInstancia();
	ices2 = fabrica.getIControladorConsultaEdicionCurso();
	try {
		configuracion = new WebServiceConfiguracion();
	}catch (Exception ex) {
}
}
@WebMethod(exclude = true) // porque no voy a publicar el metodo
public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
	
	endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCurso2Publish", this);
	System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCurso2Publish");
}


@WebMethod(exclude = true) 
public Endpoint getEndpoint() {
	return endpoint;
}


@WebMethod 
public void ingresarInstituto(String nomInstituto){
	
	ices2.ingresarInstituto(nomInstituto);;

}

@WebMethod 
public void ingresarCategoria(String nomCategoria) {
	
	ices2.ingresarCategoria(nomCategoria);
	
}

@WebMethod 
public void ingresarCurso(String nomCurso) {
	
	ices2.ingresarCurso(nomCurso);
	
}

@WebMethod 
public void ingresarCursoPorCat(String nomCurso) {
	
	ices2.ingresarCursoporCat(nomCurso);
	
}



@WebMethod 
public String[] listarEdicion() {
	String[] aux;
	aux= ices2.listarEdicion();
	return aux;
}

@WebMethod 
public String[] listarEdicionCat() {
	String[] aux;
	aux= ices2.listarEdicionCat();
	return aux;
}
}