package ejercicio1;
import java.util.ArrayList;
import java.util.TreeSet;
public class Cliente {
	public int codCliente;
	private String direccion;
	private long telefono;
	public Pais pais;
	public TreeSet facturas=new java.util.TreeSet();
	public Cliente(int codCliente, String direccion, long telefono, TreeSet facturas,Pais pais) {
		this.codCliente = codCliente;
		this.direccion = direccion;
		this.telefono = telefono;
		this.facturas = facturas;
		this.pais=pais;
	}
}
