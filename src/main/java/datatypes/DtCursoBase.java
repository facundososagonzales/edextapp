package datatypes;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class DtCursoBase {
	private String nombre;
	private String descripcion;
	
	
	public DtCursoBase() {
		super();
	}
	
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
