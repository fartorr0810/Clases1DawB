package v4;

public enum Puesto {
	ADMINISTRADOR(1150.0),OPERARIO(1100.0),CONTABLE(1350.0);
	protected double sueldo;	
	Puesto(double sueldo) {
	    this.sueldo = sueldo;
	}

	public double getSueldo() {
		return sueldo;
	}
}



