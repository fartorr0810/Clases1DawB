package boletinObjetos;

import java.util.Scanner;

public class PrincipalMaquina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int opcionMaquina=4;
		Scanner teclado = new Scanner(System.in);
		Maquina cafetera = new Maquina();
		
		
		
		
		while(opcionMaquina !=5) {
			mostrarMenu();
			opcionMaquina = Integer.parseInt(teclado.nextLine());
		switch(opcionMaquina) {
		
		case 0:
			cafetera.llenarDeposito();
		case 1:
			cafetera.servirCafe();
			break;
		case 2:
			cafetera.servirLeche();
			break;
		case 3:
			cafetera.servirCafeLeche();
			break;
		case 4:
			cafetera.consultarEstado();
			break;
		case 5:
			break;
		}
	}
	}
	
	public static void mostrarMenu() {
		System.out.println("\n Elija una opción:\n 1.Café solo \n 2.Leche \n 3.Café con leche \n 4.Consultar estado \n 5. Apagar");
		
		
		
	}

}
