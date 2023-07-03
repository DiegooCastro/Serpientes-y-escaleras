/*
*	MODELO DE BASE DE DATOS PARA PROYECTO DE POO "SERPIENTES Y ESCALERAS"
*	DESARROLLADO POR: DIEGO CASTRO
*	CONTENIDO: SCRIPT DE TABLAS E INSERTS
*	INSTRUCCIONES DE USO: PRIMERO CREAR Y SELECCIONAR LA BASE DE DATOS LUEGO SELECCIONAR TODO EL SCRIPT HASTA EL FINAL Y EJECUTAR.
*	IMPORTANTE: SE DEBE EJECUTAR TODO EL ARCHIVO SQL PARA QUE EL JUEGO FUNCIONE
*	POSTERIORMENTE: DEBE EJECUTARSE EL ARCHIVO PROYECTO_POO_TSQL.sql
*/

CREATE DATABASE PROYECTO_POO;
USE PROYECTO_POO;

CREATE TABLE Ficha(
id int not null primary key,
nombre_ficha varchar(36) not null unique,
ruta_ficha varchar(64) not null unique
);

INSERT INTO Ficha (id,nombre_ficha,ruta_ficha) VALUES (1,'Ficha Purple Guy','/Recursos/ficha-purple-guy.png');
INSERT INTO Ficha (id,nombre_ficha,ruta_ficha) VALUES (2,'Ficha Jett','/Recursos/ficha-jett.png');
INSERT INTO Ficha (id,nombre_ficha,ruta_ficha) VALUES (3,'Ficha Spiderman','/Recursos/ficha-spiderman.png');
INSERT INTO Ficha (id,nombre_ficha,ruta_ficha) VALUES (4,'Ficha Sailormoon','/Recursos/ficha-sailormoon.png');

CREATE TABLE Tablero(
id int not null primary key,
nombre_tablero varchar(36) not null unique, -- Tablero 1 / Tablero 2 / Tablero 3 
ruta_tablero varchar(64) not null default 'src/Recursos/tablero1.jpg'
);

INSERT INTO Tablero (id,nombre_tablero, ruta_tablero) VALUES (1,'Tablero Easy','/Recursos/tablero_facil.jpg');
INSERT INTO Tablero (id,nombre_tablero, ruta_tablero) VALUES (2,'Tablero Medium','/Recursos/tablero_medio.jpg');
INSERT INTO Tablero (id,nombre_tablero, ruta_tablero) VALUES (3,'Tablero Hard','/Recursos/tablero_dificil.jpg');

CREATE TABLE Tipo_casilla (
id int not null primary key,
tipo_casilla varchar(12) not null unique -- Serpiente / Escalera
);

INSERT INTO Tipo_casilla (id, tipo_casilla) values (1,'Serpiente');
INSERT INTO Tipo_casilla (id, tipo_casilla) values (2,'Escalera');
INSERT INTO Tipo_casilla (id, tipo_casilla) values (3,'Normal');

CREATE TABLE Casillas_tablero(
id int not null primary key identity,
id_tablero int not null references Tablero(id),
id_tipo_casilla int not null references Tipo_casilla(id),
numero_casilla tinyint not null,
posicion_x smallint not null,
posicion_y smallint not null,
posicion_final tinyint null, 
);

-- INSERT DE LAS COORDENADAS DEL TABLERO 1
INSERT INTO Casillas_tablero(id_tablero, id_tipo_casilla, numero_casilla, posicion_x, posicion_y, posicion_final) VALUES
(1, 3, 1, 260, 670, null),
(1, 3, 2, 420, 670, null),
(1, 2, 3, 580, 670, 14),
(1, 3, 4, 740, 670, null),
(1, 3, 5, 900, 670, null),
(1, 3, 6, 1060, 670, null),
(1, 2, 7, 1220, 670, 11),
(1, 3, 8, 1380, 670, null),
(1, 2, 9, 1380, 490, 24),
(1, 3, 10, 1220, 490, null),
(1, 3, 11, 1070, 490, null),
(1, 2, 12, 900, 490, 21),
(1, 1, 13, 740, 490, 4),
(1, 3, 14, 580, 490, null),
(1, 3, 15, 420, 490, null),
(1, 2, 16, 260, 490, 18),
(1, 3, 17, 260, 300, null),
(1, 3, 18, 420, 300, null),
(1, 1, 19, 580, 300, 1),
(1, 3, 20, 740, 300, null),
(1, 3, 21, 900, 300, null),
(1, 3, 22, 1060, 300, null),
(1, 1, 23, 1220, 300,10),
(1, 3, 24, 1380, 300, null);

