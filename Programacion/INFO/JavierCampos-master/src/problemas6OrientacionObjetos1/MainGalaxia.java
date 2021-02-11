package problemas6OrientacionObjetos1;

public class MainGalaxia {

	public static void main(String[] args) {
		
		PersonajeGalaxia personaje1 = new PersonajeGalaxia("Javier", 85, "Los Estrellados", 1.77, "Sobre Humano", 64);
		PeliculaGalaxia pelicula1= new PeliculaGalaxia("Los Estrellados", 1998, "El tio Paco", "PacaPacheco", "El gordo de los Morancos");
		PeliculaGalaxia pelicula2= new PeliculaGalaxia("3 Patas Pa un Banco", 2010, "Resines", "Frank de la Jungla", "Tragabuche");
		
		try {
			System.out.println(pelicula1.peliculaMasNueva(pelicula1.getYearEstreno(),pelicula2.getYearEstreno()));
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		System.out.println(pelicula1.poderMaximoPelicula(15, 45, 78));
		System.out.println(pelicula1.poderMaximoPersonajes(45, 62, 78));
		System.out.println(pelicula1);
		
		
		System.out.println(personaje1);

	}

}
