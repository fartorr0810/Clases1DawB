<--1. Mostrar el nombre de los clientes junto al nombre de su pueblo.-->
SELECT c.NOMBRE ,p.NOMBRE 
FROM CLIENTES c ,PUEBLOS p 
WHERE c.CODPUE =p.CODPUE ;

/*
2. Mostrar el nombre de los pueblos junto con el nombre de la provincia correspondiente.
*/
SELECT p.NOMBRE ,pr.NOMBRE 
FROM PUEBLOS p ,PROVINCIAS pr
WHERE p.CODPRO = pr.CODPRO ;

<--3. Mostrar el nombre de los clientes junto al nombre de su pueblo y el de su provincia.-->
SELECT c.NOMBRE ,p.NOMBRE ,pr.NOMBRE 
FROM CLIENTES c ,PUEBLOS p ,PROVINCIAS pr
WHERE c.CODPUE =p.CODPUE AND p.CODPRO =pr.CODPRO ;
<--4. Nombre de las provincias donde residen clientes sin que salgan valores repetidos.-->
SELECT DISTINCT pr.NOMBRE 
FROM PROVINCIAS pr,CLIENTES c,PUEBLOS p
WHERE p.CODPUE =c.CODPUE AND p.CODPRO = pr.CODPRO ;
/*
5. Mostrar la descripción de los artículos que se han vendido en una cantidad
superior a 10 unidades. Si un artículo se ha vendido más de una vez en una cantidad 
superior a 10 sólo debe salir una vez.
*/
SELECT a.DESCRIP
FROM ARTICULOS a,LINEAS_FAC lf 
WHERE lf.CODART =a.CODART AND lf.CANT>10;

/*6. Mostrar la fecha de factura junto con el código del artículo y la cantidad
vendida por cada artículo vendido en alguna factura. Los datos deben salir ordenado 
por fecha, primero las más reciente, luego por el código del artículos, y si el mismo
artículo se ha vendido varias veces en la misma fecha los más vendidos primero.
*/
SELECT  f.FECHA , lf.CANT ,a.CODART
FROM ARTICULOS a,LINEAS_FAC lf ,FACTURAS f 
WHERE a.codart =lf.CODART AND lf.CODFAC =f.CODFAC
ORDER BY f.FECHA ASC ;
/*
7. Mostrar el código de factura y la fecha de las mismas de las facturas que se 
han facturado a un cliente que tenga en su código postal un 7.
*/
SELECT  f.FECHA ,f.CODFAC 
FROM FACTURAS f , CLIENTES c
WHERE c.CODCLI =f.CODCLI AND c.CODPOSTAL = '%7%';
/*
8. Mostrar el código de factura, la fecha y el nombre del cliente de todas 
las facturas existentes en la base de datos.
*/
SELECT  f.CODFAC ,f.FECHA ,c.NOMBRE 
FROM CLIENTES c,FACTURAS f 
WHERE c.CODCLI =f.CODCLI ;
/*
9. Mostrar un listado con el código de la factura, la fecha, el iva, el dto y 
el nombre del cliente para aquellas facturas que o bien no se le ha cobrado iva 
(no se ha cobrado iva si el iva es nulo o cero), o bien el descuento es nulo.
*/
SELECT  f.CODFAC ,f.FECHA ,f.IVA, f.DTO ,c.NOMBRE 
FROM FACTURAS f,CLIENTES c
WHERE f.CODCLI =c.CODCLI AND (f.IVA is NULL) OR f.IVA =0;
/*
10. Se quiere saber que artículos se han vendido más baratos que el precio que 
actualmente tenemos almacenados en la tabla de artículos, para ello se necesita 
mostrar la descripción de los artículos junto con el precio actual. Además deberá 
aparecer el precio en que se vendió si este precio es inferior al precio original.
*/
SELECT a.DESCRIP , a.PRECIO , lf.PRECIO 
FROM ARTICULOS a ,LINEAS_FAC lf 
WHERE a.CODART =lf.CODART aND a.PRECIO >lf.PRECIO 
;
/*
11. Mostrar el código de las facturas, junto a la fecha, iva y descuento.
También debe aparecer la descripción de los artículos vendido junto al precio 
de venta, la cantidad y el descuento de ese artículo, para todos los artículos 
que se han vendido.
*/
SELECT f.CODFAC ,f.FECHA ,f.IVA ,f.DTO ,a.DESCRIP ,lf.PRECIO 
FROM FACTURAS f ,ARTICULOS a,LINEAS_FAC lf 
WHERE lf.CODART =a.CODART AND lf.CODFAC =f.CODFAC ;
/*
12. Igual que el anterior, pero mostrando también el nombre del cliente 
al que se le ha vendido el artículo.
*/
SELECT f.CODFAC ,f.FECHA ,f.IVA ,f.DTO ,a.DESCRIP ,lf.PRECIO ,c.NOMBRE 
FROM FACTURAS f ,ARTICULOS a,LINEAS_FAC lf ,CLIENTES c
WHERE lf.CODART =a.CODART AND lf.CODFAC =f.CODFAC AND f.CODCLI =c.CODCLI ;
/*
13. Mostrar los nombres de los clientes que viven en una provincia 
que contenga la letra ma.
*/
SELECT DISTINCT CLIENTES.NOMBRE,PROVINCIAS.NOMBRE
FROM CLIENTES,PROVINCIAS,PUEBLOS
WHERE PUEBLOS.CODPRO=PROVINCIAS.CODPRO AND PROVINCIAS.NOMBRE LIKE '%MA%';

/*
14. Mostrar el código del cliente al que se le ha vendido un artículo 
que tienen un stock menor al stock mínimo.
*/
SELECT c.NOMBRE 
FROM CLIENTES c,ARTICULOS a , FACTURAS f,LINEAS_FAC lf 
WHERE c.CODCLI =f.CODCLI AND f.CODFAC =LF.CODFAC AND lf.CODART =a.CODART AND
a.STOCK > a.STOCK_MIN ;
/*
15. Mostrar el nombre de todos los artículos que se han vendido alguna 
vez. (no deben salir valores repetidos)
*/
SELECT DISTINCT a.DESCRIP 
FROM ARTICULOS a,LINEAS_FAC lf 
WHERE lf.CODART!=a.CODART;/*
16. Se quiere saber el precio real al que se ha vendido cada vez los artículos. 
Para ello es necesario mostrar el nombre del artículo, junto con el precio de venta
(no el que está almacenado en la tabla de artículos) menos el descuento aplicado en la
línea de descuento.
*/
SELECT  lf.PRECIO-lf.DTO 
FROM ARTICULOS a,LINEAS_FAC lf 
WHERE a.codcli=lf.
/*
17. Mostrar el nombre de los artículos que se han vendido a clientes que vivan 
en una provincia cuyo nombre termina  por a.
*/

/*
18. Mostrar el nombre de los clientes sin que salgan repetidos a los que se 
les ha hecho un descuento superior al 10% en alguna de sus facturas.
*/

/*19. Mostrar el nombre de los clientes sin que salgan repetidos a los que se
les ha hecho un descuento superior al 10% en alguna de sus facturas o en alguna 
de las líneas que componen la factura o en ambas.
*/

/*
20. Mostrar la descripción, la cantidad y el precio de venta de los artículos
vendidos al cliente con nombre MARIA MERCEDES
*/



