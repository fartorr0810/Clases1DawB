package v1;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TamanoMunicipioComunidad m=new TamanoMunicipioComunidad();
		m.LeerJson("./fichero/tamanoMunicipioComunidad.json");
		System.out.println("asd");
		System.out.println(m.mostrarDatosComunidad(2000));
	}
}
