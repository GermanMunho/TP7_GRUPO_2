package Dao;

import java.sql.ResultSet;
import java.util.List;

import Entidades.TipoSeguros;

public interface TipoSegurosDao {
	public boolean agregar(TipoSeguros TipoSeguros);

	public boolean eliminar(TipoSeguros TipoSeguros_eliminar);

	public boolean modificar(TipoSeguros TipoSeguros_modificar);

	public TipoSeguros getContratacion(ResultSet rs);
	
	public List<TipoSeguros> listar();
	
	public TipoSeguros BuscarTipoSeguro(int idTipo);
}
