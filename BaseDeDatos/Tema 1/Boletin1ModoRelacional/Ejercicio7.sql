CREATE TABLE Club(
	idclub	smallint not null primary key,
	anofundacion	date not null,
	nsocios	integer,
	nombrepresidente	varchar(30) not null,
	estadio	text
);
CREATE TABLE Jugador(
	n_ficha	integer not null primary key,
	peso	decimal(5,2),
	nombre	text,
	fechanacimiento	date,
	estatura	decimal(5,4),
	apellido	text,
);
CREATE TABLE Contrato(
	n_ficha	integer not null references Jugador,
	idclub	smallint not null references Club,
	fechacomienzo	date,
	duracion	date,
	clasularesicion integer,
	fichaanual	date,
	primary key (n_ficha, idclub)
);
CREATE TABLE Arbitro(
	ncolegiado	integer not null primary key,
	nombre	text,
	colegioarbitral	text,
	numtemporadas	smallint,
	apellido	text,
	tipo_arbitro	text
);
CREATE TABLE Partido(
	idclub	smallint not null references Club,
	ncolegiado	integer not null references Arbitro,
	n_ficha	integer not null references Jugador,
	num_minutos	smallint,
	golesencontra	smallint,
	golesafavor	smallint
);