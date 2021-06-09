/* 1.Escribe un procedimiento que muestre el número de empleados y el
salariomínimo, máximo y medio del departamento de FINANZAS. Debe hacerse uso de
cursores implícitos, es decir utilizar SELECT ... INTO.
 */
CREATE OR REPLACE PROCEDURE boletin2x1 IS 
	CURSOR c IS 
		SELECT max(em.SALAR),MIN(em.SALAR),avg(em.SALAR),COUNT(em.NOMEM)
		FROM EmPLEADOS em,DEPARTAMENTOS d 
		WHERE em.NUMDE =d.NUMDE AND d.NOMDE='FINANZAS';
	salariomax	empleados.salar%TYPE;
	salariomin	empleados.salar%TYPE;
	salariomed	empleados.salar%TYPE;
	numepleados	empleados.salar%TYPE;

	BEGIN
		OPEN c;
		FETCH c INto salariomax,salariomin,salariomed,numepleados;
		dbms_output.put_line('Salario maximo: '||salariomax||'Salario minimo: '||salariomin
							||'Salario medio: '||salariomed||'y hay :'||numepleados||' empleados.');
		END boletin2x1;
/* 2.Escribe un procedimiento que suba un 10% el salario a los EMPLEADOS conmás 
de 2 hijos y que ganen menos de 2000 €. Para cada empleado se mostrar por pantalla
el código de empleado, nombre, salario anterior y final. Utiliza un cursorexplícito. 
La transacción no puede quedarsea medias. Si por  cualquier  razón  no  esposible  actualizar 
todos  estos  salarios,  debe deshacerse el trabajo a la situacióninicial.
 */
CREATE OR REPLACE PROCEDURE DUMMY.boletin2x2 IS 
	CURSOR c is SELECT e.NUMEM ,e.NOMEM ,e.SALAR FROM EMPLEADOS e ;
	numempleado	empleados.numem%TYPE;
	nombreempleado	empleados.nomem%TYPE;
	salarempelado	empleados.salar%TYPE;
BEGIN
	OPEN c;
	LOOP
	FETCH c INTO numempleado,nombreempleado,salarempelado;
	EXIT WHEN c%NOTFOUND;
		dbms_output.put_line('El codigo del empleado es:'||numempleado||'Su nombre es: '||nombreempleado||
		'Y su salario era: '||salarempelado||' y su nuevo sueldo sera'||salarempelado*1.1);
	UPDATE EMPLEADOS
	SET salar=salar*1.1 
	WHERE empleados.salar<2000 AND empleados.numhi=2;
	END loop;
END boletin2x2;
/* 3.Escribe   un   procedimiento   que   reciba   dos   parámetros   (número   dedepartamento, hijos).
Deber. crearse un cursor explícito al que se le pasarán estosparámetros y que mostrar. los datos de 
los empleados que pertenezcan aldepartamento y con el número de hijos indicados. 
Al final se indicar. el número deempleados obtenidos.
*/
CREATE OR REPLACE PROCEDURE boletin2x3 (numero NUMBER,hijos number) IS 
	CURSOR c IS SELECT e.NUMDE ,e.NUMHI 
				FROM EMPLEADOS e;
	v_numdepartamento empleados.numde%TYPE;
	v_numhijos	empleados.numhi%TYPE;
	contador NUMBER:=0;
	BEGIN
		OPEN c;
	LOOP 
	FETCH c INTO v_numdepartamento,v_numhijos;
	EXIT WHEN c%NOTFOUND;
	IF v_numdepartamento=numero AND v_numhijos=hijos THEN 
		contador:=contador+1;
	END IF;
	END LOOP;
	dbms_output.put_line(contador);
	END boletin2x3;
/* 4.Escribe un procedimiento con un parámetro para el nombre de empleado,que nos
 muestrela edad de dicho empleado en años, meses y días */
 CREATE OR REPLACE PROCEDURE DUMMY.boletin2x4 (nombre varchar2) IS 
CURSOR c IS SELECT empleados.FECNA
			FROM empleados
			WHERE empleados.FECNA=nombre;
dias	NUMBER;
meses	NUMBER;
agnos	NUMBER;
BEGIN 
	OPEN c;
	LOOP
	FETCH c INTO dias,meses,agnos;
	EXIT WHEN c%notfound;
		dias:=EXTRACT(DAY FROM agnos);
		meses:=EXTRACT(MONTH FROM meses);
		agnos:=EXTRACT(YEAR FROM agnos);
	dbms_output.putline(dias||meses||agnos);
	END LOOP;
	CLOSE c;
END boletin2x4;

--Boom xd