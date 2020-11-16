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
	dni	text not null reference alumno,
	matricula	text not null reference Coche,
	nss	text not null reference Profesor,
	primary key	(dni,nss,matricula)
);