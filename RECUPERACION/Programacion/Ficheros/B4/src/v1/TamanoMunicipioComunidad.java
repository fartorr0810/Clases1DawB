package v1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		lista = new ArrayList<Comunidad>();
	}	
	public void LeerJson(String fichero) {
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
			
			
			lista =gson.fromJson(resul.toString(), new TypeToken<ArrayList<Comunidad>>(){}.getType()); 
			
			
		}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Comunidad c : lista) {
			sb.append(c + "\n");
		}
		return sb.toString();
	}
	public String mostrarDatosComunidad(int anno) {
		StringBuilder sb = new StringBuilder();
		for (Comunidad comunidad : lista) {
			
			sb.append(comunidad.toString());
		}
		return sb.toString();
	}
	}
	

