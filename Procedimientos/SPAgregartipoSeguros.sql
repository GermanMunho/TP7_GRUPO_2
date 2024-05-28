CREATE DEFINER=`root`@`localhost` PROCEDURE `SPAgregartipoSeguros`( NewId int,NewDescripcion varchar(200))
BEGIN
INSERT INTO tiposeguros(idTipo, descripcion) VALUES(NewId, NewDescripcion);
END