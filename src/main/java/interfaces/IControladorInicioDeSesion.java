package interfaces;

public interface IControladorInicioDeSesion {

	public boolean ingresarUsuario(String usuario, String contrasenia);
	
	public String tipoUsuario(String nick);
}