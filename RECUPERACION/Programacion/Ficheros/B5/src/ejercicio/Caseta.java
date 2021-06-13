package ejercicio;

public class Caseta {
	private String titulo;
	private int numero;
	private int modulos;
	private ClaseCaseta clase;
	private String entidad;
	private int id;
	
	public Caseta(String titulo, int numero, int modulos, String clase, String entidad, int id) {
		super();
		this.titulo = titulo;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = ClaseCaseta.valueOf(clase);
		this.entidad = entidad;
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getNumero() {
		return numero;
	}

	public int getModulos() {
		return modulos;
	}

	public ClaseCaseta getClase() {
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
		return true;
	}

	@Override
	public String toString() {
		return "Caseta [titulo=" + titulo + ", numero=" + numero + ", modulos=" + modulos + ", clase=" + clase
				+ ", entidad=" + entidad + ", id=" + id + "]";
	}
	
	


}
