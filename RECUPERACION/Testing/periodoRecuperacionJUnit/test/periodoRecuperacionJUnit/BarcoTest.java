package periodoRecuperacionJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BarcoTest {
	private Barco b1;
	@BeforeEach
	public void init() {
		b1=new Barco("20","BMW","Motora","Juanito el golondrino",1);
	}

	@Test
	void testCargaContenedor() throws CapacidadExcedidaException {
		Contenedor c=new Contenedor("Marruecos","CUSCUS",(float) 100.0,"Kebab");
		try {
			assertEquals(true, b1.cargaContenedor(c));
		} catch (CapacidadExcedidaException e) {
		}
		//El barco solo puede con un contenedor, al voler anadir otro contenedor, sobrepasara la capacidad y debe
		//lanzar la excepcion correspondiente
		c.setPeso(4000);
			try {
				assertEquals(false, b1.cargaContenedor(c));
			} catch (CapacidadExcedidaException e) {
				assertEquals("No caben más contenedores", e.getMessage());
			}
		//Ahora comprobaremos que se incrementa la carga
			Barco b2=new Barco("20","BMW","Motora","Juanito el golondrino",2);
			
			assertEquals(0, b2.getCargaActual());
			b2.cargaContenedor(c);
			assertEquals(1, b2.getCargaActual());
			//Volvemos a cargar otro contenedor igual y vemos si llega al 2
			b2.cargaContenedor(c);
			assertEquals(2, b2.getCargaActual());
			//Otra forma de hacerlo, con variable, en caso de que se pueda hacerlo
			Barco b3=new Barco("20","BMW","Motora","Juanito el golondrino",2);
			int cargaActual=b3.getCargaActual();
			b3.cargaContenedor(c);
			assertEquals(cargaActual++, b3.getCargaActual());
		}
	//Comprobar que se hace vacio, lo hace arriba ya.
	@Test
	void testBarcoVacio() {
		Barco b3=new Barco("20","BMW","Motora","Juanito el golondrino",0);
		//assertEquals(expected, actual);
	}
}
