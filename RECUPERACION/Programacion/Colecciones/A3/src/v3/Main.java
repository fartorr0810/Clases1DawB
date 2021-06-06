package v3;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int eleccion=0;
		Empresa jaca=new Empresa("IES JACARANDA S.A");
		do {
			System.out.println(mostrarMenu());
			eleccion=Integer.parseInt(sc.nextLine());
			switch (eleccion) {
			case 1:
				jaca.addGeneradorSolar(LocalDate.of(2023, 2, 23), "San Juan", (float) 50.0, 2, 5, "FOTOVOLTAICO");
				jaca.addGeneradorSolar(LocalDate.of(2013, 2, 23), "San Juan", (float) 50.0, 2, 5, "FOTOVOLTAICO");

				break;
			case 2:
				jaca.addGeneradorEolico(LocalDate.of(2020, 2, 20), "Brenes", (float) 25.00, 4);
				jaca.addGeneradorEolico(LocalDate.of(2021, 2, 1), "Brenes", (float) 43.00, 4);
				jaca.addGeneradorEolico(LocalDate.of(2021, 2, 1), "Antilla", (float) 43.00, 4);

				break;
			case 3:
				System.out.println(jaca.ordenarGeneradores());
				break;
			case 4:
				System.out.println(jaca.ordenarGeneradores());

				break;
			case 5:
				System.out.println(jaca.mostrargeneradoreseolicos());
				break;
			case 6:
				try {
					System.out.println(jaca.BorrarGenerador(2));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println(jaca.MostrarPotencia());
				break;
			case 8:
				System.out.println(jaca.ExisteGenerador("Brenes"));
				System.out.println(jaca.ExisteGenerador("Italia"));

				break;
			default:
				break;
			}
		}while(eleccion!=9);
	}
	public static String mostrarMenu() {
		return "1-Anadir generador solar\n"+
							"2-Añadir generador eólico\n"+
							"3-Mostrar generadores ordenados por fecha\n"+
							"4-Mostrar generadores ordenados por localidad y por fecha\n"+
							"5-Mostrar generadores eólicos de la empresa\n"+
							"6-Borrar generador\n"+
							"7-Mostrar toda la energia\n"+
							"8-¿Existe el generador?\n"+
							"9-Salir";
	}
}