-- INSERT DE LAS COORDENADAS DEL TABLERO 2
INSERT INTO Casillas_tablero(id_tablero, id_tipo_casilla, numero_casilla, posicion_x, posicion_y, posicion_final) VALUES
(2, 3, 1, 230, 670, null),
(2, 2, 2, 240, 530, 7),
(2, 3, 3, 240, 390, null),
(2, 3, 4, 240, 250, null),
(2, 3, 5, 410, 250, null),
(2, 3, 6, 410, 390, null),
(2, 3, 7, 410, 520, null),
(2, 3, 8, 410, 680, null),
(2, 3, 9, 570, 660, null),
(2, 2, 10, 580,530, 13),
(2, 1, 11, 570, 390, 1),
(2, 1, 12, 570, 250, 4),
(2, 3, 13, 750, 250, null),
(2, 3, 14, 750, 390, null),
(2, 1, 15, 750, 530, 9),
(2, 3, 16, 760, 670, null),
(2, 3, 17, 930, 670, null),
(2, 3, 18, 940, 530, null),
(2, 2, 19, 930, 390, 21),
(2, 3, 20, 930, 250, null),
(2, 3, 21, 1100, 250, null),
(2, 3, 22, 1110, 390, null),
(2, 3, 23, 1100, 530, null),
(2, 3, 24, 1100, 670, null),
(2, 2, 25, 1270, 670, 32),
(2, 3, 26, 1270, 530, null),
(2, 3, 27, 1260, 390, null),
(2, 1, 28, 1270, 250, 26),
(2, 3, 29, 1460, 250, null),
(2, 3, 30, 1460, 390, null),
(2, 1, 31, 1460, 530, 24),
(2, 3, 32, 1470, 670, null);

-- INSERT DE LAS COORDENADAS DEL TABLERO 3
INSERT INTO Casillas_tablero(id_tablero, id_tipo_casilla, numero_casilla, posicion_x, posicion_y, posicion_final) VALUES
(3, 3, 1, 200, 180, null),
(3, 3, 2, 370, 180, null),
(3, 3, 3, 550, 180, null),
(3, 3, 4, 730, 180, null),
(3, 3, 5, 900, 180, null),
(3, 3, 6, 1070, 180, null),
(3, 2, 7, 1250, 180, 11),
(3, 3, 8, 1420, 180, null),
(3, 3, 9, 1430, 320, null),
(3, 3, 10, 1250, 320, null),
(3, 3, 11, 1060, 320, null),
(3, 3, 12, 900, 320, null),
(3, 3, 13, 730, 320, null),
(3, 1, 14, 550, 320, 2),
(3, 2, 15, 380, 320, 18),
(3, 3, 16, 200, 320, null),
(3, 1, 17, 200, 460, 1),
(3, 3, 18, 380, 460, null),
(3, 3, 19, 550, 460, null),
(3, 1, 20, 730, 460, 5),
(3, 2, 21, 900, 460, 29),
(3, 1, 22, 1070, 460, 6),
(3, 3, 23, 1250, 460, null),
(3, 1, 24, 1430, 460, 10),
(3, 3, 25, 1420, 600, null),
(3, 3, 26, 1250, 600, null),
(3, 3, 27, 1090, 600, null),
(3, 3, 28, 900, 600, null),
(3, 3, 29, 730, 600, null),
(3, 3, 30, 540, 600, null),
(3, 3, 31, 380, 600, null),
(3, 3, 32, 200, 600, null),
(3, 1, 33, 200, 740, 19),
(3, 3, 34, 380, 740, null),
(3, 1, 35, 560, 740, 31),
(3, 3, 36, 730, 740, null),
(3, 1, 37, 900, 740, 23),
(3, 1, 38, 1070, 740, 26),
(3, 3, 39, 1250, 740, null),
(3, 3, 40, 1420, 740, null);

