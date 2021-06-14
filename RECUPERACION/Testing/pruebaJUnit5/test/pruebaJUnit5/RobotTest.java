 package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotTest {
	private Robot robot;
	@BeforeEach
	public void init() {
		robot=new Robot("RD-D2", 100, 25);
		robot=new Robot("C-3PO", 100, 25);
	}
	@Test
	void testRobot() {
		
	}

	@Test
	void testGetID() {
		fail("Not yet implemented");
	}

	@Test
	void testGetVida() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFuerza() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFuerza() {
		fail("Not yet implemented");
	}

}
