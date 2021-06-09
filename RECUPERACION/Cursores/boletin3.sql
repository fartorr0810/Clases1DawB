/* 5.6.1. Desarrolla el paquete ARITMETICA cuyo código fuente viene en este tema. 
Crea un archivo para la especi(cación y otro para el cuerpo. Realiza varias pruebaspara 
comprobar que las llamadas a funciones y procedimiento funcionan correctamente.
 */
CREATE OR REPLACE PACKAGE ARITMETICA IS 
	PROCEDURE suma(num1 NUMBER,num2 number);
	PROCEDURE resta(num1 NUMBER,num2 number);
	FUNCTION multiplicacion(num1 NUMBER,num2 NUMBER) RETURN NUMBER;
	PROCEDURE diviision (num1 NUMBER,num2 number);
END aritmetica; 
/* 5.6.2. Al paquete anterior añade una función llamada RESTO que reciba dos parámetros,
el dividendo y el divisor, y devuelva el resto de la división.
 */
CREATE OR REPLACE PACKAGE DUMMY.ARITMETICA IS 
	PROCEDURE suma(num1 NUMBER,num2 number);
	PROCEDURE resta(num1 NUMBER,num2 number);
	FUNCTION multiplicacion(num1 NUMBER,num2 NUMBER) RETURN NUMBER;
	PROCEDURE diviision (num1 NUMBER,num2 number);
	FUNCTION resto (num1 NUMBER,num2 number) RETURN NUMBER;
END aritmetica;


/* 5.6.3. Al paquete anterior añade un procedimiento sin parámetros llamado AYUDA que muestre 
un mensaje por pantalla de los procedimientos y funciones disponiblesen el paquete, su utilidad y 
forma de uso.
 */
/* 5.6.4. Desarrolla el paquete GESTION. En un principio tendremos los procedimientos para gestionar 
los departamentos. Dado el archivo de especi(cación mostrado más abajo crea el archivo para el cuerpo. 
Realiza varias pruebas para comprobar que las llamadas a funciones y procedimientos funcionan correctamente. */