package Elemento;

public class Guerrero extends Jugador {

	public Guerrero (int fil, int col, Dinero dinero, Pocion pocion, Gema gema) {
		super(logicaJuego.Constantes.GUERRERO_FUERZA, logicaJuego.Constantes.GUERRERO_MAGIA, logicaJuego.Constantes.GUERRERO_VELOCIDAD, fil, col, dinero, pocion, gema);
	}

	
}
