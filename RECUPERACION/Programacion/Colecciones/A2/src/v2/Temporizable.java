package v2;

import java.time.LocalDate;

public interface Temporizable {
	//deben implementar lainterfaz temporizable, que deberá tener un método llamado numDias,
//	que reciba como parámetrouna fecha y devuelva el número de días transcurridos entre la
//	fecha de creación de la tarea y elparámetro. Siempre debe devolver un valor positivo.
	public int numDias(LocalDate fecha); //Devuelve el numero de dias transcurridos
}
