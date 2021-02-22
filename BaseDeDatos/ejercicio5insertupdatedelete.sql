--1.Vamos a crear una nueva tabla en la que tengamos el nombre del cliente 
--y todo lo gastado por cada cliente,
--por lo que vamos a crear la tabla y rellenarlas con los datos adecuados.
CREATE TABLE Gastados(
	NOMBRE	VARCHAR2(50),
	dinerogastado	number(12)
);

INSERT INTO GASTADOS (nombre, dinerogastado)
	SELECT c.NOMBRE ,SUM(lf.PRECIO)
	FROM CLIENTES c,FACTURAS f ,LINEAS_FAC lf 
	WHERE c.CODCLI =f.CODCLI AND f.CODFAC =lf.CODFAC 
	GROUP BY c.NOMBRE;

SELECT *
FROM GASTADOS;

--2.Vamos a borrar la tabla anterior, y rellenar los datos, pero sólo para
--aquellos clientes que hayan tenido tres o más facturas.
DROP TABLE GASTADOS;

CREATE TABLE Gastados(
	NOMBRE	VARCHAR2(50),
	dinerogastado	number(12)
);

INSERT INTO GASTADOS (nombre, dinerogastado)
	SELECT c.NOMBRE ,SUM(lf.PRECIO)
	FROM CLIENTES c,FACTURAS f ,LINEAS_FAC lf
	WHERE c.CODCLI =f.CODCLI AND f.CODFAC =lf.CODFAC
	GROUP BY c.NOMBRE
	HAVING COUNT(f.codfac)>3;
--3.Vamos a añadir en provincias un nuevo campo en el que 
--guardaremos el número de pueblos que tiene cada provincia, 
--Rellena el nuevo campo de la tabla
ALTER TABLE PROVINCIAS ADD (numeropueblos	number);

UPDATE PROVINCIAS SET NUMEROPUEBLOS =(
SELECT count(p.CODPUE)
FROM PUEBLOS p,PROVINCIAS p2
WHERE p.CODPRO =p2.CODPRO AND p2.CODPRO =p.CODPRO 
GROUP BY p2.CODPRO);
