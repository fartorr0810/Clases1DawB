package pruebaJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IndiceMasaCorporalTest {
	//Preguntar si tiene sentido poner un valor que lanze una excepcion en un test parametrizado.
	static Stream<Arguments> edades(){
		return Stream.of(
		Arguments.of(170,50,"Tienes que engordar",17.3),
		Arguments.of(170,52,"Muy bien",18),
		Arguments.of(170,140,"Sobrepeso",48.4),
		Arguments.of(170,72,"Muy bien",24.9));
	}


	@ParameterizedTest
	@MethodSource("edades")
	void testDiagnostico(int altura,int peso,String respuesta) {
		IndiceMasaCorporal mc=new IndiceMasaCorporal(peso, altura);
		try {
			assertEquals(respuesta, mc.diagnostico());
			
		} catch (Exception e) {
		}
	}
	@Test
	void testDiagnostico() {
		try {
			IndiceMasaCorporal mc=new IndiceMasaCorporal("-1", "165.4.3");
			fail("No se puede convertir a numero");
		} catch (Exception e) {
			//No se que mensaje lanza.
		}
}
}
