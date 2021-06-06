-- 1. Mostrar ‘Hola mundo’ por pantalla.
-- 2. Declarar una variable numéricay mostrar si es mayor de 10 o no.
-- 3. Declarar una variable numéricay pedir su valor y mostrarlo.
-- 4. Mostrar los númerosdel 1 al 100 con un while.
-- 5. Mostrar los numeros del 1 al 100 con un for.
-- 6. Mostrar los númerosdel 1 al 100 con un loop.
--Esos ejercicios son demasiado sencillos, ya llevo dos boletines asi xdd.
/* 7. Mostrar el nombre de un cliente dado su código.
 */
CREATE OR REPLACE PROCEDURE mostrarcliente (codigo NUMBER) IS 
	v_cliente CLIENTES%ROWTYPE;
BEGIN
	SELECT * INTO CLIENTES 
	FROM CLIENTES c
	WHERE c.CODIGOCLIENTE=codigo ;
	dbms_output.put_line('Se llama: '||v_cliente.nombrecliente);
END mostrarcliente;

CALL MOSTRARCLIENTE(2); 
--8. Mostrar el precioVenta y la gama de un producto dado su código.
CREATE OR REPLACE PROCEDURE DUMMY.mostrarprecioventaygama (codigo VARCHAR2) IS 
	v_producto PRODUCTOS%ROWTYPE;
BEGIN
	SELECT * INTO v_producto 
	FROM PRODUCTOS p 
	WHERE p.codigoproducto=codigo ;
	dbms_output.put_line('Su gama es: '||v_producto.gama||' y su precio es: '||v_producto.precioventa);
END mostrarprecioventaygama;

--9.  Mostrar  toda  la  informacion  de  un  pedido  dado  
--su código(fechaEsperada, fechaEntrega, fechapedido, estado, comentarios)
CREATE OR REPLACE PROCEDURE infopedido(codigo number) IS 
	v_infopedido	pedidos%rowtype;
BEGIN
	SELECT * INTO v_infopedido
	FROM PEDIDOS p 
	WHERE p.codigopedido=codigo;
	dbms_output.put_line('Su fecha de entrega es: '||v_infopedido.fechaesperada||' es entregado: '||
	v_infopedido.fechaentrega||' es pedido '||v_infopedido.fechapedido||' Su estado es: '||v_infopedido.estado||
	'y han comentado: '||v_infopedido.comentarios);
END infopedido;
/*  10. Realizar una función que me devuelva la suma de pagos que ha realizado. 
 Pasa el códigopor parámetro. */
CREATE OR REPLACE FUNCTION DUMMY.sumadepagos(codigo number) RETURN NUMBER  IS 
	v_sumapagos NUMBER;
BEGIN
	SELECT sum(p.CANTIDAD) INTO v_sumapagos 
	FROM PAGOS p
	WHERE p.CODIGOCLIENTE=codigo;
RETURN v_sumapagos;
END sumadepagos;ç

/* 11.Realizar  un  método  o  procedimiento  que  muestre  el  total  en euros de un pedido,
pásaleel códigopor parámetro.
 */
CREATE OR REPLACE FUNCTION DUMMY.mostrareurodepedido(codigo number) RETURN NUMBER IS 
v_eurostotal NUMBER;
BEGIN
	SELECT SUM(p2.CANTIDAD) INTO v_eurostotal
	FROM PEDIDOS p ,PAGOS p2
	WHERE p.CODIGOCLIENTE=p2.CODIGOCLIENTE AND p2.CODIGOCLIENTE=codigo;
RETURN v_eurostotal;
END mostrareurodepedido;
/* 12. Mostrar el nombre de un cliente dado su código. Controla en caso de que no se encuentre,
mostrando un mensaje,por ejemplo. */
CREATE OR REPLACE PROCEDURE DUMMY.mostrarclienteconexcepciones (codigo NUMBER) IS 
	v_cliente CLIENTES%ROWTYPE;
	
	--Falta declarar bloque de excepcion. en el is.
BEGIN
	SELECT * INTO v_cliente
	FROM CLIENTES c
	WHERE c.CODIGOCLIENTE=codigo ;
	IF codigo IS NULL THEN
    RAISE importe_mal;
	ELSE 
		dbms_output.put_line('Se llama: '||v_cliente.nombrecliente);
	END IF;
END mostrarclienteconexcepciones;

13. Realizar una función que me devuelva la suma de pagos 
que ha realizado. Pasa el codigo por parametro. Controla en caso de que no se encuentre, 
en ese caso devuelve un -1.
