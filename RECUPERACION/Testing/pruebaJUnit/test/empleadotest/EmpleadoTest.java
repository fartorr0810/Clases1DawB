package empleadotest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import empleado.Empleado;

class EmpleadoTest {
	private Empleado p1;
	private Empleado p2;
	private Empleado p3;
	private Empleado p4;
	@
	@BeforeEach
	public void init() {
	
		//Empleado sin parametros
		p1=new Empleado();
		//Empleado con dos parametros.
		p2=new Empleado("Maria", "Sanchez");
		//Empleado con tres parametros
		p3=new Empleado("Lola", "Mento", 40);
		//Empleado con tres parametros
		p4=new Empleado("Lola", "Mento", 41,1200);
	}
	//Test a get no hace falta
	@Test
	void ConstructorVacio() {
		assertEquals("", p1.getNombre());
		assertEquals("", p1.getApellido());
		assertEquals(0, p1.getEdad());
		assertEquals(600, p1.getSalario());
		
	}
	@Test
	void ConstructorDosParametros() {
		assertEquals("Maria", p2.getNombre());
		assertEquals("Sanchez", p2.getApellido());
		assertEquals(0, p2.getEdad());
		assertEquals(600, p2.getSalario());
	}
	@Test
	void ConstructorTresParametros() {
		assertEquals("Lola", p3.getNombre());
		assertEquals("Mento", p3.getApellido());
		assertEquals(40, p3.getEdad());
		assertEquals(600, p3.getSalario());
	}
	@Test
	void ConstructorCuatroParametros() {
		assertEquals("Lola", p4.getNombre());
		assertEquals("Mento", p4.getApellido());
		assertEquals(41, p4.getEdad());
		assertEquals(1200, p4.getSalario());
	}
	@Test
	void testPlus() {
		//No tiene edad definida, es decir 0
		assertFalse(p1.plus(2));
		//Esta persona tiene 40 anios
		//El metodo dice mayores a 40 , no mayor o igual segun los comentarios
		assertFalse(p3.plus(6));
		//Esta persona tiene 41
		assertTrue(p4.plus(41));
	}
	@Test
	void SumaSueldo() {
		//Persona creada sin atributos
		p1.plus(200);
		assertEquals(600, p1.getSalario());
		//Persona que tiene 39 años.
		p3.plus(3000);
		assertEquals(600, p1.getSalario());
		//Persona con 40 que si se le suma el plus indicado a su sueldo por defecto
		p4.plus(130);
		assertEquals(1330, p4.getSalario());
	}
	
	@Test
	void testEqualsEmpleado() {
		//Segun los comentarios, dos empleados son iguales si tienen el mismo nombre y apellido
		Empleado e1=new Empleado("Jesus","Garcia",32,720);
		Empleado e2=new Empleado("Jesus","Garcia",32,720);
		assertTrue(e1.equals(e2));
		Empleado e3=new Empleado("Josemi","Garcia",32,720);
		assertFalse(e1.equals(e3));
		Empleado e4=new Empleado("Jesus","Galan",32,720);
		assertFalse(e1.equals(e4));	
	}
    /**
     * Indica si un empleado es mayor, igual o menor que otro segun la edad
     * @param a empleado a comparar
     * @return 1: mayor, 0: iguales y -1 menor que el empleado comparado
     */
	@Test
	void testCompareTo() {
		Empleado e1=new Empleado("Jesus","Garcia",32,720);
		Empleado e2=new Empleado("Jesus","Garcia",32,720);
		Empleado e3=new Empleado("Jesus","Garcia",31,720);
		Empleado e4=new Empleado("Jesus","Galan",32,720);
		assertEquals(0, e1.compareTo(e2));
		assertEquals(1, e1.compareTo(e3));
		assertEquals(-1, e3.compareTo(e1));	
	}

	@Test
	void testToString() {
		Empleado e1=new Empleado("Jesus","Garcia",32,720);
		assertEquals("El empleado se llama Jesus Garcia con 32 años " +
                "y un salario de 720.0", e1.toString());
	}

}
