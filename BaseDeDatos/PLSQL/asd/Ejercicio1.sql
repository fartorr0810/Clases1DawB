CREATE OR REPLACE FUNCTION ADELALIRANUMERO(NUM NUMBER,NUM2 NUMBER) RETURN NUMBER IS 
    V_RESULTADO NUMBER:=-1;
    V_SUMA NUMBER:=0;
    BEGIN
        IF NUM>0 AND NUM=TRUNC(NUM) THEN
            NUM:=1;
            FOR i IN 1..NUM LOOP
                V_SUMA:=V_SUMA+I;
            END LOOP;
            DBMS_OUTPUT.PUT_LINE('El parametro de entrada y salida es '  V_SUMA);
            RETURN V_RESULTADO;

        ELSE
            V_SUMA:=0;
            DBMS_OUTPUT.PUT_LINE('El parametro de entrada y salida es '  V_SUMA);
            RETURN V_RESULTADO;
        END IF;

    END ADELALIRANUMERO;
//
CALL ADELALIRANUMERO(3,7);

CREATE OR REPLACE FUNCTION ADELALIRANUMERO(NUM NUMBER,NUM2 NUMBER) RETURN NUMBER IS 
    V_RESULTADO NUMBER:=-1;
    V_SUMA NUMBER:=0;
    BEGIN
        IF NUM>0 AND NUM=TRUNC(NUM) THEN
            NUM:=1;
            FOR i IN 1..NUM LOOP
                V_SUMA:=V_SUMA+I;
            END LOOP;
            DBMS_OUTPUT.PUT_LINE('El parametro de entrada y salida es '  V_SUMA);
            RETURN V_RESULTADO;

        ELSE
            V_SUMA:=0;
            DBMS_OUTPUT.PUT_LINE('El parametro de entrada y salida es '  V_SUMA);
            RETURN V_RESULTADO;
        END IF;

    END ADELALIRANUMERO;
//
CALL ADELALIRANUMERO(3,7);

CREATE OR REPLACE FUNCTION DUMMY.RAFAELCUBEROSNUMERO(numero NUMBER, param NUMBER) RETURN NUMBER IS

suma NUMBER ;
resultado NUMBER;
parametro NUMBER := param;
BEGIN
    suma:=0;

--Primer Caso devuelve -1 y entradaSalida es 0;
IF (numero=TRUNC(numero)) OR numero<0 THEN
    resultado:=-1;
    parametro:=0;

--Segundo caso devuelde entradaSalida=suma n numeros, return=1
ELSIF (numero=TRUNC(numero)) AND numero>0 THEN
    FOR i IN 1..numero LOOP
        suma:=suma+i;
        parametro:=suma;
    END LOOP;
    resultado:=1;
END IF;
RETURN resultado;
END RAFAELCUBEROSNUMERO;


/*
DECLARE
BEGIN
DELETE caballos WHERE CODCABALLO=25;
IF SQL%NOTFOUND THEN
RAISE_APPLICATION_ERROR(-20001,'No existe esa pieza');
END IF;
END;
/
*/
[18:43]
DECLARE
error_al_eliminar EXCEPTION;
BEGIN
DELETE piezas WHERE tipo='ZU' AND modelo=26;
IF SQL%NOTFOUND THEN
RAISE error_al_eliminar;
END IF;
EXCEPTION
WHEN error_al_eliminar THEN
DBMS_OUTPUT.PUT_LINE ('Error -20001: No existe esa pieza');
END

CREATE OR REPLACE PROCEDURE DUMMY.RAFAELCUBEROSInsertarApuesta(codCab NUMBER, codCarrera NUMBER, dniCliente varchar2, importe NUMBER) IS
aux NUMBER;
V_apuesta_Max NUMBER;
BEGIN

    SELECT COUNT() INTO aux FROM CABALLOS c WHERE c.CODCABALLO=codCab;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20001,'Caballo Imaginario');


    END IF;
    SELECT COUNT() INTO aux FROM CARRERAS c WHERE c.CODCARRERA=codCarrera;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20002,'Carrera Imaginario');
    END IF;
    SELECT COUNT() INTO aux FROM CLIENTES c WHERE c.DNI=dniCliente;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20003,'Cliente Imaginario');

    END IF;
    SELECT COUNT() INTO aux FROM CABALLOS c, PARTICIPACIONES p, CARRERAS c2 WHERE c.CODCABALLO=codCab AND c.CODCABALLO=p.CODCABALLO AND p.CODCARRERA=c2.CODCARRERA;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20004,'Caballo Descansando');
    END IF;
    SELECT c.APUESTALIMITE INTO v_apuesta_Max FROM CARRERAS c WHERE c.CODCARRERA=codCarrera;
    IF importe>V_apuesta_Max THEN
        RAISE_APPLICATION_ERROR(-20005,'Jugar es Malo');

    INSERT INTO APUESTAS VALUES(dniCliente, codCab, codCarrera, importe, 1);
    END IF;
