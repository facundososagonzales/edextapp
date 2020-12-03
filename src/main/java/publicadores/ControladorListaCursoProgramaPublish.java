package publicadores;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtExtra;
import datatypes.DtWebCurso;
import datatypes.DtWebProgF;
import interfaces.Fabrica;
import interfaces.IControladorListaCursoPrograma;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorListaCursoProgramaPublish {
	private Fabrica fabrica;
	private IControladorListaCursoPrograma icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorListaCursoProgramaPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorListaCursoPrograma();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/controladorListaCursoPrograma", this);
		System.out.println("http://" + configuracion.getConfigOf("-WS_IP") + ":" + configuracion.getConfigOf("-WS_PORT") + "/controladorListaCursoPrograma");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DtWebCurso[] listarCursos() {
		ArrayList<DtWebCurso> cursos = icon.listarCursos();
		int i = 0;
		DtWebCurso[] ret = new DtWebCurso[cursos.size()];
		for(DtWebCurso s : cursos) {
            ret[i]=s;
            i++;
        }
		return ret;		
	}
	 
	@WebMethod
	public DtWebProgF[] listarProgramas() {
		ArrayList<DtWebProgF> programas = icon.listarProgramas();
		int i = 0;
		DtWebProgF[] ret = new DtWebProgF[programas.size()];
		for(DtWebProgF s : programas) {
            ret[i]=s;
            i++;
        }
		return ret;		
	}
	@WebMethod
	public void ingresarDtExtra(DtExtra dt) {
		System.out.println("\n 1234");
	}
	
}
