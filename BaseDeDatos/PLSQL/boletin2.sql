/* 1.Escribe unprocedimiento que muestre el número de empleados y 
el salariomínimo, máximo y medio del departamento de FINANZAS. 
Debe hacerse uso decursores implícitos, es decir utilizar SELECT ... INTO.
 */
CREATE OR REPLACE PROCEDURE DUMMY.MIOSTRARINFO ()
AS 
  CURSOR cursorempleado IS 
 	SELECT count(e.NUMEM) AS NUMEMPLEADOS ,MIN(e.SALAR) AS SALARIOMIN, MAX(e.SALAR) AS SALARIOMAX, AVG(e.SALAR) AS SALARIOMED
	FROM DUMMY.EMPLEADOS e ,DUMMY.DEPARTAMENTOS d
	WHERE d.NUMDE=e.NUMDE AND d.nomde='FINANZAS';
BEGIN
	DBMS_OUTPUT.PUT_LINE('El numero de empleados es'|| cursorempleado.NUMEMPLEADOS);
	DBMS_OUTPUT.PUT_LINE('El salario minimo es'|| cursorempleado.SALARIOMIN);
	DBMS_OUTPUT.PUT_LINE('El salario maximo es'|| cursorempleado.SALARIOMAX);
	DBMS_OUTPUT.PUT_LINE('El salario medio es'|| cursorempleado.SALARIOMED);
END dummy.miostrarinfo;

CREATE OR REPLACE PROCEDURE DUMMY.SUELDOEMPLEADOS IS
SALARIO_MINIMO EMPLEADOS.SALAR%TYPE;
SALARIO_MAXIMO EMPLEADOS.SALAR%TYPE;
SALARIO_MEDIO EMPLEADOS.SALAR%TYPE;
NUMERO_EMPLEADOS EMPLEADOS.NUMEM%TYPE;
	BEGIN
		SELECT MIN(SALAR), MAX(SALAR), AVG(SALAR), COUNT(NUMEM)
		INTO SALARIO_MINIMO, SALARIO_MAXIMO, SALARIO_MEDIO, NUMERO_EMPLEADOS
		FROM EMPLEADOS, DEPARTAMENTOS d2 
		WHERE EMPLEADOS.NUMDE =d2.NUMDE AND d2.NOMDE='FINANZAS';
		DBMS_OUTPUT.PUT_LINE('Salario minimo: ' || SALARIO_MINIMO  || 
							', salario maximo ' || SALARIO_MAXIMO || 
							', salario medio ' || SALARIO_MEDIO || 
							' y numero de empleados ' || NUMERO_EMPLEADOS);
	END SUELDOEMPLEADOS;  
/* 2.Escribe un procedimiento que suba un 10% el salario a los EMPLEADOS 
conmás de 2 hijos y que ganen menos de 2000 €. Para cada empleado se mostrar
por pantalla el código de empleado, nombre, salario anterior y final. Utiliza 
un cursorexplícito. La transacción no puede quedarsea medias. Si por  cualquier  
razón  no  esposible  actualizar  todos  estos  salarios,  debe deshacerse el trabajo 
a la situacióninicial.
 */
CREATE OR REPLACE PROCEDURE DUMMY.SUBIRSALARIO AS
	CURSOR subirempleados IS
	SELECT *
	FROM Empleados e
	WHERE e.NUMHI>1 AND e.SALAR<2000;
	datos	empleados%rowtype;
BEGIN
	open subirempleados;
	loop
	  fetch subirempleados into datos;
	  exit when subirempleados%NOTFOUND;
	  DBMS_OUTPUT.PUT_LINE('El codigo es '||datos.numem||
	  'El nombre:'||datos.nomem||
	  'El salario;'||datos.SALAR||
	  'El nuevo salario'||datos.salar*1.1);
	  update empleados set salar=Datos.salar*1.1 where numem=datos.numem;
	end loop;
	close subirempleados;
	end subirsalario;

END subirsalario;
/* 3.Escribe   un   procedimiento   que   reciba   dos   parámetros   (número   dedepartamento, hijos).
Deber. crearse un cursor explícito al que se le pasarán estosparámetros y que mostrar.
los datos de los empleados que pertenezcan aldepartamento y con el número de hijos indicados.
Al final se indicar. el número deempleados obtenidos.
 */
/* 3.Escribe   un   procedimiento   que   reciba   dos   parámetros   (número   dedepartamento, hijos).
Deber. crearse un cursor explícito al que se le pasarán estosparámetros y que mostrar.
los datos de los empleados que pertenezcan aldepartamento y con el número de hijos indicados.
Al final se indicar. el número deempleados obtenidos.
 */
CREATE OR REPLACE PROCEDURE DATOSEMPLEADOS(v_numdep	DEPARTAMENTOS.NUMDE%TYPE, v_numhijos	empleados.NUMHI%TYPE)
AS
...
CURSOR parametros IS 
SELECT e.NUMDE , e.NUMHI 
FROM empleados e,departamentos d2
WHERE e.NUMDE=d2.numde AND e.NUMHI=v_numhijos ;
	variablenumdep	departamentos.numde%TYPE;
	variablenumhijos empleados.numhijos%TYPE;
	v_empleados	empleados%rowtype;
BEGIN
	OPEN parametros;
	FETCH parametros INTO v_empleados;
	LOOP 
	  DBMS_OUTPUT.PUT_LINE('El numero de dapartamento es '||variablenumdep||'y los hijos son'||VARIABLENUMHIJOS);
	 CLOSE parametros;
END DATOSEMPLEADOS;

CALL DATOSEMPLEADOS(112,1);

/* 4.Escribe un procedimiento con un parámetro 
para el nombre de empleado,que nos muestrela edad de dicho empleado en años, meses y días. */