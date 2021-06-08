package v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class MuchosPaises {
	private LinkedList<Country> paises;

	public MuchosPaises() {
		super();
		paises=new LinkedList<Country>();
	}
	public void cargarPaises()  {
		String linea;
		String aux[];
		try {
			FileReader lectura = new FileReader("./ficheros/country.txt");
			BufferedReader buffer=new BufferedReader(lectura);
			linea=buffer.readLine();
			while (linea!=null) {				
				aux=linea.split(",");
				Country cc=new Country(Integer.parseInt(aux[0]),aux[1]);
				paises.add(cc);
				linea=buffer.readLine();
			}
			buffer.close();
			lectura.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String toStringCiudades() {
		String mensaje="";
		for (Country country : paises) {
			mensaje+=country.toString()+"\n";
		}
		return mensaje;
	}
}
