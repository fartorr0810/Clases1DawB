package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Empresa {
	private ArrayList<Producto> listaproductos;
	private String nombreempresa;

	public Empresa(String nombreempresa) {
		super();
		this.nombreempresa = nombreempresa;
		listaproductos=new ArrayList<Producto>();
	}
//	addPeliSerie(entero opc, cadena nombre, cadena tema, entero annoEstreno, entero visualizaciones, enteroaux).
//	Si el parámetro opc es 1 se deberá añadir una película, si la opc es 2 se deberá añadir una serie y sies otro 
//	valor se deberán lanzar una exception. El parámetro aux será el número de episodios si se quiereañadir la serie 
//	y la duración si se quiere añadir una película. Este método no deberá devolver nada.
	public void addPeliSerie(int opc,String nombre, String tema,int annoestreno,int visualizaciones,int aux) throws Exception {
		if (opc==1) {
			Pelicula p=new Pelicula(nombre, tema, annoestreno, visualizaciones, aux);
			if (!Comprobador(p)) {
				listaproductos.add(p);
			}else {
				throw new Exception("Esa peli ya existe");
			}
		}
		else if (opc==2){
			Serie s=new Serie(nombre, tema, annoestreno,visualizaciones, aux);
			if (!Comprobador(s)) {
				listaproductos.add(s);
			}else {
				throw new Exception("Esa serie ya existe");
			}
		}
		else {
			throw new Exception("Opcion invalida, solo 1 para peli y 2 para serie");
		}

	}
	//Este metodo es auxiliar al metodo addPeliSerie para comprobar que no se repitan productos, ya que 
	//los array lo permiten , de esta forma lo evitamos.
	private boolean Comprobador(Producto p) {
		boolean encontrado=false;
		Iterator<Producto> sig = listaproductos.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Producto producto = (Producto) sig.next();
			if (producto.equals(p)) {
				listaproductos.remove(producto);
				encontrado=true;
				}
			}
		return encontrado;
		}
	
//	setDuracion(cadena  nombre, entero duracion) deberá asignar la duración a la cadena que se le pasa
//	pordefecto devolviendo true si se encuentra la película y false en caso contrario.
	public boolean setDuracion(String nombre,int duracion) {
		boolean result=false;
		boolean encontrado=false;
		Iterator<Producto> sig = listaproductos.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Producto producto = (Producto) sig.next();
			if (producto instanceof Pelicula) {
				if (producto.getNombre().equals(nombre)){
					((Pelicula) producto).setDuracion(duracion);
					encontrado=true;
					result=true;
				}
			}
		}
		return result;
	}
//	listarPelisSeries(): este método deberá devolver una cadena con todas las películas y series 
//	ordenados poraño y dentro del mismo año por nombre.
	public String listarPelisSeries() {
		String sb=new String();
		String mensaje;
		Collections.sort(listaproductos);
		for (Producto producto : listaproductos) {
			sb+=""+producto.toString()+"\n";
		}
		mensaje=sb.toString();
		return mensaje;
	}
	//ListarPorNombres(): este método deberá devolver una cadena con todas las películas y 
	//series ordenadorpor nombre de la serie o película.
	public String listarPorNombres() {
		String sb=new String();
		String mensaje;
		Collections.sort(listaproductos,new OrdenarSoloPorNombre());
		for (Producto producto : listaproductos) {
			sb+=""+producto.toString()+"\n";
		}
		mensaje=sb.toString();
		return mensaje;
	}
	//setTema(cadena nombre, cadena tema): este método deberá asignar un nuevo tema al libro o
	//películacuyo nombre se le pasa por argumento. Si el nombre no corresponde con ninguna película o serie
	//o alasignar el tema se lanza una exception se deberá devolver false, en caso contrario true.
	public boolean setTema(String nombre,String tema) throws Exception {
		boolean result=false;
		boolean encontrado=false;
		Iterator<Producto> sig = listaproductos.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Producto producto = (Producto) sig.next();
			if (producto instanceof Pelicula || producto instanceof Serie) {
				if (producto.getNombre().equals(nombre)){
					producto.setTema(Tema.valueOf(tema));;
					encontrado=true;
					result=true;
				}
			}
		}
		if (encontrado=false) {
			throw new Exception("No existe ese producto");
		}
		return result;
	}
	//addEpisodio(cadena nombreSerie, cadena nombreEpisodio, int pos): deberá asignar un nuevo
	//episodio ala serie. Devolverá true si se puede añadir el episodio de la serie y false en caso contrario.
	public boolean addEpisodio(String nombreserie,String nombreepisodio,int pos) {
		boolean result=false;
		boolean encontrado=false;
		Iterator<Producto> sig = listaproductos.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Producto producto = (Producto) sig.next();
			if (producto instanceof Serie) {
				if (producto.getNombre().equals(nombreserie)){
					encontrado=true;
					try {
						((Serie) producto).AddEpisodio(nombreepisodio, pos);
					} catch (Exception e) {
						e.printStackTrace();
					}
					result=true;
				}
			}
		}
		return result;
	}
	public void delEpisodio(String nombreserie, String nombreepisodio) throws Exception {
		boolean encontrado=false;
		Iterator<Producto> sig = listaproductos.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Producto producto = (Producto) sig.next();
			if (producto instanceof Serie) {
				if (producto.getNombre().equals(nombreserie)){
					try {
						((Serie) producto).delEpisodio(nombreepisodio);
						encontrado=true;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		if (encontrado) {
			throw new Exception("Serie no encontrada");
		}
	}
	
	
}
