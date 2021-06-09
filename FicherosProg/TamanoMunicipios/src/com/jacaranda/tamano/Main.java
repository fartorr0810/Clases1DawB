package com.jacaranda.tamano;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException, ComunidadDescripcionException {
	
		gui();	
	}	
	
	
	
	public static TamanoMunicipioComunidad lista = new TamanoMunicipioComunidad(".\\ContenedorFicheros\\tamanoMunicipioComunidad.json");
	
	
	
	
	public static void gui() throws IOException, ComunidadDescripcionException {
		int op = 0;
		int anno;
		String descrip;
		String comunidad;
		int dato;
		do {
			menu();
			op=Integer.parseInt(teclado.nextLine());
			switch(op) {
			case 1:
				System.out.println("Mostrar los datos de todas las comunidades y de España de un año que se pedirá\n"
						+ "por teclado. Es decir, se mostrarán todos los datos");
				anno=leerEntero("Introduce el año del que desea la informacion");
				System.out.println(lista.mostrarDatosComunidad(anno));
				break;
			case 2:
				System.out.println("Mostrar los datos de una comunidad y un año. Los datos se pedirán por teclado");
				anno=leerEntero("Introduce el año del que desea la informacion");
				comunidad=leerCadena("Introduce la comunidad deseada");
				System.out.println(lista.mostrarDatosComunidadYAnno(comunidad, anno));
				break;
			case 3:
				System.out.println("Añadir un dato. Se pedirá el nombre de la comunidad y la descripción (descrip).\n"
						+ "A continuación se pedirá el año y el valor del dato.\n"
						+ "Si la comunidad y la descripción no existe se mostrará un mensaje de error. Si\n"
						+ "existe se deberá mirar si existe el año y en este caso modificar el dato. Si el año\n"
						+ "no existe se deberá añadir junto con el dato");
				descrip=leerCadena("Introduce la descripcion");
				comunidad=leerCadena("Introduce la comunidad deseada");
				anno=leerEntero("Introduce el año del que desea añadir la informacion");
				dato=leerEntero("Introduce el dato que quieres añadir");
				lista.addDato(descrip, comunidad, anno, dato);
				break;
			case 4:
				System.out.println("Comprobar que el valor de Total es la suma de todos los valores: Para ello se\n"
						+ "deberá pedir la comunidad y el año. Se deberá comparar el valor “Total” de ese\n"
						+ "año con la suma de todos los datos de todos los municipios menos “Total”. Se\n"
						+ "deberá informar si el valor es igual o en caso de que no sea igual el valor actual\n"
						+ "y el que debería estar.");
				anno=leerEntero("Introduce el año del que desea la informacion");
				comunidad=leerCadena("Introduce la comunidad deseada");
				System.out.println(lista.mostrarSumaTotal(comunidad, anno));
				break;
			case 5:
				String salir = leerCadena("¿Quieres guardar los datos en un nuevo fichero(S/N)?");	
				if(salir.equalsIgnoreCase("S")) {
					String nombreFichero = leerCadena("¿Que nombre le desea que tenga el fichero con los datos?");
					lista.crearArchivoJson(nombreFichero);
					System.out.println("Saliendo, el archivo ha sido guardado");
				}
				else {
					System.out.println("Saliendo sin guardado");
				}
				break;
			default:
				System.out.println("Ha ocurrido un error");
				break;
			}
			
			
		}while(op<=9);
		
	}
	
	
	public static void menu() {
		System.out.println("1.- Mostrar los datos de todas las comunidades y de España. \n"+
							"2.-Mostrar los datos de una comunidad y un año. \n"+
							"3.-Añadir un dato. \n"+
							"4.-Valor total. \n"+
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
	
	
	private static LocalDate obtenerFecha() {

		System.out.println("Introduzca la fecha paso a paso. Introduzca dia: ");
		int day = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca mes: ");
		int month = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca a�o: ");
		int year = Integer.parseInt(teclado.nextLine());
		
		return LocalDate.of(year, month, day);
	}
	
	
	
	
	
	
}
