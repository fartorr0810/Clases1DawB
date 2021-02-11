package boletinObjetos;

public class Rectangulo {

	private double longitud =1;
	private double ancho=1;
	
	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		
		if (ancho>0 && ancho<20) {
		this.ancho = ancho;
		}
	}

	public double getLongitud() {
		return longitud;
		
	}
	
	public void setLongitud(double longitud) {
		if (longitud>0 && longitud<20) {
			this.longitud = longitud;
			}
	}
	
	
	public double calculaPerimetro() {
		return longitud+ longitud + ancho + ancho;
	}
	
	public double calculaArea() {
		return this.longitud*this.ancho;
	}
	
	
}
