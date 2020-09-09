package logica;

import excepcion.InstitutoCargadoException;
import interfaces.IControladorAltaInstituto;

public class ControladorAltaInstituto implements IControladorAltaInstituto {

	public ControladorAltaInstituto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void darDeAltaInstituto(String nomInstituto)throws InstitutoCargadoException {
		// TODO Auto-generated method stub
		
		ManejadorInstituto mI = ManejadorInstituto.getInstancia();
		Instituto instituto=mI.buscarInstituto(nomInstituto);
		if (instituto==null) 
		{
			Instituto ins= new Instituto(nomInstituto);
			ins.setCursos(null);
			mI.agregarInstituto(ins);
			
		}
		else {
			throw new InstitutoCargadoException("El Instituto "+ nomInstituto +" ya existe en el sistema\n");
			 
		}
			
	}



}
