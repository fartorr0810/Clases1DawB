package cadenas1;


/*
 * 
 * Design a function called lowCaseInString that has a string of 
 * characters as parameter, the method should return how many of 
 * those characters are lowcase letters.
 *
 * 
 * 
 * */
 
public class ej2 {

	
	public static int lowCaseInString(String cadena) {
		int minusculas=0;
		
		//Comprobamos por cada caracter si es minusculas recorriendo la cadena y si es, sumamos
		
		for (int i=0;i<cadena.length();i++) {
			
			if (Character.isLowerCase(cadena.charAt(i))==true) {
				
				minusculas++;
				}
		}
		
		return minusculas;
	}
	
	
	public static int upperCaseInString(String cadena) {
	
	int may=0;
	
	//Comprobamos por cada caracter si es minusculas recorriendo la cadena y si es, sumamos
	
	for (int i=0;i<cadena.length();i++) {
		
		if (Character.isUpperCase(cadena.charAt(i))==true) {
			
			may++;
			}
	}
	
	
	return may;
	}
	
	 public static void main (String[]args) {
		 
		 System.out.println(lowCaseInString("HaSd Fg"));
		 System.out.println(lowCaseInString(""));
		 System.out.println(lowCaseInString("A"));
		 System.out.println(lowCaseInString("a"));
		 System.out.println("-------");
		 System.out.println(upperCaseInString("HaSd Fg"));
		 System.out.println(upperCaseInString(""));
		 System.out.println(upperCaseInString("A"));
		 System.out.println(upperCaseInString("a"));
		 System.out.println("------------");
		 System.out.println(cuentaMinMay("hola AhOLA", false));
		 System.out.println(cuentaMinMay("hola AhOLA", true));
	 
	 }
	 
	 public static int cuentaMinMay(String cadena, boolean upper) {
		 int cont=0;
		
		 for (int i=0;i<cadena.length();i++) {
			 
			 if( upper && Character.isUpperCase(cadena.charAt(i))==true) {
				 
				 cont++;
			 }
			 
			 else if(!upper && Character.isLowerCase(cadena.charAt(i))==true) {
				 
				 cont++;
				 
			 }
			 
		 }
		 
		 return cont;
		
		 } 
}
