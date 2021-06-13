package v1;
import java.util.ArrayList;
public class Curso {
	private String nombre;
	private ArrayList<Materia> materias;
	
	public Curso(String nombre) {
		super();
		this.nombre = nombre;
		materias=new ArrayList<Materia>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void addMateria(Materia materia) {
		if(!materias.contains(materia)) {
			materias.add(materia);
		}
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
		Curso other = (Curso) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("Curso: "+nombre);
		for (Materia materia : materias) {
			sb.append(materia.toString()+"\n");
		}
		return sb.toString();
	}
	
	
}
