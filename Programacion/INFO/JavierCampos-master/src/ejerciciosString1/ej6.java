package ejerciciosString1;

public class ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Realizar una función que busque una palabra escondida dentro de un texto. Por ejemplo,
		 *  si la cadena es "shybaoxlna" y la palabra que queremos buscar es "hola", entonces si 
		 *  se encontrará y deberá devolver True, en caso contrario deberá devolver False.
		 */
		
		System.out.println(palabraEscondida("hhodfsdgffsdgldfdsfas", "hola"));
	}
	
	public static boolean palabraEscondida(String cadena, String palabra)
	{
		boolean resultado=false;
		int j =0;
		if (cadena.length()>palabra.length()) {
		for (int i=0;i< cadena.length();i++)
		{
			if (palabra.length()>j && cadena.charAt(i)==palabra.charAt(j))
					{
					j++;
					}
		}
		if (palabra.length() == j) 
		{
			resultado = true;
		}
		}
		
		return resultado;	
	}

}
