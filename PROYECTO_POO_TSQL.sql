/*
*	MODELO DE BASE DE DATOS PARA PROYECTO DE POO "SERPIENTES Y ESCALERAS"
*	DESARROLLADO POR: DIEGO CASTRO
*	PREREQUISITO: HABER EJECUTADO TODO EL SCRIPT DEL ARCHIVO PROYECTO_POO.sql
*	CONTENIDO: SCRIPT DE FUNCIONES Y PROCEDIMIENTOS ALMACENADOS
*	IMPORTANTE: EJECUTAR EN ORDEN DE CASCADA 
*/

USE PROYECTO_POO;

-- SCRIPT DE LAS FUNCIONES TSQL

CREATE OR ALTER FUNCTION obtenerContrincante(@idPartida int,@idJugador int)
 returns varchar(64)
 as 
 begin
 return (select j.nickname as contricante 
 from Detalle_partida d 
 inner join Jugador j on j.id  = d.id_jugador
 where id_partida = @idPartida and id_jugador != @idJugador);
END;

CREATE OR ALTER FUNCTION obtenerIdJugador(@nickname varchar(32))
 returns int 
 as 
 begin
 return (select id from Jugador where nickname = @nickname);
END;

CREATE OR ALTER FUNCTION numeroPartidasPerdidas(@id_jugador int)
 returns int 
 as 
 begin
 return (SELECT ISNULL(COUNT(d.id_jugador),0) 'partidas perdidas'
 FROM Detalle_partida d 
 WHERE d.id_resultado_partida = 1 and id_jugador = @id_jugador 
 GROUP BY d.id_jugador);
END;

CREATE OR ALTER FUNCTION numeroPartidasIndividuales(@id_jugador int)
 returns int 
 as 
 begin
 return (SELECT COUNT(d.id) 'partidas individuales'
 FROM Detalle_partida d 
 WHERE d.cantidad_desbanque IS NULL and id_jugador = @id_jugador
 GROUP BY d.id_jugador);
END;

CREATE OR ALTER FUNCTION numeroPartidasCompetencia(@id_jugador int)
 returns int 
 as 
 begin
 return (SELECT COUNT(d.id) 'partidas competencia'
 FROM Detalle_partida d 
 WHERE d.cantidad_desbanque IS NOT NULL and id_jugador = @id_jugador
 GROUP BY d.id_jugador);
END;

CREATE OR ALTER FUNCTION obtenerJugador1(@id_partida int)
RETURNS VARCHAR(32)
AS 
BEGIN
	RETURN (SELECT TOP 1 j.nickname FROM Detalle_partida d INNER JOIN Jugador j ON j.id = d.id_jugador WHERE d.id_partida = @id_partida ORDER BY d.id ASC);
END;

CREATE OR ALTER FUNCTION obtenerJugador2(@id_partida int)
RETURNS VARCHAR(32)
AS 
BEGIN
	RETURN (SELECT TOP 1 j.nickname FROM Detalle_partida d INNER JOIN Jugador j ON j.id = d.id_jugador WHERE d.id_partida = @id_partida ORDER BY d.id DESC);
END;

CREATE OR ALTER FUNCTION obtenerGanador(@id_partida int)
RETURNS VARCHAR(32)
AS 
BEGIN
	RETURN (SELECT j.nickname FROM Detalle_partida d INNER JOIN Jugador j ON d.id_jugador = j.id WHERE id_resultado_partida = 1 AND id_partida = @id_partida);
END;

-- SCRIPT DE LOS PROCEDIMIENTOS ALMACENADOS 

CREATE PROCEDURE iniciarPartidaCompetencia
    @id_tablero int,
	@id_ficha1 int,
	@id_jugador1 int,
	@id_ficha2 int,
	@id_jugador2 int
AS   
	insert into Partida (id_tablero,fecha_inicio,fecha_fin) values(@id_tablero,default,null);
	declare @id_partida int  = (select max(id) from Partida);

	insert into Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque)
	values (@id_ficha1,@id_partida,@id_jugador1,null,default,default,default,default),(@id_ficha2,@id_partida,@id_jugador2,null,default,default,default,default);
