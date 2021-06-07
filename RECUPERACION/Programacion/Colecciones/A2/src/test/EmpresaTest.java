package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import v2.Empresa;

class EmpresaTest {
	private Empresa jaca;
	@BeforeEach
	public void init() {
		jaca=new Empresa();
	}

	@Test
	void testAddTareaEmpresa() {
		try {
			assertEquals(true, jaca.AddTareaEmpresa("Prueba", "Informatica", "ALTA"));
		} catch (Exception e) {
		}
		//Debe devolver false porque no se va anadir una tarea que son iguales.
		try {
			assertEquals(false, jaca.AddTareaEmpresa("Prueba", "Informatica", "ALTA"));
		} catch (Exception e) {
		}
		try {
		//Compruebo que lanza la excepcion
		jaca.AddTareaEmpresa("Prueba", "Informatica", "ALTAaa");
		} catch (Exception e) {
			assertEquals("Solo se permite ALTA/MEDIA/BAJA", e.getMessage());
		}
	}

	@Test
	void testAddTareaCliente() {
		try {
			assertEquals(true, jaca.AddTareaCliente("Prueba", "MEDIA", "Maria", "Brenes"));
		} catch (Exception e) {
		}
		try {
			assertEquals(false, jaca.AddTareaCliente("Prueba", "MEDIA", "Maria", "Brenes"));
		} catch (Exception e) {
		}
		try {
			assertEquals(false, jaca.AddTareaCliente("Prueba", "MEDIas", "Maria", "Brenes"));
		} catch (Exception e) {
			assertEquals("Solo se permite ALTA/MEDIA/BAJA", e.getMessage());
		}
	}

	@Test
	void testMostrarTareas() throws Exception {
		jaca.AddTareaCliente("Prueba", "MEDIas", "Maria", "Brenes");
		//jaca.AddTareaCliente("Prueba", "MEDIA", "Maria", "Brenes");
		}

	@Test
	void testMostrarTareasPrioridad() {
		fail("Not yet implemented");
	}

	@Test
	void testNumTareasPendientes() {
		fail("Not yet implemented");
	}

	@Test
	void testResolverTarea() {
		fail("Not yet implemented");
	}

}
