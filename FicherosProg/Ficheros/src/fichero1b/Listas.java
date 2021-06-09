package fichero1b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

public class Listas {

	
	private HashSet <Country> listaPaises;
	
	//ESTO ES EL CONSTRUCTOR
	public Listas (String ficheroPaises, String ficheroCiudades, String ficheroDirecciones) throws Exception {
		this.listaPaises=new HashSet<Country>();
		try {
			FileReader f=new FileReader(ficheroPaises);
			BufferedReader buffer=new BufferedReader(f);
			
			String linea = buffer.readLine();
			linea = buffer.readLine();
			
			while (linea!=null) {
				String aux[]=linea.split(",");
				if(aux.length>=2) {
					Country c = new Country(Integer.parseInt(aux[0]), aux[1]);
					this.listaPaises.add(c);
				}
				linea = buffer.readLine();
			}
			buffer.close();
			f.close();
			
			ListaCiudades(ficheroCiudades);
			ListaDirecciones(ficheroDirecciones);
		}
		catch(FileNotFoundException e) {
			throw new Exception ("No se puede abrir el fichero");
		}
	}
	
	public void ListaCiudades (String ficheroCiudades) throws Exception {
		try {
			FileReader f=new FileReader(ficheroCiudades);
			BufferedReader buffer=new BufferedReader(f);
			
			String linea = buffer.readLine();

			while(linea!=null) {
				
				String aux[]=linea.split(",");
				if(aux.length>=3) {
					City c = new City(Integer.parseInt(aux[0]),aux[1]);
					int codigoPais = Integer.parseInt(aux[2]);
					
					boolean encontrado=false;
					Iterator<Country> sig = this.listaPaises.iterator();
					while(sig.hasNext() && !encontrado) {
						Country pais = sig.next();
						if(pais.getCountry_id()==codigoPais) {
							pais.addCiudades(c);
							encontrado=true;
							
						}
					}
				}
				linea = buffer.readLine();
	
			}
			buffer.close();
			f.close();
		}
		catch (FileNotFoundException e){
			throw new Exception ("No se encuentra el fichero" + ficheroCiudades);
		}
	}
	
	
	public void ListaDirecciones (String ficheroDirecciones) throws Exception {
		try {
			FileReader f=new FileReader(ficheroDirecciones);
			BufferedReader buffer=new BufferedReader(f);
			
			String linea = buffer.readLine();
			
			while(linea!=null) {
				String aux[]=linea.split(",");
				if(aux.length>=5) {
					Address a = new Address(Integer.parseInt(aux[0]),aux[1]);
					int codigoCiudad = Integer.parseInt(aux[4]);
					String nombreCiudad = aux[3];
					System.out.println(a);
					
					boolean encontrado=false;
					Iterator<Country> sig = this.listaPaises.iterator();
					while(sig.hasNext() && !encontrado) {
						Country pais = sig.next();
						if(pais.addDirecciones(codigoCiudad, nombreCiudad, a)==true) {
							encontrado=true;
						}
					}
				}
				linea = buffer.readLine();
				System.out.println(linea);
			}
			buffer.close();
			f.close();
		}
		catch (FileNotFoundException e){
			throw new Exception ("No se encuentra el fichero" + ficheroDirecciones);
		}
	}
	
	
	public void listaLocalidades(String fichero) {
		
	}
	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		
		for (Country a : listaPaises) {
			sb.append(a.toString() +"\n");
		}
		return sb.toString();
	}
	
	
}
