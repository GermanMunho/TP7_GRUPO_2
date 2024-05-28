CREATE DEFINER=`root`@`localhost` PROCEDURE `SPAgregarUsuarios`( Newdni varchar(10),NewNombre varchar(50),NewApellido varchar(50),NewNombreUsuario varchar(25),NewtipoUsuario int,NewPass varchar(25))
BEGIN
INSERT INTO usuarios(nombreUsuario, pass,tipoUsuario,dni,nombre,nombre) VALUES(NewNombreUsuario,NewPass,NewtipoUsuario,Newdni,NewNombre,NewApellido);
END