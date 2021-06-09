package com.jacaranda.tamano;

import java.util.ArrayList;

public class Municipio {

	private String  descrip;
	private ArrayList<Datos>datos;
	
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public ArrayList<Datos> getDatos() {
		return datos;
	}
	public void setDatos(ArrayList<Datos> datos) {
		this.datos = datos;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datos == null) ? 0 : datos.hashCode());
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
		if (datos == null) {
			if (other.datos != null)
				return false;
		} else if (!datos.equals(other.datos))
			return false;
		if (descrip == null) {
			if (other.descrip != null)
				return false;
		} else if (!descrip.equals(other.descrip))
			return false;
		return true;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("\n" + descrip + "\n");
		for (Datos m : datos) {
			sb.append(m + "\n");
		}
		return sb.toString();
		
	}
	public void addDatos(Datos dato) {
		  if (datos.contains(dato)) {
	           datos.get(datos.indexOf(dato)).setDato(dato.getDato());
	        }else {
	            datos.add(dato);
	        }
	}
	
	
	
	
	
}
