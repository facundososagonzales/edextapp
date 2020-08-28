package interfaces;

import datatypes.DtUsuario;

public interface IControladorAltaUsuario {

	public void ingresarUser(DtUsuario user);
	
	public void ingresarInstituto(String nombre);
	
	public boolean verificar();
		
	public boolean modificarUser(String nick,String correo);
		
	public void altaUsuario();
	
}
