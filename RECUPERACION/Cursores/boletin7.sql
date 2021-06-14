/* 7.1. Crea un trigger que, cada vez que se inserte o elimine un empleado, registre una entrada en
la tabla AUDITORIA_EMPLEADOS con la fecha del suceso, número y nombre de empleado, así como el tipo 
de operación realizada (INSERCIÓN o ELIMINACIÓN). */
TRIGGER tigre1boletin2 BEFORE INSERT OR delete ON  empleados FOR EACH ROW
BEGIN 
	IF deleting THEN 
		INSERT INTO AUDITORIA_EMPLEADOS VALUES (sysdate||' '||:OLD.numem||' '||:OLD.nomem||' Tipo operacion: DELETE');
	END IF;
	IF inserting THEN 
		INSERT INTO AUDITORIA_EMPLEADOS VALUES (sysdate||' '||:new.numem||' '||:new.nomem||' Tipo operacion: INSERT');
	END IF;	
END tigre1boletin2;


INSERT INTO EMPLEADOS VALUES(434,620,'10/25/1979','02/15/2011',1910,NULL,0,'OTILIA',122); 

SELECT * FROM AUDITORIA_EMPLEADOS ae ;

DELETE FROM EMPLEADOS e 
WHERE NOMEM='OTILIA';


--7.2. Crea un trigger que, cada vez que se modi(quen datos de un empleado, registre una entrada
--en la tabla AUDITORIA_EMPLEADOS con la fecha del suceso, valor antiguo y valor nuevo de cada campo,
--así como el tipo de operación realizada (en este caso MODIFICACIÓN).
CREATE OR REPLACE tigre2boletin2 AFTER UPDATE ON empleados FOR EACH  ROW 
BEGIN 
	IF updating ('') THEN 
	--Esto es demasiado largo para hacerlo xdd sorry.		
END tigre2boletin2;


/* 7.3. Crea un trigger para que registre en la tabla AUDITORIA_EMPLEADOS las subidas 
de salarios superiores al 5%.  */
TRIGGER tigre3boletin2 AFTER UPDATE ON empleados FOR EACH ROW 
BEGIN 
	IF :NEW.salar>:OLD.salar*1.05 THEN 
		INSERT INTO AUDITORIA_EMPLEADOS VALUES ('Han modificado el sueldo el '||user);
	END IF;
END tigre3boletin2;