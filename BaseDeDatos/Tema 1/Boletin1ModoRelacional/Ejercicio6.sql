CREATE TABLE Medico(
	dni_medico	text not null primary key,
	nombre	text,
	apellido	text,
	direccion
);
CREATE TABLE Sala(
	numplanta	smallint not null primary key
);
CREATE TABLE Paciente(
	dni_paciente	text not null primary key,
	nombre	text,
	apellido	text,
	direccion	text
);
CREATE TABLE Atiende(
	dni_paciente	text not null references Paciente,
	dni_medico	text not null references Medico,
	Sala	smallint not null references Sala,
	primary key	(dni_paciente, dni_medico ,Sala),
	hora_atencion	date not null
);