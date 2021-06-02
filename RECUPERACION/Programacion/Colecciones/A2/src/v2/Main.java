package v2;

public class Main {

	public static void main(String[] args) throws Exception {

		Empresa emp=new Empresa();
		try {
			emp.addTareaCliente("Instalar W7", "ALTA", "PEPE", "Madrid");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.addTareaEmpresa("Actualizar W10", "ALTA", "Informatica");
		
		System.out.println(emp.mostrarTareas());
	}

}
