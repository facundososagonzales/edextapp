package publicadores;

import java.util.ArrayList;



import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtCursoBase;
import datatypes.DtEdicionBasico;
import datatypes.DtEdicionDetalle;
import datatypes.DtInfoProgCurso;
import datatypes.DtProgCurso;
import interfaces.Fabrica;
import interfaces.IControladorConsultaDeCurso;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorConsultaDeCursoPublish {
	private Fabrica fabrica;
	private IControladorConsultaDeCurso icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorConsultaDeCursoPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaDeCurso();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/controladorConsultaDeCurso", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/controladorConsultaDeCurso");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}

	@WebMethod
	public DtCursoBase[] ingresarInstituto(String nombre) {
		ArrayList<DtCursoBase> 	cursosI = icon.ingresarInstituto(nombre);
		DtCursoBase[] ret = new DtCursoBase[cursosI.size()];
		int i = 0;
		
		for(DtCursoBase dt: cursosI) {
			ret[i]=dt;
			i++;
		}
		
		return ret;
	}
	
	@WebMethod
	public DtInfoProgCurso seleccionarCurso(String nombreC) {
		DtInfoProgCurso ret = null;
		ret = icon.seleccionarCurso(nombreC);
		return ret;
	}

	@WebMethod
	public DtProgCurso seleccionarPrograma(String nombreP) {
		DtProgCurso ret = icon.seleccionarPrograma(nombreP);
		return ret;
	}
	
	@WebMethod
	public DtEdicionDetalle seleccionarEdicion(String nomE){
		DtEdicionDetalle ret = icon.seleccionarEdicion(nomE);
		return ret;
	}
	
	@WebMethod
	public DtCursoBase[] ingresarCategoria(String nombre) {
		ArrayList<DtCursoBase> 	cursosI = icon.ingresarCategoria(nombre);
		DtCursoBase[] ret = new DtCursoBase[cursosI.size()];
		int i = 0;
		
		for(DtCursoBase dt: cursosI) {
			ret[i]=dt;
			i++;
		}
		
		return ret;
	}
	
	@WebMethod
	public DtInfoProgCurso seleccionarCursoEnCat(String nombreC) {
		DtInfoProgCurso ret = null;
		ret = icon.seleccionarCursoEnCat(nombreC);
		return ret;
	}
	
	@WebMethod
	public DtEdicionDetalle seleccionarEdicionCat(String nomE) {
		DtEdicionDetalle ret = icon.seleccionarEdicionCat(nomE);
		return ret;
	}
	
	@WebMethod
	public void ingresarDt(DtEdicionBasico dt) {
		//DtEdicionBasico dt = new DtEdicionBasico();
	}
	
}
