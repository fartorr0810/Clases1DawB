/* 1.Crea un procedimiento llamado ESCRIBE para mostrar por pantalla elmensaje HOLA MUNDO.
 */
CREATE OR REPLACE PROCEDURE ESCRIBE IS 
BEGIN 
	dbms_output.put_line('HOLA MUNDO');
END escribe;

CALL ESCRIBE(); 

/* 2.Crea un procedimiento llamado ESCRIBE_MENSAJE que tenga unparámetro de tipo VARCHAR2 que 
recibe un texto y lo muestre por pantalla. La forma del procedimiento ser. la siguiente
:ESCRIBE_MENSAJE (mensaje VARCHAR2)
 */
CREATE OR REPLACE PROCEDURE ESCRIBE_MENSAJE (texto varchar2) IS 
BEGIN 
	dbms_output.put_line(texto);
END ESCRIBE_MENSAJE;

CALL ESCRIBE_MENSAJE('illojuan');


/* 3.Crea un procedimiento llamado SERIE que muestre por pantalla 
una serie denúmeros  desde  un  mínimo  hasta  un  máximo  con  un  determinado  paso.  La 
forma delprocedimiento ser. la siguiente:SERIE (minimo NUMBER, maximo NUMBER, paso NUMBER)
 */
CREATE OR REPLACE PROCEDURE DUMMY.SERIE (minimo NUMBER, maximo NUMBER,paso NUMBER) IS 
    BEGIN
        FOR paso IN minimo..maximo LOOP
        DBMS_OUTPUT.PUT_LINE(minimo+paso);
        END LOOP;
    END Serie;


CALL SERIE(1, 10, 3);

/* 4.Crea una función AZAR que reciba dos parámetros y genere un número alazar  entre  un  mínimo
y  máximoindicado.  La  forma  de  la  función  serála siguiente:
AZAR (minimo NUMBER, maximo NUMBER) RETURN NUMBER
 */
CREATE OR REPLACE FUNCTION DUMMY.AZAR (minimo NUMBER, maximo NUMBER) RETURN NUMBER IS 
	NUMEROO NUMBER:=NULL;
BEGIN
	numeroo:= ABS(DBMS_RANDOM.RANDOM,maximo)+minimo;
 RETURN NUMEROO ;
 END AZAR;

SELECT azar(1,100) FROM dual;



/*5.Crea una función NOTA que reciba un parámetro que seráuna notanumérica entre 0 y 10 y 
devuelva una cadena de textocon la calificación(Suficiente, Bien, Notable, ...). 
La forma de la función serála siguiente:
NOTA(nota NUMBER) RETURN VARCHAR2*/
CREATE OR REPLACE FUNCTION NOTA (nota NUMBER) RETURN VARCHAR2 IS 
	MENSAJE VARCHAR2(30):='null';
BEGIN
CASE nota 
	WHEN 10 THEN 
	MENSAJE:='SOBRESALIENTE';
	WHEN 9  THEN 
	MENSAJE:='SOBRESALIENTE';
	WHEN 8  THEN 
	MENSAJE:='NOTABLE';
	WHEN 7  THEN 
	MENSAJE:='NOTABLE';
	WHEN 6  THEN 
	MENSAJE:='BIEN';
	WHEN 5  THEN 
	MENSAJE:='SUFICIENTE';
	WHEN 4  THEN 
	MENSAJE:='INSUFICIENTE';
	WHEN 3  THEN 
	MENSAJE:='INSUENTE';
	WHEN 2  THEN 
	MENSAJE:='INSUENTE';
	WHEN 1  THEN 
	MENSAJE:='INSUENTE';
	WHEN 0  THEN 
	MENSAJE:='INSUENTE';
	ELSE 
	DBMS_OUTPUT.PUT_LINE('NOTA INVALIDA');
	END CASE;
RETURN  MENSAJE;
 END NOTA;



SELECT NOTA(7) FROM DUAL;
