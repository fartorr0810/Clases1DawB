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
	public boolean contieneCiudad(int codciudad) {
		boolean result=false;
		City c=new City(codciudad,"");
		if(ciudades.contains(c)) {
			result=true;
		}
		return result;
	}
	public boolean addDireccionCiudad(int codciudad,Adress calle) {
		City c=new City(codciudad, null);
		boolean result=false;
		if (ciudades.contains(c)) {
			c.addDireccion(calle);
			ciudades.get(ciudades.indexOf(c));
			result=true;
		}
		return result;
	}
	public int getCountryid() {
		return countryid;
	}
	public void addciudad(City c) {
		ciudades.add(c);
	}
	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", countryname=" + countryname + "]";
	}
	//Crear metodo que anada ciudades junto a su respetivo id.
	public String toStringCiudades() {
		String mensaje="";
		for (City ciudad : ciudades) {
			mensaje+=ciudades.toString()+"\n";
		}
		return mensaje; 
	}

}
