package examenFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;





public class Listas {

	//He elegido en este caso la coleccion HashSet porque las casetas no se pueden repetir, ya que cada una tiene un id y numero diferente
	private List<Calle> listaCalles;
	

	public Listas (String nombreFichero) throws IOException {
		this.listaCalles= new ArrayList<Calle>();
		try
		{
			FileReader flujoLectura=new FileReader(nombreFichero);
			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
			String linea=filtroLectura.readLine();
			linea=filtroLectura.readLine();
			
				while ( linea!=null){
					String aux[]=linea.split(",");
					if(aux.length>=8) {
						Calle c = new Calle(aux[1],Integer.parseInt(aux[7]));
						Caseta ca = new Caseta(aux[0],Integer.parseInt(aux[2]),Integer.parseInt(aux[3]),aux[4],aux[5],Integer.parseInt(aux[6]));
						c.addCasetas(ca);
						addCalle(c,ca);
					}
					
			linea=filtroLectura.readLine();
		}
			
		//ASI LO IMPRIMIMOS EN JSON
		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		final String resultado =gson.toJson(listaCalles);
			
				
		FileWriter fw = new FileWriter(".\\ContenedorFicheros\\nuevo.json");
				
		PrintWriter pw = new PrintWriter(fw);
				
		pw.println(resultado);

		fw.close();
		pw.close();
		
		filtroLectura.close();
		flujoLectura.close();
		}
		catch(FileNotFoundException e){
		System.out.println("No existe el fichero " + nombreFichero);
		}
		
	}

	
	public void addCalle(Calle calle, Caseta caseta) {
		if(!this.listaCalles.contains(calle)){
			this.listaCalles.add(calle);
		}
		this.listaCalles.get(this.listaCalles.indexOf(calle)).addCasetas(caseta);
	}
	
	
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Calle c : listaCalles) {
			sb.append("IdCalle=" + " " + c.getId_calle()  + " Nombre calle: " + c.toString() + "\n");
		}
		return sb.toString();
	}


	
	public String mostrarCasetasDeUnaCalle(String nombre) {
		StringBuilder sb = new StringBuilder();
		
	
			for (Calle c : listaCalles) {
				if(c.getNombre().equalsIgnoreCase(nombre)) {
					for (Caseta ca : c.getListaCasetas()) {
						sb.append(ca.getTitulo() + "\n");
					}
				}
			}
		
		return sb.toString();
		
	}
	
	public String mostrarNumeroCasetasCalle() {
		StringBuilder sb = new StringBuilder();
		
		for (Calle c : listaCalles) {
			int contador= 0;
			for (Caseta ca : c.getListaCasetas()) {
				contador++;
			}
			sb.append("En la calle " + c.getNombre() + " hay un total de " + contador + " casetas \n");
		}
		return sb.toString();
	}
	
	
	//ESTA ES OTRA FORMA DE CREAR EL JSON CUANDO NOSOTROS QUERAMOS EN VEZ DE QUE SE HAGA AUTOMATICO
	public void crearArchivoJson(String nombreFichero) {
		Gson gson= new Gson();
		String fichero=".\\ContenedorFicheros\\nuevo.json"; //VARIABLE CON RUTA DEL FICHERO
				
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String todo= prettyGson.toJson(listaCalles);//AQUI INTRODUCIMOS LA LISTA
		
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


	public boolean  eliminarCasetass(String nombreCalle, int numeroCaseta) throws NoExisteCalleCasetaException {
		boolean existe=false;
		for (Calle c : listaCalles) {
			if(c.getNombre().equalsIgnoreCase(nombreCalle)) {
				for (Caseta m : c.getListaCasetas()) {
					if (m.getNumero()==(numeroCaseta)) {
						existe=true;
                        listaCalles.remove(m.getNumero());
                    }		
				}
			}
			
	
		}
		if(existe==false) {
			throw new NoExisteCalleCasetaException();
		}
		
		
		return existe;
		
	}
	
}
