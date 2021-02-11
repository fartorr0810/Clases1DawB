package cadenas1;

public class ej6 {

	
	/*
	 * 
	 * Realizar una función que busque una palabra escondida dentro de un texto. 
	 * Por ejemplo, si la cadena es “shybaoxlna” y la palabra que queremos buscar 
	 * es “hola”, entonces si se 
	 * encontrará y deberá devolver True, en caso contrario deberá devolver False.
	 * 
	 * 
	 */
	
	
	public static boolean buscaPalabra(String texto, String palabra) {
		boolean result=false;
		int j=0;
		
		texto=texto.toLowerCase();
		palabra=palabra.toLowerCase();
		
		for (int i=0;i<texto.length();i++) {
			if (j<palabra.length() && texto.charAt(i)==palabra.charAt(j)) {
				j++;
			}
		if (j==palabra.length()){
			result=true;
		}
		}
		
		return result;
		
	} 
	
	
	public static void main(String[] args) {
System.out.println(buscaPalabra("123ho4h5la67", "Hola"));
System.out.println(buscaPalabra("123456h7", "ho"));	
	}

}
