package testing;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoDetalle;
import datatypes.DtEdicionDetalle;
import datatypes.Estado;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.Fabrica;
import logica.ManejadorUsuario;

import logica.Categoria;
import logica.Curso;
import logica.Docente;
import logica.Estudiante;
import logica.ManejadorCategoria;
import logica.ManejadorCurso;
import logica.Usuario;
import persistencia.Conexion;


public class ManejadorUsuarioTest {

@Test
public void buscarCorreo() {

ManejadorUsuario mc = ManejadorUsuario.getInstancia();
String bus = "u1";
Usuario u1 =mc.buscarCorreo(bus);
Docente u2 = new Docente() ;
u2.setCorreo("u1");


assertEquals(u1.getCorreo(),u2.getCorreo());


}

@Test

public void obtenerCorreos() {
boolean coincide=false;
ManejadorUsuario mc = ManejadorUsuario.getInstancia();

Estudiante e1 = new Estudiante();
e1.setCorreo("e3");

List<String> lista = mc.obtenerCorreos();

for (String i: lista) {
if (i.equals(e1.getCorreo())) {
coincide = true;
}
}
assertFalse(coincide);
}


}