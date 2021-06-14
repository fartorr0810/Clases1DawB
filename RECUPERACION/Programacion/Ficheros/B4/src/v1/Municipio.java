package v1;

import java.util.ArrayList;


public class Municipio {

	private String  descrip;
	private ArrayList<Datos>datos;

	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		this.datos=new ArrayList<Datos>();
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
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
		Municipio other = (Municipio) obj;
		if (descrip == null) {
			if (other.descrip != null)
				return false;
		} else if (!descrip.equals(other.descrip))
			return false;
		return true;
	}
	
	public String toString(int ano){
		StringBuilder sb = new StringBuilder("\n" + descrip + "\n");
		for (Datos m : datos) {
			if (m.getAno()==ano) {
				sb.append(m + "\n");
			}
		}
		return sb.toString();
		
	}
	
	
	
	
	
	
}
