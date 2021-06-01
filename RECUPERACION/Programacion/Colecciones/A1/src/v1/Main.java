package v1;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Empresa jaca=new Empresa("Jacaranda");
		try {
			jaca.addPeliSerie(2, "ClSafir", "COMEDIA", 2001, 25, 10);
		} catch (Exception e) {
		}
		try {
			jaca.addPeliSerie(2, "AlSafir", "COMEDIA", 2001, 25, 10);
		} catch (Exception e) {
		}
		jaca.addPeliSerie(1, "Jodidos", "COMEDIA", 1999, 25, 10);
		jaca.addPeliSerie(1, "Jodiados", "COMEDIA", 1999, 25, 10);

		System.out.println(jaca.listarPelisSeries());
		System.out.println(jaca.setTema("Jodido", "CIENCIAFICCION"));
	}

}
