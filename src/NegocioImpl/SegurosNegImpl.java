package NegocioImpl;

import Negocio.SegurosNeg;

import java.util.List;

import Dao.SegurosDao;
import DaoImpl.SeguroImpl;
import Entidades.Seguros;

public class SegurosNegImpl implements SegurosNeg {
	SegurosDao SegDao = new SeguroImpl();

	public boolean agregar(Seguros Seg) {
		boolean estado = false;
		if (Seg.getId() > 0 && Seg.getDescripcion().trim().length() > 0 && Seg.getTipo().getId() > 0
				&& Seg.getCostoAsegurado() > 0 && Seg.getCostoContracion() > 0) {
			estado = SegDao.agregar(Seg);
		}
		return estado;
	}

	public boolean eliminar(Seguros Seguros_eliminar) {
		return SegDao.eliminar(Seguros_eliminar);
	}

	public boolean modificar(Seguros Seguros_modificar) {
		return SegDao.modificar(Seguros_modificar);

	}

	public int obtenerUltimoID() {
		return SegDao.obtenerUltimoID();
	}

	public List<Seguros> listar() {
		return SegDao.listar();

	}

	public List<Seguros> listarPorTipo(int tipoSeguroId) {
		return SegDao.listarPorTipo(tipoSeguroId);
	}
}
