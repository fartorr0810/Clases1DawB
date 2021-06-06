package v3;

import java.time.LocalDate;

public class Solar extends Generador {

	private int numpaneles;
	private int m2;
	private Tipogenerador generador;
	
	public Solar(LocalDate fechainicio, String localidad, float potencia,int numpaneles,int m2,String generador) {
		super(fechainicio, localidad, potencia);
		this.numpaneles=numpaneles;
		this.m2=m2;
		this.generador=Tipogenerador.valueOf(generador);
	}

	public int getNumpaneles() {
		return numpaneles;
	}

	public void setNumpaneles(int numpaneles) {
		this.numpaneles = numpaneles;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public Tipogenerador getGenerador() {
		return generador;
	}

	public void setGenerador(Tipogenerador generador) {
		this.generador = generador;
	}

	@Override
	public String toString() {
		return super.toString()+"Solar [numpaneles=" + numpaneles + ", m2=" + m2 + "]";
	}

	@Override
	public float dinerogenerado(float precio) {
		return super.getPotencia()*numpaneles*precio;
	}
	
}
