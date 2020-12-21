--1.
CREATE TABLE Matricula(
	matricula 	number(2) DELETE ON CASCADE,
	nombre	VARCHAR2(30),
	PRIMARY KEY (matricula)
);
CREATE TABLE Asignaturas(
	codigo	VARCHAR2(2) DELETE ON CASCADE,
	titulo	VARCHAR2(30),
	PRIMARY KEY (codigo)
);
CREATE TABLE Matriculan(
	matalumno	number(2),
	codasignatura	VARCHAR2(2),
	FOREIGN KEY (matalumno) REFERENCES Matricula(matricula),
	FOREIGN KEY (codasignatura) REFERENCES Asignaturas(matricula),
	PRIMARY KEY (matalumno,codasignatura)
);
--1.2
INSERT INTO Matriculan(matalumno,codasignatura)
VALUES (5,'A1')
--1.3
UPDATE Asignaturas
set titulo='Bases de datos'
where titulo='BBDD' and codigo='A1'
--1.4
Delete from Asignaturas
where titulo='Inteligencia Artificial' and codigo='A4'

--Ejercicio 2
CREATE TABLE Enfermo(
	cod_inscripcion	number(4),
	nss	VARCHAR2(10),
	nombre	VARCHAR2(30),
	sexo	VARCHAR2(1),
	PRIMARY KEY (cod_inscripcion)
);
CREATE TABLE Habitacion(
	num_hab	number(3),
	numero_camas	number(1) Check (numero_camas in(1,2,3)),
	PRIMARY KEY(num_hab)
);
CREATE TABLE Ingreso(
	cod_ingreso	number(5) DELETE ON CASCADE,
	cod_inscripcion	number(4),
	fecha_ingreso	DATE Default Sysdate,
	fecha_alta	DATE check (fecha_alta>fecha_ingreso),
	num_hab	number(3),
	PRIMARY key(cod_ingreso),
	FOREIGN KEY (num_hab) REFERENCES Habitacion (num_hab),
	FOREIGN KEY (cod_inscripcion) REFERENCES Enfermo (cod_inscripcion)
);
CREATE TABLE Medico(
	cod_medico	number(4),
	nombre	VARCHAR2(30),
	especialidad	VARCHAR2(30) Default 'FAM',
	cod_director	number(4),
	PRIMARY key(cod_medico),
	FOREIGN key (cod_director) REFERENCES Medico(cod_medico)
);
CREATE TABLE Visita(
	cod_medico	number(4),
	cod_inscripcion	number(4),
	fecha 	DATE,
	diagnostico	VARCHAR2(60),
	FOREIGN key (cod_medico) REFERENCES Medico (cod_medico),
	FOREIGN key (cod_inscripcion) REFERENCES Enfermo (cod_inscripcion),
	PRIMARY KEY (cod_medico,cod_inscripcion)
);
--2.i
alter table ENFERMO MODIFY (sexo	VARCHAR2(1) check (sexo='H' or sexo='M'));
--2.j
--Se debe a que la visita esta enlazada en la primary key el medico con la inscripcion
alter table VISITA MODIFY (PRIMARY key (cod_inscripcion));
--2.k
alter TABLE Medico MODIFY (especialidad VARCHAR2(3) check(especialidad=UPPER(especialidad)));
--2.l
INSERT into Medico(cod_medico,nombre,especialidad,cod_director)
VALUES(1,'Pepe','TOR',1);
INSERT into Enfermo(cod_inscripcion,nss,nombre,sexo)
VALUES(1,'1234567890','Juan','H');
INSERT into Enfermo(cod_inscripcion,nss,nombre,sexo)
VALUES(2,'1234167890','Luisa','M');
--2.m
INSERT INTO Habitacion(num_hab,numero_camas)
VALUES (102,2);
INSERT INTO Ingreso(cod_ingreso,cod_inscripcion,fecha_ingreso,fecha_alta,num_hab)
VALUES(1,1,Sysdate,'20210213',2)
--2.n
INSERT into Visita(cod_medico,cod_inscripcion,fecha,diagnostico)
VALUES(1,1,Sysdate,'Tiene covid')
--2.o
ALTER TABLE Visita add (fecha_proxima_visita	DATE);
--2.p
UPDATE Enfermo
	set nombre='PEPE PEREZ'
	where cod_inscripcion=1
UPDATE Enfermo
	set sexo='H'
	where cod_inscripcion=1
--2.q
DELETE FROM Enfermo
	where cod_inscripcion=1
--2.r
DROP TABLE Ingreso;
DROP TABLE Visita;
DROP TABLE Medico;
DROP TABLE Habitacion;
DROP TABLE Enfermo;


