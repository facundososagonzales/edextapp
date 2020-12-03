package logica;


import datatypes.DtProgFormacion;
import interfaces.IControladorCrearProgFormacion;

public class ControladorCrearProgFormacion implements IControladorCrearProgFormacion {

	private DtProgFormacion progsFor;
	private String nombreProg;
	
	
	public ControladorCrearProgFormacion() {
		super();
	}
	
	public boolean ingresarNombreProg(String nombreProg) {
		Boolean coincide = false;
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		if (mpf.buscarProgFormacion(nombreProg)!=null) {
			coincide=true;
			return coincide;}
		else {
		this.nombreProg=nombreProg;
		coincide=false;
		return coincide;}
	
	}

	public void ingresarDatos(DtProgFormacion dprog) {
		this.progsFor=dprog;
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion progfor = new ProgFormacion (nombreProg, dprog.getDescripcion(), dprog.getFechaI(), dprog.getFechaF(), dprog.getFechaAlta());
		mpf.agregarProgformacion(progfor);
	
	}
	
	public boolean ingresarNombreProgFor(String nombreProg)   {
		boolean coincide;
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		
	
		if (mpf.buscarProgFormacion(nombreProg)!=null) {
			coincide=true;
			return coincide;}
			//throw new ProgForRepetido("El Progrma de Formacion "+ nombreProg +" ya existe en el sistema\n");
		else {
			this.nombreProg=nombreProg;
		coincide=false;
		return coincide;}
	}

	public DtProgFormacion getProgsFor() {
		return progsFor;
	}

	public void setProgsFor(DtProgFormacion progsFor) {
		this.progsFor = progsFor;
	}

	@Override
	public String getNombre() {
		return this.nombreProg;
	}

}
