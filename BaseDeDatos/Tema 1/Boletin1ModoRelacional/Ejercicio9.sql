CREATE TABLE Empleado(
	num_matricula smallint not null primary key,
	porcentajehacienda	decimal,
	nombre	text,
	dni	text,
	edad	smallint,
	numhijos	smallint
	);
CREATE TABLE Cuenta(
	num_matricula not null references Empleado,
	cuentacorriente	text not null primary key,
	banco	text
);
CREATE TABLE Departamento(
	id_departamento	smallint not null primary key,
);
CREATE TABLE Empleado_Departamento(
	id_departamento	smallint not null references Departamento,
	num_matricula	smallint not null references Empleado,
	primary key (id_departamento,num_matricula)

);
CREATE TABLE Retribucion(
	cod_retribucion	smallint not null primary key,
	descrip	text
);
CREATE TABLE JustificanteNomina(
	id_nomina	smallint not null primary key,
	num_matricula	smallint not null references Empleado,
	cod_retribucion	smallint not null references Retribucion
	numorden	smallint,
	mes	date
);
CREATE TABLE JustificanteNomina_Ingreso(
	id_nomina	smallint not null references JustificanteNomina,
	cantidad_positiva	decimal
);
CREATE TABLE JustificanteNomina_Descuento(
	id_nomina	smallint not null references JustificanteNomina,
	base	decimal,
	cantidadnegativa	decimal
);
CREATE TABLE ElementoCoste(
	cod_coste	smallint not null references primary key,
	saldo	decimal,
	descrip	text
);
CREATE TABLE JustificanteNomina_ElementoCoste(
	cod_coste	smallint not null references ElementoCoste,
	id_nomina	smallint not null references JustificanteNomina
);
CREATE TABLE ElementoCoste_Tiene(
	ElementoCosteDependiente	smallint not null references ElementoCoste,
	ElementoCosteIndepiente	smallint not null references ElementoCoste,
	primary key (ElementoCosteDependiente,ElementoCosteIndepiente)

);
