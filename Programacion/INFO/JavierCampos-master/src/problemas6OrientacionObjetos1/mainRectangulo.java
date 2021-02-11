package problemas6OrientacionObjetos1;
import java.util.Scanner;


public class mainRectangulo {

	public static void main(String[] args) {
		Rectangulo rectangulo1 = new Rectangulo();
		Scanner teclado;
		
		rectangulo1.setAncho(15);
		rectangulo1.setLongitud(15);
		
		
		
		teclado = new Scanner(System.in);
		System.out.println("Escribe el ancho");
		rectangulo1.setAncho(Double.valueOf(teclado.nextInt()));
		System.out.println("Escribe la longitud");
		rectangulo1.setLongitud(Double.valueOf(teclado.nextInt()));
		
		System.out.println(rectangulo1.calcularArea() + " es el area");
		System.out.println(rectangulo1.calcularPerimetro() + " es el perimetro");

	}

}
