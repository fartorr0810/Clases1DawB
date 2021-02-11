package cadenas1;






public class ej4 {

/*
 * Design a function called numberInString that has a string of characters as parameter,
 *  the method should return how many of those characters are numbers
 * 
 * */

	
	public static int numberInString(String cadena) {
		int suma=0;
		
		
		for(int i=0;i<cadena.length();i++) {
			
			if (Character.isDigit(cadena.charAt(i))==true) {
				suma++;
			}
		}
		
		
		return suma;
		
	}
	
	
	public static void main(String[] args) {
			
		System.out.println(numberInString("aa 4 4 4 s d e wasdasdWERWEFWE4FG"));
		System.out.println(numberInString("0"));
		System.out.println(numberInString("1"));
		System.out.println(numberInString(""));
		System.out.println(numberInString("aaASDADS ssss"));
		System.out.println(numberInString("55555"));
	}


	
	
}





