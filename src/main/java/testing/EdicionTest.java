package testing;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import datatypes.DtCursoDetalle;
import datatypes.DtEdicionBase;
import datatypes.DtEdicionBasico;
import datatypes.DtEdicionDetalle;
import datatypes.Estado;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import interfaces.Fabrica;
import logica.Edicion;

import logica.Categoria;
import logica.Curso;
import logica.Docente;
import logica.Estudiante;
import logica.InscripcionEdi;
import logica.Usuario;
import logica.Edicion;;


public class EdicionTest {

@Test

public void EstudianteEstainscripto() {

Edicion edi = new Edicion();
edi.setNombre("ed1");
InscripcionEdi inscripcion = new InscripcionEdi();

DtEdicionBase dt = edi.getDtEdicionBase();
DtEdicionDetalle dt1 = edi.getDtEdicionDetalle();
DtEdicionBasico dt2 = edi.getInfoBase();

Estudiante e1 = new Estudiante();
inscripcion.setEstado(Estado.Inscripto);

edi.estudianteEstaInscripto(e1.getNick());


int hola = edi.getCupo();
Curso cur = edi.getCurso();
List<Docente> lista = edi.getDocentesAsignados();
edi.getDtEdicionBase();
edi.getDtEdicionDetalle();
edi.getEdiciones();
edi.getFechaF();
edi.getFechaI();
edi.getFechaPub();
edi.getFechaPub();
edi.getInfoBase();

assertFalse(edi.estudianteEstaInscripto(e1.getNick()));


}

@Test

public void AgregarInscripcion() {

Estudiante e1 = new Estudiante();
e1.setNick("e1");
e1.setApellido("hola");
e1.setCorreo("hola");
e1.setFechaNac(null);
e1.setNombre("Hola");
e1.setPassword("");


List<Usuario> seguidores = null;
e1.setSeguidores(seguidores);



Edicion ed = new Edicion();
ed.setNombre("ed1");


InscripcionEdi i = new InscripcionEdi(e1,ed,null);
int num = ed.getEdiciones().size();

ed.agregarInscripcion(e1,null);

int num1 = ed.getEdiciones().size();

assertNotEquals(num,num1);
}

@Test
public void agregarInscripcionWeb() {

Estudiante e1 = new Estudiante();
e1.setNick("e1");
Curso cur = new Curso();
Edicion ed = new Edicion();
ed.setNombre("ed1");
ed.setCurso(cur);
ed.setCupo(0);
ed.setFechaF(null);
ed.setFechaI(null);
ed.setFechaPub(null);

List<Docente> docentesAsignados = null;
ed.setDocentesAsignados(docentesAsignados);

InscripcionEdi i = new InscripcionEdi(e1,ed,null);
int num = ed.getEdiciones().size();

ed.agregarInscripcionWeb(e1,null,i.getEstado());

int num1 = ed.getEdiciones().size();

e1.getApellido();
e1.getCorreo();
e1.getFechaNac();
e1.getInsEdi();
e1.getNick();
e1.getNombre();
e1.getPassword();
e1.getSeguidores();
e1.getSeguidos();

assertNotEquals(num,num1);
}



}