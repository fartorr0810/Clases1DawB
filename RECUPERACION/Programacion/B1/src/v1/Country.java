package v1;

public class Country {
	private int countryid;
	private String countryname;
	//Crear lista con ciudades
	public Country(int countryid, String countryname) {
		super();
		this.countryid = countryid;
		this.countryname = countryname;
	}
	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", countryname=" + countryname + "]";
	}
	//Crear metodo que anada ciudades junto a su respetivo id.
	

}
