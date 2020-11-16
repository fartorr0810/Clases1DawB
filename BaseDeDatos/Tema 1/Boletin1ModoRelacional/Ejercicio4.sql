CREATE TABLE sucursal (
	id_sucursal	text not null Primary Key,
	activo_disponible	text
);
CREATE TABLE Cuenta (
	num_cuenta	smallint not null Primary Key,
	saldo	smallint
);
CREATE TABLE Sucursal_Cuenta(
	id_sucursal	smallint not null references sucursal,
	num_cuenta smallint not null references Cuenta
	Primary Key (id_sucursal, num_cuenta)
);
CREATE TABLE Cliente(
	dni	text not null primary key,
	nombre	text,
	ciudad	text,
	direccion	text
);
CREATE TABLE Cuenta_Cliente(
	dni	text not null references Cliente,
	num_cuenta	smallint not null references Cuenta
);
CREATE TABLE Transacciones (
	num_transaccion	text not null primary key,
	num_cuenta	text not null references Cuenta,
	cantidad decimal(10,2),
	tipo	text
);