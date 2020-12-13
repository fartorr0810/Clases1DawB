--Ejercicio 1
INSERT INTO EMPLEADOS
(DNI, NOMBRE, APELLIDO1, APELLIDO2, DIRECC1, DIRECC2, CIUDAD, MUNICIPIO, COD_POSTAL, SEXO, FECHA_NAC)
VALUES (12345678, 'PACO', 'ARROYO', 'DELATORRE', 'C/SANLAZARO', 'C/SANCASTOR', 'El Priorato', 1, 'M', 20001008);

INSERT INTO EMPLEADOS
(DNI, NOMBRE, APELLIDO1, APELLIDO2, DIRECC1, DIRECC2, CIUDAD, MUNICIPIO, COD_POSTAL, SEXO, FECHA_NAC)
VALUES (12345679, 'PACA', 'ARROYO', 'DELATORRE', 'C/SANLAZARO', 'C/SANCASTOR', 'El Priorato', 2, 'F', 20001008);

INSERT INTO EMPLEADOS
(DNI, NOMBRE, APELLIDO1, APELLIDO2, DIRECC1, DIRECC2, CIUDAD, MUNICIPIO, COD_POSTAL, SEXO, FECHA_NAC)
VALUES (12345670, 'PACAA', 'ARROYO', 'DELATORRE', 'C/SANLAZARA', 'C/SANCASTAR', 'El Priorata', 3, 'F', 20001028);


INSERT INTO DEPARTAMENTOS
(DPTO_COD, NOMBRE_DPTO, JEFE, PRESUPUESTO, PRES_ACTUAL)
VALUES (1, 'Chorizo', 1, 1232320, 123213);

INSERT INTO DEPARTAMENTOS
(DPTO_COD, NOMBRE_DPTO, JEFE, PRESUPUESTO, PRES_ACTUAL)
VALUES (2, 'QUESO', 2, 12323299, 1232132);

INSERT INTO DEPARTAMENTOS
(DPTO_COD, NOMBRE_DPTO, JEFE, PRESUPUESTO, PRES_ACTUAL)
VALUES (3, 'TORTILLA', 3, 1232320121, 12983);

INSERT INTO UNIVERSIDADES
(univ_cod, nombre_univ, ciudad, municipio, cod_postal)
VALUES (1, 'Pablo lavide', 'Sevilla', 'ES', 12345);

INSERT INTO UNIVERSIDADES
(univ_cod, nombre_univ, ciudad, municipio, cod_postal)
VALUES (2, 'UAV', 'Madrid', 'MD', 12341);

INSERT INTO UNIVERSIDADES
(univ_cod, nombre_univ, ciudad, municipio, cod_postal)
VALUES (3, 'POLITECNICA', 'Oviedo', 'OV', 12245);

INSERT INTO estudios
(empleado_dni, universidad, ano, grado, especialidad)
VALUES (12345678, 1, 2010, 'SUP', 'Desarrollo Web')

INSERT INTO estudios
(empleado_dni, universidad, ano, grado, especialidad)
VALUES (12345679, 2, 2020, 'MED', 'Desarrollo MUL')

INSERT INTO estudios
(empleado_dni, universidad, ano, grado, especialidad)
VALUES (12345670, 3, 2010, 'SUP', 'Desarrollo Web')

INSERT INTO TRABAJOS
(trabajo_cod, nombre_trab, salario_min, salario_max)
VALUES (123, 'Programador', 10, 15)

INSERT INTO TRABAJOS
(trabajo_cod, nombre_trab, salario_min, salario_max)
VALUES (122, 'Analista', 12, 18)

INSERT INTO TRABAJOS
(trabajo_cod, nombre_trab, salario_min, salario_max)
VALUES (121, 'Dependiente', 8, 12)

INSERT INTO HISTORIAL_LABORAL
(EMPLEADO_DNI, TRAB_COD, FECHA_INICIO, FECHA_FIN, DPTO_COD, SUPERVISOR_DNI)
VALUES (12345678, 123, 20100023, 20121023, 1, 12345670)

INSERT INTO HISTORIAL_LABORAL
(EMPLEADO_DNI, TRAB_COD, FECHA_INICIO, FECHA_FIN, DPTO_COD, SUPERVISOR_DNI)
VALUES (12345679, 122, 20110023, 20131023, 2, 12345670)


INSERT INTO HISTORIAL_LABORAL
(EMPLEADO_DNI, TRAB_COD, FECHA_INICIO, FECHA_FIN, DPTO_COD, SUPERVISOR_DNI)
VALUES (12345670, 121, 20100223, 20151023, 3, 12345670)


INSERT INTO HISTORIAL_SALARIA
(EMPLEADO_DNI, SALARIO, FECHA_COMIENZO, FECHA_FIN)
VALUES (12345678, 1300, 20100023, 20130123)

INSERT INTO HISTORIAL_SALARIA
(EMPLEADO_DNI, SALARIO, FECHA_COMIENZO, FECHA_FIN)
VALUES (12345679, 1500, 20110023, 20130123)

INSERT INTO HISTORIAL_SALARIA
(EMPLEADO_DNI, SALARIO, FECHA_COMIENZO, FECHA_FIN)
VALUES (12345670, 1300, 20100223, 20190123)
--Ejercicio 2
INSERT INTO EMPLEADOS 
(nombre, apellido1, apellido2, dni, sexo )
VALUES 
(‘SERGIO’, ’PALMA’, ’ENTRENA’, ’111222’, ’P’) ;

