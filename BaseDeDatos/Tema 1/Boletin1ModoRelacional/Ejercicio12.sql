CREATE TABLE Personal(
	dni	smallint not null primary key,
	nss	smallint,
	nombre	text,
	direccion	text,
	telf	smallint,
	sueldo	decimal,
	tipo_personal	text
);
CREATE TABLE Personal_PersonalInvestigacion(
	dni	smallint not null references Personal,
	presupuesto	decimal,
	periodorealizacion	date
);
CREATE TABLE Personal_PersonalInvestigacion(
	dni	smallint not null references Personal,
	matricula	text not null primary key,
	tipo	text
);
CREATE TABLE Personal_PersonalGestion(
	dni	smallint not null references Personal,
	nentradasasignadas	smallint
);
CREATE TABLE CA (
	cod_autonoma	smallint not null primary key,
	organismoresponsable	text
);
CREATE TABLE Parque(
	cod_autonoma	smallint not null references CA,
	nombre	text not null primary key,
	fecha_declaracion	date,
	extension	text
);
CREATE TABLE Entrada(
	identrada	smallint not null primary key,
	cod_autonoma	smallint not null references Parque
);
CREATE TABLE Area(
	idarea	smallint not null primary key,
	nombre	text not null references CA
);
CREATE TABLE Especie (
	idarea	smallint not null references Area,
	denominacioncientificia	text not null primary key,
	denominacionvulgar	text,
	inventarioespecie	smallint,
	tipo_especie	text
);
CREATE TABLE Especie_Minerales(
	denominacioncientificia	text not null references Especie,
);
CREATE TABLE Especie_Animales(
	denominacioncientificia	text not null references Especie,
	alimento	text,
	celo	date
);CREATE TABLE Visitante(
	nombre_parque	text not null references Parque,
	dni	text not null primary key,
	nombre	text,
	domicilio	text,
	profesion	text
);
CREATE TABLE Alojamiento(
	dni	text not null references Visitante,
	capacidad	text,
	categoria	text
);
CREATE TABLE Excursiones(
	id_alojamiento	smallint not null primary key,
	dni	text not null references Visitante
	vehiculo	text,
	horario	date
);