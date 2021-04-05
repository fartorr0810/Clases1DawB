package logicaJuego;

import java.util.ArrayList;
import java.util.Iterator;

public class Juego {

	
	char [][] tablero  = new char [10][10];
	//jugador
	private int ancho;
	private int alto;
	private int numJugadores;
	private boolean finished = false;
	private int jugadorJuega;
	
	public Juego() {}
	
	public Juego(int numJugadores) {
		this.ancho=Constantes.ANCHO;
		this.alto=Constantes.ALTO;
		this.numJugadores=numJugadores;
	}
	
	/**
	 * CREA EL TABLERO
	 */
	public void crearTablero(char [][] tablero) {
		
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j]=' ';
			
				
			}
		}
		System.out.println(ImprimirMatrices.printMatrix(tablero));
	}

	
	/**
	 * CREAR JUGADORES (se le introduce un char)
	 */
	public void crearJugador() {
		 
		return ;
	 }
	
	
	/**
	 * CREAR ROCAS
	 */
	private void crearRocas() {
		tablero[0][7] = Constantes.ROCA;
	}
	
	/**
	 * CREAR ARBOLES
	 */
	private void crearArboles() {
		
	}
	
	/**
	 * CREAR GEMAS
	 */
	private void crearGemas() {		
		tablero[0][0]=Constantes.GEMA;
	}
	
	/**
	 * CREAR POCIONES
	 */
	private void crearPociones() {
		
	}
	
	/**
	 * CREAR DINERO
	 */
	private void crearDinero() {
		
	}
	
	
	/**
	 * HACER TOSTRING
	 */
	
	
	/**
	 * COMPROBAR SI EL JUEGO HA FINALIZADO
	 */
	public boolean isTerminado() {
		boolean terminado = false;
		
		//	COMPROBAR SI LA PARTIDA HA TERMINADO
		
		return terminado;
		
	}
	
	
	/**
	 * ¿BARRA?
	 */
	private String barra() {
		return null;
		
	}
	
	
	/**
	 * IMPRIME EL NOMBRE DE JUGADORES EN PARTIDA
	 */
	public String imprimeNombreJugadores() {
		return null;
		
	}
	
	
	
	/**
	 * IMPRIME LOS VALORES DE LOS JUGADORES
	 */
	public String imprimeValoreJugadores() {
		return null;
		
	}
	
	
	
	/**
	 * INDICA DE QUE JUGADOR ES EL TURNO
	 */
	public void getJugadorTurno() {
		
	}
	
	
	
	/**
	 * INDICA EL MOVIMIENTO???
	 */
	public int getMovimientoJugador() {
		return ancho;
		
	}
	
	
	/**
	 * COMPRUEBA SI EL JUEGO HA FINALIZADO
	 */
	public void compruebaFinJuego() {
		
	}
	
	/**
	 * ELIMINA JUGADOR DE LA PARTIDA (HAY QUE INTRODUCIRLE QUE JUGADOR)
	 */
	private void eliminarJugador() {
		
	}
	
	/**
	 *ENCUENTRA ARBOL EN EL CAMINO (jugador,int,int)
	 */
	private String encuentraArbol() {
		return null;
		
		//if(magia>RELLENAR) posicion roca para jugador
		
		//else no puede colocarse ahi
	}
	
	/**
	 * ENCUENTRA ROCA EN EL CAMINO
	 */
	private String encuentraRoca() {
		return null;
		
		//if(gema>0) posicion roca para jugador
		
		//else no puede colocarse ahi
	}
	
	/**
	 *LUCHA ENTRE LOS DOS JUGADORES(jugador, jugador)
	 */
	public String lucha() {
		return null;
		//"El jugador " + 1ºJUGADOR + " ha ganado, el jugador " + 2ºJUGADOR + " ha perdido."
	}
	
	/**
	 * INDICA LA POSICION DONDE SE VA A MOVER EL JUGADOR(int,int)
	 */
	public void irAPosicion() {
		
	}
	
	
	/**
	 * INDICA QUE JUGADOR SE V A MOVER(char)
	 */
	public String moverJugador() {
		return null;
		
	}
	
	/**
	 * INDICA EL PROXIMO JUGADOR
	 */
	public void proximoJugador() {
		
	}
	
	
	
	/**
	 * NOS DA EL GANADOR
	 */
	public String getGanador() {
		return null;
		//"El jugador " + SEÑALIZACION + " es el ganador."
	}
	
}