CREATE TABLE Jugador(
id int not null primary key identity,
nombre varchar(64) not null,
nickname varchar(64) not null unique,
edad tinyint not null default 0,
genero varchar(12) not null,
clave varchar(64) not null default '40bd001563085fc35165329ea1ff5c5ecbdbbeef', -- La clave es: 123
partidas_jugadas smallint not null default 0,
partidas_ganadas smallint not null default 0,
check (partidas_jugadas >= 0),
check (partidas_ganadas >= 0)
);

INSERT INTO Jugador (nombre,nickname,edad,genero,clave,partidas_jugadas,partidas_ganadas) values ('Diego Castro','Castroll',20,'Masculino',default,default,default);
INSERT INTO Jugador (nombre,nickname,edad,genero,clave,partidas_jugadas,partidas_ganadas) values ('Alexandra Aguilar','AlexEagle',19,'Femenino',default,default,default);
INSERT INTO Jugador (nombre,nickname,edad,genero,clave,partidas_jugadas,partidas_ganadas) values ('Carlos Ordoñez','Carlos0rd',20,'Masculino',default,default,default);
INSERT INTO Jugador (nombre,nickname,edad,genero,clave,partidas_jugadas,partidas_ganadas) values ('Alexis Figueroa','Alepo02',20,'Masculino',default,default,default);
INSERT INTO Jugador (nombre,nickname,edad,genero,clave,partidas_jugadas,partidas_ganadas) values ('Angel Santos','Aresantos',19,'Masculino',default,default,default);

CREATE TABLE Partida(
id int not null primary key identity,
id_tablero int not null references Tablero(id),
fecha_inicio datetime not null default getDate(), -- Se obtendra por default al ingresar el registro de la partida 
fecha_fin datetime null default getDate() -- Se hara un UPDATE al registro con default
);

CREATE TABLE Resultado_partida(
id int not null primary key,
resultado_partida varchar(20) not null unique -- victoria / derrota 
);

INSERT INTO Resultado_partida (id,resultado_partida) VALUES (1,'Victoria');
INSERT INTO Resultado_partida (id,resultado_partida) VALUES (2,'Derrota');

CREATE TABLE Detalle_partida(
id int not null primary key identity(1,1),
id_ficha int not null references Ficha(id),
id_partida int not null references Partida(id),
id_jugador int not null references Jugador(id),
id_resultado_partida int null references Resultado_Partida(id) default null, -- Si el resultado es NULL significa que la partida sigue en curso
cantidad_tiros smallint not null default 0,
cantidad_escalera smallint not null default 0,
cantidad_serpiente smallint not null default 0,
cantidad_desbanque smallint null default 0, -- Si queda NULL significa que la partida es Individual (NULL nos da informacion) / Si es Competencia ingresamos con el valor default
);


