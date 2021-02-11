package prueba;

public class persona {
	private String nombre;
	private String apellidos;
	private double altura;
	private int edad;
	private int peso;
	
	//Constructor vacio
	public persona () {
		
	}
	
	//Constructor con argumentos
	public persona (String nombre, double altura) {
		this.nombre= nombre;
		this.altura= altura;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String toString() {
		return ("La longitud de este rectangulo es "
				+ this.getLongitud() + " y ancho " + 
				this.getAncho())
	}
	
}