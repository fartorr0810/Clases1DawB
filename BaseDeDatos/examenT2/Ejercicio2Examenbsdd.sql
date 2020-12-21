CREATE TABLE Persona(
	dni	text not null primary key,
	telefono	text,
	poblacion	text,
	direccion	text,
	apellidos	text,
	nombre	text
);
CREATE TABLE Infracciones(
	idifraccion	smallint not null primary key,
	fecha	date,
	hora	time,
	importe	smallint,
	lugar	text
);
CREATE TABLE Vehiculo(
	matricula	text not null primary key,
	marca 	text,
	modelo	text
	idifraccion	smallint not null references Infracciones
);
CREATE TABLE Persona_Vehiculo(
	dni 	text not null references Persona,
	matricula	text not null references Vehiculo,
	primary key	(dni,matricula)
);
CREATE TABLE Accidente(
	idacidente	smallint not null primary key,
	fecha	date,
	hora	time,
	lugar	text
);
CREATE TABLE Vehiculo_accidente(
	matricula	smallint not null references Vehiculo,
	idacidente	smallint not null references Accidente
);
