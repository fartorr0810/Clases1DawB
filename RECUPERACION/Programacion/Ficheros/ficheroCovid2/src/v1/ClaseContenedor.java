package ficheroCovid2.covid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class ClaseContenedor {
	
	private ClaseDatos Datos;
	
	public ClaseContenedor() {
		this.Datos = Datos;
	}

	public ClaseDatos getDatos() {
		return Datos;
	}

	public void setDatos(ClaseDatos datos) {
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
		if (!(obj instanceof ClaseContenedor))
			return false;
		ClaseContenedor other = (ClaseContenedor) obj;
		if (Datos == null) {
			if (other.Datos != null)
				return false;
		} else if (!Datos.equals(other.Datos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Datos=" + Datos;
	}

	
}
