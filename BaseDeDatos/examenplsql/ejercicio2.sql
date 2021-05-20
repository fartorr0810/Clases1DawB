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
--No tiene sentido que me de error las lineas de finalizacion del if 