#el valor del campo SEXO “P”  no se añadirá a la base de datos porque hay una restricción de que el valor del campo debe ser F o M. 
Para poder insertarlo debería poner el dato ‘M’ en el campo sexo.

INSERT INTO EMPLEADOS
(nombre, apellido1, apellido2, dni, sexo)
VALUES 
(‘LUCIA’, ’ORTEGA’, ’PLUS’, ’222333’, NULL) ;

#el campo SEXO no puede estar vacío (null) dado que existe una restricción para los valores de este campo que lo delimitan a F o M. 
Para poder insertarlo debería poner el dato ‘F’ en el campo sexo.

    INSERT INTO HISTORIAL_LABORAL
    (EMPLEADO_DNI, TRAB_COD, FECHA_INICIO, FECHA_FIN, DPTO_COD, SUPERVISOR_DNI)
    VALUES
    (111222, ‘NULL’,  ‘16-JUN-1996’, ‘NULL’, ‘NULL’, 222333)

#el campo TRAB_COD no puede quedar vacío porque es clave ajena que referencia a la tabla TRABAJOS; al igual que el campo DPTO_COD, el cual tampoco puede tomar el valor null porque es una clave ajena que referencia a la tabla DEPARTAMENTOS. Además estos dos datos son los que forman la clave primaria esta tabla (HISTORIAL LABORAL) por lo que sus campos no pueden tomar valor null.

--Ejercicio 3
--Nos daría un error porque el campo DNI-SUPERVISOR es una clave ajena de la tabla HISTORIAL_LABORAL que hace referencia a la tabla EMPLEADOS.
--Haciendo eso se viola la segunda regla de integridad que se aplica a las claves ajenas (si en una relación hay alguna clave ajena, sus valores deben coincidir con valores de la clave primaria a la que hace referencia, o bien, deben ser completamente nulos).

--Ejercicio 4
--No se puede borrar una universidad en la que su código haya sido utilizado como clave ajena de la tabla ESTUDIOS porque existe una restricción de que la tabla ESTUDIOS tiene como clave ajena el UNIV_COD.

--Ejercicio 5

ALTER TABLE EMPLEADOS ADD CONSTRAINT FECHA_NAC (DATE)  NOT NULL
--Con las tuplas introducidas (...)

--Ejercicio 6
INSERT INTO EMPLEADOS 
(DNI, NOMBRE, APELLIDO1, APELLIDO2, DIRECC1,  DIRECC2, CIUDAD, MUNICIPIO, COD_POSTAL, SEXO, FECHA_NAC)
VALUES (2653214, ‘JULIÁN’, ‘MARTÍN’, ‘ORTEGA’, ‘VELÁZQUEZ,7’, ‘NULL’, ‘SEVILLA’, ‘LA ALGABA’, 41023, ‘M’, ‘19-02-81’)

--Ejercicio 7
ALTER TABLE EMPLEADOS MODIFY FECHA_NAC VARCHAR2(20)

--Ejercicio 8

DELETE FROM EMPLEADOS
WHERE DNI==12345670
--Como no esta el borrado en cascada en el script de creacion, este empleado
--no se puede eliminar, ya que de este depende otras tablas

--Ejercicio 9
CREATE TABLE INFORMACION_UNIVERSITARIA (
	NOMBRE	VARCHAR2(10) REFERENCES EMPLEADOS,
	APELLIDO1	VARCHAR2(15) REFERENCES EMPLEADOS,
	APELLIDO2	VARCHAR2(15) REFERENCES EMPLEADOS,
	univ_cod	NUMBER(5) REFERENCES estudios
);
--Ejercicio 10
CREATE TABLE Nombre_Empleados(
	NOMBRE	VARCHAR2(10) REFERENCES EMPLEADOS,
	APELLIDO1	VARCHAR2(15) REFERENCES EMPLEADOS,
	APELLIDO2	VARCHAR2(15) REFERENCES EMPLEADOS,
	CIUDAD VARCHAR2(20) CHECK (UPPER.CIUDAD='MALAGA')
);
--Ejercicio 11
CREATE TABLE INFORMACION_EMPLEADO (
	NOMBRE	VARCHAR2(10) REFERENCES EMPLEADOS,
	APELLIDO1	VARCHAR2(15) REFERENCES EMPLEADOS,
	APELLIDO2	VARCHAR2(15) REFERENCES EMPLEADOS,
	FECHA_NAC	DATE,
	idInformacionempleado	number(5) PRIMARY KEY
	);
--Eso es PL/SQL para calcular la edad , no lo hemos dado.
--Ejercicio 12
CREATE TABLE INFORMACION_ACTUAL (
	idInformacionempleado	number(5) REFERENCES INFORMACION_EMPLEADO,
	salario_max	number(2) REFERENCES TRABAJOS
);
--Ejercicio 13
ALTER TABLE DEPARTAMENTOS ADD (coste_salarial	number(2) REFERENCES INFORMACION_ACTUAL);
--Otra vez igual con consultas y pl/sql

--Ejercicio 14
ALTER TABLE UNIVERSIDADES ADD (num_alums	number(2) REFERENCES estudios)
--Mas de lo mismo :( )

--Ejercicio 15
CREATE TABLE EMPLEADOS_Dinero_Ganado (
	NOMBRE	VARCHAR2(10) REFERENCES EMPLEADOS,
	APELLIDO1	VARCHAR2(15) REFERENCES EMPLEADOS,
	APELLIDO2	VARCHAR2(15) REFERENCES EMPLEADOS,
	Dineroganado 	NUMBER(10) REFERENCES HISTORIAL_LABORAL
);
--Tampoco :( )