package Elemento;

public class Mago extends Jugador {

	public Mago (int fil, int col, Dinero dinero, Pocion pocion, Gema gema) {
		super(logicaJuego.Constantes.MAGO_FUERZA,logicaJuego.Constantes.MAGO_MAGIA, logicaJuego.Constantes.MAGO_VELOCIDAD, fil, col, dinero, pocion, gema);

	}
	
	
}
