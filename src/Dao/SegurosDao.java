package Dao;

import java.util.List;

import Entidades.Seguros;;

public interface SegurosDao {
	public boolean agregar(Seguros Seguros);

	public boolean eliminar(Seguros Seguros_eliminar);

	public boolean modificar(Seguros Seguros_modificar);

	public List<Seguros> listar();

}
