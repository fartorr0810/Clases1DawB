CREATE TABLE EmpresaSeguridad(
	cif text(15)
	PRIMARY KEY (cif),
	);
CREATE TABLE Guardias(
	idguardia   number(5),
	nombre  text,
	apellidos   text,
	cif text(15) ADD REFERENCES EmpresaSeguridad(cif),
	PRIMARY KEY (idguardia)
	);
CREATE TABLE SUCURSAL(
	codigo  number(4), 
	direccion   text,
	telefono    text,
	ciudad  text,
	provincia   text
	PRIMARY KEY (codigo)
	);

CREATE TABLE EMPLEADO(
	idtrabajador    number(5),
	nif text,
	nombre  text,
	apellido    text,
	telefono    text,
	direccion   text,
	codigo_sucursal number(4) ADD REFERENCES SUCURSAL(codigo),
	PRIMARY KEY (idtrabajador)
	);
CREATE TABLE REVISTA(
    idrevista   number(5),
    título  text,
    tipo    text,
    periodicidad    date,
    PRIMARY KEY (idrevista)
	);
CREATE TABLE SucursalPublicaRevista(
    codigo_sucursal	number(4) add REFERENCES SUCURSAL(codigo), 
    idrevista	number(5) add REFERENCES REVISTA(idrevista)
    );

CREATE TABLE PERIODISTA(
	idperiodista 	number(4),
    nombre	text,
    apellido text,
    teléfono	text,
    especialidad	text
    PRIMARY KEY (idperiodista)
    );

CREATE TABLE Periodista_Escribe_Revista(
	idperiodista	number(4) add REFERENCES PERIODISTA(idperiodista),
	idrevista	number(5) add REFERENCES REVISTA(idrevista)
	);

CREATE TABLE SECCION(
	idseccion	number(4) PRIMARY KEY,
	titulo	text,
	descripcion	text,
	idrevista number(5) add REFERENCES REVISTA(idrevista)
	);
CREATE TABLE EJEMPLAR(
	idejemplar	number(5) PRIMARY KEY,
	num_ejemplares	number(10), 
	numpaginas	(3), 
	fecha	date, 
	idrevista	number(5) add REFERENCES REVISTA(idrevista)
	);
