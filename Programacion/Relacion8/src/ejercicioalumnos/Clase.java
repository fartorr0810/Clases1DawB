package ejercicioalumnos;

import java.util.ArrayList;
import java.util.List;

public class Clase {
	private final double NOTA_APROBADO=5;
	/*
	 * Declaro la lsita de alumnos, si no declaro es null
	 */
	private List<Alumno> alumnos;
	public Clase() {
		super();
		/*
		 * Inicializo
		 */
		alumnos=new ArrayList<Alumno>();
	}
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}


	public void AddAlumnos(Alumno alumnos) {
		this.alumnos.add(alumnos);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getAlumnosAprobados() {
		StringBuilder aprobados=new StringBuilder("Lista de alumnos aprobados: \n");
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno al = alumnos.get(i);
			if (al.getNota()>=NOTA_APROBADO) {
				aprobados.append(al.toString());
			}
		}
		/*
		 * Otra forma de hacer lo mismo de arriba.
		 */
//		for(Alumno al:alumnos) {
//			if (al.getNota()>=NOTA_APROBADO) {
//				aprobados.append(al.toString());
//			}
//		}
		return aprobados.toString();
	}
	public String getAlumnosSuspensos() {
		StringBuilder suspensos=new StringBuilder("Lista de alumnos suspensos: \n");
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno al = alumnos.get(i);
			if (al.getNota()<NOTA_APROBADO) {
				suspensos.append(al.toString());
			}
		}
		/*
		 * Otra forma de hacer lo mismo de arriba.
		 */
//		for(Alumno al:alumnos) {
//			if (al.getNota()>=NOTA_APROBADO) {
//				aprobados.append(al.toString());
//			}
//		}
		return suspensos.toString();
	}
	public double getNotaMedia() {
		double sumadenotas=0;
		double result=0;
		if (!alumnos.isEmpty()) {
			for (Alumno alumno : alumnos) {
				sumadenotas+=alumno.getNota();
			}
			result=sumadenotas/alumnos.size();
		}
		return result;
		}
}

