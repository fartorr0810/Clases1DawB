package fichero1b;

public class Address {

	private int address_id;
	private String address;

	public Address(int address_id, String address) {
		super();
		this.address_id = address_id;
		this.address = address;
	}

	public int getAddress_id() {
		return address_id;
	}


	public String getAddress() {
		return address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + address_id;
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
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (address_id != other.address_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address=" + address + "]";
	}
	
	
	
}
