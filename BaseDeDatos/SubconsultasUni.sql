--1.Mostrar el identificador de los alumnos matriculados en cualquier
--asignatura excepto la '150212' y la '130113'.
SELECT a2.IDALUMNO
FROM ALUMNO a2 
WHERE a2.IDALUMNO NOT IN (SELECT aa.IDALUMNO 
						FROM ALUMNO_ASIGNATURA aa 
						WHERE aa.IDASIGNATURA = '150212' OR  aa.IDASIGNATURA = '130113');                                             WHERE IdAsignatura = "150212" OR  IdAsignatura = "130113")
--2.Mostrar el nombre de las asignaturas que tienen más créditos que "Seguridad Vial".
SELECT  a2.NOMBRE 
FROM ASIGNATURA a2 
WHERE a2.CREDITOS >(SELECT a3.CREDITOS 
					FROM ASIGNATURA a3 
					WHERE a3.NOMBRE='Seguridad Vial');
--3.Obtener el Id de los alumnos matriculados en las asignaturas "150212" y "130113" a la vez.
SELECT  aa.IDALUMNO 
FROM ALUMNO_ASIGNATURA aa 
WHERE aa.IDASIGNATURA IN (SELECT aa.IDASIGNATURA 
						FROM ALUMNO_ASIGNATURA aa2 
							WHERE aa2.IDASIGNATURA='150212' OR aa2.IDASIGNATURA='130113');
--4.Mostrar el Id de los alumnos matriculados en las asignatura "150212" ó "130113", 
--en una o en otra pero no en ambas a la vez.
 
SELECT DISTINCT aa.IDALUMNO 
FROM ALUMNO_ASIGNATURA aa 
WHERE (aa.IDASIGNATURA='150212' AND aa.IDALUMNO NOT IN 
(SELECT aa2.IDASIGNATURA 
FROM ALUMNO_ASIGNATURA aa2 
WHERE aa2.IDASIGNATURA='130113')) OR (aa.IDASIGNATURA ='130113' AND aa.IDALUMNO NOT IN 
(SELECT aa2.IDASIGNATURA 
FROM ALUMNO_ASIGNATURA aa2 
WHERE aa2.IDASIGNATURA='150212'));


--5. Mostrar el nombre de las asignaturas de la titulación "130110" cuyos costes básicos
--sobrepasen el coste básico promedio por asignatura en esa titulación.

SELECT a.NOMBRE 
FROM ASIGNATURA a
WHERE a.COSTEBASICO =(SELECT AVG(a2.costebasico) from ASIGNATURA a2
WHERE a2.idtitulacion='130110') AND a.idtitulacion='130110';


--6. Mostrar el identificador de los alumnos matriculados en cualquier 
--asignatura excepto la "150212" y la "130113”
SELECT DISTINCT (aa.IDALUMNO)
FROM ALUMNO_ASIGNATURA aa
WHERE aa.IDALUMNO NOT IN(SELECT aa2.IDALUMNO 
FROM ALUMNO_ASIGNATURA aa2 
WHERE aa2.IDASIGNATURA IN('150212','130113'));

--7. Id de los alumnos matriculados en la asignatura "150212" pero no en la "130113".
SELECT aa.IDASIGNATURA 
FROM ALUMNO_ASIGNATURA aa 
WHERE aa.IDASIGNATURA='150212'
AND aa.IDALUMNO IN(SELECT idalumno
FROM ALUMNO_ASIGNATURA aa2 
where aa2.IDASIGNATURA<>'130113');

--8.Mostrar el nombre de las asignaturas que tienen más créditos que "Seguridad Vial".
SELECT a2.NOMBRE 
FROM ASIGNATURA a2 
WHERE a2.CREDITOS >(SELECT a3.CREDITOS 
					FROM ASIGNATURA a3 
					WHERE a3.NOMBRE='Seguridad Vial');

--9.Mostrar las personas que no son ni profesores ni alumnos.
SELECT *
FROM PERSONA p2 
WHERE p2.DNI NOT IN (SELECT p3.DNI 
					FROM PROFESOR p3) AND p2.DNI NOT IN
					(SELECT a2.DNI 
					FROM ALUMNO a2);

--10.Mostrar el nombre de las asignaturas que tengan más créditos.
SELECT a2.NOMBRE 
FROM ASIGNATURA a2 
WHERE a2.CREDITOS =(SELECT MAX(a3.CREDITOS)
					FROM ASIGNATURA a3);
--11.Lista de asignaturas en las que no se ha matriculado nadie.
SELECT a2.NOMBRE 
FROM ASIGNATURA a2 
WHERE a2.IDASIGNATURA NOT IN (SELECT aa.IDASIGNATURA 
							FROM ALUMNO_ASIGNATURA aa);


--12. Ciudades en las que vive algún profesor y también algún alumno.
SELECT DISTINCT (p.ciudad)
FROM PERSONA p1 , PERSONA p2 
WHERE p1.DNI IN(SELECT a2.DNI from ALUMNO a2)
OR p1.DNI IN(SELECT p3.DNI FROM PROFESOR p3)
AND p1.CIUDAD =p2.CIUDAD
AND p1.DNI >p2.DNI 
				