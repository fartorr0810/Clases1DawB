/* 1.Crear un procedimiento que en la tabla emp incremente el 
salario el 10% a los empleados quetengan una comisión superior al 5% del salario. 
 */
CCREATE OR REPLACE PROCEDURE DUMMY.SUBIRSALARIO IS
CURSOR datos IS
	SELECT e.NOMEM ,e.SALAR ,e.COMIS 
	FROM empleados e
	WHERE e.COMIS > e.SALAR *0.05 FOR UPDATE ;
	v_nombre empleados.NOmem%TYPE;
	v_salario empleados.salar%TYPE;
	v_salnuevo empleados.salar%TYPE;
	v_comision empleados.comis%TYPE;
BEGIN
	OPEN datos;
	WHILE datos%FOUND LOOP
   	FETCH datos INTO v_nombre, v_salario, v_comision;
    	UPDATE EMPLEADOS 
	    SET EMPLEADOS.salar=EMPLEADOS.SALAR *1.1 
	    WHERE CURRENT OF datos;
		SELECT EMPLEADOS.SALAR INTO v_salnuevo FROM EMPLEADOS WHERE EMPLEADOS.nomem=v_nombre;
	END LOOP;
	CLOSE datos ;
END subirsalario;

/* 2.Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos
vendedores/as con más comisiones.
 */
  */
CREATE OR REPLACE PROCEDURE MostrarMejoresVendedores IS
    CURSOR vendedor
    IS 
    SELECT e.NOMEM , e.COMIS 
    FROM empleados e
    ORDER BY e.COMIS ASC;
    v_vendedores c_vendedores%rowtype;
   BEGIN 
    OPEN vendedor;
    FETCH vendedor INTO v_vendedores;
    WHILE C_VEND%FOUND AND C_VEND%ROWCOUNT<=2 LOOP
        DBMS_OUTPUT.PUT_LINE(V_VEND.ENAME);
        FETCH VENDEDOR INTO V_VEND;
    END LOOP;
	CLOSE vendedor;
END MostrarMejoresVendedores;
/* 3.Realiza un procedimiento MostrarsodaelpmE que reciba el nombre de un departamento 
alrevés y muestre los nombres de los empleados de ese departamento. 
 */



CREATE OR REPLACE PROCEDURE Mostrarsueldemp



/* 4.Realiza un procedimiento RecortarSueldos que recorte el sueldo un 20% a los empleados
cuyo nombre empiece por la letra que recibe como parámetro. Trata las excepciones que
consideres necesarias.
 */
CREATE OR REPLACE PROCEDURE RecortarSueldos(letras varchar2) IS 
numemple NUMBER ;
BEGIN 
	IF length(letras)=0 THEN 
	raise_application_error(-20001,"Solo un caracter");
	END IF 
	IF (ASCII(UPPER(letras)) NOT between(65,90) THEN 
		raise_application_error(-20001,"Solo un caracter");
	END IF 
	select count(*) INTO numemple FROM emple WHERE ename LIKE upper(letras% || '%');
	IF numEmple=0 THEN 
	raise_application_error(-20001,'No hay empleados');
	END IF;
	UPDATE emp SET sal=sal sal*0.20 WHERE ename LIKE upper(letras||'%');
END;

SELECT ASCII(UPPER('a')) FROM dual WHERE ascii(upper(letras));


/* 5.Realiza un procedimiento BorrarBecarios que borre a los dos empleados más nuevos de cada
departamento. */
CREATE or replace procedure borrarbecarios() is 
    cursor cdepartamento is select deptno from dept;
    numerodpto dept.deptno%tyoe;
    cursor c1 is select empno from  emp where deptno=numeroDpto order by hiredate desc;
    cont num=0;
    numeroemple emp.empno%type;
begin 
    for departamento in cdepartamento loop 
        numerodpto=departamento.deptno;
        open c1;
        fetch c1 into numeroemple;
        if c1%FOUND THEN 
            while cont <=2 loop
            delete from emp where empno=numeroemple;
            end loop
        end if 
end 