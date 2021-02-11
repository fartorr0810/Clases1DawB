package cadenas1;

import java.util.Scanner;

/*
 * Diseñar una función que determine la cantidad de vocales diferentes, que tiene una palabra 
 * o frase introducida por teclado. Por ejemplo, la cadena “Abaco”, devolvería 2
 */


public class ej8 {

	
	public static int cuentaVocales(String palabra) {

	
		int contA=0;
		int contE=0;
		int contI=0;
		int contO=0;
		int contU=0;
		
		palabra=palabra.toLowerCase();
		for (int i=0; i<palabra.length();i++) {
			
			if(palabra.charAt(i)!='a' && palabra.charAt(i)!='e' 
		&& palabra.charAt(i)!='i'&& palabra.charAt(i)!='o' 
		&& palabra.charAt(i)!='u') {	
			}
			
			else if (palabra.charAt(i)=='a') {
				contA=1;
			} 
			else if (palabra.charAt(i)=='e') {
				contE=1;	
			}
			
			else if (palabra.charAt(i)=='i') {
				contI=1;	
			}
			
			else if (palabra.charAt(i)=='o') {
				contO=1;
			}
			
			else if(palabra.charAt(i)=='u'){
				contU=1;

				
			}
			
			
		}
		
		return contA+contE+contI+contO+contU;
		
	}
	
	public static void main(String[] args) {
		
		
		
		
		
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce Texto");
		String textoIntroducido = teclado.nextLine();
		
		
		
		
		System.out.println(cuentaVocales(textoIntroducido));
		
		
	}
}
