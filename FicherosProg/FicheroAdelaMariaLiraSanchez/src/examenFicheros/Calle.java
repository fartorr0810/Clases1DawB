package examenFicheros;

import java.util.ArrayList;
import java.util.List;


public class Calle {

	private String nombre;
	private int id_calle;
	private List<Caseta> listaCasetas;
	
	
	public Calle(String nombre, int id_calle) {
		super();
		this.nombre = nombre;
		this.id_calle = id_calle;
		this.listaCasetas = new ArrayList<Caseta>();;
	}

	public void addCasetas(Caseta c) {
		if(!listaCasetas.contains(c)) {
			listaCasetas.add(c);
		}
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getId_calle() {
		return id_calle;
	}


	public void setId_calle(int id_calle) {
		this.id_calle = id_calle;
	}


	public List<Caseta> getListaCasetas() {
		return listaCasetas;
	}
	
	

//He puesto el nombre pero no se si id tambien seria REVISAR
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Calle other = (Calle) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder("\n" + nombre + "\n");
		for (Caseta c : listaCasetas) {
			sb.append( c +" \n");
		}
		return sb.toString();
	}


	public void removeDatos(int numero) {
		if(listaCasetas.contains(numero)) {
			 listaCasetas.remove(numero);
		}

	}
	
	
	
}
