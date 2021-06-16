package v1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ContadorCorona {
	private ArrayList<Corona>listacoronas;
	
	public ContadorCorona() {
		listacoronas = new ArrayList<Corona>();
	}
	
	public void addCoronaContagios(Informacion paciente, int valorAnterior) {
		Corona corona = new Corona();
		corona.setFecha(paciente.getFecha());
		corona.setContagiados(paciente.getValor()-valorAnterior);
		if(!this.listacoronas.contains(corona)) {
			listacoronas.add(corona);
		}
	}
	
	public void addCoronaCurados(Informacion caso, int numanterior) {
		
		Corona c = new Corona();
		c.setFecha(caso.getFecha());
		if(!listacoronas.contains(c)) {
			listacoronas.add(c);
			c.setCurados(caso.getValor()-numanterior);
		}
		else {
			int pos= listacoronas.indexOf(c);
			listacoronas.get(pos).setCurados(caso.getValor()-numanterior);
		}
		
	}
	
	public void addCoronaFallecidos(Informacion caso, int numanterior) {
		
		Corona corona = new Corona();
		corona.setFecha(caso.getFecha());
		if(!listacoronas.contains(corona)) {
			listacoronas.add(corona);
			corona.setFallecidos(caso.getValor()-numanterior);
		}
		else {
			int pos= listacoronas.indexOf(corona);
			listacoronas.get(pos).setFallecidos(caso.getValor()-numanterior);
		}
	}

	

	public String ordenarContagios() {
		Collections.sort(listacoronas, new OrdenarContagiados());
		StringBuilder sb = new StringBuilder();
		for(Corona c : listacoronas) {
			sb.append(c.toString());
		}
		return sb.toString();
	}
	
	
//	Mejor día: Esta opción mostrará el día en el que se produjo menos contagios, el día en el que
//	se produjo menos muertes y el día en que se produjeron más altas
	public String mejorDia() {
		StringBuilder sb = new StringBuilder();
		Collections.sort(listacoronas, new OrdenarContagiados());
		sb.append("Menos contagios: " + listacoronas.get(0).getFecha() + " con " + listacoronas.get(0).getContagiados() + " contagios \n");   
		Collections.sort(listacoronas, new OrdenarCurados());
		sb.append("Mas curados es: " + listacoronas.get(0).getFecha() + " con " + listacoronas.get(listacoronas.size()-1).getCurados() + " curados \n");
		Collections.sort(listacoronas, new OrdenarFallecidos());
		sb.append("Menos fallecidos es: " + listacoronas.get(0).getFecha() + " con " + listacoronas.get(0).getFallecidos() + " fallecidos \n");
	
		return sb.toString();
	
	}
	
//	Mejor día a partir de: se pedirá un día y un mes (un valor numérico para el día y un valor
//			String para el mes) y se mostrarán los mismos datos que en la opción anterior pero a partir
//			del día introducido.
	
	//Aqui convierto la fecha que me pasan
	public LocalDate convertirFechatoLocalDate(int dia, String mes, int year) {
		String[] meses={"", "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre"
                , "octubre", "noviembre", "diciembre"};
		int mes1=0;
		for(int i =0; i<meses.length;i++) {
			if(meses[i].equalsIgnoreCase(mes)) {
				mes1=i;
			}
		}
		

		LocalDate fecha = LocalDate.of(year, mes1, dia);
		return fecha;
	}
	
	//Este metodo ordena la lista a partir de la fecha y coge los valores que le interesa
	public String mejorDiaAPartirDe(int dia, String mes, int year) {
		ArrayList<Corona> fechasNuevas = new ArrayList<Corona>();
		Collections.sort(listacoronas);
		for(Corona corona:listacoronas) {
			if(corona.getFecha().isAfter(convertirFechatoLocalDate(dia,mes,year))) {
				fechasNuevas.add(corona);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(fechasNuevas, new OrdenarContagiados());
		sb.append("El dia con menos contagios es: " + fechasNuevas.get(0).getFecha() + " con " + fechasNuevas.get(0).getContagiados() + " contagios \n");   
		
		Collections.sort(fechasNuevas, new OrdenarCurados());
		sb.append("El dia con mas curados es: " + fechasNuevas.get(0).getFecha() + " con " + fechasNuevas.get(fechasNuevas.size()-1).getCurados() + " curados \n");
	
		Collections.sort(fechasNuevas, new OrdenarFallecidos());
		sb.append("El dia con menos fallecidos es: " + fechasNuevas.get(0).getFecha() + " con " + fechasNuevas.get(0).getFallecidos() + " fallecidos \n");
		
		return sb.toString();
	}
	
public String peorDia() {
	StringBuilder sb = new StringBuilder();
	Collections.sort(listacoronas, new OrdenarContagiados());
	sb.append("El dia con mas contagios es: " + listacoronas.get(listacoronas.size()-1).getFecha() + " con " + listacoronas.get(listacoronas.size()-1).getContagiados() + " contagios \n");   
	
	Collections.sort(listacoronas, new OrdenarCurados());
	sb.append("El dia con menos curados es: " + listacoronas.get(listacoronas.size()-1).getFecha() + " con " + listacoronas.get(0).getCurados() + " curados \n");

	Collections.sort(listacoronas, new OrdenarFallecidos());
	sb.append("El dia con mas fallecidos es: " + listacoronas.get(listacoronas.size()-1).getFecha() + " con " + listacoronas.get(listacoronas.size()-1).getFallecidos() + " fallecidos \n");

	return sb.toString();
}


public String peorDiaAPartirDe(int dia, String mes, int ano) {
	ArrayList<Corona> fechasNuevas = new ArrayList<Corona>();
	Collections.sort(listacoronas);
	for(Corona corona:listacoronas) {
		if(corona.getFecha().isAfter(convertirFechatoLocalDate(dia,mes,ano))) {
			fechasNuevas.add(corona);
		}
	}
	
	StringBuilder sb = new StringBuilder();
	Collections.sort(fechasNuevas, new OrdenarContagiados());
	sb.append("El dia con mas contagios es: " + fechasNuevas.get(fechasNuevas.size()-1).getFecha() + " con " + fechasNuevas.get(fechasNuevas.size()-1).getContagiados() + " contagios \n");   
	
	Collections.sort(fechasNuevas, new OrdenarCurados());
	sb.append("El dia con menos curados es: " + fechasNuevas.get(fechasNuevas.size()-1).getFecha() + " con " + fechasNuevas.get(0).getCurados() + " curados \n");

	Collections.sort(fechasNuevas, new OrdenarFallecidos());
	sb.append("El dia con mas fallecidos es: " + fechasNuevas.get(fechasNuevas.size()-1).getFecha() + " con " + fechasNuevas.get(fechasNuevas.size()-1).getFallecidos() + " fallecidos \n");
	
	return sb.toString();
}



//Número de contagios, número de muertes y número de curados en un día (se pedirá día y
//mes).

	public String informacionDia(int dia, String mes, int year) {
		Corona coronaCopia= new Corona(convertirFechatoLocalDate(dia, mes, year),0,0,0);
		StringBuilder sb = new StringBuilder();
		int aux;
		if(listacoronas.contains(coronaCopia)) {
			aux=listacoronas.indexOf(coronaCopia);
			sb.append("Ese dia hubo " + listacoronas.get(aux).getContagiados() + " contagios \n");
			sb.append("Ese dia hubo " + listacoronas.get(aux).getCurados() + " curados \n");
			sb.append("Ese dia hubo " + listacoronas.get(aux).getFallecidos() + " fallecidos \n");
			
		}
		else {
			sb.append("Ese dia no se registraron datos");
		}
		return sb.toString();
	}
	
	public String mediaInfo() {
		int totalContagios=0;
		int totalCurados=0;
		int totalFallecidos=0;
		
		StringBuilder sb = new StringBuilder();
		
		for(Corona corona: listacoronas) {
			totalContagios+=corona.getContagiados();
			totalCurados+=corona.getCurados();
			totalFallecidos+=corona.getFallecidos();
		}
		sb.append("Media contagios " + (totalContagios/listacoronas.size())+"\n");
		sb.append("Media curados " + (totalCurados/listacoronas.size())+"\n");
		sb.append("Media fallecidos " + (totalFallecidos/listacoronas.size())+"\n");
		
		return sb.toString();
	}






	@Override
	public String toString() {
		Collections.sort(listacoronas);
		StringBuilder sb = new StringBuilder();
		for(Corona corona : listacoronas) {
			sb.append(corona.toString());
		}
		return sb.toString();
	}
	
	
	
}
