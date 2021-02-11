package problemas6OrientacionObjetos1;

public class Complejo {
	private double parteReal;
	private double parteImaginaria;
	
	public double getParteReal() {
		return parteReal;
	}

	public void setParteReal(double parteReal) {
		this.parteReal = parteReal;
	}

	public double getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(double parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}

	public Complejo() {}
	
	public Complejo(double parteReal, double parteImaginaria) {
		this.parteReal = parteReal;
		this.parteImaginaria= parteImaginaria;
	}
	
	public Complejo sumarComplejos(double parteReal1, double parteImaginaria1, double parteReal2, double parteImaginaria2 ) {
		parteReal=parteReal1+parteReal2;
		parteImaginaria=parteImaginaria1+parteImaginaria2;
		Complejo resultadoSuma = new Complejo(parteReal, parteImaginaria);
		return resultadoSuma;
	}
	
	public Complejo restarComplejos(double parteReal1, double parteImaginaria1, double parteReal2, double parteImaginaria2 ) {
		parteReal=parteReal1-parteReal2;
		parteImaginaria=parteImaginaria1-parteImaginaria2;
		Complejo resultadoResta = new Complejo(parteReal, parteImaginaria);
		return resultadoResta;
	}
	
	@Override 
	public String toString() {
		return this.parteReal + " + "+ this.parteImaginaria + "i";
		
	}
	@Override 
	public boolean equals(Object obj) {
		boolean sonIguales = false;
		if (this==obj) {
			sonIguales=true;
		}
		else if (obj instanceof Complejo) {
			if (((Complejo) obj).getParteImaginaria()==this.getParteImaginaria() && ((Complejo)obj).getParteReal()==this.getParteReal()) {
				sonIguales=true;
			}
		}
		return sonIguales;
		
	}
	

}


