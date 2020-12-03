


package publicadores;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import javax.jws.WebMethod;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtEdicionDetalle;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicionCurso;


@WebService// pueden ser soap o rest. Los rest se hacen con jsons.
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)  //indican como se va a hacer la serializacion de los datos, como se van a enviar de una tecnologia a otra.
public class ControladorConsultaEdicionCurso3Publish {
	private Fabrica fabrica;
	private IControladorConsultaEdicionCurso ices3;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


public ControladorConsultaEdicionCurso3Publish() {
	fabrica= Fabrica.getInstancia();
	ices3 = fabrica.getIControladorConsultaEdicionCurso();
	try {
		configuracion = new WebServiceConfiguracion();
	}catch (Exception ex) {
}
}
@WebMethod(exclude = true) // porque no voy a publicar el metodo
public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
	
	endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCurso3Publish", this);
	System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorConsultaEdicionCurso3Publish");
}


@WebMethod(exclude = true) 
public Endpoint getEndpoint() {
	return endpoint;
}


@WebMethod 
public void ingresarEdicion(String nomEdicion){
	
	ices3.ingresarEdicion(nomEdicion);

}

@WebMethod 
public DtEdicionDetalle seleccionarEdicion() {
	
	DtEdicionDetalle aux;
	aux=ices3.SeleccionarEdicion();
	return aux;
}

@WebMethod 
public String[] listarDocentes() {
	String[] aux;
	aux=ices3.listarDocentes();
	return aux;
}


}