package NegocioImpl;

import java.util.List;

import Entidades.Contratacion;
import Dao.ContratacionDao;
import DaoImpl.ContratacionImpl;
import Negocio.ContratacionNeg;

public class ContratacionNegImpl implements ContratacionNeg {
	ContratacionDao contDao=new ContratacionImpl();
	
	public boolean agregar(Contratacion da) {
		boolean estado=false;
		if(da.getID() > 0 && da.getNombre().trim().length() >0 && da.getIDSeguro() > 0)
		{
			estado=contDao.agregar(da);
		}
		return estado;
	}

	public boolean eliminar(Contratacion Contratacion_eliminar) {
		
		return contDao.eliminar(Contratacion_eliminar);
	}

	public boolean modificar(Contratacion Contratacion_modificar) {
		return contDao.modificar(Contratacion_modificar);
	}

	public List<Contratacion> listar(){
		return contDao.listar();
	}
}
