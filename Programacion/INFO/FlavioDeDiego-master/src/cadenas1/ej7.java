package cadenas1;

public class ej7 {

	
	/*
	 * Diseñar una función que reciba como parámetro tres cadenas, 
	 * la primera será una frase y deberá buscar si existe la palabra 
	 * que recibe como segundo parámetro y reemplazarla por la tercera.
	 * 
	 */
	
	
	public static String buscarYReemplazar(String texto,String busqueda,String reemplazo) {
		return texto.replace(busqueda, reemplazo);
	}
	
	public static void main(String[] args) {
System.out.println(buscarYReemplazar("la lluvia en sevilla es una maravilla sevilla", "sevilla", "cordoba"));
	}

}
