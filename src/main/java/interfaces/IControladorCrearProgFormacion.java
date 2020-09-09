package interfaces;



import datatypes.DtProgFormacion;

import excepciones.ProgForRepetido;


public interface IControladorCrearProgFormacion {

	public void ingresarNombreProg(String nombreProg);
	public void ingresarDatos(DtProgFormacion dprog);
	public void ingresarNombreProgFor(String nombreProg) throws ProgForRepetido;	
}
