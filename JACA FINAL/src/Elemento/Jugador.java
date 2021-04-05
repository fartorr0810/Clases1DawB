package Elemento;

public class Jugador extends Elemento {

	private int fuerza;
	private int magia;
	private int velocidad;
	private int fil;
	private int col;
	private Dinero dinero;	//?
	private Pocion pocion;  //?
	private Gema gema; 		//?
	

	
	public Jugador(int fuerza, int magia, int velocidad, int fil, int col, Dinero dinero, Pocion pocion, Gema gema) {
		super();
		this.fuerza=fuerza;
		this.magia=magia;
		this.velocidad=velocidad;
		this.fil=fil;
		this.col=col;
		this.dinero=dinero;
		this.pocion=pocion;
		this.gema=gema;
		
	}
	

	

	public int getFuerza() {
		return fuerza;
	}



	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}



	public int getMagia() {
		return magia;
	}



	public void setMagia(int magia) {
		this.magia = magia;
	}



	public int getVelocidad() {
		return velocidad;
	}



	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}



	public int getFil() {
		return fil;
	}



	public void setFil(int fil) {
		this.fil = fil;
	}



	public int getCol() {
		return col;
	}



	public void setCol(int col) {
		this.col = col;
	}
	
	
}
