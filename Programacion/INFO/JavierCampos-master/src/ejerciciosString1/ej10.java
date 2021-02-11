package ejerciciosString1;

public class ej10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribir una función que, devuelva el número de palabras que hay en una cadena que recibecomo parámetro. Ten en cuenta que entre dos 
		 * palabras puede haber más de un blanco. También al principio y al final de la frase puede haber blancos redundantes.Por ejemplo, 
		 * si la cadena es “He estudiado mucho”, debe devolver 3
		 */
		System.out.println(cuentaPalabras("     Hola    aqui vemos , ,   si cuenta bien     "));
		System.out.println(cuentaPalabras("     Hola    ?%$ "));
	}
	public static int cuentaPalabras(String cadena)
	{
		int contador=0;
		boolean palabra=false;
		int ultimaLetra=cadena.length()-1;
		
		for (int i=0;i<cadena.length();i++)
		{
			//Si el caracter es una letra y no es el ultimo, convertimos palabra en true
			if (Character.isLetter(cadena.charAt(i)) && i!=ultimaLetra)
			{
				palabra=true;
			}
			// si el caracter no es una cadena y palabra es true, aumentamos el contador y reiniciamos la variable de palabra a false
			else if (! Character.isLetter(cadena.charAt(i)) && palabra==true)
			{
				contador++;
				palabra=false;
			}
			// si el caracter es una letra, pero nos encontramos ante el ultimo caracter, aumentados el condador 
			else if (Character.isLetter(cadena.charAt(i)) && i==ultimaLetra)
			{
				contador++;
			}
		}
		return contador;
	}

}
