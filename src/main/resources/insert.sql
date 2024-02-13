POBLANDO LA BASE DE DATOS:

Direcciones:

INSERT INTO DIRECCION (PRINCIPAL, NUMERO, TIPO) VALUES ('CALLE', '123', 'CASA');
INSERT INTO DIRECCION (PRINCIPAL, NUMERO, TIPO) VALUES ('AVENIDA', '456', 'APARTAMENTO');
INSERT INTO DIRECCION (PRINCIPAL, NUMERO, TIPO) VALUES ('CARRERA', '789', 'CASA');
INSERT INTO DIRECCION (PRINCIPAL, NUMERO, TIPO) VALUES ('CALLE', '101', 'APARTAMENTO');
INSERT INTO DIRECCION (PRINCIPAL, NUMERO, TIPO) VALUES ('AVENIDA', '112', 'CASA');




Ciudades:

INSERT INTO CIUDAD (NOMBRE) VALUES ('Bogotá');
INSERT INTO CIUDAD (NOMBRE) VALUES ('Medellín');
INSERT INTO CIUDAD (NOMBRE) VALUES ('Cali');
INSERT INTO CIUDAD (NOMBRE) VALUES ('Barranquilla');
INSERT INTO CIUDAD (NOMBRE) VALUES ('Cartagena');


Personas:

INSERT INTO PERSONA (TIPO_DOCUMENTO, DOCUMENTO, NOMBRE1, APELLIDO1, TELEFONO, FECHA_NACIMIENTO, GENERO, ID_DIRECCION, ID_CIUDAD, TIPO_PERSONA)
VALUES ('C.C', '123456789', 'Juan', 'Pérez', '1234567890', '1990-01-01', 'M', 1, 1, 'DOCENTE');

INSERT INTO PERSONA (TIPO_DOCUMENTO, DOCUMENTO, NOMBRE1, APELLIDO1, TELEFONO, FECHA_NACIMIENTO, GENERO, ID_DIRECCION, ID_CIUDAD, TIPO_PERSONA)
VALUES ('C.E', '987654321', 'María', 'López', '0987654321', '1995-05-15', 'F', 2, 2, 'ESTUDIANTE');

INSERT INTO PERSONA (TIPO_DOCUMENTO, DOCUMENTO, NOMBRE1, APELLIDO1, TELEFONO, FECHA_NACIMIENTO, GENERO, ID_DIRECCION, ID_CIUDAD, TIPO_PERSONA)
VALUES ('C.C', '456789123', 'Pedro', 'García', '4567891230', '1985-10-20', 'M', 3, 3, 'DOCENTE');

INSERT INTO PERSONA (TIPO_DOCUMENTO, DOCUMENTO, NOMBRE1, APELLIDO1, TELEFONO, FECHA_NACIMIENTO, GENERO, ID_DIRECCION, ID_CIUDAD, TIPO_PERSONA)
VALUES ('C.C', '321654987', 'Ana', 'Martínez', '3216549870', '1998-03-25', 'F', 4, 4, 'ESTUDIANTE');

INSERT INTO PERSONA (TIPO_DOCUMENTO, DOCUMENTO, NOMBRE1, APELLIDO1, TELEFONO, FECHA_NACIMIENTO, GENERO, ID_DIRECCION, ID_CIUDAD, TIPO_PERSONA)
VALUES ('T.I', '789456123', 'Luis', 'Rodríguez', '7894561230', '1980-08-12', 'M', 5, 5, 'DOCENTE');







Departamentos:

INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Departamento de Matemáticas');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Departamento de Ingeniería');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Departamento de Ciencias Sociales');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Departamento de Biología');
INSERT INTO DEPARTAMENTO (NOMBRE) VALUES ('Departamento de Lenguas');

Docentes:

INSERT INTO DOCENTE (ID_PERSONA, ID_DEPARTAMENTO) VALUES (1, 1);
INSERT INTO DOCENTE (ID_PERSONA, ID_DEPARTAMENTO) VALUES (3, 2);
INSERT INTO DOCENTE (ID_PERSONA, ID_DEPARTAMENTO) VALUES (5, 3);


Programa:

INSERT INTO PROGRAMA (NOMBRE, NIVEL, CODIGO) VALUES ('Ingeniería de Sistemas', 'Pregrado', 'ISI');
INSERT INTO PROGRAMA (NOMBRE, NIVEL, CODIGO) VALUES ('Ingeniería Civil', 'Pregrado', 'IC');
INSERT INTO PROGRAMA (NOMBRE, NIVEL, CODIGO) VALUES ('Administración de Empresas', 'Pregrado', 'ADM');
INSERT INTO PROGRAMA (NOMBRE, NIVEL, CODIGO) VALUES ('Psicología', 'Pregrado', 'PSI');
INSERT INTO PROGRAMA (NOMBRE, NIVEL, CODIGO) VALUES ('Medicina', 'Pregrado', 'MED');

