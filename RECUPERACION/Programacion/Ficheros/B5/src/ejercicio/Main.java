package ejercicio;

public class Main {

	public static void main(String[] args) {
		CargarDatos s=new CargarDatos();
			
		s.cargarCalles();
		s.cargarCasetas();
		System.out.println(s.toStringCasetas());
	}

}
