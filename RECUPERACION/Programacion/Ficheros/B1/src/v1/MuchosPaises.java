package v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class MuchosPaises {
	private LinkedList<Country> paises;
	private LinkedList<City> ciudades;

	public MuchosPaises() {
		super();
		paises=new LinkedList<Country>();
		ciudades=new LinkedList<City>();
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
	public void cargarCiudades()  {
		String linea;
		String aux[];
		try {
			FileReader lectura = new FileReader("./ficheros/country.txt");
			BufferedReader buffer=new BufferedReader(lectura);
			linea=buffer.readLine();
			while (linea!=null) {				
				aux=linea.split(",");
				City city=new City(Integer.parseInt(aux[0]),aux[1],Integer.parseInt(aux[2]));
				ciudades.add(city);
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
	public String toStringPaises() {
		String mensaje="";
		for (Country country : paises) {
			mensaje+=country.toString()+"\n";
		}
		return mensaje;
	}
	public String toStringCiudades() {
		String mensaje="";
		for (City c : ciudades) {
			mensaje+=c.toString()+"\n";
		}
		return mensaje;
	}
}
