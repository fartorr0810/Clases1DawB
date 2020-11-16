CREATE TABLE Categoria (
	nombre text not null Primary Key
);

CREATE TABLE Producto (
	nombre text not null Primary Key,
	precio smallint,
	nombre smallint not null reference Categoria
);