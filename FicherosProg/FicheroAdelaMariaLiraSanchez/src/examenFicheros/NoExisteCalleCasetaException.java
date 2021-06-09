package examenFicheros;

public class NoExisteCalleCasetaException extends Exception {

	public NoExisteCalleCasetaException() {
		super("No se encuentra esa calle o numero de caseta");
	}
	
}
