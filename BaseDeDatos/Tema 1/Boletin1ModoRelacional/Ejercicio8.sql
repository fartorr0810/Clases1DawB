CREATE TABLE Pais(
	numpais	integer not null primary key,
	numdeclubs	text
	);
CREATE TABLE Pais_representa(
	numpais_representa	not null references numpais,
	numpais_representado not null references numpais
);
CREATE TABLE Participante(
	num_participante	integer not null primary key,
	numpais integer not null primary key,
	telefono	integer,
	nivel	smallint,
	nombre	text,
	campeonatos	text,
	direccion	text,
	tipo_participante	text
);
CREATE TABLE Hotel(
	idhotel	smallint not null primary key,
	nombre	text,
	telf	text,
	direccion	text
);
CREATE TABLE Aloja(
	idhotel	smallint not null references Hotel,
	num_participante	integer not null references Participante,
	primary key (idhotel, num_participante)

);
CREATE TABLE Sala(
	id_sala	smallint not null primary key,
	idhotel	smallint not null references Hotel,
	capacidad	smallint not null,
	medios	smallint not null
);
CREATE TABLE Partida(
	cod_partida	smallint,
	num_participante	integer not null references Participante,
	tipo_participante	text not null
	primary key (cod_partida, num_participante,tipo_participante)
);
CREATE TABLE Movimiento(
	id_movimiento	integer not null primary key,
	color	text not null
);
CREATE TABLE Partida_Movimiento(
	cod_partida	integer not null primary key,
	color	text 
);