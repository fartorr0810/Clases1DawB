package v1;

import java.util.Comparator;

public class OrdenarFallecidos implements Comparator<Corona>{
	@Override
	public int compare(Corona c1, Corona c2) {
		int result = (int)(c1.getFallecidos()-c2.getFallecidos());
		return result;
	}

}
