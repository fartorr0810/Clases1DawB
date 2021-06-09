package v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;




public class MuchosPaises {

	private LinkedList<Country> paises;

	public MuchosPaises() {
		super();
		paises=new LinkedList<Country>();		
	}
	
	public void cargarPaises()  {
		String linea;
		String aux[];
		try {
			FileReader lectura = new FileReader("./ficheros/country.txt");
			BufferedReader buffer=new BufferedReader(lectura);
			linea=buffer.readLine();
			while (linea!=null) {				
				aux=linea.split(",");
				Country cc=new Country(Integer.parseInt(aux[0]),aux[1]);
				paises.add(cc);
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
	public void cargarCiudades()  {
		String linea;
		String aux[];
		try {
			FileReader lectura = new FileReader("./ficheros/city.txt");
			BufferedReader buffer=new BufferedReader(lectura);
			linea=buffer.readLine();
			while (linea!=null) {				
				aux=linea.split(",");
				boolean encontrado=false;
				Iterator<Country> sig = paises.iterator();
				while (sig.hasNext( ) && !encontrado) {
					Country t1 = sig.next();
					if (t1.getCountryid()==Integer.parseInt(aux[2])) {
						City city=new City(Integer.parseInt(aux[0]),aux[1]);
						t1.addCiudades(city);
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
	public void cargarDirecciones() throws IOException  {
		String linea;
		String aux[];
		FileReader lectura=new FileReader("./ficheros/address2.txt");
		BufferedReader buffer=new BufferedReader(lectura);
		linea = buffer.readLine();
		while(linea!=null) {
			aux=linea.split(",");
			if(aux.length>=4) {
				Adress c = new Adress(Integer.parseInt(aux[0]),aux[1]);
				int codigoCiudad = Integer.parseInt(aux[4]);
				String nombreCiudad = aux[3];
				System.out.println(c);
				boolean encontrado=false;
				Iterator<Country> sig = this.paises.iterator();
				while(sig.hasNext() && !encontrado) {
					Country pais = sig.next();
					if(pais.addDirecciones(codigoCiudad, nombreCiudad, c)==true) {
						encontrado=true;
					}
				}
			}
			linea = buffer.readLine();
			System.out.println(linea);
		}
		buffer.close();
		lectura.close();
		}
	public String toStringPaises() {
		String mensaje="";
		for (Country country : paises) {
			mensaje+=country.toString()+"\n";
		}
		return mensaje;
	}

	

}
