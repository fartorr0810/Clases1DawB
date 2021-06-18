
---------------------Ejercicio 1---------------------------------
CREATE OR REPLACE PACKAGE paquete_ciclistas IS --Paquete de 2 y 2.1 NO SE PORQUE PERO NO ME COMPILA EL CREAR EL PAQUETE,
																	--PERO LAS FUNCIONES DE DENTRO FUNCIONAN

PROCEDURE listado();

FUNCTION carrerasGanadas(pequipo VARCHAR2) RETURN NUMBER;

END paquete_ciclistas;


CREATE OR REPLACE PACKAGE BODY paquete_ciclistas IS

---------------------Ejercicio 2---------------------------------
CREATE OR REPLACE PROCEDURE DUMMY.listado IS


v_codigo_equipo NUMBER;


CURSOR cursor_equipo IS
SELECT e.CODEQUIPO,e.NOMBRE,e.NACIONALIDAD,e.NOMBREDIRECTOR FROM EQUIPOS e;

CURSOR cursor_ciclista IS 
SELECT c.NOMBRE,c.FECHANACIMIENTO  FROM CICLISTAS c WHERE C.CODEQUIPO=v_codigo_equipo;

BEGIN
	FOR equipo IN cursor_equipo loop
	DBMS_OUTPUT.PUT_LINE('Nombre: '|| equipo.nombre ||' Nacionalidad: ' || equipo.nacionalidad|| ' Nombre del director: ' ||equipo.nombredirector);
	DBMS_OUTPUT.PUT_LINE(' ');
    v_codigo_equipo:=equipo.codequipo;

		FOR ciclista IN cursor_ciclista LOOP
		DBMS_OUTPUT.PUT_LINE('  Ciclista     '|| ciclista.nombre||'   ' || ciclista.fechanacimiento);
		
		
		END LOOP;
	DBMS_OUTPUT.PUT_LINE(' ');

	END LOOP;
	
END listado;

---------------------Ejercicio 2.1---------------------------------

CREATE OR REPLACE FUNCTION DUMMY.carrerasGanadas(pequipo VARCHAR2) RETURN NUMBER IS

v_ganadas NUMBER;
BEGIN
	SELECT COUNT(*) INTO v_ganadas FROM EQUIPOS e WHERE e.NOMBRE=pequipo;
	IF v_ganadas=0 THEN
		raise_application_error(-20001,'No se ha encontrado el equipo');
	END IF;

	SELECT COUNT(*) INTO v_ganadas FROM Equipos e,CICLISTAS c, CLASIFICACIONETAPAS c2 WHERE e.NOMBRE=pequipo AND e.CODEQUIPO=c.CODEQUIPO 
AND c.DORSAL=c2.DORSAL AND c2.POSICION='1';

	RETURN v_ganadas;

END carrerasGanadas;



END paquete_ciclistas;


---------------------Ejercicio 3---------------------------------
TRIGGER no_mas_de_4_ciclistas BEFORE INSERT ON CICLISTAS
FOR EACH ROW
DECLARE
v_cantidad_actual NUMBER;

BEGIN
	SELECT COUNT(*) INTO V_CANTIDAD_ACTUAL FROM CICLISTAS c WHERE c.CODEQUIPO=:NEW.codequipo;
	IF V_CANTIDAD_ACTUAL >3 THEN
		raise_application_error(-20002,'No puede haber mas de 4 ciclistas en el mismo equipo');
	END IF;
	
END no_mas_de_4_ciclistas;

---------------------Ejercicio 4--------------------------------- Hay que retocarlo para cuando sale del equipo
CREATE TABLE memoria (descrip varchar2(200));

--debe guardar nombre jugador, nombre equipo, fecha=sysdate
CREATE OR REPLACE TRIGGER auditoria_memoria BEFORE INSERT OR UPDATE OR DELETE ON CICLISTAS
FOR EACH ROW

DECLARE 
nombre_equipo_new EQUIPOS.NOMBRE%TYPE;
nombre_equipo_old EQUIPOS.NOMBRE%TYPE;

BEGIN
	
	

	IF INSERTING THEN
	SELECT e.NOMBRE INTO nombre_equipo_new FROM EQUIPOS e WHERE e.CODEQUIPO=:NEW.codequipo;
	INSERT INTO MEMORIA VALUES('El jugador ' ||:NEW.nombre || ' ha empezado a formar parte del equipo ' ||nombre_equipo_new|| ' el dia ' || SYSDATE);
	
	ELSIF DELETING THEN
	SELECT e.NOMBRE INTO nombre_equipo_old FROM EQUIPOS e WHERE e.CODEQUIPO=:OLD.codequipo;
	INSERT INTO MEMORIA VALUES('El jugador ' ||:OLD.nombre || ' ha dejado de formar parte del equipo ' ||nombre_equipo_old|| ' el dia ' || SYSDATE);

	ELSIF UPDATING THEN
	SELECT e.NOMBRE INTO nombre_equipo_new FROM EQUIPOS e WHERE e.CODEQUIPO=:NEW.codequipo;
	SELECT e.NOMBRE INTO nombre_equipo_old FROM EQUIPOS e WHERE e.CODEQUIPO=:OLD.codequipo;
	INSERT INTO MEMORIA VALUES('El jugador ' ||:NEW.nombre || ' ha empezado a formar parte del equipo ' ||nombre_equipo_new|| ' el dia ' || SYSDATE);
	INSERT INTO MEMORIA VALUES('El jugador ' ||:NEW.nombre || ' ha dejado de formar parte del equipo ' ||nombre_equipo_old|| ' el dia ' || SYSDATE);
	
	

	END IF;
END auditoria_memoria;





----------------------------Pruebas-----------------------------------

CALL listado();--Prueba ej.2
SELECT carrerasGanadas('noexiste') FROM DUAL; --Prueba ej 2.1 victorias de cada equipo

INSERT INTO CICLISTAS VALUES (23,'Ramoncin','Rumano',2,NULL);--PruebaS ej.4 trigger 
UPDATE CICLISTAS SET CODEQUIPO=4 WHERE NOMBRE='Ramoncin';--
DELETE FROM CICLISTAS c WHERE NOMBRE='Ramoncin';



INSERT INTO CICLISTAS VALUES(22,'Federico','VieloRuso',5,NULL); --Prueba  ej.3 Trigger 



