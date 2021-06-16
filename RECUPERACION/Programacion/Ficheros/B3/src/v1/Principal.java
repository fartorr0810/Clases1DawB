package v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Principal {

	public static void main(String[] args) {
		
		
		leerFichero("./ficheros/casos_diagnosticados_de_c.json",1);
		leerFichero("./ficheros/evolucion_de_casos_curado.json",2);
		leerFichero("./ficheros/muertos_por_coronavirus_e.json",3);
		
		System.out.println(contadorCorona.ordenarContagios());
		
		System.out.println(contadorCorona.mejorDia());
		System.out.println(contadorCorona.mejorDiaAPartirDe(10, "octubre", 2020));
		System.out.println(contadorCorona.peorDiaAPartirDe(02, "enero", 2021));
		System.out.println(contadorCorona.peorDia());
		System.out.println(contadorCorona.informacionDia(02, "mayo", 2020));
		System.out.println(contadorCorona.mediaInfo());
		
		
		

	}
	
	public static ContadorCorona contadorCorona = new ContadorCorona();
	
	public static void leerFichero(String fichero, int tipo) {
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
		
		LeerJson l = gson.fromJson(resul.toString(), LeerJson.class);
		//ContadorCorona contadorCorona = new ContadorCorona();
		int valorAnterior=0;
		
		
		for (ClaseMetrica metrica : l.getDatos().getMetrica()) {
			for (Informacion paciente : metrica.getDatos()) {
				if(tipo==1) {
					contadorCorona.addCoronaContagios(paciente, valorAnterior);
					valorAnterior=paciente.getValor();
				}
				else if(tipo==2) {
					contadorCorona.addCoronaCurados(paciente, valorAnterior);
					valorAnterior=paciente.getValor();
				}
				else if(tipo==3) {
					contadorCorona.addCoronaFallecidos(paciente, valorAnterior);
					valorAnterior=paciente.getValor();
				}
			}
			}
				
		}

}
