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