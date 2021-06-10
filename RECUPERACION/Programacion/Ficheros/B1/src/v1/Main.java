package v1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MuchosPaises mc=new MuchosPaises();
		mc.cargarPaises();
		mc.cargarCiudades();
		mc.cargarDirecciones();
		System.out.println(mc.toStringPaises());
		System.out.println(mc.EscribirFichero());
	}
}


