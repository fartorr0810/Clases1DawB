package ejercicioalumnos;

public class Alumno extends Persona implements Comparable<Alumno>{
	
	private double nota;
	
	public Alumno(String nombre,String apellido1,String apellido2,double nota) {
		super(nombre, apellido1, apellido2);
		this.nota=nota;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"y su nota es "+this.nota;
	}

	@Override
	public int compareTo(Alumno o) {
		int comparatorrr=0;
		if (this.getNombre()>o.getNombre()) {
			
		}
		return 0;
	}

//	@Override
//	public int compareTo(Alumno o) {
//		// TODO Auto-generated method stub
//		int compareResult=0;
//		if (this.nota>o.getNota()) {
//			compareResult=1;
//		}else if(this.nota<o.getNota()) {
//			compareResult=-1;
//		}
//		return compareResult;
//	}
	
	
}
