/* EJERCICIOSDE PL-SQL–
Bloques, Procedimientos y FuncionesBLOQUES: 
DECLARE...BEGIN...END
1.-Escribir un bloque PL/SQL que escriba el texto ‘Hola’. */
BEGIN  
	DBMS_OUTPUT.PUT_LINE('Hola');
	END; 

/* 2.-Escribir  un  bloque  PL/SQL  que  cuente  el  número  de  filas 
 que  hay  en  la  tabla productos, deposita el resultado en 
 la variable v_num, y visualiza su contenido. */

DECLARE 
contadordeproductos	NUMBER;
BEGIN
	SELECT COUNT(idproducto) INTO CONTADORDEPRODUCTOS FROM producto;
	DBMS_OUTPUT.PUT_LINE(CONTADORDEPRODUCTOS);
	END; 

/* CREATE OR REPLACE PROCEDURE/ FUNTION
1)Escribir un procedimiento que reciba dos números y visualice su suma. */

CREATE OR REPLACE 
PROCEDURE SUMA (num1 number,num2 number) IS 
BEGIN
	DBMS_OUTPUT.PUT_LINE(num1+num2);
END ESCRIBEMENSAJE;

CALL SUMA(2,2);
/* 2) Codificar un procedimiento que reciba una cadena y la visualice al revés. */
CREATE OR REPLACE PROCEDURE CADENAREVERSA(cadenanormal VARCHAR2)
AS
	cadenareversa VARCHAR2(30);
BEGIN
	FOR i IN REVERSE 1..LENGTH(cadenanormal) LOOP
		cadenareversa := cadenareversa || SUBSTR(cadenanormal,i,1);
	END LOOP;
	DBMS_OUTPUT.PUT_LINE(cadenareversa);
END cadenareversa;

CALL CADENAREVERSA('amor');

/* 3) Escribir una función que reciba una fecha y devuelva el año, en número, 
correspondiente a esa fecha. */
CREATE OR REPLACE FUNCTION ano(fecha date)
return number
as 
    anoo number;
begin 
    anoo:= to_number(to_CHAR(fecha, 'YYYY'));
    return anoo;
end ano;

SELECT ano('23122000') FROM dual;

/* 4) Escribir un bloque PL/SQL que haga uso de la función anterior */
/* DECLARE
 	numero NUMBER(4);
BEGIN
 	numero := ano(SYSDATE);
 	DBMS_OUTPUT.PUT_LINE('Bienvenido al año : '|| numero);
END;

5) Dado el siguiente procedimiento: 
CREATE OR REPLACE PROCEDURE crear_depart ( v_num_dept depart.dept_no%TYPE,
    v_dnombre depart.dnombre%TYPE DEFAULT 'PROVISIONAL',
    v_loc depart.loc%TYPE DEFAULT ‘PROVISIONAL’) IS 
BEGIN 
INSERT INTO depart VALUES(v_num_dept, v_dnombre, v_loc); 
END crear_depart;  */

/*No se hacer ese ejercicio :( */

/* 6) Desarrollar una función que devuelva el número de años completos que hay entre 
dos fechas que se pasan como argumentos. */
CREATE OR REPLACE FUNCTION ENTREANOYANOHAY (
fecha1 DATE, fecha2 DATE)
RETURN NUMBER
AS
	diferenciaentreanos NUMBER(6);
BEGIN
	diferenciaentreanos := ABS(TRUNC(MONTHS_BETWEEN(fecha2,fecha1)/ 12));
	RETURN diferenciaentreanos;
END ENTREANOYANOHAY;


SELECT ENTREANOYANOHAY(SYSDATE,SYSDATE-1) FROM dual;

/* 7) Escribir una función que, haciendo uso de la función anterior devuelva 
los trienios que hay entre dos fechas. (Un trienio son tres años completos).
 */

CREATE OR REPLACE FUNCTION TRIANOS (
fecha1 DATE, fecha2 DATE)
RETURN NUMBER
AS
	trianos NUMBER(6);
