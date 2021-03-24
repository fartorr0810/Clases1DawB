--1. Obtener el número de trenes que entraron entre los meses 
--de enero y abril del año pasado.
SELECT COUNT(t.CODIGO)
FROM TREN t 
WHERE EXTRACT (MONTH FROM t.FECHA_ENTRADA)>=1 and EXTRACT (MONTH FROM t.FECHA_ENTRADA)<=4 AND 
EXTRACT (YEAR FROM t.FECHA_ENTRADA)=EXTRACT (YEAR FROM SYSDATE)-1;
--2. Obtener la localización y el código de la estación a la que 
--pertenecen las cocheras con una capacidad entre 4 y 10 ambos incluidos ordenados 
--por el código de la estación de forma descendente y por la localización de forma ascendente.
SELECT c2.LOCALIZACION , c2.ESTACION 
FROM ESTACION e2 ,COCHERA c2 
WHERE e2.CODIGO =c2.ESTACION AND c2.CAPACIDAD BETWEEN 4 AND 10
ORDER BY c2.ESTACION DESC , c2.LOCALIZACION ASC;
--3. Obtener todos los campos de las estaciones cuyo nombre 
--contenga la cadena 'ci' en mayúsculas o minúsculas.
SELECT *
FROM ESTACION e2 
WHERE e2.NOMBRE LIKE '%ci%' OR e2.NOMBRE LIKE '%CI%';
--4. Mostrar el número de accesos que hay de cada orientación menos del
--tipo 'S' mostrando también la orientación.
SELECT COUNT(a2.NUMERO_ACCESO),a2.ORIENTACION 
FROM ACCESO a2 
WHERE a2.ORIENTACION NOT LIKE 'S'
GROUP BY a2.ORIENTACION ;
--5. Mostrar el nombre y el distrito de las estaciones 
--cuyo nombre comience por c,b,m,o,s,r,p,v,g,w,x,a,j,n ó z mayúscula o minúscula y 
--que el distrito termine en uno de los siguientes números 1,3,4,5,6,7,8,9.
--d e f h i k l q t u y

SELECT e2.DISTRITO ,e2.NOMBRE 
FROM ESTACION e2 
WHERE UPPER(e2.NOMBRE) NOT LIKE 'D%' OR UPPER(e2.NOMBRE) NOT LIKE 'E%' OR UPPER(e2.NOMBRE) NOT LIKE 'F%'
OR UPPER(e2.NOMBRE) NOT LIKE 'H%' OR UPPER(e2.NOMBRE) NOT LIKE 'I%' OR UPPER(e2.NOMBRE) NOT LIKE 'K%'
OR UPPER(e2.NOMBRE) NOT LIKE 'L%' OR UPPER(e2.NOMBRE) NOT LIKE 'Q%' OR UPPER(e2.NOMBRE) NOT LIKE 'T%' OR 
UPPER(e2.NOMBRE) NOT LIKE 'U%' OR UPPER(e2.NOMBRE) NOT LIKE 'Y%';

--6. Mostrar el nombre de las estaciones y el número de accesos que 
--tienen ordenadas de mayor a menor número de accesos.
SELECT e.NOMBRE , count(a2.NUMERO_ACCESO)
FROM ACCESO a2 ,ESTACION e 
WHERE a2.ESTACION =e.CODIGO 
GROUP BY e.NOMBRE
ORDER BY COUNT(a2.NUMERO_ACCESO) DESC;

--7. Mostrar todos los datos de las estaciones que tienen acceso sur.
SELECT e3.NOMBRE , e3.DISTRITO , 3.CODIGO 
FROM ESTACION e3 , ACCESO a 
WHERE e3.CODIGO =a.ESTACION AND a.ORIENTACION LIKE 'S';

--8. Mostrar el nombre de todas las estaciones por las que pasa una línea con cobertura CENTRO.
SELECT e2.NOMBRE 
FROM ESTACION e2 ,LINEA l2 
WHERE l2.COBERTURA LIKE 'CENTRO' AND e2.CODIGO =l2.CODIGO;

--9. Mostrar la velocidad media de los trenes que circulan en una línea con cobertura 'CIRCULAR'.
SELECT AVG(t2.VELOCIDAD_MAXIMA)
FROM TREN t2 ,LINEA l2 
WHERE t2.LINEA =l2.CODIGO AND l2.COBERTURA LIKE 'CIRCULAR';

--10. Mostrar la estación y el número de líneas que pasa por dicha estación.
SELECT e2.NOMBRE ,COUNT(le.LINEA) 
FROM ESTACION e2 ,LINEA_ESTACION le 
WHERE e2.CODIGO =le.ESTACION 
GROUP BY e2.NOMBRE ;

--11. Mostrar la capacidad máxima de una cochera.
SELECT MAX(c.CAPACIDAD )
FROM COCHERA c;

--12. Mostrar el código de las cocheras junto con el número de accesos
--con orientación sur (S) que tiene la estación a la que la cochera pertenece.
SELECT c2.CODIGO ,COUNT(a2.NUMERO_ACCESO) 
FROM COCHERA c2 ,ACCESO a2 
WHERE c2.ESTACION =a2.ESTACION AND a2.ORIENTACION LIKE 'S'
GROUP BY c2.CODIGO;

--13. Mostrar el número total de “huecos” que hay en todas las cocheras de la 
--base de datos. Es decir, que nos diga el número total de huecos.
SELECT  COUNT(t2.COCHERA)
FROM TREN t2 
WHERE t2.COCHERA IS NULL;

--14. Mostrar cada uno de los distritos junto con el número de trenes con una
--velocidad máxima de 100 k/h que pasan por cualquier estación que pertenezca a 
--ese distrito, siempre y cuando pasen más de tres trenes con una velocidad máxima
-- de 100 kilómetros por hora.
SELECT e.DISTRITO ,COUNT(t2.CODIGO) 
FROM TREN t2 ,ESTACION e 
WHERE t2.VELOCIDAD_MAXIMA=100
GROUP BY e.DISTRITO 

--15. Mostrar el nombre de la estación junto con el nombre de las líneas 
--que pasan por esa estación, y el modelo y velocidad máxima de los trenes que 
--tienen esa línea, junto con la localización de la cochera en la que duerme el tren 
--y el nombre de la estación a la que pertenece la cochera. Ordenar los datos por línea y estación.
SELECT e.NOMBRE ,l2.NOMBRE 
FROM ESTACION e ,LINEA l2 ,LINEA_ESTACION le 
WHERE