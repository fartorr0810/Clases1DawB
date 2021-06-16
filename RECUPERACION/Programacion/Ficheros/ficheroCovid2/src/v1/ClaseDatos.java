package ficheroCovid2.covid;

import java.util.ArrayList;
import java.util.List;

public class ClaseDatos {

	private List<ClaseMetricas> Metricas;

	public ClaseDatos() {
		this.Metricas = new ArrayList<ClaseMetricas>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Metricas == null) ? 0 : Metricas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ClaseDatos))
			return false;
		ClaseDatos other = (ClaseDatos) obj;
		if (Metricas == null) {
			if (other.Metricas != null)
				return false;
		} else if (!Metricas.equals(other.Metricas))
			return false;
		return true;
	}

	public List<ClaseMetricas> getMetricas() {
		return Metricas;
	}

	public void setMetricas(List<ClaseMetricas> metricas) {
		Metricas = metricas;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (ClaseMetricas claseMetricas : Metricas) {
			sb.append(claseMetricas.toString() + "\n");
		}
		return sb.toString();
	}

}
