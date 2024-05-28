CREATE DEFINER=`root`@`localhost` PROCEDURE `SPModificarUsuarios`( Newdni varchar(10),NewNombre varchar(50),NewApellido varchar(50),NewNombreUsuario varchar(25),NewtipoUsuario int,NewPass varchar(25))
BEGIN
    UPDATE usuarios
    SET nombreUsuario = NewNombreUsuario,pass=NewPass,tipoUsuario=NewtipoUsuario,nombre=NewNombre,apellido=NewApellido
    WHERE dni = Newdni;
END