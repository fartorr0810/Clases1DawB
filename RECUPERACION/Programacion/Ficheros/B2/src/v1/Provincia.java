package v1;

import java.util.ArrayList;

public class Provincia {
	private String nombre;
	private ArrayList<Localidad>localidades;
	
	public Provincia(String nombre) {
		localidades=new ArrayList<Localidad>();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void addLocalidad(Localidad local, Centro centro, Curso curso, Materia ma) {
		if(!this.localidades.contains(local)) {
			localidades.add(local);
		}else {
			this.localidades.get(this.localidades.indexOf(local)).addCentro(centro, curso, ma);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("Provincia: "+nombre);
		for (Localidad localidad : localidades) {
			sb.append(localidad.toString()+"\n");
		}
		return sb.toString();
	}
	
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
		Provincia other = (Provincia) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
