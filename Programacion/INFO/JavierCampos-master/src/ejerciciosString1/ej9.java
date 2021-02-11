package ejerciciosString1;

public class ej9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Crear una función que, tomando una cadena de texto como entrada, construya y devuelva otra cadena formada de la siguiente manera: 
		 * el método debe colocar todas las consonantes al principio y todas las vocales al final de la misma, eliminando los blancos.
		 * Por ejemplo, pasándole la cadena "curso de programacion", una posible solución sería "crsdprgrmcnuoeoaaio
		 */
		System.out.println(modificaCadena("curso de programacion"));
	}
	public static String modificaCadena(String cadena)
	{
		String cadena1="";
		String cadena2="";
		cadena=cadena.replace(" ", "");
		for (int i=0; i<cadena.length();i++)
		{
			if ((cadena.charAt(i)=='a') || (cadena.charAt(i)=='e') || (cadena.charAt(i)=='i') || (cadena.charAt(i)=='o') || (cadena.charAt(i)=='u'))
			{
				cadena1= cadena1+cadena.charAt(i);
			}
			else {
				cadena2=cadena2+cadena.charAt(i);
			}
		}
	return cadena2+cadena1;
	}
}
