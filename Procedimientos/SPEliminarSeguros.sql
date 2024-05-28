CREATE DEFINER=`root`@`localhost` PROCEDURE `SPEliminarSeguros`( DropId int)
BEGIN
delete from seguros where idSeguro=DropId;
END