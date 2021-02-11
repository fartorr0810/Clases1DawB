package problemas6OrientacionObjetos1;
import java.util.Scanner;

public class mainCuenta {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		double cantidad=-1;
		int opcion=0;
		int salir=0;
		
		//Con este primer bucle nos aseguramos que la cantidad inical sea mayor que 0
		while (cantidad<0) {
			System.out.println("Ingresa la cantidad inicial: ");
			cantidad=teclado.nextInt();
		}
		Cuenta cuenta1 = new Cuenta(cantidad);
		
		System.out.println("1.Hacer un reintegro.\n"
				+ "2.Hacer un ingreso.\n"
				+ "3.Consultar el saldo  y el número de reintegros e ingresos realizados.\n"
				+ "4.Finalizar las operaciones.\n"
				+ "Elija la operación que desea realizar");
		opcion = teclado.nextInt();
		while (opcion==1 || opcion==2 || opcion==3 || opcion==4) {
			if (opcion==1) {
				System.out.println("Introduzca la opcion a reintegrar");
				cuenta1.hacerReintegro(teclado.nextInt());
			}
			else if (opcion==2){
				System.out.println("Introduzca la opcion a ingresar");
				cuenta1.hacerIngreso(teclado.nextInt());
			}
			else if (opcion==3){
				System.out.println(cuenta1.getStatus());
			}
			
			else if (opcion==4) {
				System.out.println(cuenta1.getSaldoFinal());
				System.out.println("Está seguro que quiere salir No=0 / Si=1");
				salir=teclado.nextInt();
			}
			
			if (salir==0) {
				System.out.println("Elija otra operacion a realizar");
				opcion = teclado.nextInt();
			}
			else {
				System.out.println("Vuelva pronto");
				opcion=0;
			}
		}
		
		//Con esto nos aseguramos de decirle que no es correcto cuando nunca haya entrado en el bucle
		if (opcion !=0 && salir!=1) {
			System.out.println("La opcion introducida no ha sido válida");
		}
		
		
		
	}
}
		
		
		/*
		Scanner teclado;
		int opcion=0;
		double cantidad=0;
		
		
		
		System.out.println("1.Hacer un reintegro.\n"
				+ "2.Hacer un ingreso.\n"
				+ "3.Consultar el saldo  y el número de reintegros e ingresos realizados.\n"
				+ "4.Finalizar las operaciones.");
		
		if (opcion==1 || opcion==2 || opcion==3 || opcion==4) {
			while (opcion!=4) {
				if (opcion==1) {
					System.out.println("¿Que cantidad desea retirar?");
					cantidad=teclado.nextInt();
					cuenta1.setTotal();
					
				}
				else if (opcion==2) {
					System.out.println("¿Que cantidad desea ingresar?");
					
				}
				else if (opcion==3) {
					
				}
				System.out.println("¿Que otra operación quiere realizar?");
				opcion=teclado.nextInt();
			}
			System.out.println("¿Realmente quiere salir?");
		}
		else {
			System.out.println("La opcion introducida no es correcta");
		}
		
		
		
		
	}

}
*/
