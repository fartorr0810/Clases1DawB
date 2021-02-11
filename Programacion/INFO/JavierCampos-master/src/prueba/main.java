package prueba;

public class main {

	public static void main(String[] args) {
		
		persona javi = new persona("Javier", 1.77 );
		
		System.out.println(javi.getNombre());
		
		
		persona personaVacia = new persona();
		personaVacia.setNombre("Antonio");
		System.out.println(personaVacia.getNombre());
	}

}