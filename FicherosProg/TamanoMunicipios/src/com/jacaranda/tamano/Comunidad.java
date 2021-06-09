package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.List;

public class Comunidad {
	
	private String nombre;
	private List<Municipio>listMunicipio;
	
	public Comunidad(String nombre) {
		this.nombre=nombre;
		this.listMunicipio=new ArrayList<Municipio>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Municipio> getListMunicipio() {
		return listMunicipio;
	}

	public void setListMunicipio(List<Municipio> listMunicipio) {
		this.listMunicipio = listMunicipio;
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
		Comunidad other = (Comunidad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("\n" + nombre + "\n");
		for (Municipio c : listMunicipio) {
			sb.append(c + "\n");
		}
		return sb.toString();
	}
	
	
}
