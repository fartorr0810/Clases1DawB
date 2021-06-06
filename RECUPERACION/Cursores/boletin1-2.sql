/* EJERCICIOSDE PL-SQL–Bloques, Procedimientos y FuncionesBLOQUES: 
DECLARE...BEGIN...END
1.-Escribir un bloque PL/SQL que escriba el texto ‘Hola’.
 */
CREATE OR REPLACE PROCEDURE ESCRIBE IS 
BEGIN 
	dbms_output.put_line('HOLA MUNDO');
END escribe;

CALL ESCRIBE(); 

/* 2.-Escribir  un  bloque  PL/SQL  que  cuente  el  número  de  filas  que  hay  en 
la  tabla productos, deposita el resultado en la variable v_num, y visualiza 
su contenido.CREATE OR REPLACE PROCEDURE/ FUNTION1)*/
DECLARE 
	v_num NUMBER;
BEGIN 
	SELECT count(*) INTO v_num
	FROM producto;
dbms_output.putline(v_num);
END;
/*Escribir un procedimiento que reciba dos números y visualice su suma.
 */
CREATE OR REPLACE PROCEDURE  suma(num1 NUMBER,num2 number) IS 
BEGIN 
	dbms_output.putline(num1+num2);
END suma;

CALL SUMA(2,2); 


/* 2) Codificar un procedimiento que reciba una cadena y la visualice al revés.
 */ 
CREATE OR REPLACE PROCEDURE DUMMY.ALREVESCADENA(cadena varchar2) IS 
	cadenareversa varchar2(30);
BEGIN
	FOR i IN REVERSE 1..LENGTH(cadena) LOOP
 		cadenareversa:=cadenareversa||SUBSTR(cadena,i,1);
	END LOOP;
 		dbms_output.put_line(cadenareversa);
END alrevescadena;


/* 3) Escribir una función que reciba una fecha y devuelva el año, en número, correspondiente a esa fecha.
 */

4) Escribir un bloque PL/SQL que haga uso de la función anterior
5) Dado el siguiente procedimiento: 
CREATE OR REPLACE PROCEDURE crear_depart ( v_num_dept depart.dept_no%TYPE,
 v_dnombre depart.dnombre%TYPE DEFAULT 'PROVISIONAL', v_loc depart.loc%TYPE DEFAULT ‘PROVISIONAL’) IS 
BEGIN 
INSERT INTO depart VALUES(v_num_dept, v_dnombre, v_loc); 
END crear_depart; 
Indicar cuáles de las siguientes llamadas son correctas y cuáles incorrectas,
 en este último caso escribir la llamada correcta usando la notación posicional
 (en los casos que se pueda): 
 1º. crear_depart;	--Esto explota 
 2º. crear_depart(50);  --Esto explota
 3º. crear_depart('COMPRAS'); --Explota
 4º. crear_depart(50,'COMPRAS'); --explota
 5º. crear_depart('COMPRAS', 50);  --explota
 6º. crear_depart('COMPRAS', 'VALENCIA'); --explota
 7º. crear_depart(50, 'COMPRAS', 'VALENCIA'); --Funciona
 8º. crear_depart('COMPRAS', 50, 'VALENCIA'); --explota
 9º. crear_depart('VALENCIA', ‘COMPRAS’); --explota
 10º. crear_depart('VALENCIA', 50); --explota

/* 6) Desarrollar una función que devuelva el número de años completos que hay entre 
dos fechas que se pasan como argumentos.
 */
CREATE OR REPLACE FUNCTION anoscompletos(fecha1 DATE,fecha2 DATE) IS 
v_num_anos	NUMBER;
BEGIN
	IF fecha1>fecha2 THEN 
		v_num_anos:=EXTRACT(YEAR FROM fecha1)-EXTRACT(YEAR FROM fecha2);
	ELSIF fecha2>fecha1 THEN
		v_num_anos:=EXTRACT(YEAR FROM fecha2)-EXTRACT(YEAR FROM fecha1);
	ELSE 
		v_num_anos:=0;
	END if;
	
	RETURN v_num_anos;
