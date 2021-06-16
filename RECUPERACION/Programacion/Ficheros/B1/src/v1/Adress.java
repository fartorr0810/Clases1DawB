package v1;

public class Adress {
	
	private String idaddress;
	private String nombre;
	
	public Adress(String idaddress, String nombre) {
		this.idaddress= idaddress;
		this.nombre = nombre;
	}



	public String getIdaddress() {
		return idaddress;
	}



	public void setIdaddress(String idaddress) {
		this.idaddress = idaddress;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idaddress == null) ? 0 : idaddress.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (idaddress == null) {
			if (other.idaddress != null)
				return false;
		} else if (!idaddress.equals(other.idaddress))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.nombre+ ", id: "+this.idaddress);
		return sb.toString();
	}

	
}