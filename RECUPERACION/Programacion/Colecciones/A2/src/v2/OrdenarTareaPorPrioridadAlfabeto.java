package v2;

import java.util.Comparator;

public class OrdenarTareaPorPrioridadAlfabeto implements Comparator<Tarea> {

	@Override
	public int compare(Tarea o1, Tarea o2) {
		int result=0;
		if(o1.getPrioridad().getNumhoras() < o2.getPrioridad().getNumhoras()) {
			result = -1;
		}else if(o1.getPrioridad().getNumhoras() > o2.getPrioridad().getNumhoras()){
			result = 1; 
			}
		else {
			result=o1.getDescripcion().compareTo(o2.getDescripcion());
		}
		return result;
	}

}
