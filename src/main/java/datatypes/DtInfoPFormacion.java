package datatypes;

public class DtInfoPFormacion {
	private String nombre;
	private String descripcion;
	public DtInfoPFormacion() {
		super();
	}
	public DtInfoPFormacion(String nombre, String descripcion) {
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
		return ("Nombre: " + nombre + " Descripcion: " + descripcion+"\n");
	}

}
