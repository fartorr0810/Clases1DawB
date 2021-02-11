package cadenas1;

public class ej5 {

	
	/*
	 * 
	 * Design a function called palindrome that has a string of characters as parameter, 
	 * and return true if it is a palindrome or false in other case. A word is a palindrome, 
	 * if it is reads the same from left to right as from right to left, ignoring whites,.
	 *  For example: "anilina" or "el abad le dio arroz al zorro" To simplify the problem, 
	 * you can assume that simple characters are used, that is, without tildes or diresis.*/
	
	
	


public static boolean palindrome(String pal) {
	

	
	pal= pal.toLowerCase();
	String palabra = new StringBuilder(pal.replace(" ", "")).toString();
	String cadena = new StringBuilder(palabra).reverse().toString();

	
	
	System.out.println(palabra);
	System.out.println(cadena);
	
	return cadena.equals(palabra);
}
	
	public static void main(String[] args) {
		
		
		System.out.println(palindrome("A cavar a Caravaca"));
		System.out.println(palindrome("el abad "));

	}

}
