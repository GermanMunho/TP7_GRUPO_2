package Dao;

import java.util.List;

import Entidades.TipoSeguros;

public interface TipoSegurosDao {
	public boolean agregar(TipoSeguros TipoSeguros);

	public boolean eliminar(TipoSeguros TipoSeguros_eliminar);

	public boolean modificar(TipoSeguros TipoSeguros_modificar);

	public List<TipoSeguros> listar();
}
