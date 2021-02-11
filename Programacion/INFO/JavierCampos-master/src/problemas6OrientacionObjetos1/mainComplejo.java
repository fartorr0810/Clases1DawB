package problemas6OrientacionObjetos1;

import java.util.Scanner;

public class mainComplejo {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		Complejo complejo1 = new Complejo();
		boolean fin=false;
		int opcion=0;
		double parteReal1;
		double parteImaginaria1;
		double parteReal2;
		double parteImaginaria2;
		System.out.println("1. Sumar complejos\n"
				+ "2.Restar complejos.\n"
				+ "3.Comparar numeros complejos.\n"
				+ "4.Salir.\n");
		
		System.out.println("Introduce primero la parte real del primer numero");
		parteReal1=Double.parseDouble(teclado.nextLine());
		
		System.out.println("Introduce primero la parte imaginaria del primer numero");
		parteImaginaria1=Double.parseDouble(teclado.nextLine());
		
		System.out.println("Introduce primero la parte real del segundo numero");
		parteReal2=Double.parseDouble(teclado.nextLine());
		
		System.out.println("Introduce primero la parte imaginaria del segundo numero");
		parteImaginaria2=Double.parseDouble(teclado.nextLine());
		
		Complejo complejoA= new Complejo(parteReal1, parteImaginaria1);
		Complejo complejoB= new Complejo(parteReal2, parteImaginaria2);
		
		while (fin==false) {
			System.out.println("Indique la opcion que quiere realizar");
			opcion=Integer.parseInt(teclado.nextLine());
			switch (opcion) {
			case 1:
			{
				System.out.println(complejo1.sumarComplejos(parteReal1, parteImaginaria1, parteReal2, parteImaginaria2));
				
				break;
			}
			case 2:
			{
				System.out.println(complejo1.restarComplejos(parteReal1, parteImaginaria1, parteReal2, parteImaginaria2));
				break;
			}
			case 3:
			{
				System.out.println(complejoA.equals(complejoB));
				break;
			}
			
			case 4:
			{
				System.out.println("Muchas gracias, vuelva pronto");
				fin=true;
				
				break;
			}
			default:
				System.out.println("La opcion introducida no es valida");
			
			}
			
		}
		
	}

}
