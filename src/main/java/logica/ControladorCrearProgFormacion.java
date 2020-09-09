package logica;


import datatypes.DtProgFormacion;
import excepciones.ProgForRepetido;
import interfaces.IControladorCrearProgFormacion;

public class ControladorCrearProgFormacion implements IControladorCrearProgFormacion {

	private DtProgFormacion progsFor;
	private String nombreProg;
	
	
	public ControladorCrearProgFormacion() {
		super();
	}
	
	public void ingresarNombreProg(String nombreProg) {
		this.nombreProg=nombreProg;
	
	}

	public void ingresarDatos(DtProgFormacion dprog) {
		this.progsFor=dprog;
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion progfor = new ProgFormacion (nombreProg, dprog.getDescripcion(), dprog.getFechaI(), dprog.getFechaF(), dprog.getFechaAlta());
		mpf.agregarProgformacion(progfor);
	
	}
	
	public void ingresarNombreProgFor(String nombreProg) throws ProgForRepetido {
		this.nombreProg=nombreProg;
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		
	
		if (mpf.buscarProgFormacion(nombreProg)!=null) {
			throw new ProgForRepetido("El Progrma de Formacion "+ nombreProg +" ya existe en el sistema\n");
		}
	}

	public DtProgFormacion getProgsFor() {
		return progsFor;
	}

	public void setProgsFor(DtProgFormacion progsFor) {
		this.progsFor = progsFor;
	}

}
