package cadenas1;


/*
 * Design a function 
 * called charactersInString that has a character string and a 
 * character as input parameters and returns how many times that 
 * character appears in the string. 
 * It should do if the string and character are  lower case or upper 
 * case characters.
 * 
 * 
 */

public class ej1 {


	
	public static int charactersInString(String cadena, char c) {
		
		cadena=cadena.toLowerCase();
		c=Character.toLowerCase(c);    //Quedaba pasar a minuscula el caracter
		int suma=0;
		
		for(int i=0;i<cadena.length();i++) {
			
			
			if(cadena.charAt(i)==c) {
				suma++;
			}
		}
		
		return suma;
	}
	
	public static void main(String[] args) {
		
		
		
		System.out.println(charactersInString("cAracolA", 'O'));

	}

	

}
