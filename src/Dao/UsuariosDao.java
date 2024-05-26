package Dao;

import java.util.List;

import Entidades.Usuarios;

public interface UsuariosDao {
	public boolean agregar(Usuarios Usuarios);

	public boolean eliminar(Usuarios Usuarios_eliminar);

	public boolean modificar(Usuarios Usuarios_modificar);

	public List<Usuarios> listar();
}
