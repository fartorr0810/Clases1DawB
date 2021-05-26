package ejercicio1;

import java.util.TreeSet;

public class PersonaNatural extends Cliente {
	
	private static Pais pais;
	private String nombre;
	private String dni;
	public PersonaNatural(int codCliente, String direccion, long telefono, TreeSet facturas, String nombre,
			String dni) {
		super(codCliente, direccion, telefono, facturas, pais);
		this.nombre = nombre;
		this.dni = dni;
	}
	
}
