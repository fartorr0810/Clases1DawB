package v1;

import java.util.ArrayList;

public class Localidad {
	private String nombre;
	private ArrayList<Centro>centros;
	
	
	public Localidad(String nombre) {
		this.nombre = nombre;
		centros=new ArrayList<Centro>();
	}
	public void addCentro(Centro centro, Curso curso, Materia materia) {//se le pasa un String para obtener la posicion para luego 
		if(!centros.contains(centro)){
			centros.add(centro);                //poder cargar las listas definitivas leyendo el archivo
		}else {
			this.centros.get(this.centros.indexOf(centro)).addCurso(curso, materia);
			}
	}

	public String getNombre() {
		return nombre;
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
		Localidad other = (Localidad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("Localidad: "+nombre);
		for (Centro centro : centros) {
			sb.append(centro.toString()+"\n");
		}
		return "Localidad []";
	}
	
	
}
