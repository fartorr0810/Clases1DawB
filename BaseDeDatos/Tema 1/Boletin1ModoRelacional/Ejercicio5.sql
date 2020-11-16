CREATE TABLE Profesor (
	nss text not null primary key,
	nombre	text,
	apellido	text
);
CREATE TABLE Grupo (
	id_grupo	smallint not null primary key,
	horario	date,
	nss	text not null references Profesor
);
CREATE TABLE Alumno(
	n_cuenta_bancaria	text not null primary key,
	nombre	text,
	nacionalidad	text
);
CREATE TABLE Nivel(
	n_cuenta_bancaria not null references Alumno,
	numeronivel	smallint not null primary key
);
CREATE TABLE Alumno_Nivel_Grupo(
	id_grupo	smallint not null references Grupo,
	n_cuenta_bancaria	text not null references Alumno,
	numeronivel	smallint not null references Nivel
	primary Key (id_grupo, n_cuenta_bancaria, numeronivel)
);