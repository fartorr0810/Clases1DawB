package v1;

import java.util.LinkedList;

public class City {
	private LinkedList<Adress> calles;
	private String ciudad;
	public City(LinkedList<Adress> calles, String ciudad) {
		super();
		calles=new LinkedList<Adress>();
		this.ciudad = ciudad;
	}
	
}
