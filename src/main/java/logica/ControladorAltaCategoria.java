package logica;

import excepciones.ExisteCategoriaException;
import interfaces.IControladorAltaCategoria;

public class ControladorAltaCategoria implements IControladorAltaCategoria{
	
	public void altaCategoria(String nombre) throws ExisteCategoriaException {
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		Categoria c= mc.buscarCategoria(nombre);
		if(c==null) {
			Categoria ca = new Categoria(nombre);
			mc.agregarCategoria(ca);
		}else {
			throw new ExisteCategoriaException("La categoria de nombre"+nombre+" ya existe");
		}
	}
}
