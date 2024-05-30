package Negocio;

import java.sql.ResultSet;
import java.util.List;

import Entidades.TipoSeguros;

public interface TipoSegNeg {
	public boolean agregar(TipoSeguros TipoSeguros);

	public boolean eliminar(TipoSeguros TipoSeguros_eliminar);

	public boolean modificar(TipoSeguros TipoSeguros_modificar);

	public TipoSeguros getContratacion(ResultSet rs);

	public TipoSeguros BuscarTipoSeguro(int idTipo);

	public List<TipoSeguros> listar();
}
