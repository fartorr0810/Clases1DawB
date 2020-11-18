CREATE TABLE alumno (
	dni	text not null Primary Key,
	apellido	text,
	nombre	text
);
CREATE TABLE Coche (
	matricula	text not null Primary Key,
	modelo	text,
	marca	text
);
CREATE TABLE Profesor (
	nss	text not null Primary Key,
	dni text,
	nombre	text,
	apellido	text
);
CREATE TABLE clase (
	dni	text not null references alumno,
	matricula	text not null references Coche,
	nss	text not null references Profesor,
	primary key	(dni,nss,matricula)
);