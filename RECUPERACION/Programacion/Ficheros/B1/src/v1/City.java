package v1;

import java.util.ArrayList;
import java.util.List;

public class City {

	private String idcity;
	private String nombre;
	private List<Adress>directions;
	
	public City(String idcity, String nombre, List<Adress>directions) {
		this.idcity=idcity;
		this.nombre = nombre;
		this.directions = new ArrayList<Adress>();
	}

	public String getIdcity() {
		return idcity;
	}

	public void setIdcity(String id_city) {
		this.idcity = id_city;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public List<Adress> getDirections() {
		return directions;
	}

	public void setDirections(List<Adress> directions) {
		this.directions = directions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcity == null) ? 0 : idcity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof City))
			return false;
		City other = (City) obj;
		if (idcity == null) {
			if (other.idcity != null)
				return false;
		} else if (!idcity.equals(other.idcity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.nombre+" direcciones: ");
		for (Adress a : directions) {
			sb.append(a.toString());
		}
		return sb.toString();
	}
	
	
}