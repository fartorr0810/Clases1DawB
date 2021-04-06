package ejercicioalumnos;

import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clase primeroB=new Clase();
		
		primeroB.AddAlumnos(new Alumno("Bad", "Bunny", "BEYBE", 10.0));
		primeroB.AddAlumnos(new Alumno("Rambo", "En El pecho del jambo", "Y el jambbo sin poder respirar", 10.0));
		primeroB.AddAlumnos(new Alumno("Gucci", "Polo", "Yeyoenmiiphone", 10.0));
		primeroB.AddAlumnos(new Alumno("Lil", "Bokeron", "Bombon", 1.0));
		primeroB.AddAlumnos(new Alumno("Terry", "Bunny", "BEYBE", 3.0));
//		System.out.println(primeroB.getAlumnos().get(0));
//		System.out.println(primeroB.getAlumnos().get(primeroB.getAlumnos().size()-1));
//		System.out.println(primeroB.getAlumnosAprobados());
//		System.out.println(primeroB.getAlumnosSuspensos());
		/*
		 * Si esto estuviera vacio y no se controlase daria un NaN , divide null entre 0 y petaria
		 */
		System.out.println(primeroB.getNotaMedia());
		Collections.sort(primeroB.getAlumnos());
		System.out.println(primeroB.getAlumnos());
	}

}
