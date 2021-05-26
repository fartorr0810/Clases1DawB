package ejercicio1;

import java.util.TreeSet;

public class DetalleFactura {
	private int noItem;
	private final int CANTIDAD=0;
	private double descuento;
	public Factura factura;
	public TreeSet Productos=new java.util.TreeSet();
	public DetalleFactura(int noItem, double descuento, Factura factura, TreeSet productos) {
		super();
		this.noItem = noItem;
		this.descuento = descuento;
		this.factura = factura;
		Productos = productos;
	}

}
