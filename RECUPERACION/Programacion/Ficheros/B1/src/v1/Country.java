package v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Country {
	private int countryid;
	private String countryname;
	private  LinkedList<City> ciudades;

	//Crear lista con ciudades
	public Country(int countryid, String countryname) {
		this.countryid = countryid;
		this.countryname = countryname;
		ciudades=new LinkedList<City>();	
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
				if (aux[2].equals(String.valueOf(countryid))) {
					City city=new City(Integer.parseInt(aux[0]),aux[1],Integer.parseInt(aux[2]));
					ciudades.add(city);
				}
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
	
	public int getCountryid() {
		return countryid;
	}

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", countryname=" + countryname + "]";
	}
	//Crear metodo que anada ciudades junto a su respetivo id.
	

}
