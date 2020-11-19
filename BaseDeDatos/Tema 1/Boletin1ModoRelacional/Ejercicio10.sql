CREATE TABLE Fabricantes(
	id_fabricante	smallint not null primary key,
	nombre	text,
	direccion	text	
);
CREATE TABLE Telefono(
	id_fabricante	smallint references Fabricantes,
	Telefono	smallint not null primary key
);
CREATE TABLE Distribuidores(
	id_distr	smallint not null primary key,
	nombre	text,
	direccion	text,
	telf	text
);
CREATE TABLE Fabricantes_Distribuidores(
	id_distr	smallint not null references Distribuidores,
	id_fabricante	smallint not null references Fabricantes
);
CREATE TABLE FabricantesCede(
	id_fabricanteCededor	smallint not null references Distribuidores,
	id_fabricanteCedido	smallint not null references Distribuidores
);
CREATE TABLE Montadores(
	nif	text not null primary key,
	nombre	text,
	direccion	text
);
CREATE TABLE Cocina(
	id_cocina	smallint not null references primary key,
	nif_montador	text not null references Montadores
);
CREATE TABLE Clientes(
	nif_cliente	text not null primary key,
	id_cocina	text not null references Cocina,
	nombre	text,
	direccion	text,
	telf	smallint
);
CREATE TABLE Muebles(
	id_mueble	smallint not null primary key,
	alturasuelo	smallint,
	linea	smallint,
	dimensiones	smallint,
	color	text,
	tipo_mueble	text,
	alto	smallint,
	ancho	smallint,
	largo	smallint
);
CREATE TABLE Mueble_Encimera(
	id_mueble	smallint not null references Muebles,
	tipo_encimera
);

