package DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dao.ContratacionDao;
import Entidades.Contratacion;

public class ContratacionImpl implements ContratacionDao {
	private static final String agregar = "call SPAgregarContratacion(?, ?, ?, ?)";
	private static final String eliminar = "call SPEliminarContratacion(?)";
	private static final String modificar = "call SPModificarContratacion(?, ?, ?, ?)";
	private static final String listar = "SELECT * FROM contratacion";

	@Override
	public boolean agregar(Contratacion contratacion) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isInsertExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(agregar);
			callst.setInt(1, contratacion.getID());
			callst.setString(2, contratacion.getNombre());
			callst.setInt(3, contratacion.getIDSeguro());
			callst.setFloat(4, contratacion.getCosto());
			if (callst.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isInsertExitoso;
	}

	@Override

	public boolean eliminar(Contratacion contratacion_eliminar) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isDeleteExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(eliminar);
			callst.setInt(1, contratacion_eliminar.getID());
			if (callst.executeUpdate() > 0) {
				conexion.commit();
				isDeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isDeleteExitoso;

	}

	@Override
	public boolean modificar(Contratacion contratacion_modificar) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean SPExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(modificar);
			callst.setInt(1, contratacion_modificar.getID());
			callst.setInt(2, contratacion_modificar.getIDSeguro());
			callst.setString(3, contratacion_modificar.getNombre());
			callst.setFloat(4, contratacion_modificar.getCosto());
			if (callst.executeUpdate() > 0) {
				conexion.commit();
				SPExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (conexion != null) {
					conexion.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return SPExitoso;
	}

	@Override
	public List<Contratacion> listar() {
		PreparedStatement statement;
		ResultSet rs;
		ArrayList<Contratacion> personas = new ArrayList<Contratacion>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(listar);
			rs = statement.executeQuery();
			while (rs.next()) {
				personas.add(getContratacion(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;

	}

	public Contratacion getContratacion(ResultSet rs) throws SQLException {
		int ID = rs.getInt("ID");
		String nombre = rs.getString("Nombre");
		int idSeguro = rs.getInt("idSeguro");
		float Costo = rs.getFloat("Costo");
		return new Contratacion(ID, nombre, idSeguro, Costo);
	}
}
