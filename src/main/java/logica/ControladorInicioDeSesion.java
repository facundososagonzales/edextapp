package logica;

import excepciones.UsuarioNoExisteException;
import interfaces.IControladorInicioDeSesion;

public class ControladorInicioDeSesion implements IControladorInicioDeSesion {
	
	private Usuario user;
	boolean coincide=false;
	
	@Override
	public void ingresarUsuario(String usuario, String contrasenia) throws UsuarioNoExisteException {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		
		if (mu.buscarUsuario(usuario)!=null) {
			
			this.user=mu.buscarUsuario(usuario);
			if (this.user.getPassword().equals(contrasenia)){
				coincide=true;
			}
				
			
			
			}
			
			else if (mu.buscarCorreo(usuario)!=null){
					
						
						this.user= mu.buscarCorreo(usuario);
						if (this.user.getPassword().equals(contrasenia)){
							coincide=true;
					}
			
		if (coincide==false) {
			throw new UsuarioNoExisteException("Los datos no coinciden");
		}			
	
			}
		
		
		}
	

	
	

}
