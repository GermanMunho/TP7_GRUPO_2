package DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.UsuariosDao;
import Entidades.Usuarios;;

public class UsuariosImpl implements UsuariosDao {
	private static final String agregar = "call SPAgregarUsuarios(?, ?, ?, ?, ?, ?)";
	private static final String eliminar = "call SPEliminarUsuarios(?)";
	private static final String modificar = "call SPModificarUsuarios(?, ?, ?, ?, ?, ?)";
	private static final String listar = "SELECT * FROM Usuarios";

	@Override
	public boolean agregar(Usuarios Usuarios) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isInsertExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(agregar);
			callst.setString(1, Usuarios.getDni());
			callst.setString(2, Usuarios.getNombre());
			callst.setString(3, Usuarios.getApellido());
			callst.setString(4, Usuarios.getNombreUsuario());
			callst.setInt(5, Usuarios.getTipoUsuario());
			callst.setString(6, Usuarios.getPass());

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

	public boolean eliminar(Usuarios Usuarios) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isDeleteExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(eliminar);
			callst.setString(1, Usuarios.getDni());
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
	public boolean modificar(Usuarios Usuarios) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean SPExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(modificar);
			callst.setString(1, Usuarios.getDni());
			callst.setString(2, Usuarios.getNombre());
			callst.setString(3, Usuarios.getApellido());
			callst.setString(4, Usuarios.getNombreUsuario());
			callst.setInt(5, Usuarios.getTipoUsuario());
			callst.setString(6, Usuarios.getPass());
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
	public List<Usuarios> listar() {
		PreparedStatement statement;
		ResultSet rs;
		ArrayList<Usuarios> personas = new ArrayList<Usuarios>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(listar);
			rs = statement.executeQuery();
			while (rs.next()) {
				personas.add(getUsuarios(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;

	}

	public Usuarios getUsuarios(ResultSet rs) throws SQLException {
		String nombreUsuario = rs.getString("nombreUsuario");
		String pass = rs.getString("pass");
		String dni = rs.getString("dni");
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		int tipoUsuario = rs.getInt("tipoUsuario");
		return new Usuarios(tipoUsuario, nombreUsuario, pass, dni, nombre, apellido);
	}
}