-- SCRIPTS DE PARTIDAS DE MODALIDAD INDIVIDUAL
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-25 11:41:01.127','2023-06-25 11:44:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,1,1,NULL,6,1,2,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-25 11:45:01.127','2023-06-25 11:47:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,2,1,NULL,9,2,3,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-25 11:48:01.127','2023-06-25 11:52:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,3,1,NULL,21,4,7,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-25 12:48:01.127','2023-06-25 12:49:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,4,1,NULL,7,1,0,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-26 13:41:01.127','2023-06-26 13:44:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,5,2,NULL,9,1,2,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-26 13:45:01.127','2023-06-26 13:47:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,6,2,NULL,11,2,2,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-26 13:48:01.127','2023-06-26 13:52:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,7,2,NULL,27,5,9,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-27 13:41:01.127','2023-06-27 13:44:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,8,3,NULL,6,2,1,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-27 13:45:01.127','2023-06-27 13:47:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,9,3,NULL,12,2,1,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-27 13:48:01.127','2023-06-27 13:52:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,10,4,NULL,26,4,7,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-27 15:41:01.127','2023-06-27 15:44:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,11,4,NULL,7,2,1,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-27 15:45:01.127','2023-06-27 15:47:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,12,5,NULL,14,3,3,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-27 15:48:01.127','2023-06-27 15:52:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,13,5,NULL,32,5,11,NULL);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-27 20:18:01.127','2023-06-27 20:22:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,14,1,NULL,12,3,2,NULL);

-- SCRIPTS DE PARTIDAS DE MODALIDAD COMPETENCIA
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-27 21:25:01.127','2023-06-27 21:29:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,15,1,1,3,1,0,1);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,15,2,2,2,0,1,0);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-27 21:35:01.127','2023-06-27 21:37:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,16,2,1,9,2,1,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,16,3,2,8,2,1,1);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-27 21:45:01.127','2023-06-27 21:50:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,17,3,1,27,3,8,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,17,5,2,26,1,6,1);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-27 22:21:01.127','2023-06-27 22:24:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,18,4,1,11,3,2,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,18,1,2,10,2,1,2);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-27 22:35:01.127','2023-06-27 22:37:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,19,5,1,17,3,2,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,19,3,2,16,2,2,1);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-27 22:38:01.127','2023-06-27 22:42:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,20,1,1,29,5,7,3);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,20,5,2,28,4,8,2);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-27 23:41:01.127','2023-06-27 23:44:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,21,1,1,10,2,1,1);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,21,3,2,9,2,2,0);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-27 23:45:01.127','2023-06-27 23:48:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,22,1,1,15,4,1,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,22,4,2,14,3,1,1);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-27 23:50:01.127','2023-06-27 23:55:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,23,2,1,23,3,6,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,23,1,2,22,2,8,0);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-28 11:41:01.127','2023-06-27 11:44:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,24,2,1,10,2,1,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,24,5,2,9,2,1,2);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-28 11:45:01.127','2023-06-27 11:47:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,25,5,1,19,4,1,2);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,25,4,2,18,3,1,1);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-28 11:48:01.127','2023-06-27 11:52:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,26,3,2,30,2,6,1);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,26,2,1,30,3,5,2);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (1,'2023-06-28 13:41:01.127','2023-06-27 13:44:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,27,3,2,11,2,1,1);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (3,27,1,1,11,3,1,2);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (2,'2023-06-28 13:45:01.127','2023-06-27 13:47:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (2,28,4,2,10,2,3,1);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,28,1,1,10,3,2,2);
INSERT INTO Partida (id_tablero,fecha_inicio,fecha_fin) VALUES (3,'2023-06-28 13:48:01.127','2023-06-27 13:52:01.127');
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (1,29,5,2,30,3,10,1);
INSERT INTO Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque) VALUES (4,29,1,1,30,4,9,2);

-- LAS ESTADISTICAS DEL JUGADOR SE ACTUALIZAN DE MANERA AUTOMATICA CON LOS PROCESOS ALMACENADOS PERO COMO AUN NO ESTAN CREADOS LOS ACTUALIZO MANUALMENTE EN ESTA SECCION
UPDATE Jugador SET partidas_jugadas = 9, partidas_ganadas = 7 WHERE id = 1;
UPDATE Jugador SET partidas_jugadas = 5, partidas_ganadas = 4 WHERE id = 2;
UPDATE Jugador SET partidas_jugadas = 6, partidas_ganadas = 1 WHERE id = 3;
UPDATE Jugador SET partidas_jugadas = 4, partidas_ganadas = 1 WHERE id = 4;
UPDATE Jugador SET partidas_jugadas = 6, partidas_ganadas = 2 WHERE id = 5;

