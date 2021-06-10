package v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Country  {
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
	
	public void addCiudades(City c) {
		if(!ciudades.contains(c)){
			ciudades.add(c);
		}
	}
	
	public boolean addDirecciones(int idCity,String city, Adress a) {
		boolean resul=false;
		City c = new City(idCity,city);
		if(ciudades.contains(c)) {
			ciudades.get(ciudades.indexOf(c)).addDirecciones(a);
			resul=true;
		}
		return resul;
	}
	public int getCountryid() {
		return countryid;
	}

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", countryname=" + countryname + "]";
	}
	//Crear metodo que anada ciudades junto a su respetivo id.
	public String toStringCiudades() {
		StringBuilder sbb=new StringBuilder("nombre pais:"+this.countryname);
		for (City ciudad : ciudades) {
			sbb.append(ciudad.toString()+"\n");
		}
		return sbb.toString(); 
	}


}
