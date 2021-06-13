package ejercicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;



public class CargarDatos {
	private LinkedList<Calle> listacalles;
	
	public CargarDatos() {
		listacalles=new LinkedList<Calle>();
	}

	public void cargarCalles()  {
		String linea;
		String aux[];
		try {
			FileReader lectura = new FileReader("./ficheros/casetasferia2021.csv");
			BufferedReader buffer=new BufferedReader(lectura);
			linea=buffer.readLine();
			linea=buffer.readLine();
			while (linea!=null) {				
				aux=linea.split(",");
				Calle c=new Calle(aux[1], Integer.parseInt(aux[7]));
				listacalles.add(c);
				linea=buffer.readLine();
			}
			buffer.close();
			lectura.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cargarCasetas()  {
		String linea;
		String aux[];
		try {
			FileReader lectura = new FileReader("./ficheros/casetasferia2021.csv");
			BufferedReader buffer=new BufferedReader(lectura);
			linea=buffer.readLine();
			linea=buffer.readLine();

			while (linea!=null) {				
				aux=linea.split(",");
				boolean encontrado=false;
				Iterator<Calle> sig = listacalles.iterator();
				while (sig.hasNext( ) && !encontrado) {
					Calle t1 = sig.next();
					if (t1.getIdcalle()==Integer.parseInt(aux[7])) {
						Caseta caseta=new Caseta(aux[0],Integer.parseInt(aux[2]),
								Integer.parseInt(aux[3]),(aux[4]),aux[5],Integer.parseInt(aux[7]));
						t1.addCaseta(caseta);
						encontrado=true;
					}
				}
				linea=buffer.readLine();
			}
			buffer.close();
			lectura.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void comprobacionYanadir(Calle calle, Caseta caseta) {
		if(!listacalles.contains(calle)){
            this.listacalles.add(calle);
        }
        this.listacalles.get(this.listacalles.indexOf(calle)).addCaseta(caseta);
    }
	public String toStringCasetas() {
		StringBuilder sb=new StringBuilder();
		for (Calle calle : listacalles) {
			sb.append(calle.toStringCaseta()+"\n");
		}
		return sb.toString();
	}
}
