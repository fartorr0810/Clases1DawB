/* 1.Crea un procedimiento llamado ESCRIBE para mostrar por pantalla elmensaje HOLA MUNDO.*/
CREATE OR REPLACE 
PROCEDURE ESCRIBE IS 
BEGIN 
	DBMS_OUTPUT.PUT_LINE('Hola Mundo');
END ESCRIBE;
call DUMMY.ESCRIBE();

/*2.Crea un procedimiento llamado ESCRIBE_MENSAJE que tenga unparámetro de tipo VARCHAR2 que recibe un texto y lo muestre por pantalla. La forma del procedimiento ser. la siguiente:
ESCRIBE_MENSAJE (mensaje VARCHAR2)*/

CREATE OR REPLACE 
PROCEDURE ESCRIBEMENSAJE (mensaje VARCHAR2) IS 
BEGIN
	DBMS_OUTPUT.PUT_LINE(MENSAJE);
END ESCRIBEMENSAJE;

CALL dummy.ESCRIBEMENSAJE('ANTONIOOOO');



/*3.Crea un procedimiento llamado SERIE que muestre por pantalla una serie denúmeros  desde  
un  mínimo  hasta  un  máximo  con  un  determinado  paso. 
 La forma delprocedimiento ser. la siguiente:
SERIE (minimo NUMBER, maximo NUMBER, paso NUMBER)*/
CREATE OR REPLACE PROCEDURE DUMMY.SERIE (minimo NUMBER, maximo NUMBER,paso NUMBER) IS 
BEGIN
 FOR paso IN minimo..maximo LOOP
  DBMS_OUTPUT.PUT_LINE(paso);
  END LOOP;
 END Serie;


CALL dummy.serie(1,12,1);
4.Crea una función AZAR que reciba dos parámetros y genere un número alazar  entre  un  mínimo  y  máximoindicado.  La  forma  de  la  función  serála siguiente:
AZAR (minimo NUMBER, maximo NUMBER) RETURN NUMBER

5.Crea una función NOTA que reciba un parámetro que seráuna notanumérica entre 0 y 10 y devuelva una cadena de textocon la calificación(Suficiente, Bien, Notable, ...). La forma de la función serála siguiente:
NOTA(nota NUMBER) RETURN VARCHAR2
 */