BEGIN
	trianos := TRUNC(ENTREANOYANOHAY(fecha1,fecha2) / 3);
 	RETURN trianos;
END;

SELECT TRIANOS('21122000','23022433') from dual;


/* 8) Codificar un procedimiento que reciba una lista de hasta 5 números y visualice su suma.
 */
CREATE OR REPLACE PROCEDURE SUMAR5NUMEROS (
	num1 NUMBEr,num2 NUMBER,num3 NUMBER,num4 NUMBER,num5 NUMBER)
AS
BEGIN
	DBMS_OUTPUT.PUT_LINE(num1+num2+num3+num4+num5);
END SUMAR5NUMEROS;

call SUMAR5NUMEROS(2,2,2,2,2);

/* 9) Escribir una función que devuelva solamente caracteres alfabéticos sustituyendo
 cualquier otro carácter por blancos a partir de una cadena que se pasará en la llamada.
 */
CREATE OR REPLACE FUNCTION substituircaracterporblanco (cad VARCHAR2)
RETURN VARCHAR2 as 
	aux char;
	cadenanueva	VARCHAR2(30);
BEGIN 
for i in 1..LENGTH(cad) LOOP
	aux:=SUBSTR(cad,i,1);
	if (ASCII(aux)) NOT BETWEEN 65 AND 90) AND (ASCII(aux) not between 97 and 112)
THEN
	aux:=' ';
	END IF;
	cadenanueva:= nuevacadena||aux;
	end loop;
	return cadenanueva;
END substituircaracterporblanco;

/* 11. Implementar un procedimiento que reciba un importe y visualice el desglose del 
cambio en unidades monetarias de 1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000 Ptas.
 en orden inverso al que aparecen aquí enumeradas.  */
CREATE OR REPLACE PROCEDURE desglosador(dinero number)
AS 
	cambio FLOAT := dinero;
	moneda float;
	v_uni_moneda float;
BEGIN
	DBMS_OUTPUT.PUT_LINE('DESGLOSADOR DE '+dinero);
	while cambio>0 LOOP
		if cambio>= 5000 then 
		moneda:=5000;
		ELSIF cambio >= 2000 THEN
			moneda := 2000;
         	ELSIF cambio >= 1000 THEN
			moneda := 1000;
	   	ELSIF cambio >= 500 THEN
			moneda := 500;
         	ELSIF cambio >= 200 THEN
			moneda := 200;
	   	ELSIF cambio >= 100 THEN
			moneda := 100;
         	ELSIF cambio >= 50 THEN
			moneda := 50;
	   	ELSIF cambio >= 25 THEN
			moneda := 25;
	   	ELSIF cambio >= 10 THEN
			moneda := 10;
         	ELSIF cambio >= 5 THEN
			moneda := 5;
	   	ELSE  
			moneda := 1;
END IF;
	v_uni_moneda:= TRUNC(cambio/moneda);
DBMS_OUTPUT.PUT_LINE(v_uni_moneda || 'Hay ' || moneda || ' euros. ');
 		cambio := MOD(cambio, moneda);
	END LOOP;
END desglosador;

/* 12) Escribir un procedimiento que modifique la localidad de un departamento. El procedimiento recibirá 
como parámetros el número del departamento y la localidad nueva
 */
CREATE OR REPLACE PROCEDURE CAMBIARLOCALIDAD(
	num_depart NUMBER,
	localidad VARCHAR2)
AS
BEGIN
	UPDATE departamento SET localidad = localidadd
		WHERE numerodepartamento = num_depart;
END CAMBIARLOCALIAD;


/* 13) Visualizar todos los procedimientos y funciones del usuario almacenados en la base de datos y su situación (valid o invalid).
 */
 SELECT *
FROM user_objects 
WHERE OBJECT_TYPE IN ('PROCEDURE','FUNCTION');
