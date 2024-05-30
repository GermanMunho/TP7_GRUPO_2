CREATE DEFINER=`root`@`localhost` PROCEDURE `SPMostrarSeguros`()
BEGIN
SELECT idSeguro,S.descripcion,costoContratacion,costoAsegurado,TP.Idtipo,TP.descripcion FROM seguros S
inner join tiposeguros TP on TP.Idtipo=S.Idtipo;
END