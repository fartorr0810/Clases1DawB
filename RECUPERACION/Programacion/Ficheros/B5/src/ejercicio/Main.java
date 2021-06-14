package ejercicio;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		CargarDatos s=new CargarDatos();
			
		//s.cargarCalles();
		//s.cargarCasetas();
		//System.out.println(s.toStringCasetas());
		
	//	System.out.println(s.MostrarCasetasDeUnaCalle(""));
		System.out.println(s.MostrarNumCasetasCalle());
		System.out.println(s.borrarCaseta("PASCUAL MARQUEZ", 27));
		//s.crearArchivoJson("./ficheros/casetasferia2021.csv");

	}

}
