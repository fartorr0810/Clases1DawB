package v4;

public class EmpleadoBase extends Empleado {
	private Puesto puesto;
	private final double SUBIRSUELDO = 1.025;
	public EmpleadoBase(String dni, String nombre,String puesto) throws Exception {
		super(dni, nombre);
		if (puesto.equals("ADMINISTRADOR")||puesto.equals("OPERARIO")||puesto.equals("CONTABLE")) {
			this.puesto=Puesto.valueOf(puesto);
			super.sueldo=Puesto.valueOf(puesto).getSueldo();
		}
		else {
			throw new Exception("Solo admite ADMINISTRADOR/OPERARIO/CONTABLE");
		}

	
	}
	public Puesto getPuesto() {
		return puesto;
	}
	@Override
	public void sueldoActualizable() {
		sueldo=sueldo*SUBIRSUELDO;
	}
	@Override
	public String toString() {
		return super.toString()+" es tipo empleado base y su puesto es: " +puesto;
	}
	
}
