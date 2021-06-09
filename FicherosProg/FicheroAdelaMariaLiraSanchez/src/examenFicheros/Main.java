package examenFicheros;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			Listas lista = new Listas(".\\ContenedorFicheros\\casetasferia2021.csv");
			System.out.println(lista);
			
			int op = 0;
			String nombreCalle;
			int numeroCaseta;
			do {
				menu();
				op=Integer.parseInt(teclado.nextLine());
				switch(op) {
				case 1:
					System.out.println("Mostrar todas las casetas existentes en una calle. (Se pedirá el nombre de la calle)");
					nombreCalle=leerCadena("Introduzca el nombre de la calle");
					System.out.println(lista.mostrarCasetasDeUnaCalle(nombreCalle));
					
					break;
				case 2:
					System.out.println(". Mostrar para cada una de las calles del recinto ferial el número de casetas que hay en la\r\n"
							+ "calle\r\n");
					System.out.println(lista.mostrarNumeroCasetasCalle());
				
					break;
				case 3:
					System.out.println("Eliminar una caseta. (Extra)Si se elimina una caseta se considerará que el resto de las\r\n"
							+ "casetas posteriores se desplazan, es decir si borro la caseta 5 de una calle, todas las casetas a\r\n"
							+ "partir del número 5 deberán descender un número si la caseta borrada tiene un módulo, dos\r\n"
							+ "si tiene dos módulos, y así sucesivamente. Se pedirá el nombre de la calle y el número. Si no\r\n"
							+ "existe se deberá mostrar un mensaje de error");
					nombreCalle = leerCadena("Introduce el nombre de la calle");
					numeroCaseta = leerEntero("Introduce el numero de la calle");
					lista.eliminarCasetass(nombreCalle,numeroCaseta);
					
					break;
				case 4:
					System.out.println("Crear un fichero de texto");
					String nombreFichero = leerCadena("¿Que nombre le desea que tenga el fichero con los datos?");
					lista.crearArchivoJson(nombreFichero);
					break;
				case 5:
					System.out.println("Saliendo");
					break;
				default:
					System.out.println("Ha ocurrido un error");
					break;
				}
				
				
			}while(op<=9);
			
			
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
	}
	




	public static void menu() {
		System.out.println("1.- Mostrar casetas de una calle. \n"+
							"2.-Mostrar numero de casetas de cada Calle. \n"+
							"3.-Eliminar caseta. \n"+
							"4.-Crear fichero Json. \n"+
							"5.-Salir\n"
				);
	}
	
	public static int leerEntero(String msg) {
		System.out.println(msg);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerCadena(String msg) {
		System.out.println(msg);
		return teclado.nextLine();
	}
	
	public static double leerReal(String msg) {
		System.out.println(msg);
		return Double.parseDouble(teclado.nextLine());
	}
	
	

	
	
	
	
	
	
}
