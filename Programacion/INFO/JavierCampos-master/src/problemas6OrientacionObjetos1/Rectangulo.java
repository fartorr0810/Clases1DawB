package problemas6OrientacionObjetos1;
/*
 * Crear una clase Rectangulo con los atributos longitud y ancho, cada uno con unvalor predeterminado igual a 1. Proporcionar los métodos  set  y  
 * get  para losatributos longitud y ancho respectivamente. El método set debe verificar quelongitud y ancho contengan números reales mayores que cero
 *  y menores que20.  Además,   proporcionar  métodos   que   calculen   el   perímetro   y  el   área   delrectángulo. 
 */
public class Rectangulo {
	private double ancho=1;
	private double longitud=1;
	
	
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		if ((ancho>0) && (ancho <20)) {
		this.ancho = ancho;
		}
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		if ((longitud>0) && (longitud <20)) {
			this.longitud = longitud;
			}
	}

	/*
	 * Este método calculan el area del rectangulo y el perimetro
	 */


	public double calcularPerimetro() {
		return this.ancho * 2 + this.longitud*2;
		
	}
	public double calcularArea() {
		return this.ancho * this.longitud;
		
	}
	
	//Para hacerlo de otra forma el to String seria así
	@Override
	public String toString() {
		return ("La longitud de este rectangulo es "
				+ this.getLongitud() + " y ancho " + 
				this.getAncho());
	}
	
	

}
