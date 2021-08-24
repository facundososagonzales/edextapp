package logica;

import interfaces.IControladorInicioDeSesion;

public class ControladorInicioDeSesion implements IControladorInicioDeSesion {
	
	private Usuario user;
	
	
	@Override
	public boolean ingresarUsuario(String usuario, String pwd) {
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		boolean coincide=false;
		if (mu.buscarUsuario(usuario)!=null) {
			
			this.user=mu.buscarUsuario(usuario);
			if (this.user.getPassword().equals(pwd)){
				coincide=true;
			}
		}else if (mu.buscarCorreo(usuario)!=null){	
			
			this.user= mu.buscarCorreo(usuario);
			if (this.user.getPassword().equals(pwd)){
				coincide=true;
			}
		}			
		return coincide;
	}

	@Override
	public String tipoUsuario(String nick) {
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.buscarUsuario(nick);
		String tipo;
		if(u instanceof Docente) {
			tipo = "Docente";
		}else {
			tipo = "Estudiante";
		}
		
		return tipo;
	}

}