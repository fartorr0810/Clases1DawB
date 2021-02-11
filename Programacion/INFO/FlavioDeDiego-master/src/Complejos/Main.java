package Complejos;

import java.util.Scanner;


public class Main  {

	static Scanner  teclado = new Scanner(System.in);
	
	
	/**
	 * Muestra el menu y nos va pidiendo reales, como si fuese una calculadora. 
	 * @author Flavio
	 *
	 */

	public static void mostrarMenu() {
		
		System.out.println("\n Hola!!");
		System.out.println("1. Sumar Complejos");
		System.out.println("2. Restar Complejoss");
		System.out.println("3. Comparar complejos");
		System.out.println("4. Salir");
	}
	
	public static Complejo pedirComplejo() throws Exception {
		
		Complejo a=null;
		
		while(a==null) {
			try {
				a = new Complejo();
				System.out.println("Introduce la parte real");
				a.setParteReal(Double.parseDouble(teclado.nextLine()));
				
				System.out.println("Introduce la parte imaginaria");
				a.setParteImaginaria(Double.parseDouble(teclado.nextLine()));
			
				}catch(Exception ex) {
				a=null;
									}}
				return a;
			}
	
	
	
	public static void main(String[] args) {
		
	int opcion=0;
		
		while (opcion!=4) {
			try {
			mostrarMenu();
			System.out.println("");
			System.out.println("Introduce opción");
			opcion = Integer.parseInt(teclado.nextLine());
			
			switch(opcion) {
		
		case 1:
			System.out.println("El primer complejo");
			Complejo a=pedirComplejo();
			System.out.println("El segundo complejo");
			Complejo b=pedirComplejo();
			System.out.println("Los numeros a sumar son:  "+a.toString() + b.toString()+"El resultado de la suma es: " + Complejo.suma(a, b));
			
			break;
		case 2:
			
			System.out.println("El primer complejo");
			a=pedirComplejo();
			System.out.println("El segundo complejo");
			b=pedirComplejo();
			
			System.out.println("Los numeros a restar son:  "+a.toString() + b.toString()+
					"El resultado de la resta es: " + Complejo.resta(a, b));
			
			break;
		case 3:
			
			System.out.println("El primer complejo");
			 a=pedirComplejo();
			System.out.println("El segundo complejo");
			 b=pedirComplejo();
			
			System.out.println("Los numeros a comparar son:  "
			+a.toString() + b.toString()+"El resultado de la comparacion es: " + a.equals(b));
			
			;
			break;
		case 4: 
			System.out.println("Hasta luego!!");
			break;
			}
			}catch(Exception ex){
				System.out.println(ex.getMessage());
				
			}
		}
		
		}
	}



