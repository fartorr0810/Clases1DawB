package boletinObjetos;

public class Cuenta {

	private double saldo;
	private int numeroIngreso;
	private double numeroReintegro;
	
	
	
	
	//constructores
	
	public Cuenta() {
		
	}
	
public Cuenta(double saldo) {
		this.saldo=saldo;
	}
	

//operadores
	public void reintegro(double cantidadRetirar) {
		if (saldo>0 && cantidadRetirar>0 && cantidadRetirar<saldo) {
		
			System.out.println("la cantidad retirada es " + cantidadRetirar);
		this.numeroReintegro++;
		
		this.saldo=saldo-cantidadRetirar;
		
		}
		else {
			System.out.println("Error, operación incorrecta");
		}
	}
	
	public void ingreso(double cantidadIngresar) {
		if ( cantidadIngresar>0) {
		
			System.out.println("la cantidad ingresada es " + cantidadIngresar);
		this.numeroIngreso++;
		
		this.saldo=saldo+cantidadIngresar;
		
		}
		else {
			System.out.println("Error, operación incorrecta");
		}
	}
	
	
	
	//Getters Setters
	
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroIngreso() {
		return numeroIngreso;
	}

	public void setNumeroIngreso(int numeroIngreso) {
		this.numeroIngreso = numeroIngreso;
	}

	public double getNumeroReintegro() {
		return numeroReintegro;
	}

	public void setNumeroReintegro(double numeroReintegro) {
		this.numeroReintegro = numeroReintegro;
	}
	
	
}
