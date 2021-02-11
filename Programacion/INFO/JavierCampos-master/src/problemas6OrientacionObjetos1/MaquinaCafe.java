package problemas6OrientacionObjetos1;

public class MaquinaCafe {
	private int depositoCafe;
	private int depositoLeche;
	private int depositoVasos;
	private double monedero;
	private double cambio;
	
	public MaquinaCafe() {
		llenarDeposito();
		this.monedero=50;
	}
	
	public MaquinaCafe(double monedero) {
		this.monedero=monedero;
	}
	
	public void vaciarMonedero() {
		System.out.println("Obtiene "+ this.monedero + " euros");
		this.monedero=0;
		
		
	}
	public void llenarDeposito() {
		this.depositoCafe=50;
		this.depositoLeche=50;
		this.depositoVasos=80;
	}
	
	@Override
	public String toString() {
		return "Hay "+this.depositoCafe +" dosis te café, "+ this.depositoLeche +" dosis de leche y, "+ this.depositoVasos + 
				" vasos, además el monedero cuenta con "+ this.monedero + " euros";
	}
				
	

	
	public void servirCafe(double pago) {
		if (depositoCafe>0 && depositoVasos>0 && pago>=1 && pago-1<=monedero) {
			depositoCafe--;
			depositoVasos--;
			System.out.println("Aqui tiene su café");
			cambio= pago-1;
			monedero-=pago-cambio;
			System.out.println("Su cambio es "+cambio+ " recójalo");	
		}
		else if (depositoCafe>0 && depositoVasos>0 && pago>=1 && pago-1>monedero) {
			System.out.println("La operación no se puede realizar porque no tenemos cambio para ese pago");
		}
		else {
			System.out.println("Lo sentimos, no podemos servirle");
		}
	}
	public void servirLeche(double pago) {
		if (depositoLeche>0 && depositoVasos>0 && pago>=0.8 && pago-0.8<=monedero) {
			depositoLeche--;
			depositoVasos--;
			System.out.println("Aqui tiene su leche");
			cambio= pago-0.8;
			monedero-=pago-cambio;
			System.out.println("Su cambio es "+cambio+ " recójalo");	
		}
		else if (depositoLeche>0 && depositoVasos>0 && pago>=0.8 && pago-0.8>monedero) {
			System.out.println("La operación no se puede realizar porque no tenemos cambio para ese pago");
		}
		else {
			System.out.println("Lo sentimos, no podemos servirle");
		}
	}
	
	public void servirCafeConLeche(double pago) {
		if (depositoLeche>0 && depositoVasos>0 && depositoCafe>0 && pago>=1.5 && pago-1.5<=monedero) {
			depositoLeche--;
			depositoCafe--;
			depositoVasos--;
			System.out.println("Aqui tiene su cafe con leche");
			cambio= pago-1.5;
			monedero-=pago-cambio;
			System.out.println("Su cambio es "+cambio+ " recójalo");	
		}
		else if (depositoLeche>0 && depositoVasos>0 && depositoCafe >0 && pago>=0.8 && pago-0.8>monedero) {
			System.out.println("La operación no se puede realizar porque no tenemos cambio para ese pago");
		}
		else {
			System.out.println("Lo sentimos, no podemos servirle");
		}
	}
	
	

}
