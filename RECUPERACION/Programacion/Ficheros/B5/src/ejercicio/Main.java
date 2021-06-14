package ejercicio;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		CargarDatos s=new CargarDatos();
			
		//s.cargarCalles();
		//s.cargarCasetas();
		//System.out.println(s.toStringCasetas());
		
		System.out.println(s.MostrarCasetasDeUnaCalle("PASCUAL MARQUEZ"));	
		System.out.println(s.borrarCaseta("ANTONIO BIENVENIDA", 94));
		System.out.println(s.MostrarCasetasDeUnaCalle("PASCUAL MARQUEZ"));

		//s.crearArchivoJson("./ficheros/casetasferia2021.csv");

	}

}
