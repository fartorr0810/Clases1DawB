/*Ejercicio1: (2puntos) Realizar una función cuyo nombre sea
TUNOMBREAPELLIDONUMERO que reciba dos parámetros, un número y un
parámetro de entrada salida. La función debe devolver el valor -1 y en el
parámetro de entrada salida un 0 si el número que recibe como primer
parámetro no es entero y positivo. Si el primer parámetro es entero y positivo
devolver en el parámetro de entrada y salida la suma de los n primeros números,
es decir si el primer parámetro es un 5 deberá devolver en el parámetro de
entrada salida el resultado de sumar 1+2+3+4+5. En este caso la función
devolverá un 1. (1,5 punto)

Realizar un bloque anónimo para probar está función en la que se llamará con
un número negativo, un número no entero, y por último con un número entero
y positivo. En este bloque se debe escribir el resultado de la función o el mensaje
de error correspondiente. (0.5 puntos)*/


CREATE OR REPLACE FUNCTION ADELALIRANUMERO(NUM NUMBER,NUM2 NUMBER) RETURN NUMBER IS 
	V_RESULTADO NUMBER:=-1;
	V_SUMA NUMBER:=0;
	BEGIN
		IF NUM>0 AND NUM=TRUNC(NUM) THEN
			V_RESULTADO:=1;
			FOR i IN 1..NUM LOOP
				V_SUMA:=V_SUMA+I;
			END LOOP;
			DBMS_OUTPUT.PUT_LINE('la suma es ' || V_SUMA);
			RETURN V_RESULTADO;
		
		ELSE
			V_SUMA:=0;
			DBMS_OUTPUT.PUT_LINE('El parametro de entrada y salida es ' || V_SUMA);
			RETURN V_RESULTADO;
		END IF;
		
	END ADELALIRANUMERO;
//
SELECT ADELALIRANUMERO(3,7) FROM DUAL;


DECLARE
	V_NUMERO NUMBER;
BEGIN
	V_NUMERO:=ADELALIRANUMERO(3,7);
	DBMS_OUTPUT.PUT_LINE(V_NUMERO);
	V_NUMERO:=ADELALIRANUMERO(-9,7);
	DBMS_OUTPUT.PUT_LINE(V_NUMERO);
	V_NUMERO:=ADELALIRANUMERO(5,7);
	DBMS_OUTPUT.PUT_LINE(V_NUMERO);
END;



/*Ejercicio 2: (1,5 puntos) Realiza un procedure para insertar una apuesta que se
llame TUNOMBREAPELLIDOINSERTARAPUESTA. El procedure recibirá el código
del caballo, el código de la carrera, el dni del cliente y el importe. El procedure
deberá mostrar los siguientes posibles errores:
o Si el caballo no existe lanzar la excepción -20001 con el mensaje
“Caballo imaginario”
o Si la carrera no existe lanzar la excepción -20002 con el mensaje
“Caballo imaginario”
o Si el cliente no existe lanzar la excepción -20003 con el mensaje “Cliente
imaginario”
o Si el caballo no participa en la carrera lanzar la excepción -20004 con el
mensaje “Caballo existente, pero descansando”
o Si el importe apostado supera el límite fijado para dicha carrera lanzar la
excepción -20005 con el mensaje, “Jugar es malo”.
El tantoporuno será de uno siempre. Si se comprueba uno de los errores no es
necesario seguir mirando los demás.*/

CREATE OR REPLACE PROCEDUCE ADELALIRAINSERTARAPUESTA (CODIGOCABALLO VARCHAR2, CODCARRERA2 VARCHAR2, CODCLI NUMBER, IMPORTE NUMBER) IS 
v_apustaLimite NUMBER;
V_AUX NUMBER;
BEGIN 
	SELECT COUNT(*) INTO V_AUX FROM CABALLOS c WHERE C.CODCABALLO=CODIGOCABALLO;
	IF SQL%NOTFOUND THEN
	 RAISE_APPLICATION_ERROR(-20001,'Caballo imaginario');
	

	SELECT COUNT(*)	 INTO V_AUX FROM CARRERAS c WHERE C.CODCARRERA=CODCARRERA2;
	ELSIF SQL%NOTFOUND THEN
	 RAISE_APPLICATION_ERROR(-20002,'Carrera imaginaria');


	SELECT COUNT(*)	 INTO V_AUX FROM CLIENTES c WHERE C.DNI=CODCLI;
	ELSIF SQL%NOTFOUND THEN
	 RAISE_APPLICATION_ERROR(-20003,'Cliente imaginario');


	SELECT COUNT(*)	 INTO V_AUX FROM PARTICIPACIONES p , CABALLOS c WHERE c.CODIGOCABALLO=p.CODCABALLO AND CODIGOCABALLO =c.CODCARRERA;
	ELSIF SQL%NOTFOUND THEN
	RAISE_APPLICATION_ERROR(-20004,'Caballo existente, pero descansando');


	SELECT APUESTALIMITE INTO v_apustaLimite FROM CARRERAS c WHERE c.CODCARRERA=CODCARRERA2;
	ELSIF v_apustaLimite>IMPORTE THEN
	RAISE_APPLICATION_ERROR(-20005,'Jugar es malo');
END IF;



END ADELALIRAINSERTARAPUESTA;
//
CALL ADELALIRAINSERTARAPUESTA();




