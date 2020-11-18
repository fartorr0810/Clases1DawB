CREATE TABLE Pais(
	numpais	integer not null primary key,
	numdeclubs	text
	);
CREATE TABLE Pais_representa(
	numpais_representa	not null references numpais,
	numpais_representado not null references numpais
);
CREATE TABLE Participante(
	num_participante	not null primary key,
	telefono	integer,
	nivel	smallint,
	nombre	text,
	campeonatos	text,
	direccion	text
);
CREATE TABLE