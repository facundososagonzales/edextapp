package testing;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;
import logica.Curso;
import logica.ProgFormacion;


public class ProgramaDeFormacionTest {

@Test

public void buscarCurso() {
boolean existe = false;
ProgFormacion prog = new ProgFormacion();
prog.setCursos(null);


List<Curso> lista = prog.getCursos();
if (lista==null) {
existe = true;
}

prog.setDescripcion("");
prog.setFechaAlta(null);
prog.setFechaF(null);
prog.setFechaI(null);
prog.setNombre("");
prog.obtenerCursos();



assertTrue(existe);
}


@Test

public void gets() {



ProgFormacion p = new ProgFormacion();
Curso cur= new Curso();

cur = p.buscarCurso("");

p.obtenerInfoDeCurso("");
p.getDtInfoPFormacion();
p.getCursos();
p.getDescripcion();
p.getDtPFormacion();
p.getFechaAlta();
p.getFechaF();
p.getFechaI();
p.getNombre();
p.getProgCurso();

}

}