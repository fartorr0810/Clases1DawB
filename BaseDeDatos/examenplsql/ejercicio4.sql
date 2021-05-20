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
