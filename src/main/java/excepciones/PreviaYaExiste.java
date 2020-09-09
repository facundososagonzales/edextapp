package excepciones;

public class PreviaYaExiste extends Exception {
	private static final long serialVersionUID = 1L;

	public PreviaYaExiste(String string) {
		super(string);
	}
}
