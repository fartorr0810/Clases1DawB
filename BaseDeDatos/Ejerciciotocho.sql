CREATE TABLE Oficina(
	idoficina	smallint not null primary key
);
CREATE TABLE Empleado(
	nombre	text,
	fax	text,
	telf	text,
	direccion	text,
	email	text,
	nss		smallint not null primary key,
	idoficina	smallint not null references Oficina,
	jefe	boolean
);
CREATE TABLE Cliente(
	nombre	text,
	email	text,
	idcliente	smallint not null primary key,
	direccion	text
);
CREATE TABLE Telefono(
	numtelefono	text not null primary key,
	idcliente	smallint not null references Cliente
);
CREATE TABLE Expediente(
	idcliente	smallint not null references Cliente,
	nss_empleado	smallint not null references Expediente,
	idexpediente	smallint not null primary key,
	fechaapertura	date,
	fechacierre	date,
	preciototal	integer
	tipo_estado	text,
	tipo_servicios	text
);
CREATE TABLE Proveedor(
	idproveedor	smallint not null primary key,
	telf 	text,
	direccion	text
);
CREATE TABLE Servicio(
	idservicio	smallint not null primary key,
	idproveedor	smallint not null references Proveedor,
	tipo_servicio	text
);
CREATE TABLE Servicio_Restauracion(
	idservicio	smallint not null references Servicio,
	descripcion	text,
	fechainicio	date,
	dechafin	date
	precio 	smallint
);
CREATE TABLE Servicio_Excursion(
	idservicio	smallint not null references Servicio,
	costumbres	text,
	ciudad	text,
	idioma	text,
	religion	text,
	clima	text
);
CREATE TABLE Establecimiento(
	idestablecimiento	smallint not null primary key,
	tipo 	text,
	nombre	text,
	categoria	text,
	direccion	text,
	telefono 	text,
	tipo_temporada	text
	tipo_servicioofrecido	text
	);
CREATE TABLE Servicio_Alojamiento(
	idservicio	smallint not null references Servicio,
	idestablecimiento	smallint not null references Establecimiento,
	costumbres	text,
	ciudad	text,
	idioma	text,
	religion	text,
	clima	text
);
CREATE TABLE Establecimiento_TemporadaAlta(
	idestablecimiento	smallint not null primary key,
	precio 	smallin
	);
CREATE TABLE Establecimiento_TemporadaBaja(
	idestablecimiento	smallint not null primary key,
	precio 	smallin
	);
CREATE TABLE Establecimiento_TemporadaMedia(
	idestablecimiento	smallint not null primary key,
	precio 	smallin
	);




