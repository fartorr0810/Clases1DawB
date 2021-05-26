package ejercicio1;

public class Producto {
	public int codProducto;
	private String descripcion;
	private String um;
	private final double PU=0.00;
	private String presentacion;
	public Producto(int codProducto, String descripcion, String um, String presentacion) {
		super();
		this.codProducto = codProducto;
		this.descripcion = descripcion;
		this.um = um;
		this.presentacion = presentacion;
	}
}
