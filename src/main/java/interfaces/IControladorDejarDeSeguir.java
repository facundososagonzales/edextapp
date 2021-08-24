package interfaces;

public interface IControladorDejarDeSeguir {
	
	public boolean ingresarUser(String nick);

	public String[] listarSeguidos(String nick);

	public void dejarDeSeguir(String nickLogueado);
}