END;
[19:16]
CREATE OR REPLACE PROCEDURE DUMMY.RAFAELCUBEROSInsertarApuesta(codCab NUMBER, codCarrera NUMBER, dniCliente varchar2, importe NUMBER) IS
aux NUMBER;
V_apuesta_Max NUMBER;
BEGIN

    SELECT COUNT() INTO aux FROM CABALLOS c WHERE c.CODCABALLO=codCab;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20001,'Caballo Imaginario');


    END IF;
    SELECT COUNT() INTO aux FROM CARRERAS c WHERE c.CODCARRERA=codCarrera;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20002,'Carrera Imaginario');
    END IF;
    SELECT COUNT() INTO aux FROM CLIENTES c WHERE c.DNI=dniCliente;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20003,'Cliente Imaginario');

    END IF;
    SELECT COUNT() INTO aux FROM CABALLOS c, PARTICIPACIONES p, CARRERAS c2 WHERE c.CODCABALLO=codCab AND c.CODCABALLO=p.CODCABALLO AND p.CODCARRERA=c2.CODCARRERA;
    IF SQL%NOTFOUND THEN
        RAISE_APPLICATION_ERROR(-20004,'Caballo Descansando');
    END IF;
    SELECT c.APUESTALIMITE INTO v_apuesta_Max FROM CARRERAS c WHERE c.CODCARRERA=codCarrera;
    IF importe>V_apuesta_Max THEN
        RAISE_APPLICATION_ERROR(-20005,'Jugar es Malo');

    INSERT INTO APUESTAS VALUES(dniCliente, codCab, codCarrera, importe, 1);
    END IF;

END;

CREATE OR REPLACE TRIGGER MODIFICADDOBORRADO AFTER UPDATE OR DELETE ON APUESTAS FOR EACH ROW 
    BEGIN 
        IF UPDATING ('DNICLIENTE') THEN 
            INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: '  SYSDATE  ' Antiguo Dni Cliente: '  :NEW.DNICLIENTE  ' nuevo Dni Cliente:'  :NEW.DNICLIENTE  ' tipo de operacion: MODIFICACIÓN ' );
        END IF;
        IF UPDATING ('CODCABALLO') THEN 
            INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: '  SYSDATE  ' Antiguo Dni Codigo caballo: '  :NEW.CODCABALLO  ' nuevo Dni Codigo caballo:'  :NEW.CODCABALLO  ' tipo de operacion: MODIFICACIÓN ' );
        END IF;     --salta excepcion por que es PK
        IF UPDATING ('CODCARRERA') THEN 
            INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: '  SYSDATE  ' Antiguo Codigo carrera: '  :NEW.CODCARRERA  ' nuevo Codigo carrera:'  :NEW.CODCARRERA  ' tipo de operacion: MODIFICACIÓN ' );
        END IF;     --salta excepcion por que es PK
        IF UPDATING ('IMPORTE') THEN 
            INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: '  SYSDATE  ' Antiguo importe: '  :NEW.IMPORTE  ' nuevo importe:'  :NEW.IMPORTE  ' tipo de operacion: MODIFICACIÓN ' );
        END IF;
        IF UPDATING ('TANTOPORUNO') THEN 
            INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: '  SYSDATE  ' Antiguo tanto por uno: '  :NEW.TANTOPORUNO  ' nuevo tanto por uno:'  :NEW.TANTOPORUNO  ' tipo de operacion: MODIFICACIÓN ' );
        END IF;
        IF DELETING  THEN 
            INSERT INTO AUDITORIA_APUESTAS VALUES  ('Fecha: '  SYSDATE  ' Antiguo Dni Cliente: '  :OLD.DNICLIENTE  ' nuevo Dni Cliente:'  :OLD.DNICLIENTE  ' tipo de operacion: BORRADO ' );
        END IF;
    END MODIFICADDOBORRADO;
UPDATE APUESTAS 
SET APUESTAS.IMPORTE ='2000';
WHERE APUESTAS.IMPORTE ='350';

DELETE FROM APUESTAS WHERE APUESTAS.IMPORTE='2000';

create or replace trigger modifyBorrado after  update or delete on apuestas for each row
    begin
        if updating('importe') then
            insert into AUDITORIA_APUESTAS values ('Fecha: '  SYSDATE  ' Antiguo Dni Cliente: '  :OLD.importe  ' nuevo Dni Cliente:'  :NEW.importe  ' tipo de operacion: MODIFICACIÓN ');
        end if;
        if deleting then
            insert into AUDITORIA_APUESTAS values ('Fecha: '  SYSDATE  ' Antiguo Dni Cliente: '  :OLD.importe  ' nuevo Dni Cliente:'  :NEW.importe  ' tipo de operacion: MODIFICACIÓN ');
        end if;
    end;
/
update APUESTAS set APUESTAS.importe = 1203 where APUESTAS.importe = 350;
commit;