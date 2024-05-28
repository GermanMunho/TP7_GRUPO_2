CREATE DEFINER=`root`@`localhost` PROCEDURE `SPAgregarContratacion`( NewId int,NewNombre varchar(25),NewIdSeguro int,NewCosto decimal(10,0))
BEGIN
INSERT INTO contratacion(idContratacion, NombreUsuario, idseguro,costoContratacion) VALUES(NewId, NewNombre, NewIdSeguro,NewCosto);
END