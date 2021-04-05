package Elemento;

public class Ogro extends Jugador {

	public Ogro (int fil, int col, Dinero dinero, Pocion pocion, Gema gema) {
		super(logicaJuego.Constantes.OGRO_FUERZA, logicaJuego.Constantes.OGRO_MAGIA, logicaJuego.Constantes.OGRO_VELOCIDAD, fil, col, dinero, pocion, gema);
	}
	
}
