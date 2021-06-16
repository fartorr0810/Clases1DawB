package ficheroCovid2.covid;

import java.util.ArrayList;
import java.util.List;

public class ClaseMetricas {
	
	private List<Dato>Datos;

	public ClaseMetricas() {
		this.Datos = new ArrayList<Dato>();
	}

	public List<Dato> getDatos() {
		return Datos;
	}

	public void setDatos(List<Dato> datos) {
		Datos = datos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Datos == null) ? 0 : Datos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ClaseMetricas))
			return false;
		ClaseMetricas other = (ClaseMetricas) obj;
		if (Datos == null) {
			if (other.Datos != null)
				return false;
		} else if (!Datos.equals(other.Datos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Dato dato : Datos) {
			sb.append(dato.toString()+"\n");
		}
		return sb.toString();
	}
	
	
}
