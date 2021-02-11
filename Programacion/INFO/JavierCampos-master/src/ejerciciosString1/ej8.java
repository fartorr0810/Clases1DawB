package ejerciciosString1;

public class ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Diseñar una función que determine la cantidad de vocales diferentes, que tiene una palabra o frase introducida por teclado. Por ejemplo,
		 *  la cadena “Abaco”, devolvería 2.
		 */
		System.out.println(contarVocales("Abaco"));
	}
	public static int contarVocales(String cadena)
	{
		int a=0;
		int e=0;
		int i=0;
		int o=0;
		int u=0;
		cadena=cadena.toLowerCase();
		for (int j=0; j<cadena.length();j++)
		{
			if (cadena.charAt(j)==('a'))
			{
				a=1;
			}
			else if (cadena.charAt(j)==('e'))
			{
				e=1;
			}
			else if (cadena.charAt(j)==('i'))
			{
				i=1;
			}
			else if (cadena.charAt(j)==('o'))
			{
				o=1;
			}
			else if (cadena.charAt(j)==('u'))
			{
				u=1;
			}
		}
		return a+e+i+o+u;
	}
}
