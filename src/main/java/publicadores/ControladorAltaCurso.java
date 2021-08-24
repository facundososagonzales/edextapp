package publicadores;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtCursoDetalle;

import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorAltaCurso {
	private Fabrica fabrica;
	private IControladorAltaCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorAltaCurso() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorAltaCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/ControladorAltaCurso");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
	
	
	@WebMethod
	
	public String[] getPrevias()  {
		String[] aux;	
		aux = icon.getPrevias();
		return aux;
		}
		
	@WebMethod
	
	public String[] getCategorias()  {
			String[] aux;
			aux = icon.getCategorias();
			return aux;
		}
		
	

	@WebMethod
	public boolean  ingresarCurso (String nombreCurso) {
		
			return icon.ingresarCurso(nombreCurso);
		
	}
	
	@WebMethod
	public void ingresarDatos(DtCursoDetalle dcursos) {
		icon.ingresarDatos(dcursos);
	}
	
	@WebMethod
	public boolean ingresarInstituto(String nombre) {
		
			return icon.ingresarInstituto(nombre);
	
		
	}
	
	@WebMethod
	public boolean AgregarPrevias(String nombreprevia) {
		
			return icon.AgregarPrevias(nombreprevia);
		
	
	}
	
	@WebMethod
	public boolean AgregarPrevias2(String nombreprevia) {
		
			return icon.AgregarPrevias2(nombreprevia);
		
	
	}
	
	@WebMethod
	public void limpiarDatos(){
		icon.limpiarDatos();
	}
	
	@WebMethod
	public String[] listarCategorias(){

		String[] aux;
		aux = icon.listarCategorias();
		return aux;
	}
	
	
	@WebMethod
	public boolean agregarCategoria(String nomCat)  {
		
			return icon.agregarCategoria(nomCat);
		
	}
	
	
	@WebMethod
	public String[] listarCursos(){

		String[] aux;
		aux = icon.listarCursos();
		return aux;
	}
	
	

}

