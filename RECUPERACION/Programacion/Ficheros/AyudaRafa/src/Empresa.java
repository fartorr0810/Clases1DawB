import java.util.ArrayList;

public class Empresa {

	private String nombre;
	private ArrayList<Empleado> empleados;
	
	//A la hora de leer, siempre constructores por defecto
	public Empresa(String nombre, ArrayList<Empleado> empleados) {
		super();
		this.nombre = nombre;
		this.empleados = empleados;
	}
	
	
	public Empresa() {
		this.empleados=new ArrayList<Empleado>();
	}
	
	
	
	
	
	

	











	@Override
	public String toString() {
		StringBuilder respuesta= new StringBuilder();
		
		respuesta.append("Empresa: "+nombre+"\n");
		
		for (Empleado empleado : empleados) {
			respuesta.append("\t"+empleado+"\n");
		}
		return respuesta.toString();
	}











	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
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
		Empresa other = (Empresa) obj;
		if (empleados == null) {
			if (other.empleados != null)
				return false;
		} else if (!empleados.equals(other.empleados))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
}
