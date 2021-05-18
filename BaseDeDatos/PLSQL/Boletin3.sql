/* 5.6.1. Desarrolla el paquete ARITMETICA cuyo código fuente viene en este tema.
Crea un archivo para la especi(cación y otro para el cuerpo. R
ealiza varias pruebaspara comprobar que las llamadas a funciones y procedimiento funcionan correctamente.
 */
CREATE OR REPLACE PACKAGE DUMMY.ARITMETICA is
	version	NUMBER:=1.0;
FUNCTION SUMAR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION RESTAR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION MULTIPLICACION (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION DIVIDIR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
END aritmetica;

CREATE OR REPLACE PACKAGE BODY DUMMY.aritmetica IS
 
FUNCTION SUMAR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1+num2);
	END SUMAR;
FUNCTION RESTAR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1-num2);
	END RESTAR;
FUNCTION MULTIPLICACION      (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1*num2);
	END MULTIPLICACION;
FUNCTION DIVIDIR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1/num2);
	END DIVIDIR;
END ARITMETICA




/* 5.6.2. Al paquete anterior añade una función llamada RESTO que reciba dos parámetros, el dividendo y 
el divisor, y devuelva el resto de la división.
 */

CREATE OR REPLACE PACKAGE DUMMY.ARITMETICA is
	version	NUMBER:=1.0;
FUNCTION SUMAR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION RESTAR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION MULTIPLICACION (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION DIVIDIR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION RESTO (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
END aritmetica;


CREATE OR REPLACE PACKAGE BODY DUMMY.aritmetica IS
 
FUNCTION SUMAR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1+num2);
	END SUMAR;
FUNCTION RESTAR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1-num2);
	END RESTAR;
FUNCTION MULTIPLICACION      (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1*num2);
	END MULTIPLICACION;
FUNCTION DIVIDIR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1/num2);
	END DIVIDIR;
END ARITMETICA;


/* 5.6.3. Al paquete anterior añade un procedimiento sin parámetros llamado AYUDA que muestre un
mensaje por pantalla de los procedimientos y funciones disponiblesen el paquete, su utilidad y
forma de uso
 */

CREATE OR REPLACE PACKAGE DUMMY.ARITMETICA is
	version	NUMBER:=1.0;
FUNCTION SUMAR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION RESTAR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION MULTIPLICACION (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
FUNCTION DIVIDIR (num1 NUMBER,num2 NUMBER) RETURN NUMBER ;
PROCEDURE AYUDA;

END aritmetica;


CREATE OR REPLACE PACKAGE BODY DUMMY.aritmetica IS
FUNCTION SUMAR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1+num2);
	END SUMAR;
FUNCTION RESTAR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1-num2);
	END RESTAR;
FUNCTION MULTIPLICACION      (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1*num2);
	END MULTIPLICACION;
FUNCTION DIVIDIR       (num1 NUMBER, num2 NUMBER) RETURN NUMBER IS
	BEGIN
    	RETURN (num1/num2);
	END DIVIDIR;
PROCEDURE AYUDA IS 
	BEGIN
		DBMS_OUTPUT.PUT_LINE('YEAH KAMEHAMEHA DESPUES DEL TETRIS VIENE EL DRAGON BALL RAP');

	END AYUDA;
END ARITMETICA;
/* 5.6.4. Desarrolla el paquete GESTION. En un principio tendremos los procedimientos para
gestionar los departamentos. Dado el archivo de especi(cación mostrado más abajo crea el 
archivo para el cuerpo. Realiza varias pruebas para comprobar que las llamadas a funciones y 
procedimientos funcionan correctamente. */


CREATE OR REPLACE PACKAGE DUMMY.GESTION AS 
PROCEDURE CREAR_DEP      (nombre VARCHAR2, presupuesto NUMBER);
FUNCTION  NUM_DEP        (nombre VARCHAR2) RETURN NUMBER;
PROCEDURE MOSTRAR_DEP    (numero NUMBER);
PROCEDURE BORRAR_DEP     (numero NUMBER);
PROCEDURE MODIFICAR_DEP  (numero NUMBER, presupuesto NUMBER);
END GESTION;

CREATE OR REPLACE PACKAGE BODY DUMMY.GESTION IS
PROCEDURE CREAR_DEP(nombre varchar2,presupuesto number) IS 
	v_numde number:= 123;
	v_numce number:= 1;
	v_direc varchar2(30):= 'sas';
	v_tidir varchar2(30):= 'sadad';
	v_depde	number:=23;
	BEGIN
		insert into Departamento (numde,numce,direc,tidir,presu,depde,nomde)
		VALUES (v_numde,v_numce,v_direc,v_tider,presupuesto,v_depde,nombre);
	END CREAR_DEP;

FUNCTION NUM_DEP (nombre varchar2) RETURN NUMBER IS
	result number;
	BEGIN
		SELECT e.NUMDE into result
		FROM EMPLEADOS e 
		where e.nomem=nombre;
		return result;
	END num_dep;

PROCEDURE MOSTRAR_DEP (numero number) IS
	result varchar2(30);
	BEGIN
		SELECT e.numdep into result
		FROM EMPLEADOS e 
		where e.numdep=numero;
		DBMS_OUTPUT.PUT_LINE(result);
	END mostrar_dep;

PROCEDURE BORRAR_DEP (numero number) IS
	result varchar2;
	BEGIN
		DELETE FROM DEPARTAMENTO WHERE DEPARTAMENTO.numdep=numero; 
		DBMS_OUTPUT.PUT_LINE('eliminasion completada');
	END BORRAR_DEP;