Curso:

INSERT INTO CURSO (NOMBRE, GUIA_CATEDRA, CODIGO) VALUES ('Introducción a la Programación', 'Una introducción básica a los conceptos de la programación', 'PROG101');
INSERT INTO CURSO (NOMBRE, GUIA_CATEDRA, CODIGO) VALUES ('Cálculo I', 'Fundamentos del cálculo diferencial e integral', 'CAL101');
INSERT INTO CURSO (NOMBRE, GUIA_CATEDRA, CODIGO) VALUES ('Álgebra Lineal', 'Conceptos básicos de álgebra lineal y matrices', 'ALG101');
INSERT INTO CURSO (NOMBRE, GUIA_CATEDRA, CODIGO) VALUES ('Derecho Constitucional', 'Estudio de los principios y normas de la Constitución', 'DER101');
INSERT INTO CURSO (NOMBRE, GUIA_CATEDRA, CODIGO) VALUES ('Literatura Universal', 'Estudio de obras literarias representativas de diferentes culturas', 'LIT101');




Edificio:

INSERT INTO EDIFICIO (NOMBRE) VALUES ('Edificio de Ciencias');
INSERT INTO EDIFICIO (NOMBRE) VALUES ('Edificio de Ingeniería');
INSERT INTO EDIFICIO (NOMBRE) VALUES ('Edificio de Humanidades');

Salon:

INSERT INTO SALON (CUPO, ID_EDIFICIO, ID_PISO) VALUES (20, 1, 1);
INSERT INTO SALON (CUPO, ID_EDIFICIO, ID_PISO) VALUES (25, 1, 2);
INSERT INTO SALON (CUPO, ID_EDIFICIO, ID_PISO) VALUES (20, 2, 1);
INSERT INTO SALON (CUPO, ID_EDIFICIO, ID_PISO) VALUES (20, 2, 2);
INSERT INTO SALON (CUPO, ID_EDIFICIO, ID_PISO) VALUES (25, 3, 1);



Periodo:

INSERT INTO PERIODO (CODIGO) VALUES ('20241');
INSERT INTO PERIODO (CODIGO) VALUES ('20242');
INSERT INTO PERIODO (CODIGO) VALUES ('20231');


Asignatura:

INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Programación I', 4, 1, 1, 1, 1);
INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Cálculo I', 3, 3, 2, 2, 1);
INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Literatura Universal', 2, 5, 4, 5, 1);
INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Derecho Constitucional', 3, 5, 3, 4, 1);
INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Álgebra Lineal', 3, 3, 2, 3, 1);
INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Inglés Avanzado', 2, 5, 5, 4, 2);
INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Física I', 3,2, 2, 2, 2);
INSERT INTO ASIGNATURA (NOMBRE, CREDITOS, ID_DOCENTE, ID_PROGRAMA, ID_CURSO, ID_PERIODO) VALUES ('Programación II', 4, 1, 1, 1, 2);





Horario:

INSERT INTO HORARIO (DIA, INICIO, FINAL, ID_SALON, ID_ASIGNATURA)
VALUES
('LUNES', '08:00:00', '10:00:00', 1, 1),
('MARTES', '09:00:00', '11:00:00', 2, 2),
('MIÉRCOLES', '10:00:00', '12:00:00', 3, 3),
('JUEVES', '11:00:00', '13:00:00', 4, 4),
('VIERNES', '12:00:00', '14:00:00', 5, 5),
('LUNES', '10:00:00', '12:00:00', 2, 6),
('MARTES', '11:00:00', '13:00:00', 3, 7),
('MIÉRCOLES', '12:00:00', '14:00:00', 4, 8);



Matricula:

INSERT INTO MATRICULA (ID_ESTUDIANTE, ID_ASIGNATURA, ID_PERIODO)
VALUES
(2, 1, 1),  
(4, 2, 1),  
(2, 3, 1),  
(4, 4, 1),  
(2, 5, 1),  
(4, 6, 1),  
(2, 7, 1),  
(4, 8, 1),  
(2, 1, 2);  


Tarifas:

INSERT INTO TARIFAS (ID_PERIODO, ID_PROGRAMA, VALOR)
VALUES
(1, 1, 1000),  
(1, 2, 1500),  
(1, 3, 1200), 
(1, 4, 2000),  
(1, 5, 1800);  



