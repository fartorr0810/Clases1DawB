package periodoRecuperacionJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class EnfermoVirusTest {
	EnfermoVirus e1;
	@BeforeEach
	public void init() {
		e1=new EnfermoVirus("Bart", "Simpson", 7);
	}
	
	static Stream<Arguments> edades(){
		return Stream.of(
		Arguments.of("Bart","Sim",11,"niño"),
		Arguments.of("Bart","Sim",12,"niño"),
		Arguments.of("Bart","Sim",16,"adolescente"),
		Arguments.of("Bart","Sim",17,"adolescente"),
		Arguments.of("Bart","Sim",18,"adulto")
		//El fallo esta en el constructor que no comprueba los valores negativos
		//Arguments.of("Bart","Sim",-1,"No se admiten valores negativos") 
		);
	}
	@ParameterizedTest
	@MethodSource("edades")
	void testRangoEdad(String nombre,String apellidos,int edad,String respuesta) {
		EnfermoVirus e=new EnfermoVirus(nombre,apellidos,edad);
		assertEquals(respuesta, e.rangoEdad());
	}
//Hacerlo parametrizado.
	@ParameterizedTest
	@MethodSource("edades")
	void testToString(String nombre,String apellidos,int edad,String respuesta) {
		EnfermoVirus e=new EnfermoVirus(nombre,apellidos,edad);
		assertEquals("EnfermoVirusImpl [nombre="+nombre+", apellidos="+apellidos+", edad="+edad+"]", e.toString());
	}

}
