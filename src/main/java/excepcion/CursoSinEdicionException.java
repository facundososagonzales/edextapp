package excepcion;

public class CursoSinEdicionException extends Exception {
	private static final long serialVersionUID = 1L;

	public CursoSinEdicionException(String string) {
		super(string);
	}
}
