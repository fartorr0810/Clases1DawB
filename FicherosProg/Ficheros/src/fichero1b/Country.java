package fichero1b;

import java.util.ArrayList;



public class Country {

	private int country_id;
	private String country;
	private ArrayList<City>listaCiudades;
	
	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
		this.listaCiudades= new ArrayList<City>();
	}

	public void addCiudades(City c) {
		if(!this.listaCiudades.contains(c)){
			this.listaCiudades.add(c);
		}
	}
	
	public boolean addDirecciones(int idCity,String city, Address a) {
		boolean resul=false;
		City c = new City(idCity,city);
		if(this.listaCiudades.contains(c)) {
			this.listaCiudades.get(this.listaCiudades.indexOf(c)).addDirecciones(a);
			resul=true;
		}
		return resul;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + country_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (country_id != other.country_id)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append("Country [country_id=" + country_id + ", country=" + country + "]");
		for (City a : listaCiudades) {
			sb.append(a.toString() +"\n");
		}
		return sb.toString();
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	
	
	
	
	
}
