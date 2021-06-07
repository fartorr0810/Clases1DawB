package empleadotest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cuentas.Cuenta;
import cuentas.IngresoNegativoException;
import cuentas.Movimiento;
import cuentas.SaldoInsuficienteException;

class CuentaTest {
	private Cuenta cc;
	@BeforeEach
	public void init() {
		cc=new Cuenta("1", "El Pepe");
	}

	@Test
	void testIngresar() throws IngresoNegativoException {
		try {
			cc.ingresar("Negativo", -100);
			fail();
		} catch (IngresoNegativoException e) {
			assertEquals("No se puede ingresar una cantidad negativa", e.getMessage());
		}
		cc.ingresar("Prueba", 1200);
		assertEquals(1200, cc.getSaldo());

	}

	@Test
	void testRetirar() throws IngresoNegativoException, SaldoInsuficienteException {
		cc.ingresar("asd", 123);
		
		try {
			cc.retirar("Quitar con saldo negativo", -120);
			fail("Deberia lanzar la excepcion saldo");
		} catch (IngresoNegativoException e) {
			assertEquals("No se puede retirar una cantidad negativa", e.getMessage());
		} catch (SaldoInsuficienteException e) {
			assertEquals("Saldo insuficiente", e.getMessage());
		}
		try {
			cc.retirar("Quitar con saldo negativo", 1000);
		} catch (IngresoNegativoException e) {
		} catch (SaldoInsuficienteException e) {
			assertEquals("Saldo insuficiente", e.getMessage());
		}
		//cc.ingresar("Prueba", 1000);
		//cc.retirar("quito 500", 500);
		//assertEquals(500, cc.getSaldo());
		
		//assertEquals(500, cc.retirar("saco 500", 500));
		
	}

	@Test
	void testGetSaldo() {
		fail("Not yet implemented");
	}
//	Este metodo no se puede comprobar 
	@Test
	void testAddMovimiento() throws IngresoNegativoException {
		//no puedo meter movimientos porque NO HAY CONSTRUCTOR 
		Movimiento m1=new Movimiento();
		cc.ingresar("asd", 120);
		cc.addMovimiento(m1);
		assertEquals(0, cc.getSaldo());
	}

}
