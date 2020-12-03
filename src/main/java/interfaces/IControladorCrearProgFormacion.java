package interfaces;



import datatypes.DtProgFormacion;

import excepciones.ProgForRepetido;


public interface IControladorCrearProgFormacion {

	public boolean ingresarNombreProg(String nombreProg);
	public void ingresarDatos(DtProgFormacion dprog);
	public boolean ingresarNombreProgFor(String nombreProg);
	public String getNombre();	
}
