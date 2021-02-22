--1. Descuento medio aplicado en las facturas.--
SELECT AVG(DTO)
FROM FACTURAS f;
--2. Descuento medio aplicado en las facturas sin considerar los valores nulos.
SELECT  AVG(DTO)
FROM FACTURAS f
WHERE DTO IS NOT NULL;
--3. Descuento medio aplicado en las facturas considerando los valores nulos como cero.
SELECT  AVG(DTO)
FROM FACTURAS f 
WHERE DTO IS NOT NULL AND DTO<>0;

--4. Número de facturas.
SELECT COUNT(CODFAC)
FROM FACTURAS f 
--5. Número de pueblos de la Comunidad de Valencia.
SELECT COUNT(CODPUE) 
FROM PUEBLOS p,PROVINCIAS p2 
WHERE p.CODPRO =p2.CODPRO AND p2.NOMBRE='VALENCIA';
--Da 0, es raro

--6. Importe total de los artículos que tenemos en el almacén.
-- Este importe se calcula sumando el producto de las unidades en stock por el precio de cada unidad
SELECT SUM(a.PRECIO)  
FROM ARTICULOS a ;
--7. Número de pueblos en los que residen clientes cuyo código postal empieza por ‘12’.
SELECT COUNT(c.CODPUE) 
FROM PUEBLOS p ,CLIENTES c
WHERE p.CODPUE =c.CODPUE AND c.CODPOSTAL='12%';
--8. Valores máximo y mínimo del stock de los artículos cuyo precio oscila entre 9 y 12 € y diferencia entre ambos valores
Select MAX(a.STOCK),MIN(a.STOCK_MIN)
FROM ARTICULOS a 
WHERE a.PRECIO BETWEEN 9 AND 12;
--9. Precio medio de los artículos cuyo stock supera las 10 unidades.
SELECT AVG(a.PRECIO) 
FROM ARTICULOS a 
WHERE STOCK >10;
--10. Fecha de la primera y la última factura del cliente con código 210.
SELECT LAST_DAY(f.FECHA)
FROM CLIENTES c ,FACTURAS f 
WHERE c.CODCLI =f.CODCLI AND f.CODFAC=210;
--No sale nada , es raro es como si nadie tuviera el codigo de factura 210. Es decir
--cuando quito la ultima condicion , me salen las fechas
--11. Número de artículos cuyo stock es nulo.
SELECT  COUNT(a.CODART) 
FROM ARTICULOS a 
WHERE STOCK IS NULL;
--12. Número de líneas cuyo descuento es nulo (con un decimal)
SELECT COUNT(lf.CODFAC) 
FROM LINEAS_FAC lf 
WHERE lf.DTO IS null;
--13. Obtener cuántas facturas tiene cada cliente.
SELECT count(f.CODFAC),c.NOMBRE 
FROM CLIENTES c,FACTURAS f 
WHERE c.CODCLI =f.CODCLI
GROUP BY c.NOMBRE;
--14.Obtener cuántas facturas tiene cada cliente, pero 
--sólo si tiene dos o más  facturas.
SELECT  COUNT(f.CODFAC) ,c.NOMBRE 
FROM CLIENTES c,FACTURAS f 
WHERE c.CODCLI =f.CODCLI
GROUP BY c.NOMBRE 
HAVING COUNT(f.CODFAC)>2;
--15.Importe de la facturación (suma del producto de la cantidad
--por el precio de las líneas de factura) de los  artículos
SELECT lf.PRECIO*count(lf.CANT)
FROM LINEAS_FAC lf 
GROUP BY lf.CODART 
--16.Importe de la facturación (suma del producto de la cantidad
--por el precio de las líneas de factura) de aquellos artículos 
--cuyo código contiene la letra “A” (bien mayúscula o minúscula).
SELECT count(lf.PRECIO)*count(lf.CANT)
FROM LINEAS_FAC lf ,ARTICULOS a 
where lf.CODART =a.CODART AND (a.CODART LIKE 'A%' OR a.CODART LIKE 'a%')
--17. Número de facturas para cada fecha, junto con la fecha
SELECT FECHA ,COUNT(FECHA)
FROM FACTURAS f
GROUP BY FECHA ;
--18.Obtener el número de clientes del pueblo junto con el
--nombre del pueblo mostrando primero los pueblos que más clientes tengan.
SELECT COUNT(c.CODCLI),p.NOMBRE 
FROM CLIENTES c ,PUEBLOS p 
WHERE c.CODPUE =p.CODPUE 
GROUP BY p.NOMBRE 
ORDER BY COUNT(c.CODCLI) DESC ;
--19. Obtener el número de clientes del pueblo junto con el 
--nombre del pueblo mostrando primero los pueblos que más clientes tengan,
--siempre y cuando tengan más de dos clientes.
SELECT COUNT(c.CODCLI),p.NOMBRE 
FROM CLIENTES c ,PUEBLOS p 
WHERE c.CODPUE =p.CODPUE
GROUP BY p.NOMBRE AND COUNT(CODCLI)>2
ORDER BY COUNT(c.CODCLI) DESC ;
--20. Cantidades totales vendidas para cada artículo cuyo
--código empieza por "P", mostrando también la descripción de dicho artículo.
SELECT MAX(a.CODART) ,a.DESCRIP 
FROM ARTICULOS a,LINEAS_FAC lf 
WHERE a.CODART =lf.CODART AND a.CODART LIKE 'P%'
GROUP BY a.DESCRIP;
--21. Igual que el anterior pero mostrando también la diferencia entre el precio máximo y mínimo. 
SELECT MAX(a.CODART) ,a.DESCRIP,MAX(lf.PRECIO) - MIN(lf.PRECIO)
FROM ARTICULOS a,LINEAS_FAC lf 
WHERE a.CODART =lf.CODART AND a.CODART LIKE 'P%'
GROUP BY a.DESCRIP;
--22. Nombre de aquellos artículos de los que se ha facturado más de 10000 euros.
SELECT  MAX(lf.PRECIO) ,a.DESCRIP 
FROM ARTICULOS a,LINEAS_FAC lf 
WHERE a.CODART =lf.CODART AND lf.PRECIO >10000
GROUP BY a.DESCRIP;
--23. Número de facturas de cada uno de los clientes cuyo código está entre 150 y 300 (se debe mostrar este código), con cada IVA distinto que se les ha aplicado.
SELECT count(f.CODFAC),f.IVA 
FROM FACTURAS f,CLIENTES c
WHERE c.CODCLI =f.CODCLI AND c.CODCLI BETWEEN 150 AND 300
GROUP BY f.IVA ;
--24. Media del importe de las facturas, sin tener en cuenta impuestos ni descuentos.
SELECT AVG(lf.PRECIO)
FROM LINEAS_FAC lf