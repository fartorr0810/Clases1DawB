/* 1º Almacenar de manera automática en la tabla MICROPROCESADORES_AUDITORIA, los cambios de precios 
que se produzcan en la primera tabla de MICROPROCESADORES, siempre y cuando el nuevo precio de venta 
sea mayor que el valor antiguo. Añadir también un campo fecha con la fecha del sistema en la que se realizó
 el cambio de precio.
 */

CREATE TABLE MICROPROCESADORES 
(
	marca VARCHAR2(50),
	modelo VARCHAR2(50),
	precio_venta NUMBER(6,2),
	PRIMARY KEY(marca, modelo)
);

INSERT INTO MICROPROCESADORES VALUES('Intel','Core i9',999);
INSERT INTO MICROPROCESADORES VALUES('AMD','Ryzen 9 3900',500);
INSERT INTO MICROPROCESADORES VALUES('Intel','Core i7',477);
INSERT INTO MICROPROCESADORES VALUES('AMD','Ryzen 6 3600',200);
INSERT INTO MICROPROCESADORES VALUES('Intel','Core i3',150);

CREATE TABLE MICROPROCESADORES_AUDITORIA
(
	precio_viejo NUMBER(6,2),
	precio_nuevo NUMBER(6,2),
	marca VARCHAR2(50),
	modelo VARCHAR2(50),
	fecha DATE,
	PRIMARY KEY(marca, modelo)
);



/* 1º Almacenar de manera automática en la tabla MICROPROCESADORES_AUDITORIA, los cambios de precios 
que se produzcan en la primera tabla de MICROPROCESADORES, siempre y cuando el nuevo precio de venta 
sea mayor que el valor antiguo. Añadir también un campo fecha con la fecha del sistema en la que se realizó
 el cambio de precio.
 */
CREATE OR REPLACE TRIGGER procesador1 AFTER UPDATE ON MICROPROESADORES FOR EACH ROW 
	BEGIN 
		IF updating('precio_nuevo') THEN 
            IF :OLD.precio>:new.precio then 
			    INSERT INTO MICROPROCESADORES_AUDITORIA (precio_viejo,PRECIO_NUEVO,MARCA,MODELO,FECHA)
			    VALUES (:OLD.precio,:NEW.precio,marca,MODELO,sysdate);
            end if;
		END IF;
END procesador1;

INSERT INTO MICROPROCESADORES VALUES('Intel','Core i9',999);
INSERT INTO MICROPROCESADORES VALUES('AMD','Ryzen 9 3900',500);
INSERT INTO MICROPROCESADORES VALUES('Intel','Core i7',477);
INSERT INTO MICROPROCESADORES VALUES('AMD','Ryzen 6 3600',200);
INSERT INTO MICROPROCESADORES VALUES('Intel','Core i3',150);

UPDATE MICROPROCESADORES 
SET PRECIO_VENTA=1200;
WHERE modelo='Ryzen 9 3900';

select * from MICROPROCESADORES_AUDITORIA;
--Forma 1.
CREATE OR REPLACE TRIGGER procesador1 AFTER UPDATE ON MICROPROCESADORES 
FOR EACH ROW WHEN(old.precio_venta<NEW.precio_venta)
	BEGIN 
		IF updating ('precio_venta') THEN 
			INSERT INTO MICROPROCESADORES_AUDITORIA
			VALUES (:OLD.precio_venta,:NEW.precio_venta,:OLD.marca,:OLD.MODELO,sysdate);
		END IF;
END procesador1;

--Forma 2.
CREATE OR REPLACE TRIGGER procesador1 BEFORE UPDATE of precio_venta ON MICROPROCESADORES 
FOR EACH ROW WHEN(old.precio_venta<NEW.precio_venta)
	BEGIN 
			INSERT INTO MICROPROCESADORES_AUDITORIA
			VALUES (:OLD.precio_venta,:NEW.precio_venta,:OLD.marca,:OLD.MODELO,sysdate);
END procesador1;


