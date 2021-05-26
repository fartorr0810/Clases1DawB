package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotTest {
	private Robot r1;
	@BeforeEach
	
	public void init() {
		r1=new Robot("RD-D2",100,200);
	}
	@Test
	void testGetID() {
		assertEquals("RD-D2", r1.getID());
	}

	@Test
	void testGetVida() {
		assertEquals(100, r1.getVida());
	}

	@Test
	void testToString() {
		assertEquals("ID: RD-D2 Porcentaje de vida: 100.0", r1.toString());
	}

	@Test
	void testCompareTo() {
		Robot r2=new Robot("Yoni",100,320);
		Robot r3=new Robot("Yoni",90,320);
		Robot r4=new Robot("Yoni",110,320);
		assertEquals(0, r1.compareTo(r2));
		assertEquals(10, r1.compareTo(r3));
		assertEquals(-10, r1.compareTo(r4));

	}

	@Test
	void testGetFuerza() {
		assertEquals(200, r1.getFuerza());
	}

	@Test
	void testSetFuerza() {
		r1.setFuerza((float) 500.0);
		assertEquals(500.0,r1.getFuerza());
	}

}
