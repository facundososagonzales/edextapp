package interfaces;

import java.util.ArrayList;

import datatypes.DtWebCurso;
import datatypes.DtWebProgF;

public interface IControladorListaCursoPrograma {
	public ArrayList<DtWebCurso> listarCursos();
	public ArrayList<DtWebProgF> listarProgramas();

}
