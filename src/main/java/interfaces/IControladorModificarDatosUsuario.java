package interfaces;


import datatypes.DtUsuario;

public interface IControladorModificarDatosUsuario {
	public String[] listarUsuario();
	public DtUsuario elegirUsuario(String nick);
	public void modificar(DtUsuario usuario);
}
