CREATE DEFINER=`root`@`localhost` PROCEDURE `SPAgregarSeguros`( NewId int,NewDescripcion varchar(200),NewIdTipo int,NewCostoContratacion decimal(10,0),NewCostoAsegurado decimal(10,0))
BEGIN
INSERT INTO seguros(idSeguro, descripcion, idTipo,costoContratacion,costoAsegurado) VALUES(NewId, NewDescripcion, NewIdTipo,NewCostoContratacion,NewCostoAsegurado);
END