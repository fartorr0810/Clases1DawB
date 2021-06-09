package examenFicheros;

import java.util.List;

public class Caseta {

	private String titulo;
	private int numero;
	private int modulo;
	private String clase;
	private String entidad;
	private int id;
	
	
	public Caseta(String titulo, int numero, int modulo, String clase, String entidad, int id) {
		this.titulo = titulo;
		this.numero = numero;
		this.modulo = modulo;
		this.clase = clase;
		this.entidad = entidad;
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public int getNumero() {
		return numero;
	}


	public int getModulo() {
		return modulo;
	}


	public String getClase() {
		return clase;
	}


	public String getEntidad() {
		return entidad;
	}


	public int getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Caseta other = (Caseta) obj;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Caseta [titulo=" + titulo + ", numero=" + numero + ", modulo=" + modulo + ", clase=" + clase
				+ ", entidad=" + entidad + ", id=" + id + "]";
	}

	
	
	
	
	
}
