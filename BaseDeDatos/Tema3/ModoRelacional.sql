CREATE TABLE EmpresaSeguridad(
cif text(15)
PRIMARY KEY (cif),
);
CREATE TABLE Guardias(
idguardia   number(5),
nombre  text,
apellidos   text,
cif text(15) ADD REFERENCES EmpresaSeguridad(cif),
PRIMARY KEY (idguardia)
);
CREATE TABLE SUCURSAL(
codigo  number(4), 
direccion   text,
telefono    text,
ciudad  text,
provincia   text
PRIMARY KEY (codigo)
);

CREATE TABLE EMPLEADO(
idtrabajador    number(5),
nif text,
nombre  text,
apellido    text,
telefono    text,
direccion   text,
codigo_sucursal number(4) ADD REFERENCES SUCURSAL(codigo),
PRIMARY KEY (idtrabajador)
);
CREATE TABLE REVISTA(
    idrevista   number(5),
    título  text,
    tipo    text,
    periodicidad    date,
    PRIMARY KEY (idrevista)
);
CREATE TABLE SucursalPublicaRevista(
    codigo_sucursal, 
    numero_registro_revista
    );

    PERIODISTA(id, nombre, apellido1, apellido2, teléfono, especialidad)

    PERIODISTA_ESCRIBE_REVISTA(id_periodista, número_registro_revista)
    SECCIÓN(id, título, extensión, número_registro_revista)
        número_registro_revista: FOREIGN KEY de REVISTA(número_registro)
    EJEMPLAR(id, número_ejemplares, número_páginas, fecha, número_registro_revista)
        número_registro_revista: FOREIGN KEY de REVISTA(número_registro)
