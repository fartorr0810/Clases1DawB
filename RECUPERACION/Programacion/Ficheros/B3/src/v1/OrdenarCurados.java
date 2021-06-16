package v1;

import java.util.Comparator;

public class OrdenarCurados implements Comparator<Corona>{
	@Override
	public int compare(Corona c1, Corona c2) {
		int result = (int)(c1.getCurados()-c2.getCurados());
		return result;
	}

}
