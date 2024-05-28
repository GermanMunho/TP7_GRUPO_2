CREATE DEFINER=`root`@`localhost` PROCEDURE `SPModificarSeguros`( NewId int,NewDescripcion varchar(200),NewIdTipo int,NewCostoContratacion decimal(10,0),NewCostoAsegurado decimal(10,0))
BEGIN
    UPDATE seguros
    SET descripcion = NewDescripcion, idTipo = NewIdTipo,costoContratacion=NewCostoContratacion,costoAsegurado=NewCostoAsegurado
    WHERE idSeguro = NewId;
END