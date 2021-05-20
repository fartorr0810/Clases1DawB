/* Ejercicio 1.(2,5Puntos)
Escribir  un  procedimiento  que  modifique  la  localidad  de  un  departamento. 
 El procedimiento recibirá como parámetros el número del departamento y la localidad 
 nueva. */
CREATE OR REPLACE PROCEDURE DUMMY.EJERCICIO1 (v_numdepartamento	NUMBER, 
v_localidadnueva varchar2)
AS BEGIN 
	UPDATE departamento SET localidad=v_localidadnueva
	WHERE numdepartamento=v_numdepartamento;
END ejercicio1;


CALL dummy.ejercicio1(1,'Triana');

/* Ejercicio 2.(2,5Puntos)Codificar unafunciónque reciba una lista de hasta 5
  númerosy que devuelvauna de estas opciones dependiendo de unvalor que se introduzca 
  por teclado
  a.-Que visualice su suma. 
  b.-Que visualice la resta del mayor menos el menor.
  c.-Quevisualicelamultiplicación del primero con el tercero y el quinto.
  d. -Que visualice la división del segundo con el cuarto, controlando que no 
  se puede dividir por 0. */
CREATE OR REPLACE FUNCTION DUMMY.Ejercicio2 (eleccion	varchar2) 
RETURN NUMBER AS 
	num1 NUMBER(10) := 3;
	--num1 NUMBER(10) := &num1;
	--Realmente se haria asi, para pedirlo por teclado pero dbveber no le gusta el aspersa xdd
	num2 NUMBER(10) := 4;
	num3 NUMBER(10) := 8;
	num4 NUMBER(10) := 4;
	num5 NUMBER(10) := 1;
	resultado NUMBER;
	mayor NUMBER;
	menor NUMBER;
BEGIN 
CASE eleccion
	WHEN eleccion='a' THEN
		resultado:= (num1+num2+num3+num4+num5);
	WHEN eleccion='b' THEN
		resultado:= (num1-num2-nume-num4-num5);
	WHEN eleccion='c' THEN
		resultado:= (num1*num3*num5);
	WHEN eleccion='d' THEN
		IF num2!=0 AND  num4!=0 THEN 
			resultado:=(num2/num4);
			ELSE
			resultado:=-1
			END IF;
    END CASE;
	RETURN resultado;
END dummy.ejercicio2;

select dummy.ejercio2 from dual;
--No tiene sentido que me de error las lineas de finalizacion del if 


/*   Ejercicio 3.(2,5Puntos)Escribir  una  función  que  devuelva  
  solamente  caracteres numéricossustituyendo cualquier otro carácter por ‘X’a partir 
  de una cadena alfanumérica que se pasará en la llamada.
 */ 
 CREATE OR REPLACE FUNCTION DUMMY.EJERCICIO3 (cadena varchar2)
RETURN varchar2 AS
	cadenanueva VARCHAR2(30);
	caracter char;
	BEGIN
		FOR i IN 1..LENGTH(cadena) LOOP
			caracter:=substr(cadena,i,1);
		IF (ASCII(caracter) NOT BETWEEN 65 AND 90) AND (ascii(caracter) NOT BETWEEN 97 AND 122) THEN 
			caracter:='X';
			END IF;
			cadenanueva:=cadenanueva || caracter;
		END LOOP;
	RETURN cadenanueva;
END  ejercicio3;

/*  Ejercicio 4.(2,5Puntos)
  Desarrollarun procedimiento que reciba una cantidad monetariay 
  realice eldesglose del  cambio  en  unidades  monetarias  de  1,  5,  10, 
   25,  50,  100,  200,  500unidades monetarias. en ord+---+en 
   inverso al que aparecen enunciadas.Visualizar el resultado. */
   CREATE OR REPLACE PROCEDURE DUMMY.EJERCICIO4 (dinero number)
AS 
CREATE OR REPLACE PROCEDURE DUMMY.EJERCICIO4 (dinero number)
AS 
cambio NUMBER:=dinero;
moneda NUMBER;
v_moneda_comotal NUMBER;
BEGIN
	DBMS_OUTPUT.PUT_LINE('El dinero quedaria asi:');
	WHILE cambio>0 LOOP 
	IF cambio>=500 THEN
		moneda:=500;
	ELSIF cambio>=200 THEN
		moneda:=200;
	ELSIF cambio>=100 THEN
		moneda:=100;
	ELSIF cambio>=50 THEN
		moneda:=50;
	ELSIF cambio>=25 THEN
		moneda:=25;
	ELSIF cambio>=10 THEN
		moneda:=10;
	ELSIF cambio>=5 THEN
		moneda:=5;
	ELSIF cambio>=1 THEN
		moneda:=1;
	END IF;
	v_moneda_comotal:= TRUNC(cambio/moneda);
	DBMS_OUTPUT.PUT_LINE(v_moneda_comotal || 'monedas de '|| moneda || 'euritos');
	cambio:=MOD(cambio,moneda);
	END LOOP;
END ejercicio4 ;

