package problemas6OrientacionObjetos1;

import java.util.Scanner;

public class mainMaquinaCafe {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		MaquinaCafe maquina1 = new MaquinaCafe();
		boolean fin=false;
		int opcion=0;
		double pago = 0;
		System.out.println("1Servir cafe solo.\n"
				+ "2.Servir leche.\n"
				+ "3.Servir cafe con leche.\n"
				+ "4.Consultar estado máquina.\n"
				+ "5.Apagar la máquina \n"
				+ "¿Que opcion quiere realizar?");
		while (fin==false) {
			System.out.println("Indique la opcion que quiere realizar");
			opcion=Integer.parseInt(teclado.nextLine());
			switch (opcion) {
			case 1:
			{
				System.out.println("El cafe cuesta 1€, introduzca la cantidad con la que va a pagar");
				pago=Double.parseDouble(teclado.nextLine());
				maquina1.servirCafe(pago);
				break;
			}
			case 2:
			{
				System.out.println("La leche cuesta 0.80€, introduzca la cantidad con la que va a pagar");
				pago=Double.parseDouble(teclado.nextLine());
				maquina1.servirLeche(pago);
				break;
			}
			case 3:
			{
				System.out.println("El cafe con leche cuesta 1.5€, introduzca la cantidad con la que va a pagar");
				pago=Double.parseDouble(teclado.nextLine());
				maquina1.servirCafeConLeche(pago);
				break;
			}
			case 4:
			{
				System.out.println(maquina1);
				break;
			}
			case 5:
			{
				System.out.println("Muchas gracias, vuelva pronto");
				fin=true;
				
				break;
			}
			default:
				System.out.println("La opcion introducida no es valida");
			
			}
			
			
			
		}
		
		/*
		MaquinaCafe maquina= new MaquinaCafe();
		maquina.servirCafe(0);
		maquina.servirLeche(0);
		maquina.servirCafeConLeche(0);
		maquina.consultarEstado();
*/
	}

}
