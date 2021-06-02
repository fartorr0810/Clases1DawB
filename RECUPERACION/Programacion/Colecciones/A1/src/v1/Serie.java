package v1;

import java.util.Iterator;
import java.util.LinkedList;

public class Serie extends Producto{
	private int maximoepisodios;
	private LinkedList<String> episodios;
	
	public Serie(String nombre, String tema, int anoestreno, int numvisualizaciones,int maximoepisodios) {
		super(nombre, tema, anoestreno, numvisualizaciones);
		episodios=new LinkedList<String>();
		this.maximoepisodios=maximoepisodios;
		
	}


	public void setEpisodios(LinkedList<String> episodios) {
		this.episodios = episodios;
	}

	public int getMaximoepisodios() {
		return maximoepisodios;
	}
	public boolean AddEpisodio(String c,int pos) throws Exception {
		boolean result=false;
		if (this.maximoepisodios <= pos ) {
			throw new Exception("No puedes anadir un episdio fuera del maximoepisodio");
		}
		else if (episodios.size()==pos){
		    episodios.add(pos, c);
		    result=true;
		}
		else if (episodios.indexOf(-1)>pos){
			result=false;
			throw new Exception("No puedes anadir un episodio superior si no existe los anteriores");
		}
		return result;
	}
	public void delEpisodio(String nombreepisodio) throws Exception {
		boolean encontrado=false;
		Iterator<String> sig = episodios.iterator();
		while (sig.hasNext( ) && !encontrado) {
			String caps = sig.next();
			if (caps.equals(nombreepisodio)) {
				int pos=caps.indexOf(nombreepisodio);
				episodios.remove(pos);
			}
		}
		if (encontrado) {
			throw new Exception("Nombre de episodio no encontrado");
		}
	}
	@Override
	public String toString() {
		return super.toString()+"Esta serie tiene :" + maximoepisodios + "maximos episodios=" + episodios + "]";
	}

}