END anoscompletos;

/*7) Escribir una función que, haciendo uso de la función anterior devuelva los
trienios que hay entre dos fechas. (Un trienio son tres años completos).*/
SELECT dummy.anoscompletos(SYSDATE,'20022000') FROM dual;

CREATE OR REPLACE FUNCTION DUMMY.trienios(fecha1 DATE,fecha2 DATE) RETURN NUMBER IS 
numtrianos	NUMBER;
anosnormales	NUMBER;
BEGIN
	SELECT anoscompletos(fecha1,fecha2) INTO anosnormales
	FROM dual;
	numtrianos:=anosnormales/3;
RETURN numtrianos;
END trienios;

/* 8) Codificar un procedimiento que reciba una lista de hasta 5 números y visualice su suma.
 */
CREATE or replace procedure sumadenumeros(num1 number,num2 number,num3 number,num4 number,num5 number) IS
BEGIN
	dbms_output.put_line(num1+num2+num3+num4+num5);
END sumadenumeros;
/*9) Escribir una función que devuelva solamente caracteres alfabéticos sustituyendo cualquier 
otro carácter por blancos a partir de una cadena que se pasará en la llamada.*/
CREATE OR REPLACE FUNCTION DUMMY.caracteralfas (cadena varchar2) RETURN varchar2 IS 
cadenanueva	 varchar2(60):='';
aux char;
BEGIN
	FOR i IN 1..length(cadena) LOOP
		aux := substr(cadena,i,1);
		IF (ascii(aux) BETWEEN 65 AND 95) OR (ascii(aux) BETWEEN 97 AND 122) THEN
			cadenanueva:=cadenanueva||aux;
		ELSE
			cadenanueva:=cadenanueva||' ';
		END IF;
	END LOOP;
RETURN cadenanueva;
END caracteralfas;

/* 10) Implementar un procedimiento que reciba un importe y visualice el desglose del cambio.
en unidades monetarias de 1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000unidades monetarias.
en orden inverso al que aparecen aquí enumeradas*/

CREATE OR REPLACE PROCEDURE desglosador(importe NUMBER) as
		cambio NUMBER;
		moneda	NUMBER:
		v_uni_moneda number;
BEGIN
	cambio := importe;
	DBMS_OUTPUT.PUT_LINE('DESGLOSE DE: ' || importe );
	WHILE cambio > 0 LOOP
         	IF 	cambio >= 5000 THEN
			moneda := 5000;
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
		v_uni_moneda := TRUNC(cambio / moneda);
	   	DBMS_OUTPUT.PUT_LINE(v_uni_moneda || ' Unidades de: ' || moneda || ' euros. ');
 		cambio := MOD(cambio, moneda);
	END LOOP;
END desglosador;




--11) Codificar un procedimiento que permita borrar un empleado cuyo número se pasará en la llamada.
CREATE OR REPLACE PROCEDURE eliminarempleado(codigo NUMBER) IS 
	v_codigo empleados.codigo%TYPE;
BEGIN
	DELETE FROM EMPLEADOS e
	WHERE e.codigo=v_codigo;
	dbms_output.put_line('Hasta la prixmaaaa');
END eliminarempleado;

/* 12) Escribir un procedimiento que modifique la  localidad de un departamento. 
El procedimiento recibirá como parámetros el número del departamento 
y la localidad nueva.
 */
CREATE OR REPLACE PROCEDURE modificar_localidad(num_depart NUMBER, localidad VARCHAR2)
AS
BEGIN
UPDATE depart SET loc = localidad
WHERE dept_no = num_depart;
END modificar_localidad;

/*  13) Visualizar todos los procedimientos y funciones del usuario almacenados en la base de datos 
y su situación (valid o invalid). */
SELECT OBJECT_NAME, OBJECT_TYPE, STATUS
FROM USER_OBJECTS
WHERE OBJECT_TYPE IN ('PROCEDURE','FUNCTION');