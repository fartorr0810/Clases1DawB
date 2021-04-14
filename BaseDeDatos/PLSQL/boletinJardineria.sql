/* Boletín Jardinería
 */
/* 1. Mostrar ‘Hola mundo’ por pantalla.
 */
CREATE OR REPLACE 
PROCEDURE HOLAMUNDO IS 
BEGIN 
	DBMS_OUTPUT.PUT_LINE('Hola Mundo');
END  HOLAMUNDO;
call DUMMY.HOLAMUNDO();
 
/* 2. Declarar una variable numérica y mostrar si es mayor de 10 o no.
 */
CREATE OR REPLACE PROCEDURE DUMMY.ESMAYORADIEZ (num NUMBER) IS 
BEGIN 
	if num>10 then
        	DBMS_OUTPUT.PUT_LINE('Es mayor a 10');
    ELSIF num<10 THEN 
        	DBMS_OUTPUT.PUT_LINE('Es menor a 10');
    ELSE
        	DBMS_OUTPUT.PUT_LINE('Es igual a 10');
    end IF;
   
END  ESMAYORADIEZ;

 
/*3Declarar una variable numéricay pedir su valor y mostrarlo.
*/
CREATE OR REPLACE 
PROCEDURE IMPRIMIRNUM (numero NUMBER) IS 
BEGIN
	DBMS_OUTPUT.PUT_LINE(numero);
END IMPRIMIRNUM;
CALL dummy.IMPRIMIRNUM(5);

/*4. Mostrar los númerosdel 1 al 100 con un while.*/
DECLARE 
	i NUMBER :=1;
BEGIN
	WHILE (i<=100)
  LOOP
    DBMS_OUTPUT.PUT_LINE(i);
    i := i+1;
  END LOOP;
END;
/*5. Mostrar los numeros del 1 al 100 con un for.*/
BEGIN
	FOR i in 1..100
	LOOP 
		DBMS_OUTPUT.PUT_LINE(i);
	END LOOP;
	END;
/*6. Mostrar los númerosdel 1 al 100 con un loop.*/
DECLARE 
	i NUMBER :=1;
BEGIN
	LOOP
	DBMS_OUTPUT.PUT_LINE(i);
	EXIT WHEN i>=100;
	i := i+1;
	END LOOP;

END;
/* 7. Mostrar el nombre de un cliente dado su código.
 */
CREATE OR REPLACE FUNCTION DUMMY.BUSCARCLIENTE (codcliente number) RETURN VARCHAR2 IS 
	nombrecliente VARCHAR2:='';
BEGIN
	SELECT c2.NOMBRECLIENTE INTO NOMBRECLIENTE
	FROM CLIENTES c2 
	WHERE c2.CODIGOCLIENTE=codcliente;
DBMS_OUTPUT.PUT_LINE('El cliente se llama' || NOMBRECLIENTE);
	RETURN nombrecliente;
END BUSCARCLIENTE;

SELECT BUSCARCLIENTE(14) FROM DUAL;


/*8. Mostrar el precioVenta y la gama de un producto dado su código.*/
CREATE OR REPLACE FUNCTION DUMMY.VERPRODUCTO (codproducto VARCHAR2) RETURN VARCHAR2 AS
	texto VARCHAR2(30):='';
	v_gama VARCHAR2(30):='';
	v_precioventa varchar2(30):='';
BEGIN
	SELECT p2.GAMA , p2.PRECIOVENTA INTO v_gama,v_precioventa
	FROM PRODUCTOS p2 
	WHERE p2.CODIGOPRODUCTO=codproducto;
	texto:=concat(V_GAMA,v_precioventa);
	RETURN texto;
END VERPRODUCTO;

SELECT VERPRODUCTO('11679') FROM DUAL;

/*9.  Mostrar  toda  la  informacion  de  un  pedido  dado  
su código(fechaEsperada, fechaEntrega, fechapedido, estado, comentarios)*/
CREATE OR REPLACE FUNCTION DUMMY.MOSTRARINFORMACIONPEDIDO (codpedido number) RETURN VARCHAR2 AS
	texto VARCHAR2(100):='';
	v_fechaesperada DATE;
	v_fechaentrega DATE;
	v_fechapedido	DATE;
	v_estado	VARCHAR2(30):='';
	v_comentario VARCHAR2(80):='';
BEGIN
	SELECT p.FECHAESPERADA ,p.FECHAENTREGA ,p.FECHAPEDIDO ,p.ESTADO ,p.COMENTARIOS INTO 
	v_fechaesperada,v_fechaentrega,v_fechapedido,v_estado,v_comentario
	FROM PEDIDOS p 
	WHERE p.CODIGOPEDIDO=codpedido;
	texto:=concat(to_char(V_FECHAESPERADA),to_char(V_fechaentrega),to_char(v_fechapedido),v_estado,to_char(v_comentario));
	RETURN texto;
