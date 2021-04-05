package Elemento;


public class Elfo extends Jugador {

	public Elfo (int fil, int col, Dinero dinero, Pocion pocion, Gema gema) {
		super(logicaJuego.Constantes.ELFO_FUERZA, logicaJuego.Constantes.ELFO_MAGIA, logicaJuego.Constantes.ELFO_VELOCIDAD, fil, col, dinero, pocion, gema);
	}
	
}
