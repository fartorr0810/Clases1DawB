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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adressid;
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
		Adress other = (Adress) obj;
		if (adressid != other.adressid)
			return false;
		return true;
	}
	
}
