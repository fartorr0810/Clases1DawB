--Me ha salido todo mal y me encuentro muy mal ,estoy tomando pastillas para el dolor de cabeza porque llevo asi desde
--ayer y no se me pasa y no me deja concentrarme ni estar bien
--El examen me ha salido fatal. 
--Lo siento mucho..
-- 



--1.Realizar un paquete que contenga todos los procedimientos y funciones
--que se piden en este ejercicio (1punto)
CREATE OR REPLACE PACKAGE DUMMY.EXAMEN IS 
VERSION NUMBER:=1.0;
PROCEDURE Listado;
FUNCTION Ejercicio2Listado(nombreequipo varchar2) RETURN NUMBER;
END Examen;

--2.Realiza un procedimiento llamado listado muestre todos los equipos y el número de
--jugadores quepertenecen a cada equipo con el siguiente formato (3 puntos)
CREATE OR REPLACE PACKAGE BODY EXAMEN IS 
CREATE OR REPLACE PROCEDURE DUMMY.Listado IS 
	CURSOR c1 
	IS 	
		SELECT e.NOMBRE ,e.NACIONALIDAD ,e.NOMBREDIRECTOR 
		FROM EQUIPOS e;
	v_nombreequipo EQUIPOS.nombre%TYPE;
	v_nacionalidad EQUIPOS.nacionalidad%TYPE;
	v_nombredirector EQUIPOS.nombredirector%TYPE;
	v_equipos c1%ROWTYPE;
	BEGIN
		OPEN c1;
			WHILE c1%FOUND LOOP 
				DBMS_OUTPUT.PUT_LINE('NombreEquipo'||v_equipos.nombre||'nacionalidad'||v_equipos.nacionalidad||'Y el director'||v_equipos.nombredirector);
				FETCH c1 INTO v_equipos;
			END LOOP;
		CLOSE c1;
	END listado;
--2.Realiza un trigger que impida que haya más de cuatro ciclistas en un equipo. 
--Si hay 4 no se podráninsertar más ciclistas por lo que deberá lanzar una excepción (2 puntos)
CREATE OR REPLACE TRIGGER ejercicio2 BEFORE 
update on CICLISTA
	for each ROW IS
	numporequipo NUMBER:=SELECT count(e.CODEQUIPO)
							FROM EQUIPOS e ,CICLISTAS c2 
							WHERE e.CODEQUIPO =c2.codequipo;
BEGIN 
	IF inserting AND numporequipo>4  THEN
		RAISE_APPLICATION_ERROR(-20005,'Estoy cansado de vivir');
END ejercicio2;






	
