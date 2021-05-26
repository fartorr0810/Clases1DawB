package pruebaJUnit5;


import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IndiceMasaCorporalTest {
	static Stream<Arguments> param1(){

		return Stream.of(
		Arguments.of(70,177,"Muy bien"),
		Arguments.of(70,120,"Sobrepeso"),
		Arguments.of(70,220,"Tienes que engordar"));
		
		}
	@ParameterizedTest
	@MethodSource("param1")
	void testDiagnostico(float p,float a,String result) {
		IndiceMasaCorporal ppp=new IndiceMasaCorporal(p,a);
		try {
			assertEquals(result, ppp.diagnostico());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
