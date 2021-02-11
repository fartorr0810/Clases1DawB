package ejerciciosString1;

public class ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(upperCaseInString("HoLA HI"));
	}
/*
 * Diseñe una función llamada upperCaseInString que tenga una cadena de caracteres como parámetro, el método debe devolver cuántos de esos caracteres son 
 * letras mayúsculas
 */
	
	public static int upperCaseInString(String cadena) {
		int contador=0;
		for (int i=0; i< cadena.length();i++) {
			if (Character.isUpperCase(cadena.charAt(i))==true){
				contador++;
			}
		}
		return contador;
	}
	
}
