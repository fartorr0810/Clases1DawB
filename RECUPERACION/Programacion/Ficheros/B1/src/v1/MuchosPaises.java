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
						t1.addciudad(city);
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
	public void cargarDirecciones()  {
		String linea;
		String aux[];
		try {
			FileReader lectura = new FileReader("./ficheros/address2.txt");
			BufferedReader buffer=new BufferedReader(lectura);
			linea=buffer.readLine();
			while (linea!=null) {				
				aux=linea.split(",");
				boolean encontrado=false;
				Iterator<Country> sig = paises.iterator();
				while (sig.hasNext( ) && !encontrado) {
				Country c1 = sig.next();
				if (aux.length>4) {
					if(c1.contieneCiudad(Integer.parseInt(aux[4]))) {
						int codciudad=Integer.parseInt(aux[4]);
						Adress c=new Adress(Integer.parseInt(aux[0]), aux[1]);
							c1.addDireccionCiudad(codciudad,c);
							encontrado=true;
						}
					}
				}
				linea=buffer.readLine();
			}
			buffer.close();
			lectura.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		 }
		}
	public String toStringPaises() {
		String mensaje="";
		for (Country country : paises) {
			mensaje+=country.toString()+"\n";
		}
		return mensaje;
	}
	public String mostrarPaisConSuCiudadesYcalles() {
		String result="";
		for (Country country : paises) {
			result+=country.toString();
			country.toStringCiudades();
			
		}
	}
	

}
