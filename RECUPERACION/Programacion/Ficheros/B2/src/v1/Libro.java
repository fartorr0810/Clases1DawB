package v1;


public class Libro {
	private String titulo;
	private String ean;
	private String editorial;
	private String digital;
	
	public Libro(String titulo, String ean, String editorial, String digital) {
		super();
		this.titulo = titulo;
		this.ean = ean;
		this.editorial = editorial;
		this.digital = digital;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public String getEan() {
		return ean;
	}
	public String getEditorial() {
		return editorial;
	}
	public String isDigital() {
		return digital;
	}
	
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", ean=" + ean + ", editorial=" + editorial + ", digital=" + digital + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ean == null) ? 0 : ean.hashCode());
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
		Libro other = (Libro) obj;
		if (ean == null) {
			if (other.ean != null)
				return false;
		} else if (!ean.equals(other.ean))
			return false;
		return true;
	}
}
