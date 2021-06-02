package v1;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Empresa jaca=new Empresa("Jacaranda");
		try {
			jaca.addPeliSerie(2, "Casa de papel", "COMEDIA", 2001, 25, 10);
		} catch (Exception e) {
		}
		try {
			jaca.addPeliSerie(2, "Vikingos", "COMEDIA", 2001, 25, 10);
		} catch (Exception e) {
		}
		jaca.addPeliSerie(1, "Jodidos", "COMEDIA", 1999, 25, 10);
		jaca.addPeliSerie(1, "Jodiados", "COMEDIA", 1999, 25, 10);

		System.out.println(jaca.listarPelisSeries());
		//System.out.println(jaca.setTema("Jodido", "CIENCIAFICCION"));
		System.out.println(jaca.addEpisodio("Vikingos", "Ragnarock", 0));
		System.out.println(jaca.addEpisodio("Vikingos", "Ragnarock", 1));
		System.out.println(jaca.addEpisodio("Vikingos", "Ragnarock", 1));

		System.out.println(jaca.addEpisodio("Vikingos", "Ragnarock", 3));
		jaca.delEpisodio("Vikingos", "Ragnarock");
		System.out.println(jaca.listarPorNombres());

	}

}
