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
    8. Valores máximo y mínimo del stock de los artículos cuyo precio oscila entre 9 y 12 € y diferencia entre ambos valores
    9. Precio medio de los artículos cuyo stock supera las 10 unidades.
    10. Fecha de la primera y la última factura del cliente con código 210.
    11. Número de artículos cuyo stock es nulo.
    12. Número de líneas cuyo descuento es nulo (con un decimal)
    13. Obtener cuántas facturas tiene cada cliente.
    14. Obtener cuántas facturas tiene cada cliente, pero sólo si tiene dos o más  facturas.
    15. Importe de la facturación (suma del producto de la cantidad por el precio de las líneas de factura) de los  artículos
    16. Importe de la facturación (suma del producto de la cantidad por el precio de las líneas de factura) de aquellos artículos cuyo código contiene la letra “A” (bien mayúscula o minúscula).
    17. Número de facturas para cada fecha, junto con la fecha
    18. Obtener el número de clientes del pueblo junto con el nombre del pueblo mostrando primero los pueblos que más clientes tengan.
    19. Obtener el número de clientes del pueblo junto con el nombre del pueblo mostrando primero los pueblos que más clientes tengan, siempre y cuando tengan más de dos clientes.
    20. Cantidades totales vendidas para cada artículo cuyo código empieza por “P", mostrando también la descripción de dicho artículo.9.-	Precio máximo y precio mínimo de venta (en líneas de facturas) para cada artículo cuyo código empieza por “c”.
    21. Igual que el anterior pero mostrando también la diferencia entre el precio máximo y mínimo.
    22. Nombre de aquellos artículos de los que se ha facturado más de 10000 euros.
    23. Número de facturas de cada uno de los clientes cuyo código está entre 150 y 300 (se debe mostrar este código), con cada IVA distinto que se les ha aplicado.
    24. Media del importe de las facturas, sin tener en cuenta impuestos ni descuentos.
