CREATE TABLE Departamento (
	nombre_departamento	text not null Primary Key,
	presupuesto	text
);
CREATE TABLE depende (
	nombre_departamento_dependiente	text not null references Departamento,
	nombre_departamento_independiente text not null references Departamento	
);
CREATE TABLE Empleado (
	nss	text not null Primary Key,
	nombre_departamento text not null references Departamento,
	estadocivil	text,
	dni	text,
	apellido	text,
	nombre	text,
	nhijos	smallint
);
ALTER TABLE Departamento ADD jefe text references Empleado;