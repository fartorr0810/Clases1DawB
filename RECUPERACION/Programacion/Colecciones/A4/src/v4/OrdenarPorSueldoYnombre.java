package v4;

import java.util.Comparator;

public class OrdenarPorSueldoYnombre implements Comparator<Empleado>{

	@Override
	public int compare(Empleado o1, Empleado o2) {
		int result=0;
		if (o1.getSueldo()>o2.getSueldo()) {
			result=-1;
		}
		else if (o1.getSueldo()<o2.getSueldo()) {
			result=+1;
		}
		else {
			result=o1.getNombre().compareTo(o2.getNombre());
		}
		return result;
	}

}
