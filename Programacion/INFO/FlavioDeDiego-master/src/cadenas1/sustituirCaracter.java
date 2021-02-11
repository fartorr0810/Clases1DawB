package cadenas1;

import java.util.Scanner;

public class sustituirCaracter {
	
	
	static Scanner sc = new Scanner (System.in);
	static String nombre;
	

	
	public static void main(String[] args) {
		
		System.out.println("Introduce nombre");
		nombre= sc.nextLine();
		System.out.println("Introduce el caracter que quieres sustituir");
		char c1=sc.nextLine().charAt(0);
		System.out.println("Introduce el caracter nuevo");
		char c2=sc.nextLine().charAt(0);
		nombre=nombre.replace(c1, c2);
		System.out.println(nombre);
	}
}
