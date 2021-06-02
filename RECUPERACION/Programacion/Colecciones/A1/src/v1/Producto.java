package v1;

import java.time.LocalDate;

public abstract class Producto implements Comparable<Producto>,VisualizacionPorAno {
	private String nombre;
	private Tema tema;
	private int anoestreno;
	private int numvisualizaciones;
	private static int menorano=999999;


	public Producto(String nombre, String tema, int anoestreno, int numvisualizaciones) {
		super();
		this.nombre = nombre;
		this.tema = Tema.valueOf(tema);
		this.anoestreno = anoestreno;
		this.numvisualizaciones = numvisualizaciones;
		if (this.anoestreno<menorano) {
			menorano=anoestreno;
		}
	}	
	
	private static int getMenosAno() {		
		return menorano;
	}
	
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public int getAnoestreno() {
		return anoestreno;
	}
	public void setAnoestreno(int anoestreno) {
		this.anoestreno = anoestreno;
	}
	public int getNumvisualizaciones() {
		return numvisualizaciones;
	}
	public void setNumvisualizaciones(int numvisualizaciones) {
		this.numvisualizaciones = numvisualizaciones;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
//	Ya ordena por agno, como ordeno por nombre?
	@Override
	public int compareTo(Producto o) {
		int result=0;
		if (this.anoestreno<o.anoestreno) {
			result=-1;
		}else if (this.anoestreno>o.anoestreno) {
			result=1;
		}
		else if (this.anoestreno==o.anoestreno) {
			//Como ambos agnos son iguales, el resultado se ordena por nombre llamando al compareto
			//con el nombre de la clase con la otra pelicula.
			result=this.nombre.compareTo(o.nombre);
		}
		return result;
	}
//	Tanto las series como las películas deben implementar la interfaz visualizacionPoranno que
//	deberá tener unmétodo llamado getMediaVisualizacion que devolverá un número real que será el número d
//	e visualizaciones queha tenido de cada año, teniendo en cuenta que el atributo número de visualizaciones 
//	es el número devisualizaciones de todos los años desde que se estrenó y que lo que se pide es la media.
	
	@Override
	public float getMediaVisualizaciones() {
		float media=this.getNumvisualizaciones()/(LocalDate.now().getYear()-this.getAnoestreno());
		return media;
	}
	
	@Override
	public String toString() {
		return "Producto de nombre=" + nombre + "su tema es: " + tema + "su anoestreno es " + anoestreno + " posee numvisualizaciones: "
				+ numvisualizaciones;
	}

	
}
