package v4;

public class Main {

	public static void main(String[] args) {
		Departamento clase=new Departamento("Programacion");
		try {
			clase.addEmpleado("12345678Q", "Fran", "CONTABLE");
		} catch (Exception e) {
		}
		try {
			clase.addJefe("123132Z", "Aose", 1360.0, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			clase.addJefe("123132Z", "Jose", 1860.0, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(clase.toString());
		System.out.println(clase.obtenerSueldo());
		System.out.println(clase.toStringSueldo());
	}

}
