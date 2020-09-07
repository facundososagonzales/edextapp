package excepcion;

public class CursoNoCargadoException extends Exception {
	private static final long serialVersionUID = 1L;

	public CursoNoCargadoException(String string) {
		super(string);
	}
}
