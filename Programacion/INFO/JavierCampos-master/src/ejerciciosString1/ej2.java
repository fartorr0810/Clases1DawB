package ejerciciosString1;

public class ej2 {

	public static void main(String[] args) {
		/*Diseñe una función llamada lowCaseInString que tenga una cadena de caracteres como parámetro, el método debe devolver cuántos de 
		 * esos caracteres son letras minúsculas.
		 */
		System.out.println(lowCaseInString("HoLA HI"));
	}
	
	public static int lowCaseInString(String cadena) {
		int contador=0;
		for (int i=0; i< cadena.length();i++) {
			if (Character.isLowerCase(cadena.charAt(i))==true){
				contador++;
			}
		}
		return contador;
	}

}
