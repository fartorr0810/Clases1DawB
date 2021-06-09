package com.jacaranda.tamano;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad(String fichero) {
		this.lista = new ArrayList<Comunidad>();

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
	
	
//	HashMap<Integer,ArrayList<Comunidad>>
//	push clave y valor
//	get clave y valor
	
	
	public String mostrarDatosComunidad(int anno) {
		StringBuilder sb = new StringBuilder();
		
		for (Comunidad c : lista) {
			for (Municipio m : c.getListMunicipio()) {
				for (Datos d : m.getDatos()) {
					if(d.getAno()==anno) {
						sb.append("\n"+c.getNombre()+"\n"+m.getDescrip()+"\n"+d.getDato());
					}
				}
			}
		}
		return sb.toString();
	}

	public String mostrarDatosComunidadYAnno(String comunidad, int anno) {
		StringBuilder sb = new StringBuilder();
		
		for (Comunidad c : lista) {
			if(c.getNombre().equalsIgnoreCase(comunidad)) {
				for (Municipio m : c.getListMunicipio()) {
					for (Datos d : m.getDatos()) {
						if(d.getAno()==anno) {
							sb.append("\n"+c.getNombre()+"\n"+m.getDescrip()+"\n"+d.getDato());
						}
					}
				}
			}	
		}
		
		
		return sb.toString();
	}
	
	
	public void addDato(String descrip, String comunidad, int anno, int dato) throws ComunidadDescripcionException {
		
		/*Comunidad busca= new Comunidad(comunidad);
        Datos da=new Datos(anno,dato);
        boolean result=false;
        for (Comunidad c : lista) {
            if (c.equals(busca)) {

                for (Municipio m : c.getListMunicipio()) {
                    if (m.getDescrip().toLowerCase().equals(descrip.toLowerCase())) {
                        m.addDatos(new Datos(anno, dato));
                        result=true;
                    }
                }
            }

        }*/
		
		
		boolean existe=false;
		for (Comunidad c : lista) {
			if(c.getNombre().equalsIgnoreCase(comunidad)) {
				for (Municipio m : c.getListMunicipio()) {
					if (m.getDescrip().toLowerCase().equals(descrip.toLowerCase())) {
						existe=true;
                        m.addDatos(new Datos(anno, dato));
                    }
					
					/*if(m.getDescrip().equalsIgnoreCase(descrip)){						
						
						for (Datos d : m.getDatos()) {
							if(d.getAno()==anno) {
								d.setDato(dato);
							}
							else {
								Datos dat = new Datos(anno, dato);
								m.getDatos().add(dat);	
							}
						}
					}*/					
				}
			}
			
	
		}
		if(existe==false) {
			throw new ComunidadDescripcionException();
		}
	}


	public String mostrarSumaTotal(String comunidad, int anno) {
		StringBuilder sb = new StringBuilder();
		int suma= 0;
		int valorTotal = 0;
		for (Comunidad c : lista) {
			if(c.getNombre().equalsIgnoreCase(comunidad)) {
				for (Municipio m : c.getListMunicipio()) {
					if(m.getDescrip().equalsIgnoreCase("Total")) {
						for (Datos d : m.getDatos()) {
							if(d.getAno()==anno) {
								valorTotal=d.getDato();
							}
						}
					}
					else {
						for (Datos e : m.getDatos()) {
							if(e.getAno()==anno) {
								suma+=e.getDato();
							}
						}
					}
				
				}
			}
		
		
	}
		if(valorTotal==suma) {
			sb.append("Los datos con correctos, total es " + valorTotal + "\n");
		}
		else {
			sb.append("Los datos no son correctos, devuelve " + valorTotal + ", pero debe ser " + suma + "\n");
		}
		return sb.toString();
	
	}

	

	public void crearArchivoJson(String nombreFichero) {
		Gson gson= new Gson();
		String fichero=".\\ContenedorFicheros\\"+nombreFichero+".json"; //VARIABLE CON RUTA DEL FICHERO
				
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String todo= prettyGson.toJson(lista);//AQUI INTRODUCIMOS LA LISTA
		
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
	
	/*public void crearNuevoFicheroJson(String fichero) throws IOException {

        try {
            FileWriter flujoEscritura = new FileWriter(fichero+".json");

            PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);

            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            final String representacionBonita = prettyGson.toJson(lista);

            filtroEscritura.println(representacionBonita);

            filtroEscritura.close();
            flujoEscritura.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }*/

	
	
}
