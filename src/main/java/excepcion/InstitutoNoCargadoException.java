package excepcion;

public class InstitutoNoCargadoException extends Exception {
	private static final long serialVersionUID = 1L;

	public InstitutoNoCargadoException(String string) {
		super(string);
	}
}
