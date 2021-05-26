package pruebaJUnit5;


import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IMCRARO {
	static Stream<Arguments> param1(){

		return Stream.of(
		Arguments.of(70,177,"Muy bien"),
		Arguments.of(70,120,"Sobrepeso"),
		Arguments.of(70,220,"Tienes que engordar")
		//Arguments.of(-70,220,"Tienes que engordar")
		);
		
		}
	@ParameterizedTest
	@MethodSource("param1")
	void testDiagnostico(float p,float a,String result) throws Exception {
		IndiceMasaCorporal ppp=new IndiceMasaCorporal(p,a);
		IndiceMasaCorporal ppp2=new IndiceMasaCorporal(p-1000,a-1000);
		assertEquals(result, ppp.diagnostico());
		try {
			assertEquals(result, ppp2.diagnostico());
		} catch (Exception e) {
			
		}
	}

}
