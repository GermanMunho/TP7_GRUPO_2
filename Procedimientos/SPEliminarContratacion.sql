CREATE DEFINER=`root`@`localhost` PROCEDURE `SPEliminarContratacion`( DropId int)
BEGIN
delete from contratacion where idContratacion=DropId;
END