package starWars;

public class Personaje {

	
	private String nombre;
	private int poder;
	private double estatura;
	private double peso;
	private Pelicula pelicula;
	private String especie;
	
	
	

	
	public Personaje() {
		
	}
	
	
public Personaje(String nombre, int poder, double estatura, double peso, Pelicula pelicula, String especie) {
	
	this.nombre=nombre;
	this.poder=poder;
	this.estatura=estatura;
	this.peso=peso;
	this.pelicula=pelicula;
	this.especie=especie;
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "";
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public int getPoder() {
		return poder;
	}





	public void setPoder(int poder) {
		this.poder = poder;
	}





	public double getEstatura() {
		return estatura;
	}





	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}





	public double getPeso() {
		return peso;
	}





	public void setPeso(double peso) {
		this.peso = peso;
	}





	public Pelicula getPelicula() {
		return pelicula;
	}





	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}





	public String getEspecie() {
		return especie;
	}





	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	
	
	
	
}
