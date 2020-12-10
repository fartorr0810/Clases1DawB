CREATE TABLE Profesores(
	nombre	VARCHAR2(30) NOT NULL,
    apellido1   VARCHAR2(30) NOT NULL,
    direccion   VARCHAR2(30) NOT NULL,
    titulo  VARCHAR2(15) NOT NULL,
    gana    NUMBER(10) NOT NULL,
    dni VARCHAR2(8) PRIMARY KEY
);
CREATE TABLE CURSOS(
    nombre_curso    VARCHAR2(20) NOT NULL,
    cod_curso   NUMBER(4) PRIMARY KEY,
    dni VARCHAR2(8) REFERENCES Profesores,
    max_alu NUMBER(6),
    fecha_ini   DATE NOT NULL,
    fecha_fin   DATE,
    num_hor NUMBER(4)
);
CREATE TABLE Alumnos(
    nombre  VARCHAR2(30) NOT NULL,
    apellido1   VARCHAR2(30) NOT NULL,
    apellido2   VARCHAR2(30) NOT NULL,
    dni_alum    VARCHAR2(8) PRIMARY KEY,
    direccion   VARCHAR2(30) NOT NULL,
    sexo    VARCHAR2(1) CHECK (sexo in('H','M')),
    fecha_nacimiento    DATE,
    cod_curso   NUMBER(4) REFERENCES CURSOS
);

INSERT INTO Profesores
(nombre, apellido1, direccion, titulo, gana, dni)
VALUES 