--Ejercicio 1
CREATE TABLE Profesores(
	nombre	VARCHAR2(30) NOT NULL,
    apellido1   VARCHAR2(30) NOT NULL,
    apellido2   VARCHAR2(30)
    direccion   VARCHAR2(30) NOT NULL,
    titulo  VARCHAR2(15) NOT NULL,
    gana    NUMBER(10) NOT NULL,
    dni VARCHAR2(8) PRIMARY KEY
);
CREATE TABLE CURSOS(
    nombre_curso    VARCHAR2(20) NOT NULL,
    cod_curso   NUMBER(4) PRIMARY KEY ON DELETE CASCADE,
    dni_prof VARCHAR2(8) REFERENCES Profesores,
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

--Ejercicio 2
--Si no se indica los campos de la tabla, el vales se introduce los datos segun
--El orden del script de la creacion de la tabla
INSERT INTO Profesores
(nombre, apellido1, apellido2, direccion, titulo, gana, dni)
VALUES ('Juan', 'Arch', 'Lopez', 'Puerta Negra,4', 'Ing. Informatica', '7500', '32432455')

INSERT INTO Profesores
(nombre, apellido1, apellido2, direccion, titulo, gana, dni)
VALUES ('Maria', 'Oliva', 'Rubio', 'Juan Alfonso 32', 'Lda Fil Inglesa', '5400', '43215643')

INSERT INTO CURSOS
(nombre_curso, cod_curso, dni_prof, max_alu, fecha_ini, fecha_fin ,num_hor)
VALUES ('Ingles basico', 1, '43215463', 15, 00001101, '0000.12.22.HH:MM:SS', 120)

INSERT INTO CURSOS
(nombre_curso, cod_curso, dni_prof, fecha_ini, num_hor)
VALUES ('Administracion Linux', 2, '32432455', 00000901, 80)
--Esta falla ya que no cumple la restriccion del sexo, porque pone V en vez de H o M
INSERT INTO Alumnos
(nombre, apellido1, apellido2, dni_alum, direccion, sexo, fecha_nacimiento, cod_curso)
VALUES ('Lucas', 'Manilva', 'Lopez', '123523', 'Alhamar,3', 'V', 19791101, 1)
--

INSERT INTO Alumnos
(nombre, apellido1, apellido2, dni_alum, direccion, sexo, cod_curso)
VALUES ('Antonia', 'Lopez', 'Alcantara', '2567567', 'Maniqui,21', 'M', 2)

--Mas de lo mismo, no cumple la restriccion del sexo
INSERT INTO Alumnos
(nombre, apellido1, apellido2, dni_alum, direccion, sexo, cod_curso)
VALUES ('Manuel', 'Alcantara', 'Pedros', '3123689', 'Julian,2', '2', 1)
--
--Esta falla porque no cumple la restriccion del sexo, y ademas , estas metiendolo en un curso que no existe.
INSERT INTO Alumnos
(nombre, apellido1, apellido2, dni_alum, direccion, sexo, fecha_nacimiento, cod_curso)
VALUES ('Jose', 'Perez', 'Caballar', '4896765', 'Jarcha,5', 'V', 19770203, 3)
--

--Ejercicio 3
--Este va a fallar porque la direccion esta indicada arriba como not null, ademas el sexo,
--vuelve ha estar mal, la fecha de nacimiento , tal y como yo lo tengo puesto arriba,
--no pasa nada que este nulo
INSERT INTO Alumnos
(nombre, apellido1, apellido2, dni_alum, sexo, cod_curso)
VALUES ('Sergio', 'Navas', 'Retal', '123523', 'P', 1)

--Ejercicio 4
INSERT INTO Profesores
(nombre, apellido1, apellido2, dni_prof, direccion, titulo, gana)
VALUES ('Juan', 'Arch', 'Lopez', '32432455', 'Puerta Negra,4', 'Ing. Informatica', null)
--Esto no funcionaria porque estamos DUPLICANDO DATOS por la PK.

--Ejercicio 5
INSERT INTO Alumnos 
(nombre, apellido1, apellido2, dni_alum, direccion, sexo, fecha_nacimiento)
VALUES ('Maria', 'Jaen', 'Sevilla', '789678', 'M', null)
--Esto fallaria porque NO LE INDICAMOS EL CURSO en el que esta.

--Ejercicio 6
UPDATE Alumnos
    SET fecha_nacimiento = 19761223
    WHERE dni_alum = '2567567'

--Ejercicio 7
UPDATE Alumnos
    SET cod_curso = 5
    WHERE dni_alum = '2567567' 
--Esto fallaria porque el curso 5 NO EXISTE

--Ejercicio 8
DELETE FROM Profesores
    WHERE nombre = 'Laura' and apellido1 = 'Jimenez'
--Esto falla porque Laura Jimenez no existe 

--Ejercicio 9
CREATE TABLE NombreDeAlumnos (
    nombre_completo VARCHAR2(30)
);
--Esto no lo hemos dado :( ademas no se puede

--Ejercicio 10
DELETE FROM CURSOS
    WHERE cod_curso = 1;
    
--Ejercicio 11
ALTER TABLE CURSOS ADD (numero_alumnos  NUMBER(4));

UPDATE CURSOS
    set numero_alumnos = 1
    WHERE cod_curso = 2;

--En el curso 1 no se puede saber porque las otras inserciones fallaron , por lo tanto tecnicamente no hay ninguno

--Ejercicio 12
UPDATE Alumnos
    set fecha_nacimiento = 20120101
    WHERE fecha_nacimiento IS null;









