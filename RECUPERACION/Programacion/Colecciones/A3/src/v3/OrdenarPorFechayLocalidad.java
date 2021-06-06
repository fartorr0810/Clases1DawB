package v3;

import java.util.Comparator;

public class OrdenarPorFechayLocalidad implements Comparator<Generador> {

	@Override
	public int compare(Generador o1, Generador o2) {
		int result=0;
		if (o1.getFechainicio().isBefore(o2.getFechainicio())){
			result=1;
		} else if (o2.getFechainicio().isAfter(o2.getFechainicio())) {
			result=1;
		}
		else if(result==0) {
			result=o1.getLocalidad().compareTo(o2.getLocalidad());
		}
		
		return 0;
	}

}
