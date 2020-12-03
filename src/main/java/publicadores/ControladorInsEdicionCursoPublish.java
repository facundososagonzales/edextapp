package publicadores;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;

import datatypes.DtEdicionDetalle;


import interfaces.Fabrica;
import interfaces.IControladorInsEdicionCurso;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorInsEdicionCursoPublish {
	private Fabrica fabrica;
	private IControladorInsEdicionCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorInsEdicionCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorInsEdicionCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorInsEdicionCursoPublish", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorInsEdicionCursoPublish");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	
	@WebMethod
	public String[] listarInstitutos(){
		String[] aux;
		aux = icon.listarInstitutos();
		return aux;
	}
	
	
	@WebMethod
	public void ingresarInstituto(String nombreI) {
		icon.ingresarInstituto(nombreI);
	}
	
	@WebMethod
	public String[] listarCategorias() {
		
		String[] aux;
		aux = icon.listarCategorias();
		return aux;
	}
	
	@WebMethod
	public void ingresarCategoria(String nombreCat){
		icon.ingresarCategoria(nombreCat);
	}
	
	@WebMethod
	public String[] listarCursos() {
		
		String[] aux;
		aux = icon.listarCursos();
		return aux;
	}
	
	@WebMethod
	public String[] listarCursosCategoria() {
		
		String[] aux;
		aux = icon.listarCursosCategoria();
		return aux;
	}
	
	@WebMethod
	public void ingresarCursoInstituto(String codCur){
		icon.ingresarCursoInstituto(codCur);
	}
	
	@WebMethod
	public void ingresarCursoporCat(String codCur){
		icon.ingresarCursoporCat(codCur);
	}
	
	
	@WebMethod
	public String[] listarEdicion(){
		
		String[] aux;
		aux = icon.listarEdicion();
		return aux;
	}
	
	@WebMethod
	public void ingresarEdicion(String nomEdi){
		icon.ingresarEdicion(nomEdi);
	}
	
	@WebMethod
	public DtEdicionDetalle seleccionarEdicion(){
		
		DtEdicionDetalle aux;
		aux = icon.SeleccionarEdicion();
		return aux;
	}
	
	@WebMethod
	public String[] listarEstudiantes(){
		
		String[] aux;
		aux = icon.listarEstudiantes();
		return aux;
	}
	
	@WebMethod
	public boolean inscripcionEstudiante(String nick, Date fechaIns, String edicion) {
		boolean aux;
		aux = icon.inscripcionEstudiante(nick, fechaIns, edicion);
		return aux;
	}
	@WebMethod
	public void inscripcionEstudianteW(String nick, String edicion) {
		icon.inscripcionEstudianteW(nick,edicion);
	}
	
	@WebMethod
	public String[] listarEdicionCat() {
		
			
			String[] aux;
			aux = icon.listarEdicionCat();
			return aux;
		
	}
	
}
