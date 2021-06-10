/* 1.Creamos  un  disparador  que  se  active  cuando  modificamos  algún  campo  de "empleados" y 
almacene 
en "controlCambios" el nombre del usuario que realiza la actualización, la fecha, el datoque se cambia y
el nuevo valor.
 */
TRIGGER tigre1 BEFORE UPDATE ON Empleados FOR EACH ROW 
BEGIN 
	IF updating ('DOCUMENTO')THEN 
		INSERT INTO CONTROLCAMBIOS(USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
		VALUES (USER,sysdate,:OLD.documento,:NEW.documento);
	END IF;
	IF updating ('NOMBRE')THEN 
		INSERT INTO CONTROLCAMBIOS(USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
		VALUES (USER,sysdate,:OLD.nombre,:NEW.nombre);
	END IF;
	IF updating ('DOMICILIO')THEN 
		INSERT INTO CONTROLCAMBIOS(USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
		VALUES (USER,sysdate,:OLD.domicilio,:NEW.domicilio);
	END IF;
	IF updating ('SECCION')THEN 
		INSERT INTO CONTROLCAMBIOS(USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
		VALUES (USER,sysdate,:OLD.seccion,:NEW.seccion);
	END IF;
END tigre1;

/* 2.Creamos  otro  desencadenador  que  se  active  cuando  ingresamos  un  nuevo registro 
en  "empleados",  debe  almacenar  en  "controlCambios"  el  nombre  del usuario  que  realiza  
el  ingreso, la  fecha,  "null"  en  "datoanterior"  (porque  se dispara con una inserción) y en
 "datonuevo" el documento.
 */
CREATE OR REPLACE TRIGGER tigre2 AFTER INSERT ON empleados FOR EACH ROW
BEGIN 
	IF inserting THEN 
		INSERT INTO CONTROLCAMBIOS 
		VALUES(USER,sysdate,NULL,:NEW.documento);
	END IF;
END tigre2;

/* 3.Creamos un tercer trigger sobre "empleados" que se active cuando eliminamos un registro en "empleados",
debe almacenar en "controlCambios" el nombre del usuario  que  realiza  la  eliminación,  la  fecha,  el
documento  en  "datoanterior"  y "null" en "datonuevo":
 */
TRIGGER tigre3 BEFORE DELETE ON empleados FOR EACH ROW 
BEGIN 
	IF deleting THEN 
		INSERT INTO CONTROLCAMBIOS VALUES (USER,sysdate,:OLD.documento,null);
	END IF;
END tigre3;

--4.Los  tres  triggers  están  habilitados.  Consultamos  el  diccionario
--"user_triggers" para corroborarlo:
SELECT * FROM user_triggers WHERE status='ENABLED';
-/* 5.Vamos a ingresar un empleado y comprobar que el trigger "tr_ingresar_empleados" se dispara 
recuperando los registros de "controlCambios".
 */
INSERT INTO EMPLEADOS VALUES ('asereje','Juanito','San Jernonimo','Informatica');

SELECT * FROM CONTROLCAMBIOS c ;


--6.Deshabilitamos el trigger "tr_ingresar_empleados"
ALTER TRIGGER tigre2 disable;

--7.Consultamos el diccionario "user_triggers" para corroborarlo.
SELECT * FROM user_triggers WHERE status='DISABLED';

/* 8.Vamos  a  ingresar  un  empleado y  comprobar  que  el  trigger  de  inserción  no  se dispara
recuperando los registros de "controlCambios".
 */
INSERT INTO EMPLEADOS VALUES ('malan','Fernandito','Malamanera','Informatica');
SELECT * FROM CONTROLCAMBIOS c 
/* 9.Vamos a actualizar el domicilio de un empleado y comprobar que el trigger de
actualización se dispara recuperando los registros de "controlCambios".
 */
UPDATE EMPLEADOS 
SET DOMICILIO='Manito'
WHERE DOMICILIO='Malamanera';
SELECT * FROM CONTROLCAMBIOS c ;
/* 10.Deshabilitamos el trigger "tr_actualizar_empleados".*/
ALTER TRIGGER tigre1 disable


/* 11.Consultamos el diccionario "user_triggers" para corroborarlo.
 */
SELECT * FROM user_triggers WHERE status='DISABLED';

/* 12.Los triggers "tr_ingresar_empleados" y "tr_actualizar_empleados" están deshabilitados,
"tr_eliminar_empleados" está habilitado.
 */

/* 13.Vamos  a  borrar  un  empleado  de  "empleados"  y  comprobar  que  el  trigger 
de borrado se disparó recuperando los registros de "controlCambios"
 */
DELETE FROM EMPLEADOS  
WHERE NOMBRE='Fernandito';

SELECT * FROM CONTROLCAMBIOS c 
/* 14.Deshabilitamos el trigger "tr_eliminar_empleados".
 */
ALTER TRIGGER tigre3 disable;

/* 15.Consultamos el diccionario "user_triggers" para comprobarlo.
 */
SELECT * FROM user_triggers WHERE status='DISABLED';
/* 16.Los tres trigger establecidos sobre "empleados" están deshabilitados.
 */
/* 17.Eliminamos  un  empleado  de  "empleados"  y  comprobamos  que  el  trigger  de 
borrado no se dispara recuperando los registros de "controlCambios".*/
DELETE FROM EMPLEADOS  
WHERE DOCUMENTO='asereje';
/* 18.Habilitamos el trigger "tr_actualizar_empleados".
 */
ALTER TRIGGER tigre2 enable;

/* 19.Actualizamos  la  sección  de  un  empleado  y  comprobamos  que  el  trigger 
de actualización se dispara recuperando los registros de "controlCambios".
 */
UPDATE EMPLEADOS 
SET DOMICILIO='Manito'
WHERE DOMICILIO='Malamanera';
SELECT * FROM CONTROLCAMBIOS c ;

/* 20.Habilitamos todos los triggersestablecidos sobre "empleados". */
ALTER TABLE empleados enable all triggers;