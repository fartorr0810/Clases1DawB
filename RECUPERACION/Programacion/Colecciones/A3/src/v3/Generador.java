package v3;

import java.time.LocalDate;

public class Generador implements Comparable<Generador>,Monetizable{
	private int codigo;
	private static int nextcod=0;
	private LocalDate fechainicio;
	private String localidad;
	
	
	public Generador(LocalDate fechainicio, String localidad, float potencia) {
		this.fechainicio = fechainicio;
		this.localidad = localidad;
		this.potencia = potencia;
		this.codigo=nextcod;
		nextcod++;
	}
	public String getLocalidad() {
		return localidad;
	}
	private float potencia;
	
	public float getPotencia() {
		return potencia;
	}
	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}
	public int getCodigo() {
		return codigo;
	}
	public LocalDate getFechainicio() {
		return fechainicio;
	}
	@Override
	public String toString() {
		return "Generador con codigo: " + codigo + ", fechainicio: " + fechainicio + "su  localidad es: " + localidad
				+ "de potencia: " + potencia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechainicio == null) ? 0 : fechainicio.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + Float.floatToIntBits(potencia);
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
		Generador other = (Generador) obj;
		if (fechainicio == null) {
			if (other.fechainicio != null)
				return false;
		} else if (!fechainicio.equals(other.fechainicio))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (Float.floatToIntBits(potencia) != Float.floatToIntBits(other.potencia))
			return false;
		return true;
	}
	@Override
	public float dinerogenerado(float precio) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int compareTo(Generador o) {
		int result=0;
		if (this.fechainicio.isBefore(o.getFechainicio())) {
			result=1;
		}
		else if (this.fechainicio.isAfter(o.getFechainicio())) {
			result=-1;
		}
		return result;
	}
}
