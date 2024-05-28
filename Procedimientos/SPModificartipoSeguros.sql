CREATE DEFINER=`root`@`localhost` PROCEDURE `SPModificartipoSeguros`( NewId int,NewDescripcion varchar(200))
BEGIN
    UPDATE seguros
    SET descripcion = NewDescripcion
    WHERE idSeguro = NewId;
END