package ejercicio1;
import java.util.Date;
import java.util.TreeSet;
public class Factura {
	public int noFactura;
	private Date fecha;
	private final double IGV=18.00;
	private final double DESCUENTO=0.0;
	public TreeSet DetalleFacturas=new java.util.TreeSet();
	public Factura(int noFactura, Date fecha, TreeSet detalleFacturas) {
		super();
		this.noFactura = noFactura;
		this.fecha = fecha;
		DetalleFacturas = detalleFacturas;
	}

}
