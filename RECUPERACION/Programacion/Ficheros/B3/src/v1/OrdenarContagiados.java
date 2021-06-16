package v1;

import java.util.Comparator;



public class OrdenarContagiados implements Comparator<Corona>{

	

	@Override
	public int compare(Corona c1, Corona c2) {
		int result = (int)(c1.getContagiados()-c2.getContagiados());
		return result;
	}

}
