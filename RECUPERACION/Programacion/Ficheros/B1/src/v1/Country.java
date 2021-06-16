package v1;

import java.util.List;
import java.util.ArrayList;

public class Country {
	private String nombre;
	private String idcountry;
	private List<City>ciudades;
	
	public Country(String nombre, String idcountry, List<City>ciudades) {
		this.nombre = nombre;
		this.idcountry = idcountry;
		this.ciudades = new ArrayList<City>();
	}

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}



	public String getIdcountry() {
		return idcountry;
	}

	public void setIdcountry(String idcountry) {
		this.idcountry = idcountry;
	}

	public List<City> getCities() {
		return ciudades;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcountry == null) ? 0 : idcountry.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (idcountry == null) {
			if (other.idcountry != null)
				return false;
		} else if (!idcountry.equals(other.idcountry))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Country "+this.nombre+", id: "+idcountry+", ciudades: ");
		for (City city : ciudades) {
			sb.append(city.toString());
		}
		return "Country [name=" + nombre + ", id_country=" + idcountry + ", cities=" + ciudades + "]";
	}
	
	
}