/*Ejercicio 3: (3 puntos)+(1punto) Realiza un procedimiento que reciba una fecha
inicial y una fecha final y muestre todas las apuestas que han resultado ganadoras
entre esas dos fechas. Las apuestas deben mostrarse con el siguiente formato:
INFORME DE APUESTAS GANADORAS ENTRE dd/mm/yy y dd/mm/yy
Carrera: Nombre de la carrera1
Fecha: dd/mm/yyyy
Cliente1 ImporteApostado1 Ganancias1
....
Clienten ImporteApostadon Gananciasn
Total ganancias de los apostantes en la carrera: nnnnn
Total ganancias Hipódromo en la carrera: nnnnnn
Carrera: Nombre de la carrera2
Fecha: dd/mm/yyyy
Cliente1 ImporteApostado1 Ganancias1
....
Clienten ImporteApostadon Gananciasn
Total ganancias de los apostantes en la carrera: nnnnn
Total ganancias Hipódromo en la carrera: nnnnnn
..........
Total Ganancias Hipódromo: nnnnnn
Para las ganancias del hipódromo se calculan sumando los importes apostados y
restando el premio al ganador de la carrera y los pagos realizados a los
apostantes ganadores. Para ello crea una función que reciba el código de la
carrera y devuelva las ganancias del hipódromo con esta carrera (1 punto).
Si la fecha inicial es mayor que la final, debe mostrarse un mensaje de error y
salir.*/



/*Ejercicio 4 (2,5 puntos):
Para la realización de este ejercicio es necesario que ejecutes la siguiente
instrucción para crear la tabla AUDITORIA_APUESTAS.
CREATE TABLE AUDITORIA_APUESTAS (descripcion VARCHAR2(200));
Crea un trigger que, cada vez que se modifiquen o se borren datos de la tabla
APUESTAS, registre una entrada en la tabla AUDITORIA_APUESTAS. La
información que deberá guardar será la fecha del suceso, valor antiguo y valor
nuevo de cada campo modificado, así como el tipo de operación realizada (en el
caso de actualización de datos deberá indicarse la palabra MODIFICACIÓN, en el
caso de borrado de datos deberá indicarse BORRADO).*/

CREATE TABLE AUDITORIA_APUESTAS (descripcion VARCHAR2(200));

CREATE OR REPLACE TRIGGER MODIFICADDOBORRADO AFTER UPDATE OR DELETE ON APUESTAS FOR EACH ROW 
	BEGIN 
		IF UPDATING ('DNICLIENTE') THEN 
			INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: ' || SYSDATE || ' Antiguo Dni Cliente: ' || :NEW.DNICLIENTE || ' nuevo Dni Cliente:' || :NEW.DNICLIENTE || ' tipo de operacion: MODIFICACIÓN ' );
		END IF;	--salta excepcion por que es PK
		IF UPDATING ('CODCABALLO') THEN 
			INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: ' || SYSDATE || ' Antiguo Dni Codigo caballo: ' || :NEW.CODCABALLO || ' nuevo Dni Codigo caballo:' || :NEW.CODCABALLO || ' tipo de operacion: MODIFICACIÓN ' );
		END IF;	 --salta excepcion por que es PK
		IF UPDATING ('CODCARRERA') THEN 
			INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: ' || SYSDATE || ' Antiguo Codigo carrera: ' || :NEW.CODCARRERA || ' nuevo Codigo carrera:' || :NEW.CODCARRERA || ' tipo de operacion: MODIFICACIÓN ' );
		END IF;	 --salta excepcion por que es PK
		IF UPDATING ('IMPORTE') THEN 
			INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: ' || SYSDATE || ' Antiguo importe: ' || :NEW.IMPORTE || ' nuevo importe:' || :NEW.IMPORTE || ' tipo de operacion: MODIFICACIÓN ' );
		END IF;	
		IF UPDATING ('TANTOPORUNO') THEN 
			INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: ' || SYSDATE || ' Antiguo tanto por uno: ' || :NEW.TANTOPORUNO || ' nuevo tanto por uno:' || :NEW.TANTOPORUNO || ' tipo de operacion: MODIFICACIÓN ' );
		END IF;	
		IF DELETING  THEN 
			INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: ' || SYSDATE || ' Antiguo Dni Cliente: ' || :OLD.DNICLIENTE || ' nuevo Dni Cliente:' || :OLD.DNICLIENTE || ' tipo de operacion: BORRADO ' );
		END IF;
	END MODIFICADDOBORRADO;
//
	

UPDATE APUESTAS 
SET APUESTAS.IMPORTE ='2000';
WHERE APUESTAS.IMPORTE ='350';

DELETE FROM APUESTAS WHERE APUESTAS.IMPORTE='2000'; 




/*Añade una columna a la tabla Caballos para almacenar el número de carreras
ganadas por cada uno de ellos. Realiza un procedimiento para llenarla con los
valores adecuados (2 puntos)*/




/*3. (2 puntos) Realizar un procedimiento que reciba un número entero y positivo (si
no es así mostrar un mensaje de error y salir), y dos letras distintas (si no son
distintas mostrar mensaje de error y salir) y escriba una tabla en la que
aparecerán n veces la primera letra, luego otra fila con n veces la segunda letra,
otra fila con n veces la primera fila, y así hasta completar n filas.

Por ejemplo, si llamo a la función con el número 6 y la letra A y B deberá aparecer
algo como esto
AAAAAA
BBBBBB
AAAAAA
BBBBBB
AAAAAA
BBBBBBB

No olvides que “hay que cuidar a Oracle”

Si la llamo con el número 5 y la letra A y B deberá aparecer algo como esto
AAAAA
BBBBB
AAAAA
BBBBBB
AAAAA*/




/*4. (2 puntos) Realiza un procedimiento para insertar una apuesta. El procedimiento
recibirá el nombre del caballo, el nombre de la carrera, el nombre y nacionalidad
del cliente y el importe. El procedimiento deberá mostrar los siguientes posibles
errores:
• El caballo, la carrera o el cliente no existe
• Si el importe apostado supera el límite fijado para dicha carrera mostrar el
correspondiente mensaje de error.
El tantoporuno será de uno siempre. (2 puntos)*/





