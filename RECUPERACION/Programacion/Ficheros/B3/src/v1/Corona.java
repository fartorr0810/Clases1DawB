package v1;

import java.time.LocalDate;

public class Corona implements Comparable<Corona>{
	private int contagiados;
	private int curados;
	private int fallecidos;
	private LocalDate fecha;
	
	public Corona() {
		super();
	}
	public Corona(LocalDate fecha, int contagiados, int curados, int fallecidos) {
		this.fecha=fecha;
		this.contagiados=contagiados;
		this.curados=curados;
		this.fallecidos=fallecidos;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getContagiados() {
		return contagiados;
	}
	public void setContagiados(int contagiados) {
		this.contagiados = contagiados;
	}
	public int getCurados() {
		return curados;
	}
	public void setCurados(int curados) {
		this.curados = curados;
	}
	public int getFallecidos() {
		return fallecidos;
	}
	public void setFallecidos(int fallecidos) {
		this.fallecidos = fallecidos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Corona other = (Corona) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Corona [fecha=" + fecha + ", contagiados=" + contagiados + ", curados=" + curados + ", fallecidos="
				+ fallecidos + "]";
	}
	@Override
	public int compareTo(Corona o) {
		
		return this.getFecha().compareTo(o.getFecha());
	}
	
	
	
	
	
	
	
}
