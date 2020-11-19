CREATE TABLE Cliente(
	cod_cliente	smallint not null primary key,
	direccion	text,
	nombre	text
	telfono	smallint
);
CREATE TABLE Alavados(
	cod_cliente_alabado	smallint not null references Cliente,
	cod_cliente_alabador	smallint not null references Cliente,
	primary key (cod_cliente_alabador,cod_cliente_alabado)

);
CREATE TABLE Agencia(
	id_agencia	smallint not null primary key,
);
CREATE TABLE Coche(
	matricula	text not null primary key,
	marca	text,
	modelo	text,
	color	text
);
CREATE TABLE GARAJE(
	id_garaje	smallint not null primary key,
);
CREATE TABLE COCHE_GARAJE(
	id_garaje	smallint not null references GARAJE,
	matricula	text not null references Coche,
	primary key	(id_garaje,matricula)
);
CREATE TABLE Reserva(
	cod_reserva	smallint not null primary key,
	precioalquiler	integer,
	entregado	boolean,
	lgasoil	smallint,
	preciototal	integer,
	fecha_inicio	date,
	fecha_fin	date
);
CREATE TABLE Hace_Reserva(
	cod_cliente smallint not null references Cliente,
	cod_reserva	smallint not null references Reserva,
	id_agencia	smallint not null references Agencia
	primary key (cod_reserva,cod_cliente,id_agencia)
);