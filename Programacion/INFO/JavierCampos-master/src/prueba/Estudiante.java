package prueba;

public class Estudiante extends persona {
	private String Nota;
	public String toString() {
		return this.getNombre() + " " + this.getNota();
	}

}
