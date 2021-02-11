package cadenas1;


/*
 * Crear una función que, tomando una cadena de texto como entrada,
 * construya y devuelva otra cadena formada de la siguiente manera:
 *  el método debe colocar todas las consonantes al principio y todas las vocales al final de la misma,
 *   eliminando los blancos.Por ejemplo, pasándole la cadena "curso de programacion",
 *   una posible solución sería "crsdprgrmcnuoeoaaio
 */

public class ej9 {


public static String construyeCadena(String cadena) {

cadena=cadena.replace(" ", "");

String vocales ="";
String consonantes="";



for(int i=0;i<cadena.length();i++) {


if (cadena.charAt(i)=='a'
|| cadena.charAt(i)=='e' || 
cadena.charAt(i)=='i' 
|| cadena.charAt(i)=='o' 
|| cadena.charAt(i)=='u') {

vocales=vocales + cadena.charAt(i);

} else {

consonantes=consonantes + cadena.charAt(i);


}


}


return consonantes+vocales;

}

public static void main(String[] args) {
System.out.println(construyeCadena("hola caracola"));

}

}