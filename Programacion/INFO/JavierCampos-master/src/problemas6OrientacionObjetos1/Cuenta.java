package problemas6OrientacionObjetos1;

public class Cuenta {
	private int numeroReintegros;
	private int numeroIngresos;
	private double saldo;
	
	public Cuenta() {}
	
	public Cuenta(double saldo) {
		this.saldo = saldo;
	}
	
	
	//operacion 1
	public void hacerReintegro(double reintegro) {
		if (saldo>0 && saldo >= reintegro && reintegro>0) {
			saldo=saldo-reintegro;
			numeroReintegros++;
		}
		else {
			System.out.println("La operacion no se puede realizar");
		}
		
	}
	//operacion 2
	public void hacerIngreso(double ingreso) {
		if (ingreso>0) {
			saldo+=ingreso;
			numeroIngresos++;
		}
		else {
			System.out.println("La operacion no se puede realizar");
		}
		
	}
	//operacio 3
	public String getStatus() {
		return "El saldo es " + this.saldo + " el numero de ingresos es "
				+ this.numeroIngresos + " y el de reintegros " + this.numeroReintegros;
	}
	// operacion 4
	public String getSaldoFinal() {
		return "El saldo final es "+ saldo;
	}
	
}
