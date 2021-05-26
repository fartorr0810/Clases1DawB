package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuchaRobotsTest {
	private LuchaRobots pelea1;
	private Robot r1;
	private Robot r2;
	@BeforeEach
	
	public void init() {
		pelea1=new LuchaRobots("Sanchez Pizjuan", "Joaquin");
		r1=new Robot("RD-D2",100,200);
		r2=new Robot("Yoni el Robot",100,500);

	}

	@Test
	void testAñadeRobot() {
		pelea1.añadeRobot("R2-D2", 100, 200);
		assertEquals(1, pelea1.getNumLuchadores());
		pelea1.añadeRobot("Yoni el Robot", 100, 69);
		assertEquals(2, pelea1.getNumLuchadores());
	}

	@Test
	void testGetNumLuchadores() {
		pelea1.añadeRobot("R2-D2", 100, 200);
		pelea1.añadeRobot("Yoni el Robot", 100, 69);
		assertEquals(2, pelea1.getNumLuchadores());
		//No se añade porque tiene ya metido los dos robots, y por eso el siguiente 
		//assert devuelve 2
		pelea1.añadeRobot("Willy", 100, 600);
		assertEquals(2, pelea1.getNumLuchadores());
	}
	@Test
	void comprobarPeleaEstaSinRobots() {
		assertEquals(0, pelea1.getNumLuchadores());
	}


	@Test
	void testSetEstadio() {
		pelea1.añadeRobot("LIRA", 100, 100);
		try {
			pelea1.setEstadio("Me-stalla");
			fail();
		} catch (NotAllowedChangeException e) {
			assertEquals("Ya se han añadido luchadores", e.getMessage());
		}
		LuchaRobots pelea2=new LuchaRobots("asd", "asd");
		try {
			pelea2.setEstadio("Tego Calderon");
			assertEquals("Tego Calderon", pelea2.getEstadio());
		} catch (NotAllowedChangeException e) {
			assertEquals("Ya se han añadido luchadores", e.getMessage());
		}
	}

}
