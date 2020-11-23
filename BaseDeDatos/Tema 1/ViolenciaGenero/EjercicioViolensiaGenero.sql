CREATE TABLE Piso(
	idpiso	smallint not null primary key,
	ciudad	text not null
);
CREATE TABLE Victima(
	idvicitima	smallint not null primary key,
	denunciasrealizadas	smallint,
	numhijos	smallint,
	dni 	text not null,
	telefono	smallint,
	ciudad	text,
	tipo_violencia	text
CREATE TABLE Victima_Piso(
	idpiso smallint not null references Piso,
	idvicitima	smallint not null references Victima,
	fechaentrada	date not null,
	fechasalida	date not null
);
CREATE TABLE Maltratador(
	idmaltratador	smallint not null primary key,
	numDenuncias	smallint,
	telefono	smallint,
	dni 	text,
	ciudad	text
);
CREATE TABLE Policia(
	idpolicia	smallint not null primary key
);
CREATE TABLE Denuncia(
	idvicitima	smallint not null references Victima,
	idmaltratador	smallint not null references Maltratador,
	idpolicia	smallint not null references policia,
	fecha 	date,
	motivos	text
	primary key (idpolicia,idmaltratador,idvicitima,fecha)
);
CREATE TABLE RegistroDenuncias(
	idregistro	smallint not null primary key,
	idmaltratador	smallint not null references Maltratador
);
CREATE TABLE Juicio(
	idmaltratador	smallint not null references Maltratador,
	idcondena	smallint not null references Condena,
	fecha_comienzo	date,
	fecha_finalizacion	date
);
CREATE TABLE Condenado_RegistroDenuncias(
	idcondena	smallint not null references Condena,
	idregistro	smallint not null references RegistroDenuncias
);