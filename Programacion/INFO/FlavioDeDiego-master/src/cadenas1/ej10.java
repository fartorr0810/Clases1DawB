package cadenas1;


/*
 * Escribir una función que, devuelva el número de palabras que hay en una
 * cadena que recibecomo parámetro. Ten en cuenta que entre dos palabras puede haber más de un blanco.
 * También al principio y al final de la frase puede haber blancos redundantes.Por ejemplo, si la cadena es
 *  “He estudiado mucho”, debe devolver 3
 */
public class ej10 {

public static int cuentaPalabras(String cadena) {
	int numeroPalabras=0;
	cadena=" "+cadena;

	
	for(int i = 0;i<cadena.length()-1;i++) {
	
	if (Character.isSpaceChar(cadena.charAt(i)) && Character.isLetter(cadena.charAt(i+1))) {
	
	numeroPalabras=numeroPalabras+1;
	
	}
}

return numeroPalabras;
}

public static void main(String[] args) {


System.out.println(cuentaPalabras("hola caracola"));
System.out.println(cuentaPalabras("hola caracola caracola hola"));

System.out.println(cuentaPalabras("  hola caracola caracola hola"));
System.out.println(cuentaPalabras("hola caracola caracola hola   "));



System.out.println(cuentaPalabras("   hola caracola caracola hola  mi "));

}
}