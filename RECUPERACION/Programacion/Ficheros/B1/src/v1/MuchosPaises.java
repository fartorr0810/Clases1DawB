package v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MuchosPaises {

	private List<Datos> datosFinales;

	public MuchosPaises() {
		datosFinales = new ArrayList<Datos>();
		try {
			cargarDatosPais();
			cargarDatosCity();
			cargarDatosAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Datos c : datosFinales) {
			sb.append(c.toString() + "\n");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datosFinales == null) ? 0 : datosFinales.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MuchosPaises))
			return false;
		MuchosPaises other = (MuchosPaises) obj;
		if (datosFinales == null) {
			if (other.datosFinales != null)
				return false;
		} else if (!datosFinales.equals(other.datosFinales))
			return false;
		return true;
	}


	public void cargarDatosPais() throws Exception {
		Datos c = null;
		try (BufferedReader filtroLectura = new BufferedReader(new FileReader("./ficheros/country.txt"))) {
			String linea = "";
			while ((linea = filtroLectura.readLine()) != null) {
				String values[] = linea.split(",");
				if (values.length <= 3) {
					c = new Datos(values[0], values[1]);
					this.datosFinales.add(c);
				}
			}
		}
	}

	public void cargarDatosCity() throws FileNotFoundException, IOException {
		String idCountry = "";
		try (BufferedReader filtroLectura = new BufferedReader(new FileReader("./ficheros/city.txt"))) {
			String linea = "";
			while ((linea = filtroLectura.readLine()) != null) {
				String values[] = linea.split(",");
				if (values.length <= 4) {
					idCountry = values[2];

					try {
						Datos cla = this.datosFinales
								.get(this.datosFinales.indexOf(new Datos(idCountry)));
						int num = cla.getNumCiudades();
						num++;
						cla.setNumCiudades(num);
						cla.setId_city(values[0]);
					} catch (Exception e) {
						System.out.println("");
					}
				}
			}
		}
	}

	public void cargarDatosAddress() throws FileNotFoundException, IOException {
		try (BufferedReader filtroLectura = new BufferedReader(new FileReader("./ficheros/address2.txt"))) {
			String linea = "";
			while ((linea = filtroLectura.readLine()) != null) {
				String values[] = linea.split(",");
				if (values.length <= 6 && values.length>2) {

					boolean resul = false;
					Iterator<Datos> c = this.datosFinales.iterator();
					while (c.hasNext() && !resul) {
						Datos s = c.next();
						if (values[4].equals(s.getId_city())) {
							int num = s.getNumDirecciones();
							num++;
							s.setNumDirecciones(num);
							resul = true;
						}
					}
				}
			}
		}
	}

	public void imprimeDatos() throws IOException {
		FileWriter fw = new FileWriter("./ficheros/resul.json");
		try (BufferedWriter filtroEscritura = new BufferedWriter(fw)) {
			Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
			String representacionBonita = prettyGson.toJson(datosFinales);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(representacionBonita);
			pw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}