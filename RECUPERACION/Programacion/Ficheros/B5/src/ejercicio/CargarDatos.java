package ejercicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;







public class CargarDatos {
	private LinkedList<Calle> listacalles;
	
	public CargarDatos() throws IOException {
		listacalles=new LinkedList<Calle>();
		cargarCalles();
		cargarCasetas();
		//ASI LO IMPRIMIMOS EN JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String resultado =gson.toJson(listacalles);	
		FileWriter fw = new FileWriter("./ficheros/nuevo.json");
		PrintWriter pw = new PrintWriter(fw);
		pw.println(resultado);
		fw.close();
		pw.close();
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
				if (!listacalles.contains(c)) {
					listacalles.add(c);

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
					if (t1.getIdcalle()==Integer.parseInt(aux[7])&& t1!=null) {
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
	//1. Mostrar todas las casetas existentes en una calle
	public String MostrarCasetasDeUnaCalle (String nombrecalle) {
		boolean encontrado=false;
		String mensaje="";
		Iterator<Calle> sig = listacalles.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Calle t1 = sig.next();
			if (t1.getNombrecalle().equals(nombrecalle)) {
				encontrado=true;
				mensaje=t1.toStringCaseta();
			}
		}
		return mensaje;
	}
	//2. Mostrar para cada una de las calles del recinto ferial el número de casetas que hay en lacalle
	public String MostrarNumCasetasCalle() {
		StringBuilder sb=new StringBuilder();
		for (Calle calle : listacalles) {
			sb.append(calle.numCasetas()+"\n");
		}
		return sb.toString();
	}
//		3. Eliminar una caseta.(Extra)Si se elimina una caseta se considerará que el resto de lascasetas 
//		posteriores se desplazan, es decir si borro la caseta 5 de una calle, todas las casetas apartir del
//		número 5 deberán descender un número si la caseta borrada tiene un módulo, dossi tiene dos módulos,
//		y así sucesivamente. Se pedirá el nombre de la calle y el número. Si noexiste se deberá mostrar un
//		mensaje de error
	public boolean borrarCaseta(String nombrecalle,int numero) {
		boolean encontrado=false;
		boolean result=false;
		String mensaje="";
		Iterator<Calle> sig = listacalles.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Calle t1 = sig.next();
			if (t1.getNombrecalle().equals(nombrecalle)) {
				encontrado=true;
				t1.Delete(numero);
				result=true;
			}
		}
		//Ordenar lista de casetas por numero, dentro de la calle,
	return result;
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
	public void crearArchivoJson(String nombreFichero) {
		Gson gson= new Gson();
		String fichero="./ficheros/nuevo.json"; //VARIABLE CON RUTA DEL FICHERO
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String todo= prettyGson.toJson(listacalles);//AQUI INTRODUCIMOS LA LISTA
		try {
			FileWriter write = new FileWriter(fichero); //AQUI LA VARIABLE DEL FICHERO
			PrintWriter pw= new PrintWriter(write);
			pw.print(todo);
			write.close();
			pw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-JSON escrito con exito-");
		
	}
}
