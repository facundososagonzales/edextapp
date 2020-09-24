package excepciones;

public class PasswordRepetidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public PasswordRepetidaException(String string) {
		super(string);
	}
}
