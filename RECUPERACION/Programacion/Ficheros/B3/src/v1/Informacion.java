package v1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Informacion {
	private int Agno;
	private String Periodo;
	private int Valor;
	
	
	public Informacion(int agno, String periodo, int valor) {
		super();
		Agno = agno;
		Periodo = periodo;
		Valor = valor;
	}
		
	public LocalDate getFecha() {
		String[] meses={"", "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre"
		                , "octubre", "noviembre", "diciembre"};
		String listaFecha[] = this.Periodo.split(" ");
		
		int dia = Integer.parseInt(listaFecha[1]);
		int mes = 0;
		for(int i =0; i<meses.length;i++) {
			if(meses[i].equalsIgnoreCase(listaFecha[3])) {
				mes=i;
			}
		}
		
		LocalDate fecha = LocalDate.of(Agno, mes, dia);
		return fecha;
		
	}


	public int getAgno() {
		return Agno;
	}


	public String getPeriodo() {
		return Periodo;
	}

	@Override
	public String toString() {
		return "Informacion [Agno=" + Agno + ", Periodo=" + Periodo + ", Valor=" + Valor + "]";
	}

	public int getValor() {
		return Valor;
	}

	public void setAgno(int agno) {
		Agno = agno;
	}

	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}
	public void setValor(int valor) {
		Valor = valor;
	}
}