GO

CREATE PROCEDURE iniciarPartidaIndividual
    @id_tablero int,
	@id_ficha int,
	@id_jugador int
AS   
	insert into Partida (id_tablero,fecha_inicio,fecha_fin) values(@id_tablero,default,null);
	declare @id_partida int  = (select max(id) from Partida);

	insert into Detalle_partida (id_ficha,id_partida,id_jugador,id_resultado_partida,cantidad_tiros,cantidad_escalera,cantidad_serpiente,cantidad_desbanque)
	values (@id_ficha,@id_partida,@id_jugador,null,default,default,default,null);
GO

CREATE OR ALTER PROCEDURE finalizarPartidaCompetencia
    @id_resultadoJ1 int,
	@id_jugadorJ1 int,
	@cantidad_tirosJ1 int,
	@cantidad_escaleraJ1 int,
	@cantidad_serpienteJ1 int,
	@cantidad_desbanqueJ1 int,
	@id_resultadoJ2 int,
	@id_jugadorJ2 int,
	@cantidad_tirosJ2 int,
	@cantidad_escaleraJ2 int,
	@cantidad_serpienteJ2 int,
	@cantidad_desbanqueJ2 int
AS  
	-- Obtenemos la ultima partida ingresada en la tabla
	declare @id_partida int = (select max(id) from Partida);
    declare @fechaFin date = (select fecha_fin from Partida where id = @id_partida);
	-- Actualizando los resultados del jugador 
	update Detalle_partida set id_resultado_partida = @id_resultadoJ1 , cantidad_tiros = @cantidad_tirosJ1, cantidad_escalera = @cantidad_escaleraJ1, cantidad_serpiente = @cantidad_serpienteJ1,
	cantidad_desbanque = @cantidad_desbanqueJ1 where id_partida = @id_partida and id_jugador = @id_jugadorJ1; 
	update Detalle_partida set id_resultado_partida = @id_resultadoJ2 , cantidad_tiros = @cantidad_tirosJ2, cantidad_escalera = @cantidad_escaleraJ2, cantidad_serpiente = @cantidad_serpienteJ2,
	cantidad_desbanque = @cantidad_desbanqueJ2 where id_partida = @id_partida and id_jugador = @id_jugadorJ2; 
	update Partida set fecha_fin = default where id = @id_partida;
GO

CREATE PROCEDURE finalizarPartidaIndividual
    @id_resultado int,
	@id_jugador int,
	@cantidad_tiros int,
	@cantidad_escalera int,
	@cantidad_serpiente int
AS  
	-- Obtenemos la ultima partida ingresada en la tabla
	declare @id_partida int = (select max(id) from Partida);
    -- Actualizamos la fecha de fin de la partida
	update Partida set fecha_fin = default where id = @id_partida;
	-- Actualizando los resultados del jugador 1 
	update Detalle_partida set id_resultado_partida = @id_resultado , cantidad_tiros = @cantidad_tiros, cantidad_escalera = @cantidad_escalera, cantidad_serpiente = @cantidad_serpiente
	where id_partida = @id_partida and id_jugador = @id_jugador; 
GO

CREATE PROCEDURE registrarJugador
	@nombre varchar(64),
	@nickname varchar(64),
	@edad int,
	@genero varchar(12),
	@clave varchar(64)
AS
	insert into Jugador (nombre,nickname,partidas_jugadas,partidas_ganadas,edad,clave,genero) values (@nombre,@nickname,default,default,@edad,@clave,@genero);
GO

CREATE PROCEDURE actualizarEstadisticasJugador
	@id_jugador int
AS  
	declare @partidas_jugadas int = (SELECT COUNT(*) 'Partidas jugadas' FROM Detalle_partida WHERE id_jugador = @id_jugador);
    declare @partidas_ganadas int = (SELECT COUNT(*) 'Partidas ganadas' FROM Detalle_partida WHERE id_resultado_partida = 1 and id_jugador = @id_jugador);
	UPDATE Jugador SET partidas_jugadas = @partidas_jugadas, partidas_ganadas = @partidas_ganadas WHERE id = @id_jugador
GO
