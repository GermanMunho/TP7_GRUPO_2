CREATE DEFINER=`root`@`localhost` PROCEDURE `SPMostrartiposeguros`(SIdtipo int)
BEGIN
SELECT Idtipo,descripcion FROM tiposeguros where Idtipo=SIdtipo;
END