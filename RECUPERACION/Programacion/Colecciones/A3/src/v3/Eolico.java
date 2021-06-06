package v3;

import java.time.LocalDate;

public class Eolico extends Generador{

	private int numaspas;

	public Eolico(LocalDate fechainicio, String localidad, float potencia,int numaspas) {
		super(fechainicio, localidad, potencia);
		this.numaspas=numaspas;
		}
	public int getNumaspas() {
		return numaspas;
	}
	public void setNumaspas(int numaspas) {
		this.numaspas = numaspas;
	}
	@Override
	public String toString() {
		return super.toString()+" es tipo Eolico y tiene: " + numaspas + " aspas";
	}
	@Override
	public float dinerogenerado(float precio) {
		return super.getPotencia()*numaspas*precio;
	}
}
