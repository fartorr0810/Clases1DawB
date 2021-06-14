import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class LecturaEscrituraJSONdificil {

	public static void main(String[] args) {
		
		//No esque sea mas dificil, era para cambiar el nombre
		//en este caso no es un array de objetos, es un elemento que tiene un array de objetos
		
		//para esto usaremos la clase empresa

		Empresa emp= new Empresa(null,null);
		emp=leerJSON("./Empresa.json",emp);
		//System.out.println(emp.toString());
		
		escribirJSON(emp);
	}
	
	
	public static void escribirJSON(Empresa emp) {
		
		Gson gson= new Gson();
		String fichero="./respuestaEmpresa.json";
				
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String todo= prettyGson.toJson(emp);
		
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
	
	
	
	
	
	public static Empresa leerJSON(String fichero,Empresa emp) {
		
		String linea;
		
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
		
		emp= gson.fromJson(resul.toString(), Empresa.class); 
		return emp;
	}

}
