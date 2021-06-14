package ejercicio;

import java.util.Iterator;
import java.util.LinkedList;


public class Calle {
	private String nombrecalle;
	private int idcalle;
	private LinkedList<Caseta> casetas;
	
	public Calle(String nombrecalle, int idcalle) {
		super();
		this.nombrecalle = nombrecalle;
		this.idcalle = idcalle;
		casetas=new LinkedList<Caseta>();
	}
	public void addCaseta(Caseta c) {
		casetas.add(c);
	}
	public String getNombrecalle() {
		return nombrecalle;
	}
	public int getIdcalle() {
		return idcalle;
	}
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idcalle;
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
		Calle other = (Calle) obj;
		if (idcalle != other.idcalle)
			return false;
		return true;
	}
	public void Delete(int numero) {
		boolean encontrado=false;
		boolean encontrado2=false;
		int modulo=0;
		int posicion=0;
		Iterator<Caseta> sig = casetas.iterator();
		Caseta t1;
		while (sig.hasNext( ) && !encontrado) {
				t1 = sig.next();
			if (t1.getNumero()==numero) {
				System.out.println(casetas.remove(t1));
				modulo=t1.getModulos();				
				posicion=t1.getNumero();
				casetas.remove(t1);				
			}
		}
		Iterator<Caseta> sig2 = casetas.iterator();
		while (sig2.hasNext()) {
			Caseta t2 = sig2.next();
			if (t2.getNumero()>posicion) {
				t2.setNumero(t2.getNumero()-modulo);
			}
		}
	}
	public String toStringCaseta() {
		StringBuilder sbb=new StringBuilder("nombre calle:"+this.nombrecalle);
		for (Caseta caseta : casetas) {
			sbb.append(caseta.toString()+"\n");
		}
		return sbb.toString(); 
	}
	public String numCasetas() {
		StringBuilder sbb=new StringBuilder("nombre calle:"+this.nombrecalle);
		int contador=0;
		for (Caseta caseta : casetas) {
			contador++;
		}
		sbb.append(String.valueOf(contador));
		return sbb.toString(); 
	}
}
