package v1;

import java.util.LinkedList;


public class City {
	private int cityid;
	private String nombrecity;
	private LinkedList<Adress> calles;

	public City(int cityid, String nombrecity) {
		super();
		this.cityid = cityid;
		this.nombrecity = nombrecity;
		calles=new LinkedList<Adress>();
	}
	
	public int getCityid() {
		return cityid;
	}

	public String getNombrecity() {
		return nombrecity;
	}
	public void addDirecciones (Adress a) {
		if(!calles.contains(a)){
			this.calles.add(a);
		}	
	}
	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append("City [city_id=" + cityid + ", city=" + nombrecity + "]");
		for (Adress c : calles) {
			sb.append(c.toString() +"\n");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cityid;
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
		City other = (City) obj;
		if (cityid != other.cityid)
			return false;
		return true;
	}
	
}
