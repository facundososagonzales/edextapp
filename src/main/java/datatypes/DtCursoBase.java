package datatypes;

public class DtCursoBase {
	private String nombre;
	private String descripcion;
	
	public DtCursoBase() {}

	
	public DtCursoBase(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nDescripcion: " + descripcion+"\n";
	}

}
