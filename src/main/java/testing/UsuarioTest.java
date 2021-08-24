package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import datatypes.DtCursoBase;
import datatypes.DtCursoDetalle1;
import logica.Curso;
import logica.Estudiante;
import logica.Instituto;
import logica.Usuario;

public class UsuarioTest {

	public UsuarioTest() {
		// TODO Auto-generated constructor stub
	}



public void inicializarTest() {
	
	
}


	

@Test
public void ConstructorTest() {

Estudiante user1 = new Estudiante();



String nick= "ju";
String nombre = "juan";
String apellido= "asd";
String correo= "aldkfj@adsf";
Date fechaNac = null;
Estudiante user2 = new Estudiante(nick, nombre, apellido, correo, fechaNac);

user2.agregarSeguidor(user1);
user2.seguirUsuario(user1);
user2.dejarSeguirUsuario(user2);
user2.setApellido(apellido);
user2.setCorreo(correo);
user2.setFechaNac(fechaNac);
user2.setNick(nick);
user2.getApellido();
user2.getCorreo();
user2.getFechaNac();
user2.getNick();
String nombre2= user2.getNombre();
user2.getPassword();
String password = "213";
user2.setPassword(password);
List<Usuario> seguidos = user2.getSeguidos();
List<Usuario> seguidores = user2.getSeguidores();	

assertEquals(nombre, nombre2);


}


}