--Crear un trigger para que cuando se inserte un personaje el nombre siempre se 
--inserte en mayúsculas. (1 punto)
CREATE OR REPLACE TRIGGER ponermayus BEFORE INSERT OR UPDATE ON ciclista FOR EACH ROW
BEGIN
	:NEW.nombre:=UPPER(:NEW.nombre;)
END ponermayus;

/* Crear un procedimiento para que aparezca un listado de las películas y los personajes que aparecen en
cada película. El procedimiento deberá mostrar la información en el siguiente formato (3 puntos)
Película: títuloNacionalidad: nacionalidad
** Nombre personaje Tarea: tarea
** Nombre personaje Tarea: tarea
** Nombre personaje Tarea: 
tareaTotal de personajes: 3
...................................................
Película: títuloNacionalidad: nacionalidad
** Nombre personaje Tarea: tarea
** Nombre personaje Tarea: tarea
.........................................
** Nombre personaje Tarea: tareaTotal de personajes: x */
CREATE OR REPLACE PROCEDURE listadoequiposciclistas IS
	nombreequipo	varchar2(30);
	contadorciclista NUMBER:=0;
	CURSOR cursor_equipo IS SELECT e.NOMEQ , e.DESCRIPCION 
								FROM equipo e;
	CURSOR cursor_ciclista IS SELECT c.NOMBRE,c.EDAD ,c.DORSAL FROM CICLISTA c,EQUIPO e 
								WHERE c.NOMEQ=e.NOMEQ AND c.NOMEQ=nombreequipo;
BEGIN
	FOR equipo IN cursor_equipo LOOP 
		DBMS_OUTPUT.PUT_LINE('Equipo: '||equipo.nomeq||' Descripcion: '||equipo.descripcion);
			DBMS_OUTPUT.PUT_LINE('----');
			nombreequipo:=equipo.nomeq;
		FOR ciclista IN cursor_ciclista LOOP 
			dbms_output.put_line('Nombre: '||ciclista.nombre||' Edad: '||ciclista.edad||' Dorsal: '||ciclista.dorsal);
			contadorciclista:=contadorciclista+1;
			END LOOP;
		dbms_output.put_line('------- Total ciclista: '||contadorciclista);
		contadorciclista:=0;
		END LOOP;
END listadoequiposciclistas;

CALL LISTADOEQUIPOSCICLISTAS();

/* Realiza un trigger o trigger que creas necesario para impedir que un equipo no haya mas
 * de 7 ciclista en la misma película.Si ya ha trabajado deberá lanzar 
una exception  */

TRIGGER unciclistaunequipo BEFORE INSERT ON ciclista FOR EACH ROW
DECLARE 
	numciclista NUMBER;
BEGIN 
	SELECT count(*) INTO numciclista  FROM CICLISTA c WHERE c.NOMEQ=:NEW.nomeq;
	IF numciclista>=7 THEN 
		RAISE_APPLICATION_ERROR(-20001,'Solo puede haber 7 ciclistas por equipo');
	END IF;
END unciclistaunequipo;

INSERT INTO CICLISTA VALUES (52,'Juan Perea',43,'Amore Vita');
DELETE FROM CICLISTA c WHERE DORSAL=52;
CALL LISTADOEQUIPOSCICLISTAS() ;



/* 2.Crear una función que devuelva el número de carreras que hań ganado los corredores de un equipo. 
Elnombre del equipo se le pasará por parámetro. Si  no existe el equipo deberá generar una excepción. 
(1punto)
 */
CREATE OR REPLACE FUNCTION DUMMY.numetapasganadas(nombreequipo varchar2) RETURN NUMBER IS 
	numcarrerasganadas NUMBER;
	CURSOR c_cilista IS SELECT c.NOMEQ,c.dorsal FROM CICLISTA c WHERE c.NOMEQ=nombreequipo;
	CURSOR c_etapas IS SELECT e.DORSAL FROM ETAPA e;
	contadorcarreras NUMBER:=0;
BEGIN 
		FOR etapas IN c_etapas LOOP
			FOR cilista IN c_cilista LOOP
				IF etapas.dorsal=cilista.dorsal THEN 
					contadorcarreras:=contadorcarreras+1;
				END IF;
			END LOOP;
		END LOOP;
RETURN contadorcarreras;
END numetapasganadas;

SELECT numetapasganadas('Navigare') FROM dual;

CALL LISTADOEQUIPOSCICLISTAS() ;

SELECT e.DORSAL FROM ETAPA e,CICLISTA c ,EQUIPO e2 WHERE e2.NOMEQ=c.NOMEQ AND c.DORSAL=e.DORSAL ;







