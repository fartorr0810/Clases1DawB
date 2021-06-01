package v1;

import java.util.LinkedList;

public class Serie extends Producto{
	private int maximoepisodios;
	private LinkedList<Capitulo> episodios;
	
	public Serie(String nombre, String tema, int anoestreno, int numvisualizaciones,int maximoepisodios) {
		super(nombre, tema, anoestreno, numvisualizaciones);
		episodios=new LinkedList<Capitulo>();
		this.maximoepisodios=maximoepisodios;
	}

	public LinkedList<Capitulo> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(LinkedList<Capitulo> episodios) {
		this.episodios = episodios;
	}

	public int getMaximoepisodios() {
		return maximoepisodios;
	}

	@Override
	public String toString() {
		return super.toString()+"Esta serie tiene :" + maximoepisodios + "maximos episodios=" + episodios + "]";
	}

}
