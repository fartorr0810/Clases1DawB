package logicaJuego;

public class Principal {

	public static void main(String[] args) {
		
		Juego juego = new Juego();
		 char[][] tablero = new char [10][10];
		
		//juego.crearTablero();

		juego.crearTablero(tablero);
		juego.crearGemas(tablero); //PORQUE NO SE VE


	}

}
