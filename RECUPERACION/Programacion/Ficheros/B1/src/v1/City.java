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
	public void addDireccion(Adress calle) {
		calles.add(calle);
	}
	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", nombrecity=" + nombrecity;
}
}
