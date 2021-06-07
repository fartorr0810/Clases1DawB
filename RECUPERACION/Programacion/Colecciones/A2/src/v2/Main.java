package v2;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws Exception {

		Empresa emp=new Empresa();

		emp.AddTareaCliente("Instalar W7", "MEDIA", "PEPE", "Madrid");
		emp.AddTareaCliente("Instalar W12", "ALTA", "PEPE", "Madrid");

		System.out.println(emp.AddTareaEmpresa("Actualizar W10", "ALTA", "Informatica"));
		
		System.out.println(emp.mostrarTareas());
		System.out.println(emp.mostrarTareasPrioridad());
		System.out.println(emp.numTareasPendientes());
		emp.resolverTarea("Instalar W7", LocalDate.now(), LocalDate.of(2022,1,2));
		System.out.println(emp.mostrarTareasPrioridad());
		System.out.println(emp.numTareasPendientes());
		//Eso peta porque lo compruebo en el cosntructor
		emp.AddTareaCliente("Instalar W12", "ALTA", "PEPE", "Madrid");


	}

}
