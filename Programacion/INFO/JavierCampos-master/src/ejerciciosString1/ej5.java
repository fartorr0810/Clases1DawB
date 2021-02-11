package ejerciciosString1;

public class ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Diseñe una función llamada palíndromo que tenga una cadena de caracteres como parámetro y devuelva verdadero si es un palíndromo o 
		 * falso en otro caso. Una palabra es un palíndromo, si se lee igual de izquierda a derecha que de derecha a izquierda, ignorando 
		 * los blancos. Por ejemplo: "anilina" o "el abad le dio arroz al zorro" Para simplificar el problema, se puede asumir que se utilizan 
		 * caracteres simples, es decir, sin tildes ni diresis.
		 */
		
		System.out.println(palindromo("Ana"));
		System.out.println(palindromo("anilina"));
		System.out.println(palindromo("el abad le dio arroz al zorro"));
		System.out.println(palindromo("Ana    aNa ANa anA     "));
		
	}
	public static boolean palindromo (String cadena) {
		
		String cadena1="";
		cadena = cadena.toLowerCase();
		cadena= cadena.replace(" ","");
		for (int i=0; i< cadena.length();i++) 
		{
			/* if (Character.isSpaceChar(cadena.charAt(i))==false)
			{
				es otra forma de quitarle los espacios
			}*/
			cadena1=cadena.charAt(i)+cadena1;
		}
		if (cadena1.equals(cadena))
		{
			return true;
		}
		else {
			return false;
		}
		
		
		
		
	}
}
