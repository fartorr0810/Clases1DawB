package v1;

import java.util.ArrayList;

public class Centro {
	
	private String nombre;
	private ArrayList<Curso> cursos;
	private Tipo tipo;
	private String codigocentro;
	
	public Centro(String nombre,String codigocentro, String tipoo) {
		super();
		this.nombre = nombre;
		cursos = new ArrayList<Curso>();
		if (tipoo.equals("PRIVADO")||tipoo.equals("PUBLICO")) {
			tipo = Tipo.valueOf(tipoo);			
		}
		this.codigocentro=codigocentro;
	}

	public String getNombre() {
		return nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getCodigocentro() {
		return codigocentro;
	}
	public void addCurso(Curso curso, Materia materia) {
		if(!cursos.contains(curso)) {
			cursos.add(curso);
		}else {
			this.cursos.get(this.cursos.indexOf(curso)).addMateria(materia);
		}
	}	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigocentro == null) ? 0 : codigocentro.hashCode());
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
		Centro other = (Centro) obj;
		if (codigocentro == null) {
			if (other.codigocentro != null)
				return false;
		} else if (!codigocentro.equals(other.codigocentro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("Centro "+nombre);
		for (Curso curso : cursos) {
			sb.append(curso.toString()+"\n");
		}
		return sb.toString();
	}
	
	
}
