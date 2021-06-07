package v1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Adress {
	private String adressid;
	private String adress;
public Adress(String adressid, String adress) {
		super();
		this.adressid = adressid;
		this.adress = adress;
	}

public void cargarDatos(String f) {
	try (BufferedReader filtroLectura = new BufferedReader(new FileReader(".\\ficheros\\body\\address2.txt"))){
		String linea = filtroLectura.readLine();
		
		while(linea != null) {
			String values[] = linea.split(",");
			
			if(values.length>=4) {
			Address d = new Adress(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[4]));
			this.direcciones.add(d);
			}
			linea = filtroLectura.readLine();
		}
	} catch (IOException e) {
		e.printStackTrace();
	} 
	}
}