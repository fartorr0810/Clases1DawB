CREATE TABLE Categoria (
	nombre text not null Primary Key
);

CREATE TABLE Producto (
	nombre text not null Primary Key,
	precio smallint,
	nombre smallint not null reference Categoria
);
CREATE TABLE Cliente (
	dni	text not null Primary Key,
	nombre	text,
	apellido	text,
	fechanacimiento	date,
	direccion	text
);
CREATE TABLE Compra (
	nombre text not null references Producto,
	dni	text not null references Cliente,
	fecha_compra	date
);