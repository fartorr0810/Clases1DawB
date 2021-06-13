package v1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CargarDatos {
	
	private ArrayList<Provincia> provincias;
	
	public CargarDatos() {
		provincias=new ArrayList<Provincia>();
	}
	
	public void addProvincia(Provincia pro,Localidad localidad,Centro centro,Curso curso,Materia materia) {
		if (!provincias.contains(pro)) {
			provincias.add(pro);
		}else {
			this.provincias.get(this.provincias.indexOf(pro)).addLocalidad(localidad, centro, curso, materia);		}
	}
	


}