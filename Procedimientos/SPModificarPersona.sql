CREATE DEFINER=`root`@`localhost` PROCEDURE `SPModificarContratacion`(
    NewId int,
    NewNombre varchar(25),
    NewIdSeguro int,
    NewCosto decimal(10,0)
)
BEGIN
    UPDATE contratacion
    SET NombreUsuario = NewNombre, idseguro = NewIdSeguro,costoContratacion=NewCosto
    WHERE idContratacion = NewId;
END