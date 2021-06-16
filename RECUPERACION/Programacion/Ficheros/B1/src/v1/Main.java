package v1;

import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		MuchosPaises l = new MuchosPaises();
		try {
			l.imprimeDatos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}