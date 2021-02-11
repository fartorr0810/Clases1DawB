package Complejos;

public class Complejo {
	
	private double parteReal;
	private double parteImaginaria;
	

	
	
public Complejo() {
		
		
	}
	
	public  Complejo(double parteReal, double parteImaginaria) {
		
		this.parteReal=parteReal;
		this.parteImaginaria=parteImaginaria;
		
	}

	
	//las partes reales se suman y las partesimaginarias se suman. 
	//Debe diseñarse de forma que devuelva el númerocomplejo resultado de la suma.
	
	public static Complejo suma(Complejo a, Complejo b) {
		
		Complejo result = new Complejo(a.getParteReal()+b.getParteReal(),
				a.getParteImaginaria()+b.getParteImaginaria());
		
		return result;
	}
	
	
	
	
	
	public static Complejo resta(Complejo a, Complejo b) {
		
		Complejo result = new Complejo(a.getParteReal()-b.getParteReal(),
				a.getParteImaginaria()-b.getParteImaginaria());
		
		return result;
	}
	
	
	@Override
	public String toString() {
	
		return "("+this.parteReal +"," + this.parteImaginaria + "i)";
	}
	
	
	public boolean equalsComplejo(Complejo b) {
		
		return (this.parteImaginaria==b.getParteImaginaria() && this.parteReal==b.getParteReal());
		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=false;
		if (obj!=null && this==obj) {
			 sonIguales=true;
		}else if(obj instanceof Complejo){
			if (((Complejo) obj).getParteImaginaria()==this.getParteImaginaria() && 
				((Complejo) obj).getParteReal()==this.getParteReal()) {
				sonIguales=true;
			}
			
		}
	
	return sonIguales;
	}
	
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
}
