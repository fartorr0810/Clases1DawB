/* 1.Realizar un paquete que contenga todos los procedimientos y funciones que 
se piden en este ejercicio (0,5puntos) */
CREATE OR REPLACE PACKAGE DUMMY.paquete31 IS 
	PROCEDURE listadoPersonajes;
	FUNCTION numpeliculas(nombrepersonaje varchar2) RETURN NUMBER;
END paquete31;

CREATE OR REPLACE PACKAGE BODY paquete31 IS
/*2.Crear un procedimiento para que aparezca un listado de las películas y los
personajes que aparecen en cada película. El procedimiento deberá mostrar la información
en el siguiente formato (3 puntos)*/
CREATE OR REPLACE PROCEDURE DUMMY.LISTADOPERSONAJES IS
	v_codigo_peli	VARCHAR2(30);
CURSOR cursor_peli IS SELECT p.TITULO_P , p.NACIONALIDAD, p.CIP 
						FROM PELICULA p; 
CURSOR cursor_actores IS SELECT p2.NOMBRE_PERSONA , t.tarea
							FROM PERSONAJE p2 , TRABAJO t 
							WHERE p2.NOMBRE_PERSONA =t.nombre_persona AND v_codigo_peli=t.cip;
	BEGIN 
		FOR peli  IN cursor_peli LOOP 
			DBMS_OUTPUT.PUT_LINE('Pelicula: '||peli.titulo_p||' Nacionalidad: '||peli.nacionalidad);
			DBMS_OUTPUT.PUT_LINE('----');
			v_codigo_peli:=peli.cip;
		
			FOR actor IN cursor_actores LOOP 
				dbms_output.put_line('Nombre personaje: '||actor.nombre_persona||' tarea: '||actor.tarea);
			END LOOP;
		
		END LOOP;
	END LISTADOPERSONAJES;
--call paquete31.listapersonajes();
--call listapersonajes31(); --De esta forma la llamo fuera del paquete porque la he ido probando fuera del paquete



	/*3.Crear una función que devuelva el número de películas en las 
	que ha participado un personaje cuyo nombre recibirá por parámetro. Si  
	no existe el personaje o no ha participado en ninguna película deberá generar una excepción 
	(Cada una con un código y un mensaje diferente). (1,5 punto)*/

-- No se hacer bien la consulta pero la logica seria esta. y tambien me da error para el %notfound pero no me da 
--tiempo hacerlo
CREATE OR REPLACE FUNCTION DUMMY.numpeliculas(nombrepersonaje varchar2) RETURN NUMBER IS
	v_pelis_participadas NUMBER;
	v_nombrepersonaje varchar2(30):=nombrepersonaje;
	BEGIN 
		SELECT t.nombre_persona INTO v_pelis_participadas
		FROM PERSONAJE p2 ,TRABAJO t,PELICULA p 
		WHERE p2.nombre_persona=t.nombre_persona AND p.cip=t.cip;
		IF v_nombrepersonaje%NOTFOUND  then 
	        RAISE_APPLICATION_ERROR(-20002,'El actor no existe');
	    END IF;
	   
        IF v_pelis_participadas=0 THEN 
            RAISE_APPLICATION_ERROR(-20004,'El actor no trabaja en ninguna pelicula');
        end if;
	END numpeliculas;
END paquete31;

--select paquete31.numpeliculas('Eren Jagger') from dual;

/* 4.Realiza un trigger o trigger que creas necesario para impedir que un personaje trabaje más
 de una vez en la misma película.Si ya ha trabajado deberá lanzar una exception (2 puntos)
 */
TRIGGER actorjamasrepetirpeli BEFORE INSERT ON TAREA 
FOR EACH ROW 
DECLARE 
	v_numveces	NUMBER;
BEGIN
	SELECT count(p2.nombre_persona)  INTO v_numveces
	FROM PERSONAJE p2 , TRABAJO t ,PELICULA p 
	WHERE p2.NOMBRE_PERSONA = t.nombre_persona AND t.nombre_persona=:NEW.nombrepersona;
	IF v_numveces>1 THEN 
		raise_application_error(-20002,'No puede trabajar mas de una vez en la misma peli')
END actorjamasrepetirpeli;

/*5.Crear un trigger para que cuando se inserte un personaje el nombre siempre se inserte en mayúsculas. (1 punto)*/
CREATe OR REplace TRIGGER siempremayus after insert on PERSONAJE
for each row
	BEGIN 
	IF inserting THEN
        update personaje 
        set nombre_persona=upper(nombre_persona)
        where nombre_persona!=:NEW.nombre_persona;
		--:new.nombre_persona=upper(:new.nombre_persona);
    end if;
end siempremayus;

INSERT 
  INTO Personaje (nombre_persona,nacionalidad_persona,
       sexo_persona)
  VALUES ('jagger','EE.UU','M');
--Me da un error de tabla mutante.


 /*6.Crea una tabla llamada log con un único campo de tipo varchar llamado descripcion y 
 realizar un trigger o los trigger que creas necesario para las modificaciones que sufre 
 la tabla personaje. Debe registrarse “Elusuario nombreUsuario en la fecha fechamodificó el personaje 
 nombre_personaje” pudiendo ser modificó, inserto o eliminó. (2 puntos) */

 --No la llamo log porque es una palabra registrada del sistema 
CREATE TABLE registro (descrip varchar2(200));


CREATE OR REPLACE TRIGGER controlCambios AFTER INSERT OR DELETE OR UPDATE ON PERSONAJE
	FOR EACH ROW
		BEGIN 
		IF updating ('NOMBRE_PERSONA') THEN
			INSERT INTO registro (DESCRIP)
			VALUES ('El usuario : '||USER||' en la fecha '||SYsdate||' modifico el personaje: '||:new.nombre_persona);
		END IF;
		IF updating ('NACIONALIDAD') THEN
			INSERT INTO registro (DESCRIP)
			VALUES ('El usuario : '||USER||' en la fecha '||SYsdate||' modifico el personaje: '||:new.nombre_persona);
		END IF;
		IF updating ('SEXO_PERSONA') THEN
			INSERT INTO registro (DESCRIP)
			VALUES ('El usuario : '||USER||' en la fecha '||SYsdate||' modifico el personaje: '||:NEW.nombre_persona);
        end if;
		IF deleting THEN
			INSERT INTO registro (DESCRIP)
			VALUES ('El usuario : '||USER||' en la fecha '||SYsdate||' elimino del personaje: '||:old.nombre_persona);
        end if;
		IF inserting THEN
			INSERT INTO registro (DESCRIP)
			VALUES ('El usuario : '||USER||' en la fecha '||SYsdate||' inserto el personaje: '||:new.nombre_persona);
		END IF;
END controlCambios;
