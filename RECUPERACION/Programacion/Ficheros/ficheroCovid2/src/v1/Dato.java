package ficheroCovid2.covid;

public class Dato {
	private int Agno;
	private String Periodo;
	private int Valor;
	
	public Dato(int Agno, String Periodo, int Valor) {
		this.Agno = Agno;
		this.Periodo = Periodo;
		this.Valor = Valor;
	}

	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}

	public int getAgno() {
		return Agno;
	}

	public void setAgno(int agno) {
		Agno = agno;
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Agno;
		result = prime * result + ((Periodo == null) ? 0 : Periodo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Dato))
			return false;
		Dato other = (Dato) obj;
		if (Agno != other.Agno)
			return false;
		if (Periodo == null) {
			if (other.Periodo != null)
				return false;
		} else if (!Periodo.equals(other.Periodo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dato: Año=" + Agno + ", Periodo=" + Periodo + ", Valor=" + Valor;
	}

	
	
}
