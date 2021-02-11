package boletinObjetos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		
	
		Scanner teclado = new Scanner(System.in);
		String opcion="1";
		
		
		Cuenta miCuenta = new Cuenta();
		
		
		
		System.out.println("Introduce Saldo inicial");
		miCuenta.setSaldo(Double.parseDouble(teclado.nextLine()));
		
	while (opcion.equals("1")|| opcion.equals("2") || opcion.equals("3") || opcion.equals("4")) {
		System.out.println("");
		System.out.println("1. Hacer reintegro");
		System.out.println("2.Hacer ingreso");
		System.out.println("3.Consultar saldo, ingresos y reintegros");
		System.out.println("4.Finalizar operación");

		System.out.println("¿Que opción desea realizar?");
		
		 opcion = teclado.nextLine();
		
		if (opcion.equals("1")) {
			System.out.println("Introduce cantidad a retirar");
			miCuenta.reintegro(Double.parseDouble(teclado.nextLine()));
			System.out.println("Su saldo actual es "+ miCuenta.getSaldo());
		}
		else if (opcion.equals("2")){
			
			
			System.out.println("Introduce cantidad a ingresar");
			miCuenta.ingreso(Double.parseDouble(teclado.nextLine()));
			System.out.println("Su saldo actual es "+ miCuenta.getSaldo());
			
			
		}else if (opcion.equals("3")){
			System.out.println("Su saldo es " +miCuenta.getSaldo());
			
			System.out.println("Ha hecho el siguiente numero de ingresos:   " + miCuenta.getNumeroIngreso());
			System.out.println("Ha hecho el siguiente numero de reintegros   :" + miCuenta.getNumeroReintegro());
			System.out.println();
			
		}else if (opcion.equals("4")){
			String salir="0";
			while (!salir.equals("1") && !salir.equals("2")) {
			System.out.println("¿Seguro que quieres salir?");
			System.out.println("");
			System.out.println("1. SI");
			System.out.println("2. NO");
			salir=teclado.nextLine();
			
			if (salir.equals("1")) {
			System.out.println("Tu saldo es "+miCuenta.getSaldo() +"\n Hasta luego!!");
			opcion="5";
			
			
			}
			else if ((salir.equals("2"))){
				System.out.println("Vamos a ello");
			}}
		}
		else {
			System.out.println("Error!!");
			opcion="1";
		}
	}	
}}

