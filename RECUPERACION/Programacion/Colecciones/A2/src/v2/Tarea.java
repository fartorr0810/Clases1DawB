package v2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Tarea implements Temporizable,Comparable<Tarea> {
	private int codigo;
	private String descripcion;
	private LocalDate fechaalta;
	private LocalDate fechasolucion;
	private static int NextCode=0;
	private Prioridad prioridad;
	private boolean resulta;
	

	public Tarea(String descripcion, String prioridad) throws Exception {
		super();
		this.descripcion = descripcion;
		this.fechaalta = LocalDate.now();
		if (!prioridad.equals("ALTA") && !prioridad.equals("MEDIA") && !prioridad.equals("BAJA")) {
			throw new Exception("Solo se permite ALTA/MEDIA/BAJA");
		}else {
			this.prioridad = Prioridad.valueOf(prioridad);			
		}
		this.resulta=false;
		NextCode++;
	}
	public Prioridad getPrioridad() {
		return prioridad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public LocalDate getFechaalta() {
		return fechaalta;
	}

	public boolean isResulta() {
		return resulta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaalta == null) ? 0 : fechaalta.hashCode());
		return result;
	}
//No se si deberia introducir la fechadesolucion, ya que si se soluciona , en los metodos se iria a 
	//tareasolucinadas, por lo tanto la mejor opcion y que no se usar es un operador elvis , en mi caso
	//uso un condicional que compruebe si esta resuelta o no. 
	@Override
	public String toString() {
		String linea="";
		if (resulta==false) {
			linea="Tarea con codigo " + codigo + "su descripcion es" + descripcion + ",  la fechaalta=" + fechaalta
					+ "y su prioridad es " + prioridad + "y su estado de resulta es: " + resulta;
		}else if (resulta==true) {
			linea="Tarea con codigo " + codigo + "su descripcion es" + descripcion + ",  la fechaalta=" + fechaalta
					+ "y su fecha de solucion es: "+fechasolucion+" y su prioridad es " + prioridad + "y su estado de resulta es: " + resulta;
		}
		return linea;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaalta == null) {
			if (other.fechaalta != null)
				return false;
		} else if (!fechaalta.equals(other.fechaalta))
			return false;
		return true;
	}

	@Override
	public int numDias(LocalDate fecha) {
		long dias=0;
		dias=ChronoUnit.DAYS.between(fecha, LocalDateTime.now());
		if (dias<0) {
			dias=0-dias;
		}
		return (int)dias;
	}

	@Override
	public int compareTo(Tarea o) {
		int result=0;
		if (this.fechaalta.isBefore(o.fechaalta)) {
			result=1;
		}else if(this.fechaalta.isAfter(o.fechaalta)) {
			result=-1;
		}else {
			result=0;
		}
		return result;
	}
	public void resolverTarea() {
		this.resulta=true;
	}
}