END MOSTRARINFORMACIONPEDIDO;

/* 10. Realizar una función que me devuelva la suma de pagos que ha realizado.
 */
CREATE OR REPLACE FUNCTION SUMAPAGOS(codcliente clientes.codigocliente%type)
RETURN NUMBER
AS
  v_suma pagos.cantidad%type:= 0;
BEGIN
	SELECT sum(p2.CANTIDAD) INTO v_suma
	FROM PAGOS p2 
	WHERE p2.CODIGOCLIENTE = codcliente;
	
RETURN v_suma;
END sumapagos;

/*11.  Realizar  un  método  o  procedimiento  que  muestre  el  total  
en euros de un pedido, pásaleel códigopor parámetro. */
 CREATE OR REPLACE PROCEDURE DUMMY.PRECIOTOTALPORPEDIDO(v_codpedido PEDIDOS.CODIGOPEDIDO%type)
AS
  total number;
BEGIN
  SELECT SUM(d.CANTIDAD *d.PRECIOUNIDAD) INTO total
  FROM PEDIDOS p2 ,DETALLEPEDIDOS d 
  WHERE p2.CODIGOPEDIDO =d.CODIGOPEDIDO AND p2.CODIGOPEDIDO =v_codpedido
  DBMS_OUTPUT.PUT_LINE('El pedido total es '|| v_total);
END PRECIOTOTALPORPEDIDO;

 12. Mostrar el nombre de un cliente dado su código. Controla en caso de que no 
 se encuentre, mostrando un mensaje,por ejemplo.
 13. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el codigo por parametro.
 Controla en caso de que no se encuentre, en ese caso devuelve un 
 -1.14.  Realizar  un  método  o  procedimiento  que  muestre  el  total  
 en euros de un pedido, pásaleel códigopor parámetro. Controla en caso de que 
 no se encuentre, en ese caso devuelve un 0. Pásaleotro parámetro,  si  supera  ese  
 limite,  lanzaremos  una excepciónpropia y devolveremos un 0.
15. Crea una función a la que le pasaremos como parámetros de 
entrada:  MATRICULA,  NUEVO_PRECIO_COMPRA.  la  función modificara los datos del 
coche que tenga la matricula introducida actualizando el precio_compra de la siguiente forma:
-Si   precio_compra   es   nulo   hacer   un   update   en  
 el   campo precio_compra asignándole el valor de nuevo_precio_compra
 -Si no hacer un update en el campo precio_compra asignándole el 
 valor de precio_compra+(precio_compra-nuevo_precio_compra).La  función 
  devolverá  el  numero  de  filas  actualizadas  crea  un bloque  anónimo 
   que  ejecute  la  función  anterior  y  muestre  el resultado devuelto por la función.
16.   Crea   procedimiento   que   reciba   como   parámetros   de 
entrada:P_ID_MARCA,P_NUMERO_COCHES.  Utiliza  un  bucle para insertar N registros nuevos en 
la tabla COCHE. El numero de registros    a    insertar    viene    indicado    por    el   
parámetro P_NUMEROS_COCHES(CONTADOR) y el bucle empezará en 1, los datos
a insertar serán:-matricula=’A00’||CONTADOR-DESCRIPCION=p_id_marca-id_marca=p_id_marca-precio_compra=nuloControlar 
excepción para cuando exista algún coche en la BBDD y se viole la pk.
17.Crea un procedimiento al que le pasaremos el dni_cliente y la matricula. 
El procedimiento deberá controlar en las ventas de los coches(tabla vende) los 
siguientes supuestos:
-.Si no existe un registro con ese dni_cliente y esa matricula saltara a la 
zona de excepciones y mostrara un mensaje “no existe la venta introducida”
–Si existe la venta introducida:
I. mostrara el precio antiguo ||II. actualizara el precio subiendo 1000 eurosIII.
devolverá     en     un     parámetro     de     salida     del procedimiento(ps_nuevo_precio)   
el   precio   nuevo   tras   la actualización   crea   un   bloque   anónimo   que   llame   
al procedimiento  anterior  y  muestre  el  precio  nuevo  devuelto por el procedimiento.
18. Crear un cursor para ver todos los clientes que no hayan hecho pagos. Hazlo con un loop.
19. Crear un cursor para ver todos los clientes que no hayan hecho pagos. Hazlo con un for.
