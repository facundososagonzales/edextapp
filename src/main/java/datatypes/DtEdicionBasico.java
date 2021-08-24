package datatypes;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtEdicionBasico {
	private String nombre;

	public DtEdicionBasico() {
		super();
	}

	public DtEdicionBasico(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return "\nNombre: " + nombre; 
	}
}