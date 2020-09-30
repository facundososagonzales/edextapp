package interfaces;
import excepciones.ExisteCategoriaException;

public interface IControladorAltaCategoria {
	public void altaCategoria(String nombre) throws ExisteCategoriaException;
}