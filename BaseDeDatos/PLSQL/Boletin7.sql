
/* .7.1. Crea un trigger que, cada vez que se inserte o elimine un empleado, 
registre una entrada en la tabla AUDITORIA_EMPLEADOS con la fecha del suceso, número 
 y nombre de empleado, así como el tipo de operación realizada (INSERCIÓN o ELIMINACIÓN).*/
CREATE OR REPLACE TRIGGER tigre1 AFTER INSERT OR DELETE ON EMPLEADOS
	FOR EACH ROW
		BEGIN 
			IF inserting THEN
				INSERT INTO AUDITORIA_EMPLEADOS (DESCRIPCION)
				VALUES (SYSDATE||:NEW.NUMEM||:NEW.nomem||" tipo:INSERCION");
			END IF;
			IF deleting THEN
				INSERT INTO AUDITORIA_EMPLEADOS (DESCRIPCION)
				VALUES (SYSDATE||:OLD.NUMEM||:OLD.nomem||" tipo:DELETING");
			END IF;
		END tigre1;
		
INSERT INTO EMPLEADOS (*)
VALUES (121,123,sysdate,sysdate,231,123,2,'juabn',100);
SELECT *
FROM CONTROLCAMBIOS c ;
/* 5.7.2. Crea un trigger que, cada vez que se modi(quen datos de un empleado, registre una 
entrada en la tabla AUDITORIA_EMPLEADOS con la fecha del suceso, valor antiguo y valor nuevo 
de cada campo, así como el tipo de operación realizada (en este caso MODIFICACIÓN).
 */
create or replace trigger insertarEmpl after update on EMPLEADOS for each row
    begin
       if updating ('NUMEM') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.numem || ', ' || :NEW.NUMEM || ', ' || 'MODIFICACION'));
         end if;
        IF UPDATING ('EXTEL') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.EXTEL || ', ' || :NEW.EXTEL || ', ' || 'MODIFICACION'));
        end if;
        IF UPDATING ('FECNA') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.FECNA || ', ' || :NEW.FECNA || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('FECIN') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.FECIN || ', ' || :NEW.FECIN || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('SALAR') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.SALAR || ', ' || :NEW.SALAR || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('COMIS') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.COMIS || ', ' || :NEW.COMIS || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('NUMHI') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.NUMHI || ', ' || :NEW.NUMHI || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('NOMEM') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.NOMEM || ', ' || :NEW.NOMEM || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('NUMDE') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.NUMDE || ', ' || :NEW.NUMDE || ', ' || 'MODIFICACION'));
        end if;

    end;
/* 5.7.3. Crea un trigger para que registre en la tabla AUDITORIA_EMPLEADOS las subidas
de salarios superiores al 5%. */