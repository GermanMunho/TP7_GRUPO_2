CREATE DEFINER=`root`@`localhost` PROCEDURE `SPEliminartipoSeguros`( DropId int)
BEGIN
delete from tiposeguros where idTipo=DropId;
END