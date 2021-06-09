package v1;

public class Adress {
	//
	private int adressid;
	private String adressname;
	
	public Adress(int adressid, String adressname) {
		super();
		this.adressid = adressid;
		this.adressname = adressname;
	}

	public int getAdressid() {
		return adressid;
	}

	public String getAdressname() {
		return adressname;
	}

	@Override
	public String toString() {
		return "Adress [adressid=" + adressid + ", adressname=" + adressname + "]";
	}
	
}
