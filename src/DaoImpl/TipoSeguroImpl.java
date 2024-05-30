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
	private static final String agregar = "call SPAgregartipoSeguros(?, ?)";
	private static final String eliminar = "call SPEliminartipoSeguros(?)";
	private static final String modificar = "call SPModificartipoSeguros(?, ?)";
	private static final String listar = "SELECT * FROM tipoSeguros";
	private static final String Buscar = "call SPMostrartiposeguros(?)";

	@Override
	public boolean agregar(TipoSeguros tipoSeguros) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isInsertExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(agregar);
			callst.setInt(1, tipoSeguros.getId());
			callst.setString(2, tipoSeguros.getDescripcion());
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

	public boolean eliminar(TipoSeguros tipoSeguros) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isDeleteExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(eliminar);
			callst.setInt(1, tipoSeguros.getId());
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
	public boolean modificar(TipoSeguros tipoSeguros) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean SPExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(modificar);
			callst.setInt(1, tipoSeguros.getId());
			callst.setString(2, tipoSeguros.getDescripcion());
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
	public ArrayList<TipoSeguros> listar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		PreparedStatement statement;
		ResultSet rs;
		ArrayList<TipoSeguros> lSeguros = new ArrayList<TipoSeguros>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(listar);
			rs = statement.executeQuery();
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
		int id=idTipo;
		String descripcion=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection conexion = null;
		CallableStatement callst = null;
		boolean SPExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(Buscar);
			callst.setInt(1, idTipo);
			if (callst.executeUpdate() > 0) {
				
				descripcion=callst.getString("Descripcion");
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
		return new TipoSeguros(id,descripcion);
	}
	@Override
	public TipoSeguros getContratacion(ResultSet rs) {
		int ID = 0;
		try {
			ID = rs.getInt("ID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tipoSeguro = null;
		try {
			tipoSeguro = rs.getString("Descripcion");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new TipoSeguros(ID, tipoSeguro);
	}
}
