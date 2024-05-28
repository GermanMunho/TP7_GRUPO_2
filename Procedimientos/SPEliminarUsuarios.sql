CREATE DEFINER=`root`@`localhost` PROCEDURE `SPEliminarUsuarios`( DropDni varchar(10))
BEGIN
delete from usuarios where dni=DropDni;
END