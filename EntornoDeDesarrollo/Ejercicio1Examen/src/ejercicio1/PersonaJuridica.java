package ejercicio1;

import java.util.TreeSet;

public class PersonaJuridica extends Cliente {

	private static Pais pais;
	private String razonSocial;
	private String ruc;
	public PersonaJuridica(int codCliente, String direccion, long telefono, TreeSet facturas, String razonSocial,
			String ruc) {
		super(codCliente, direccion, telefono, facturas, pais);
		this.razonSocial = razonSocial;
		this.ruc = ruc;
	}
}
