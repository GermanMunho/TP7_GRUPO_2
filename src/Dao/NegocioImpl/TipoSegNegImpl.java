package NegocioImpl;

import java.sql.ResultSet;
import java.util.List;

import Entidades.TipoSeguros;
import Negocio.TipoSegNeg;
import Dao.TipoSegurosDao;
import DaoImpl.TipoSeguroImpl;

public class TipoSegNegImpl implements TipoSegNeg {

	TipoSegurosDao TSegDao = new TipoSeguroImpl();

	public boolean agregar(TipoSeguros TSeg) {
		boolean estado = false;
		if (TSeg.getId() > 0 && TSeg.getDescripcion().trim().length() > 0) {
			estado = TSegDao.agregar(TSeg);
		}
		return estado;
	}

	public boolean eliminar(TipoSeguros TipoSeguros_eliminar) {
		return TSegDao.eliminar(TipoSeguros_eliminar);
	}

	public boolean modificar(TipoSeguros TipoSeguros_modificar) {
		return TSegDao.modificar(TipoSeguros_modificar);

	}

	public TipoSeguros getContratacion(ResultSet rs) {
		return TSegDao.getContratacion(rs);
	}

	public List<TipoSeguros> listar() {
		return TSegDao.listar();

	}

	public TipoSeguros BuscarTipoSeguro(int idTipo) {
		return TSegDao.BuscarTipoSeguro(idTipo);
	}

}
