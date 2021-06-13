package ejercicio;

import java.util.LinkedList;


public class Calle {
	private String nombrecalle;
	private int idcalle;
	private LinkedList<Caseta> casetas;
	
	public Calle(String nombrecalle, int idcalle) {
		super();
		this.nombrecalle = nombrecalle;
		this.idcalle = idcalle;
		casetas=new LinkedList<Caseta>();
	}
	public void addCaseta(Caseta c) {
		casetas.add(c);
	}
	public String getNombrecalle() {
		return nombrecalle;
	}
	public int getIdcalle() {
		return idcalle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idcalle;
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
		Calle other = (Calle) obj;
		if (idcalle != other.idcalle)
			return false;
		return true;
	}
	public String toStringCaseta() {
		StringBuilder sbb=new StringBuilder("nombre calle:"+this.nombrecalle);
		for (Caseta caseta : casetas) {
			sbb.append(caseta.toString()+"\n");
		}
		return sbb.toString(); 
	}
}
