package periodoRecuperacionJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContenedorTest {
	private Contenedor c;
	@BeforeEach
	public void init() {
		c=new Contenedor("Africa", "Silice", (float) 3000.0, "Microsoft");
	}
	//No tiene sentido hacer test a los get y setter a no ser que tengan logica dentro.


}
