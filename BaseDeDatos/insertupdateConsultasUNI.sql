--1. Añade un campo en la tabla profesor para almacenar las asignaturas que imparte cada uno. 
--Rellena este campo con los datos existentes.
ALTER TABLE PROFESOR ADD (asignatura    VARCHAR2(30));

UPDATE PROFESOR p1
SET ASIGNATURA=(SELECT a2.NOMBRE 
        FROM ASIGNATURA a2,PROFESOR p 
        WHERE a2.IDPROFESOR=p.IDPROFESOR AND p1.IDPROFESOR=p.IDPROFESOR);

SELECT *
FROM PROFESOR p 
--2. Crea una nueva tabla en la que guardaremos el nombre del profesor y 
--el número de alumnos que tiene cada profesor. Rellena la tabla con los datos existentes.
CREATE TABLE PROFESORALUMS AS profesoralum(
SELECT p.NOMBRE 
FROM PROFESOR p2 ,PERSONA p 
WHERE p.DNI =p2.DNI, 
SELECT COUNT(a.IDALUMNO)
FROM ALUMNOS a
);
       

       
--3. Crea un nuevo campo en la tabla asignatura para 
--guardar el nombre de la titulación a la que pertenece.
-- Rellena el campo con los datos existentes.
ALTER TABLE ASIGNATURA ADD (nombretitulo    VARCHAR2(30));
UPDATE ASIGNATURA a
SET nombretitulo=(SELECT t2.NOMBRE 
                    FROM TITULACION t2 
                    WHERE t2.IDTITULACION=a.IDTITULACION);
       
--4. Borra las personas que no sean ni alumnos ni profesores.
DELETE FROM PERSONA p 
WHERE p.DNI!=(SELECT p2.DNI 
                FROM PROFESOR p2) OR p.DNI!=(SELECT a2.DNI 
                FROM ALUMNO a2);
--4. Borra las personas que no sean ni alumnos ni profesores.
DELETE FROM PERSONA p 
WHERE p.DNI!=(SELECT p3.DNI 
                FROM PERSONA p3 ,PROFESOR p4 ,ALUMNO a 
                WHERE p3.DNI =p4.DNI OR a.DNI =p3.DNI );
--Ambas me fallan :( )  
--5. Añade un nuevo campo en la tabla titulación para guardar el número de 
--asignaturas que tiene cada titulación. Rellena el campo con los datos existentes.
ALTER TABLE TITULACION ADD (numasignaturas  number);
UPDATE TITULACION t
SET t.numasignaturas=(SELECT COUNT(a2.IDASIGNATURA)
                        FROM ASIGNATURA a2 ,TITULACION t2 
                        WHERE a2.IDTITULACION=t2.IDTITULACION AND t2.IDTITULACION=t.IDTITULACION);       
--6. Crea una nueva tabla para guardar el nombre del alumno, junto con el total 
--que tiene que pagar por su matrícula. Recuerda que por cada repetición hay que subirle un 10%. 
-- Rellena la tabla con los datos existentes
CREATE TABLE COSTO(
nombrealumno    VARCHAR2(30),
precio  NUMBER);
INSERT INTO COSTO(nombrealumno,precio)
VALUES (SELECT p.NOMBRE ,a.COSTEBASICO *a.CREDITOS 
        FROM ALUMNO a2,PERSONA p ,ALUMNO_ASIGNATURA aa 
        WHERE a2.DNI=p.DNI AND aa.IDALUMNO=a2.IDALUMNO);
        
--7. Añade un nuevo campo en la tabla alumnos para almacenar el 
--número total de créditos del que está matriculado. Rellena el campo con los datos existentes.
ALTER TABLE ALUMNO ADD (numcreditos     number);
UPDATE ALUMNO a
SET a.numcreditos=(SELECT a3.CREDITOS 
                    FROM ALUMNO a2 ,ASIGNATURA a3 ,ALUMNO_ASIGNATURA aa 
                    WHERE a2.DNI=aa.IDASIGNATURA AND a.DNI=a2.DNI);       
--8. Borra las titulaciones que no tengan ninguna asignatura.
DELETE FROM TITULACION t 
WHERE t.IDTITULACION NOT IN (SELECT a2.IDTITULACION
                            FROM ASIGNATURA a2);
--9. Crea una tabla profesores completas, en ellas que aparecerán 
--el nombre, apellido, ciudad, teléfono y el número de titulaciones en las que da clase.
--Rellena la tabla con los datos existentes
CREATE TABLE PROFESORCOMPLETA(
nombre  VARCHAR2(30),
apellido    VARCHAR2(30),
ciudad  VARCHAR2(30),
telefono    VARCHAR2(30),
numtitulaciones number
);
INSERT INTO PROFESORCOMPLETA
VALUES(SELECT p.NOMBRE ,p.APELLIDO ,p.CIUDAD ,p.TELEFONO ,COUNT(a.IDTITULACION)
    FROM PERSONA p ,ASIGNATURA a ,PROFESOR p2 
    WHERE p.DNI=p2.DNI AND p2.IDPROFESOR=a.IDPROFESOR
    GROUP BY a.IDTITULACION);       
--10. Crea un campo en la tabla persona llamado ejer10 en el que se almacenará las dos primeras letras del nombre, un número que identificará donde aparece una “a” dentro del nombre, junto con el día de la fecha de nacimiento.
--No se hacerlo :( )