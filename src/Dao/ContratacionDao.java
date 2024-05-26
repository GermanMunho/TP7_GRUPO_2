package Dao;

import java.util.List;
import Entidades.Contratacion;

public interface ContratacionDao {
	public boolean agregar(Contratacion Contratacion);

	public boolean eliminar(Contratacion Contratacion_eliminar);

	public boolean modificar(Contratacion Contratacion_modificar);

	public List<Contratacion> listar();
}
