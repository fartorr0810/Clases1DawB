package fichero1b;

public class Main {

	public static void main(String[] args) {
		try {
			Listas paises = new Listas("./ContenedorFicheros/country.txt","./ContenedorFicheros/city.txt","./ContenedorFicheros/address2.txt");
			System.out.println(paises);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
