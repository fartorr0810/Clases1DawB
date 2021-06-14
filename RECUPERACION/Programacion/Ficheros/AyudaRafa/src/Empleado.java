
public class Empleado {

	private String nombre;
	private int salario;
	private boolean casado;
	
	public Empleado(String nombre, int salario) {
		super();
		this.nombre = nombre;
		this.salario = salario;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (casado ? 1231 : 1237);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + salario;
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
		Empleado other = (Empleado) obj;
		if (casado != other.casado)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (salario != other.salario)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "nombre:" + nombre + ", salario:" + salario + ", casado:" + casado + "\n";
	}
	
	
	
}
