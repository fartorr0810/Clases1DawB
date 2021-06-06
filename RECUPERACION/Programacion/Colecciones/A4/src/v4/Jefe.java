package v4;

public class Jefe extends Empleado {
	
	private int antiguedad;
	private final double SUBIDAJEFE= 1.10;
	//Es el sueldo del jefe
	private double sueldojefe;
	public Jefe(String dni, String nombre, double sueldojefe,int antiguedad) throws Exception {
		super(dni, nombre);
		this.antiguedad=antiguedad;
		if(sueldojefe<=1300) {
			throw new Exception("No se permite un sueldo menor a 1300");
		}
		else {
			super.sueldo=sueldojefe;
		}
	}

	@Override
	public void sueldoActualizable() {
		sueldo=sueldo*SUBIDAJEFE;
	}

	@Override
	public String toString() {
		return super.toString()+"es jefe y lleva: " + antiguedad + "agnos";
	}
	
	
	
}
