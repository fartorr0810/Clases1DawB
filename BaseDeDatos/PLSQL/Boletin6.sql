/* --1.Creamos  un  disparador  que  se  active  cuando  modificamos  algún  campo 
--de "empleados" y almacene en "controlCambios" el nombre del usuario que realiza 
--la actualización, la fecha, el datoque se cambia y el nuevo valor. */
CREATE OR REPLACE TRIGGER controlCambios AFTER INSERT OR DELETE OR UPDATE ON EMPLEADOS
	FOR EACH ROW
		BEGIN 
		IF updating ('DOCUMENTOS') THEN
			INSERT INTO CONTROLCAMBIOS (USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
			VALUES (USER,SYSDATE,:OLD.DOCUMENTO,:NEW.DOCUMENTO);
		END IF;
		IF updating ('NOMBRE') THEN
			INSERT INTO CONTROLCAMBIOS (USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
			VALUES (USER,SYSDATE,:OLD.NOMBRE,:NEW.NOMBRE);
		END IF;
		IF updating ('DOMICILIO') THEN
			INSERT INTO CONTROLCAMBIOS (USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
			VALUES (USER,SYSDATE,:OLD.DOMICILIO,:NEW.DOMICILIO);
		END IF;
		IF updating ('SECCION') THEN
			INSERT INTO CONTROLCAMBIOS (USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
			VALUES (USER,SYSDATE,:OLD.SECCION,:NEW.SECCION);
		END IF;
END controlCambios;

UPDATE EMPLEADOS 
SET empleados.NOMBRE = 'MANOLITO GAFOTAS'
WHERE nombre = 'Carlos Caseres';

SELECT *
FROM CONTROLCAMBIOS c ;

/* 2.Creamos  otro  desencadenador  que  se  active  cuando  ingresamos  un  
nuevo registro  en  "empleados",  debe  almacenar  en  "controlCambios"  el  nombre  del usuario 
que  realiza  el  ingreso,  la  fecha,  "null"  en  "datoanterior"  (porque  se dispara con una inserción) 
y en "datonuevo" el documento.
 */
CREATE OR REPLACE TRIGGER controlCambioEjer2 AFTER INSERT OR DELETE OR UPDATE ON EMPLEADOS
	FOR EACH ROW
		BEGIN 
			IF inserting THEN
				INSERT INTO CONTROLCAMBIOS (USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
				VALUES (USER,sysdate ,NULL,:NEW.DOCUMENTO);
			END IF;
		END controlCambiosEjer2;
		
insert into empleados values('12321123','CHIQUILICUATRE','EL PULSAITO','MUSICO');

SELECT *
FROM CONTROLCAMBIOS c ;

/* 
3.Creamos un tercer trigger sobre "empleados" que se active cuando eliminamos un registro en
 "empleados", debe almacenar en "controlCambios" el nombre del usuario  que  realiza  la  eliminación, 
  la  fecha,  el  documento  en  "datoanterior"  y "null" en "datonuevo":
 */
CREATE OR REPLACE TRIGGER controlCambioEjere AFTER INSERT OR DELETE OR UPDATE ON EMPLEADOS
	FOR EACH ROW
		BEGIN 
			IF deleting THEN
				INSERT INTO CONTROLCAMBIOS (USUARIO,FECHA,DATOANTERIOR,DATONUEVO)
				VALUES (USER,sysdate,:NEW.DOCUMENTO,null);
			END IF;
		END controlCambiosEjer3;
		
DELETE FROM EMPLEADOS e 
WHERE e.NOMBRE='CHIQUILICUATRE';
	
SELECT *
FROM CONTROLCAMBIOS c ;










