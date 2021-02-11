package boletinObjetos;

import java.util.Scanner;

public class Maquina {

	Scanner teclado = new Scanner(System.in);
	
	private int depositoCafe=50;
	private int depositoLeche=50;
	private int depositoVasos=80;
	private double monedero=50.0;
	
	
	public Maquina() {
		llenarDeposito();
		this.monedero=50.0;
	}
	
	
	
	public void llenarDeposito() {
		this.depositoCafe=50;
		this.depositoLeche=50;
		this.depositoVasos=80;
		
	}
	
	
	public void vaciarMonedero() {
		this.monedero=0;
	}
	
	public void consultarEstado() {
		System.out.println("Nº Vasos " + getDepositoVasos());
		System.out.println("Nº Cafe " + getDepositoCafe());
		System.out.println("Nº Leche " + getDepositoLeche());
		System.out.println("Cambio :  " + getMonedero());
		 
	}
	
	public void servirCafe() {
		
		if (depositoVasos>0 && depositoCafe>0 && depositoLeche>0) {
			
		this.depositoCafe-=1;
		this.depositoVasos-=1;
		this.monedero+=1;
		darCambio(1);
		
		}else {System.out.println("AGOTADO");}
		
	}
	
	public void servirCafeLeche() {
		if (depositoVasos>0 && depositoCafe>0 && depositoLeche>0) {
			
					
			this.depositoCafe-=1;
			this.depositoVasos-=1;
			this.depositoLeche-=1;
			this.monedero+=1.5;
			darCambio(1.5);
		
		}else {System.out.println("AGOTADO");}
		
		
		
	}

	public void servirLeche() {
		
		if (depositoVasos>0 && depositoLeche>0) {
			
			
			this.depositoVasos-=1;
			this.depositoLeche-=1;
			this.monedero+=0.8;
			darCambio(0.8);
			
		} else {System.out.println("AGOTADO");}
	}

	public void darCambio(double aCobrar) {
		double cambio=0;
		double pagado=0;
		
		while (pagado<aCobrar) {
			System.out.println("Su precio es : "+ aCobrar+"\n Ha introducido \n" + pagado +"\n Introduce monedas");
			double cantidadIntroducida=Double.parseDouble(teclado.nextLine());
			if (cantidadIntroducida-aCobrar<monedero) {
				pagado+=cantidadIntroducida;
			}else {System.out.println("CAMBIO INSUFICIENTE!!");}
			
		}
		
		cambio=pagado-aCobrar;
		 System.out.println("Gracias!! Aquí tiene su cambio "+ cambio);
		
	}

	//GETTERS SETTERS
	
	public int getDepositoCafe() {
		return depositoCafe;
	}


	public void setDepositoCafe(int depositoCafe) {
		this.depositoCafe = depositoCafe;
	}


	public int getDepositoLeche() {
		return depositoLeche;
	}


	public void setDepositoLeche(int depositoLeche) {
		this.depositoLeche = depositoLeche;
	}


	public int getDepositoVasos() {
		return depositoVasos;
	}


	public void setDepositoVasos(int depositoVasos) {
		this.depositoVasos = depositoVasos;
	}


	public double getMonedero() {
		return monedero;
	}


	public void setMonedero(double monedero) {
		this.monedero = monedero;
	}
}
