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
 1º. crear_depart; 
 2º. crear_depart(50); 
 3º. crear_depart('COMPRAS'); 
 4º. crear_depart(50,'COMPRAS'); 
 5º. crear_depart('COMPRAS', 50); 
 6º. crear_depart('COMPRAS', 'VALENCIA'); 
 7º. crear_depart(50, 'COMPRAS', 'VALENCIA'); 
 8º. crear_depart('COMPRAS', 50, 'VALENCIA'); 
 9º. crear_depart('VALENCIA', ‘COMPRAS’); 
 10º. crear_depart('VALENCIA', 50);
6) Desarrollar una función que devuelva el número de años completos que hay entre 
dos fechas que se pasan como argumentos.
7) Escribir una función que, haciendo uso de la función anterior devuelva los
 trienios que hay entre dos fechas. (Un trienio son tres años completos).
 8) Codificar un procedimiento que reciba una lista de hasta 5 números y visualice su suma.
 9) Escribir una función que devuelva solamente caracteres alfabéticos sustituyendo cualquier 
 otro carácter por blancos a partir de una cadena que se pasará en la llamada.
 10) Implementar un procedimiento que reciba un importe y visualice el desglose del cambio
  en unidades monetarias de 1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000unidades monetarias.
   en orden inverso al que aparecen aquí enumeradas
11) Codificar un procedimiento que permita borrar un empleado cuyo número se pasará en la llamada.
12) Escribir un procedimiento que modifique la 
localidad de un departamento. El procedimiento recibirá como parámetros el número del departamento 
y la localidad nueva.
13) Visualizar todos los procedimientos y funciones del usuario almacenados en la base de datos 
y su situación (valid o invalid).