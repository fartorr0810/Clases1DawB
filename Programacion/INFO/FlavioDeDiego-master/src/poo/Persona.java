package poo;

public class Persona {

	private String nombre;
	private double altura;
	private int edad;
	private double peso;
	
	
	
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}


	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	
	
	//Constructor
	
	public Persona(String nombre, int edad, double altura, double peso) {
		
		this.nombre=nombre;
		this.edad=edad;
		this.altura=altura;
		this.peso=peso;
	}
	
	//constructor 2- Vacio
	
	public Persona() {
		
	}
	
	
	//toString suele ir al final del syso sin que lo veamos
	
	@Override
	public String toString() {
		return this.nombre + this.edad;
	}
	
}
