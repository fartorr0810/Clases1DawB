package v3;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Empresa {
	private String nombre;
	private HashSet<Eolico> listaeolicos;
	private HashSet<Solar> listasolar;

	public Empresa(String nombre) {
		listaeolicos=new HashSet<Eolico>();
		listasolar=new HashSet<Solar>();
		this.nombre = nombre;
	}
	public boolean addGeneradorSolar(LocalDate fechainicio, String localidad, float potencia,int numpaneles,int m2,String generador) {
		boolean result=false;
		Solar s=new Solar(fechainicio, localidad, potencia, numpaneles, m2, generador);
		if (listasolar.contains(s)) {
			result=false;
		} else {
			listasolar.add(s);
		}
		return result;
	}
	public boolean addGeneradorEolico(LocalDate fechainicio, String localidad, float potencia,int numaspas) {
		boolean result=false;
		Eolico e=new Eolico(fechainicio,localidad,potencia,numaspas);
		if (listaeolicos.contains(e)) {
			result=false;
		} else {
			listaeolicos.add(e);
		}
		return result;
	}
	//3.Mostrar generadores de la empresa ordenados por lafecha de inicio de funcionamiento.
	public String ordenarGeneradores() {
		String mensaje="";
		LinkedList<Generador> lista=new LinkedList<Generador>();
		lista.addAll(listaeolicos);
		lista.addAll(listasolar);
		Collections.sort(lista);
		for (Generador g1 : lista) {
			mensaje+=""+g1.toString()+"\n";
		}
		return mensaje.toString();		
	}
	public String ordenarGeneradoresPorFechayLocalidad() {
		String mensaje="";
		LinkedList<Generador> lista=new LinkedList<Generador>();
		lista.addAll(listaeolicos);
		lista.addAll(listasolar);
		Collections.sort(lista,new OrdenarPorFechayLocalidad());
		for (Generador g1 : lista) {
			mensaje+=""+g1.toString()+"\n";
		}
		return mensaje.toString();		
	}
	public String mostrargeneradoreseolicos() {
		String mensaje="";
		for (Generador g1 : listaeolicos) {
			mensaje+=""+g1.toString()+"\n";
		}
		return mensaje;
	}
//	6.Borrar generador (se deberán mostrar los generadores por el orden que quieras), solicitarel 
//	código   y   eliminar   el   generador.   Si   no   existe   el   generador   se   deberá   mostrar  
//	elcorrespondiente mensaje de error.
	public boolean BorrarGenerador(int codigo) throws Exception {
		boolean result=false;
		LinkedList<Generador> lista=new LinkedList<Generador>();
		lista.addAll(listaeolicos);
		lista.addAll(listasolar);
		boolean encontrado=false;
		Iterator<Generador> sig = lista.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Generador g1 = (Eolico) sig.next();
			if (g1.getCodigo()==codigo && g1 instanceof Eolico) {
				lista.remove(g1);
				encontrado=true;
				}
			}
		if (encontrado==false) {
			throw new Exception("No existe ese generador");
		}
		return encontrado;
		}
	//Mostrar total de energía suministrada por la empresa
	public float MostrarPotencia() {
		float result=0;
		for (Eolico eolico : listaeolicos) {
			result+=eolico.getPotencia();
		}
		for (Solar solar : listasolar) {
			result+=solar.getPotencia();
		}
		return result;
	}
//	8.¿Existe generador en Localidad? Deberá solicitar una localidad y mostrar si existe
//	o no ungenerador en esa localidad.
	public boolean ExisteGenerador(String localidad) {
		boolean result=false;
		LinkedList<Generador> lista=new LinkedList<Generador>();
		lista.addAll(listaeolicos);
		lista.addAll(listasolar);
		boolean encontrado=false;
		Iterator<Generador> sig = lista.iterator();
		while (sig.hasNext( ) && !encontrado) {
			Generador g1 = (Generador) sig.next();
			if (g1.getLocalidad().equals(localidad)) {
				encontrado=true;
				}
			}
		return encontrado;
	}
}