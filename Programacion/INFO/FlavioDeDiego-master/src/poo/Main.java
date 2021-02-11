package poo;

public class Main {

	public static void main(String[] args) {
		
		Persona flavio = new Persona();
		Persona juan = new Persona("Juan", 22, 1.85,90.00);
		
		
	
		System.out.println(flavio);
		System.out.println(juan);
		System.out.println(juan.getNombre() + " tiene " +juan.getEdad()+", mide "+juan.getAltura()+" y pesa " + juan.getPeso());
		

	}

}
