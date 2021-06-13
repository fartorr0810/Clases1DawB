package v1;

public class Materia {
	private String nombre;
	private Libro libro;
	
	public Materia(String nombre, Libro libro) {
		super();
		this.nombre = nombre;
		this.libro = libro;
	}

	public String getNombre() {
		return nombre;
	}

	public Libro getLibro() {
		return libro;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", libro=" + libro.getTitulo() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
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
		Materia other = (Materia) obj;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
