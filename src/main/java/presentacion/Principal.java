package presentacion;

import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;

import datatypes.DtUsuario;
import datatypes.DtEstudiante;
import datatypes.DtDocente;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;


public class Principal {
	static void menu() {
		System.out.println("Campus\n"
				+ "1. Alta Usuario\n"
				+ "2. \n"
				+ "3. \n"
				+ "4. \n"
				+ "5. \n"
				+ "6. \n"
				+ "7. Salir\n"
				+ "8. OPCIÓN: ");	
		
	}
	
	static void altaUsuario() {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Nick: ");
		String nick = null;
		nick=entrada.nextLine();
		System.out.print("Nombre: ");
    	String nombre = null;
    	nombre = entrada.nextLine();
		System.out.print("Apellido: ");
    	String apellido = null;
    	apellido = entrada.nextLine();
		System.out.print("Correo: ");
    	String correo = null;
    	correo = entrada.nextLine();
		System.out.print("Ingresar dia de nacimiento: ");
    	int dia;
    	dia = entrada.nextInt();
		System.out.print("Ingresar mes de nacimiento: ");
    	int mes;
    	mes = entrada.nextInt();
		System.out.print("Ingresar anio de nacimiento: ");
    	int anio;
    	anio = entrada.nextInt();
    	Date fechaNac = new GregorianCalendar(anio, mes, dia).getTime();
		System.out.print("Precione 1 si es estudiante, 2 si es docente: ");
    	int tipoUser;
    	tipoUser = entrada.nextInt();
    	DtUsuario user = null;
    	Fabrica f = Fabrica.getInstancia();
    	IControladorAltaUsuario iap = f.getIControlador();
    	if(tipoUser==1) {
        	user = new DtEstudiante(nick,nombre,apellido,correo,fechaNac);
    	}else if (tipoUser==2){
        	user = new DtDocente(nick,nombre,apellido,correo,fechaNac);
    		System.out.println("Ingresar instituto: ");
    		String inst = null;
    		inst=entrada.nextLine();
        	iap.ingresarInstituto(inst);
    	}
    	iap.ingresarUser(user);
    	iap.altaUsuario();

	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		menu();
		int opcion = Integer.parseInt(entrada.nextLine());
		while(opcion!=7) {
			switch (opcion) {
		  		case 1:
		  			altaUsuario();
		  			break;
		  		case 2:
		  			break;
		  		case 3:
		  			break;
		  		case 4:
		  			break;
		  		case 5:
		  			break;
		  		case 6:
		  			break;
			}
			menu();
			if(entrada.hasNextLine()) {
				opcion = Integer.parseInt(entrada.nextLine());
			}
		}
		entrada.close();
	}
}
