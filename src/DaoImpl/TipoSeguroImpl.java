package DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dao.TipoSegurosDao;
import Entidades.TipoSeguros;

public class TipoSeguroImpl implements TipoSegurosDao {
	private static final String listar = "SELECT * FROM tipoSeguros";
	private String agregar = "call SPAgregartipoSeguros(?, ?)";
	private String eliminar = "call SPEliminartipoSeguros(?)";
	private String modificar = "call SPModificartipoSeguros(?, ?)";
	private String Buscar = "call SPMostrartiposeguros(?)";

	@Override
	public boolean agregar(TipoSeguros tipoSeguros) {
		boolean isInsertExitoso = false;
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
				CallableStatement callst = conexion.prepareCall(agregar)) {

			callst.setInt(1, tipoSeguros.getId());
			callst.setString(2, tipoSeguros.getDescripcion());
			if (callst.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try (Connection conexion = Conexion.getConexion().getSQLConexion()) {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isInsertExitoso;
	}

	@Override
	public boolean eliminar(TipoSeguros tipoSeguros) {
		boolean isDeleteExitoso = false;
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
				CallableStatement callst = conexion.prepareCall(eliminar)) {

			callst.setInt(1, tipoSeguros.getId());
			if (callst.executeUpdate() > 0) {
				conexion.commit();
				isDeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try (Connection conexion = Conexion.getConexion().getSQLConexion()) {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isDeleteExitoso;
	}

	@Override
	public boolean modificar(TipoSeguros tipoSeguros) {
		boolean SPExitoso = false;
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
				CallableStatement callst = conexion.prepareCall(modificar)) {

			callst.setInt(1, tipoSeguros.getId());
			callst.setString(2, tipoSeguros.getDescripcion());
			if (callst.executeUpdate() > 0) {
				conexion.commit();
				SPExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try (Connection conexion = Conexion.getConexion().getSQLConexion()) {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return SPExitoso;
	}

	@Override
	public ArrayList<TipoSeguros> listar() {
		ArrayList<TipoSeguros> lSeguros = new ArrayList<>();
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
				PreparedStatement statement = conexion.prepareStatement(listar);
				ResultSet rs = statement.executeQuery()) {

			while (rs.next()) {
				TipoSeguros ts = new TipoSeguros();
				ts.setId(rs.getInt("idTipo"));
				ts.setDescripcion(rs.getString("descripcion"));
				lSeguros.add(ts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lSeguros;
	}

	@Override
	public TipoSeguros BuscarTipoSeguro(int idTipo) {
		TipoSeguros tipoSeguro = null;
		try (Connection conexion = Conexion.getConexion().getSQLConexion();
				CallableStatement callst = conexion.prepareCall(Buscar)) {

			callst.setInt(1, idTipo);
			try (ResultSet rs = callst.executeQuery()) {
				if (rs.next()) {
					String descripcion = rs.getString("Descripcion");
					tipoSeguro = new TipoSeguros(idTipo, descripcion);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try (Connection conexion = Conexion.getConexion().getSQLConexion()) {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return tipoSeguro;
	}

	@Override
	public TipoSeguros getContratacion(ResultSet rs) {
		TipoSeguros tipoSeguro = null;
		try {
			int ID = rs.getInt("ID");
			String tipoDescripcion = rs.getString("Descripcion");
			tipoSeguro = new TipoSeguros(ID, tipoDescripcion);
		} catch (SQLException e) {
			e.printStackTrace();
			try (Connection conexion = Conexion.getConexion().getSQLConexion()) {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return tipoSeguro;
	}
}
