package boletinObjetos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Rectangulo rect1 = new Rectangulo();
		
		System.out.println("Introduce Longitud");
		rect1.setLongitud(Double.parseDouble(sc.nextLine()));
		
		System.out.println("Introduce Ancho");
		rect1.setAncho(Double.parseDouble(sc.nextLine()));
		
		
		
		System.out.println("El area es " + rect1.calculaArea());
		System.out.println("El perimetro es " + rect1.calculaPerimetro());
		
		
	}

}
