package ejerciciosString1;


public class ej7 {

	public static String prueba() {
		return "HOla";
	}
	
	
	public static void main(String[] args) {
		/*
		 * Diseñar una función que reciba como parámetro tres cadenas, la primera será una frase y 
		 * deberá buscar si existe la palabra que recibe como segundo parámetro y reemplazarla por la 
		 * tercera
		 */
		System.out.println(cambiaCadena("hola que haces", "haces", "tal"));
		
		
	}
	public static String cambiaCadena(String texto, String palabra, String reemplazo)
	{
		
		return texto.replace(palabra,reemplazo);
	}
	
}
