package interfaces;


import java.util.List;

import datatypes.DtUsuario;

public interface IControladorModificarDatosUsuario {
	public String[] listarUsuario();
	public DtUsuario elegirUsuario(String nick);
	public void modificar(DtUsuario usuario);
	public String[] listarUsuarios();
	public DtUsuario datosUsuario(String nick);
}