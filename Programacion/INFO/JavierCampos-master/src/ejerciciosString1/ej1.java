package ejerciciosString1;


public class ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Diseñe una función llamada charactersInString que tenga una cadena de caracteres y un carácter como 
		 * parámetros de entrada y devuelva cuántas veces aparece ese carácter en la cadena. Debería funcionar 
		 * si la cadena y el carácter son minúsculas o mayúsculas.
		 */
		System.out.println(charactersInString("HOla que haCEs", 'e'));
		}
	
	
	
	
	
	public static int charactersInString(String cadena , char caracter)
	{
	int numeroCaracteres=0;
	cadena = cadena.toLowerCase();
	caracter = Character.toLowerCase(caracter);
	for ( int i=0;  i < cadena.length();i++) {
		if (cadena.charAt(i)==caracter) {
			numeroCaracteres++;
		}
	}
	return numeroCaracteres;
	}
}
