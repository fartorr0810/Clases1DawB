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