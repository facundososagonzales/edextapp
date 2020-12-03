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
import interfaces.IControladorAltaEdicionCurso;

@WebService// pueden ser soap o rest. Los rest se hacen con jsons.
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)  //indican como se va a hacer la serializacion de los datos, como se van a enviar de una tecnologia a otra.
public class ControladorAltaEdicionCurso {
	private Fabrica fabrica;
	private IControladorAltaEdicionCurso icaec;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;


	public ControladorAltaEdicionCurso() {
		fabrica= Fabrica.getInstancia();
		icaec = fabrica.getIControladorAltaEdicionCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		}catch (Exception ex) {}
	}
	
	@WebMethod(exclude = true) // porque no voy a publicar el metodo
	public void publicar() {                         //conseguir ip                  + :+          conseguir puerto                               este this es que lo que estoy publicando soy yo mismo.
		
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorAltaEdicionCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorAltaEdicionCurso");
	}
	
	
	@WebMethod(exclude = true) 
	public Endpoint getEndpoint() {
		return endpoint;
	}
	
	@WebMethod 
	public String[] listarInstitutos() {
		return icaec.listarInstitutos();
	}
	
	@WebMethod 
	public void ingresarInstituto(String nombre) {
		icaec.ingresarInstituto(nombre);
	}
	
	@WebMethod 
	public String[] listarCursos() {
		return icaec.listarCursos();
	}
	
	@WebMethod 
	public void ingresarCurso(String nombre) {
		icaec.ingresarCurso(nombre);
	}
	
	@WebMethod 
	public String[] listarDocentes() {
		return icaec.listarDocentes();
	}
	
	@WebMethod 
	public boolean ingresarEdicionCurso(DtEdicionDetalle edicion) {
		return icaec.ingresarEdicionCurso(edicion);
	}
	
	@WebMethod 
	public boolean darAltaEdicionCurso() {
		return icaec.darAltaEdicionCurso();
	}
	
	@WebMethod 
	public void ingresarDocentes(String[] docentes) {
		icaec.ingresarDocentes(docentes);
	}
	
	@WebMethod 
	public void limpiarDatos() {
		icaec.limpiarDatos();
	}

}