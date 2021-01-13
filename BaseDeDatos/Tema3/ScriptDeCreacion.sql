CREATE TABLE EmpresaSeguridad(
	cifseguridad varchar(15),
	PRIMARY KEY (cifseguridad)
	);
CREATE TABLE Guardias(
	idguardia   number(5),
	nombre  varchar2(30),
	apellidos   varchar2(30),
	cifseguridad varchar2(15),
	PRIMARY KEY (idguardia),
	FOREIGN KEY (cifseguridad) REFERENCES EmpresaSeguridad
	);
CREATE SEQUENCE secuenciaGuardias START with 1 INCREMENT BY 1 maxvalue 99999999 minvalue 1;
CREATE TABLE SUCURSAL (
	codsucursal number(4), 
	direccion   varchar2(30),
	telefono    varchar2(30),
	ciudad  varchar2(30),
	provincia   varchar2(30),
	cifseguridad varchar2(15),
	FOREIGN KEY (cifseguridad) REFERENCES EmpresaSeguridad,
	PRIMARY KEY (codsucursal)
	);
CREATE SEQUENCE secuenciaSucursal START with 1 INCREMENT BY 1 maxvalue 99999999 minvalue 1;
CREATE TABLE EMPLEADO(
	idtrabajador    number(5),
	nif varchar2(9),
	nombre  varchar2(30),
	apellido    varchar2(30),
	telefono    varchar2(30),
	direccion   varchar2(30),
	codigo_sucursal number(4),
	FOREIGN KEY (codigo_sucursal) REFERENCES SUCURSAL,
	PRIMARY KEY (idtrabajador)
	);
CREATE SEQUENCE secuenciaEmpleado START with 1 INCREMENT BY 1 maxvalue 99999999 minvalue 1;
CREATE TABLE REVISTA(
    idrevista   number(5),
    título  varchar2(30),
    tipo    varchar2(30),
    periodicidad    date,
    PRIMARY KEY (idrevista)
	);
CREATE SEQUENCE secuenciaRevista START with 1 INCREMENT BY 1 maxvalue 99999999 minvalue 1;
CREATE TABLE SucursalPublicaRevista(
    codsucursal	number(4),
    idrevista	number(5),
    FOREIGN KEY (idrevista) REFERENCES REVISTA,
	FOREIGN KEY (codsucursal) REFERENCES SUCURSAL, 
    PRIMARY KEY(codsucursal,idrevista)
    );

CREATE TABLE PERIODISTA(
	idperiodista 	number(4),
    nombre	varchar2(30),
    apellido varchar2(30),
    telefono	varchar2(10),
    especialidad	varchar2(30),
 	tiponacionalidadperiodista	varchar2(10),
    PRIMARY KEY (idperiodista)
    );
CREATE SEQUENCE secuenciaPeriodista START with 1 INCREMENT BY 1 maxvalue 99999999 minvalue 1;
CREATE TABLE Periodista_Escribe_Revista(
	idperiodista	number(4),
	idrevista	number(5),
	FOREIGN KEY (idperiodista) REFERENCES PERIODISTA,
	FOREIGN KEY (idrevista) REFERENCES REVISTA,
	PRIMARY key (idperiodista,idrevista)
	);

CREATE TABLE SECCION(
	idseccion	number(4),
	titulo	varchar2(30),
	descripcion	varchar2(30),
	idrevista number(5),
	FOREIGN KEY (idrevista) REFERENCES REVISTA,
	PRIMARY KEY (idseccion)
CREATE SEQUENCE secuenciaSeccion START with 1 INCREMENT BY 1 maxvalue 99999999 minvalue 1;
	);
CREATE TABLE EJEMPLAR(
	idejemplar	number(5),
	num_ejemplares	number(10), 
	numpaginas	number(3), 
	fecha	date, 
	idrevista	number(5),
	FOREIGN KEY (idrevista) REFERENCES REVISTA,
	PRIMARY KEY (idrevista)
	);
CREATE SEQUENCE secuenciaEjemplar START with 1 INCREMENT BY 1 maxvalue 99999999 minvalue 1;

 