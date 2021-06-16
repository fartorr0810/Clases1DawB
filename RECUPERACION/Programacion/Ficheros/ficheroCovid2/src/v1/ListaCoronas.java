package v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class ListaCoronas {

	private ArrayList<Corona>coronas;
	
	public ListaCoronas() {
		this.coronas = new ArrayList<Corona>();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Corona corona : coronas) {
			sb.append(corona+"\n");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coronas == null) ? 0 : coronas.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ListaCoronas))
			return false;
		ListaCoronas other = (ListaCoronas) obj;
		if (coronas == null) {
			if (other.coronas != null)
				return false;
		} else if (!coronas.equals(other.coronas))
			return false;
		return true;
	}
	public List<Corona> getCoronas() {
		return coronas;
	}

	public void cargarDatos() {
		String linea = "";
		StringBuilder resul = new StringBuilder();
		try (BufferedReader buffer = new BufferedReader(new FileReader("./ficheros/muertos_por_coronavirus_e.json"))){
			linea = buffer.readLine();
				while(linea!=null) {
					resul.append(linea);
					linea = buffer.readLine();
				}	
		} catch (IOException e) {
			e.printStackTrace();
		}	
		Gson gson = new Gson();
		ClaseContenedor l = gson.fromJson(resul.toString(), ClaseContenedor.class);
		for(ClaseMetricas m: l.getDatos().getMetricas()) {
			for(Dato d: m.getDatos()) {
				
			}
		}
	}

}
