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
