package ejerciciosString1;

public class ej4 {

	public static void main(String[] args) {
		/*
		 * Diseñe una función llamada numberInString que tenga una cadena de caracteres como parámetro, el método debe devolver cuántos de esos 
		 * caracteres son números.
		 */
		System.out.println(numberInString("Ho87LA  8  HI654"));
	}
	public static int numberInString(String cadena) {
		int contador=0;
		for (int i=0; i< cadena.length();i++) {
			if (Character.isDigit(cadena.charAt(i))==true){
				contador++;
			}
		}
		return contador;
	}

}
