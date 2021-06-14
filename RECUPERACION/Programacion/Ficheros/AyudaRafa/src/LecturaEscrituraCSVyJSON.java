import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;





public class LecturaEscrituraCSVyJSON {

	public static void main(String[] args) {
		
		//------------------------Para CSV---------------------------
		HashSet<Clientes> clientes = new HashSet<Clientes>();//inicializamos donde vamos a guardar los datos
		//En este caso usamos un HashSet porque en el csv/txt se repiten los datos
		String fichero=("./Rafa.txt");
		clientes=leerFicheroCSV(fichero,clientes);
		//System.out.println(clientes);
		
		escribeFicheroCSV(clientes);
		//------------------------Para JSON---------------------------
		
		//1º ejemplo un json que tiene un array de empleados
		//hay que leer los datos a un array, sea dentro o fuera de una clase
		//hay que tener la libreria de gson
		ArrayList<Empleado> empleados=new ArrayList<Empleado>();
		empleados=leerJSON("./empleados.json",empleados);
		System.out.println(empleados);
		
		escribirJSON(empleados);
	}
	
	public static void escribirJSON(ArrayList<Empleado> datos) {
		
		Gson gson= new Gson();
		String fichero="./respuestaEmpleados.json";
				
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String todo= prettyGson.toJson(datos);
		
		try {
			
			FileWriter write = new FileWriter(fichero);
			PrintWriter pw= new PrintWriter(write);
			pw.print(todo);
			
			
			
			write.close();
			pw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("-JSON escrito con exito-");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<Empleado> leerJSON(String fichero,ArrayList<Empleado> empleados) {
		
		String linea;
		ArrayList<Empleado> respuesta=empleados;
		StringBuilder resul = new StringBuilder();
		try
		{
			FileReader flujoLectura=new FileReader(fichero);
			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
			linea=filtroLectura.readLine();
			while ( linea!=null)
			{
				resul.append(linea);
				linea=filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
			}
		catch(FileNotFoundException e){
		System.out.println("No existe el fichero ");
		}
		catch(IOException e){
		System.out.println( e.getMessage());
		}
		
		Gson gson = new Gson();
		
		respuesta = gson.fromJson(resul.toString(), new TypeToken<ArrayList<Empleado>>() {}.getType()); 
		return respuesta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static HashSet<Clientes>  leerFicheroCSV(String fichero, HashSet<Clientes> clientes) {
		
		String linea;
		HashSet<Clientes> respuesta = clientes;//Con usar clientes vale pero para que me quede claro
		
		try {
			FileReader flujoLectura = new FileReader(fichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			
			linea=filtroLectura.readLine();//leemos la primera linea
			
			
			
			while (linea!=null) {//Si no es null la primera seguimos leyendo
			
				String lista[] = linea.split(",");//Separamos los valores por coma
				Clientes cli= new Clientes(lista[0],lista[1],Integer.parseInt(lista[2]),Double.parseDouble(lista[3]));
				//asignamos al cliente los valores de cada una de las filas
				respuesta.add(cli);//añadimos al hashSet cada cliente que creamos
				linea=filtroLectura.readLine();//Y leemos otra para tener una linea nueva cada vez que damos vueltas al bucle
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return respuesta;
	}
	
	public static void escribeFicheroCSV(HashSet<Clientes> datos) {
		
			
				String fichero="./respuesta.csv";
				
				  try { 
					  FileWriter flujoEscritura = new FileWriter(fichero,true);
					  PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
				  
				  for (Clientes c : datos) {
					  filtroEscritura.println(c);
				}
				  
				  
				  
				  filtroEscritura.close(); 
				  flujoEscritura.close(); 
				  } catch (Exception e) {
				  System.out.println(e.getMessage()); }
				  
				  System.out.println("-Fichero CSV escrito con exito-");
				 
	}
	

}
