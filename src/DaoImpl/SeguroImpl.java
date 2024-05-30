package DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dao.SegurosDao;
import Entidades.Seguros;

public class SeguroImpl implements SegurosDao{
	private static final String agregar = "call SPAgregarSeguros(?, ?, ?, ?, ?)";
	private static final String eliminar = "call SPEliminarSeguros(?)";
	private static final String modificar = "call SPModificarSeguros(?, ?, ?, ?, ?)";
	private static final String listar = "SELECT * FROM seguros";

	@Override
	public boolean agregar(Seguros seguros) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isInsertExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(agregar);
			callst.setInt(1, seguros.getId());
			callst.setString(2, seguros.getDescripcion());
			callst.setInt(3, seguros.getIdTipo());
			callst.setFloat(4, seguros.getCostoContracion());
			callst.setFloat(5, seguros.getCostoAsegurado());
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

	public boolean eliminar(Seguros seguros_eliminar) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean isDeleteExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(eliminar);
			callst.setInt(1, seguros_eliminar.getId());
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
	public boolean modificar(Seguros seguros_modificar) {
		Connection conexion = null;
		CallableStatement callst = null;
		boolean SPExitoso = false;
		try {
			conexion = Conexion.getConexion().getSQLConexion();
			callst = conexion.prepareCall(modificar);
			callst.setInt(1, seguros_modificar.getId());
			callst.setString(2, seguros_modificar.getDescripcion());
			callst.setInt(3, seguros_modificar.getIdTipo());
			callst.setFloat(4, seguros_modificar.getCostoContracion());
			callst.setFloat(5, seguros_modificar.getCostoAsegurado());
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
	public List<Seguros> listar() {
		PreparedStatement statement;
		ResultSet rs;
		ArrayList<Seguros> personas = new ArrayList<Seguros>();
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

	public Seguros getContratacion(ResultSet rs) throws SQLException {
		int ID = rs.getInt("ID");
		String nombre = rs.getString("Descripcion");
		int idSeguro = rs.getInt("idSeguro");
		float CostoContracion = rs.getFloat("CostoContracion");
		float CostoAsegurado = rs.getFloat("CostoAsegurado");

		return new Seguros(ID, nombre, idSeguro, CostoContracion,CostoAsegurado);
	}
	
	public int obtenerUltimoID() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		 Connection conexion = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     int ultimoID = 0;
		
	     try {
	            conexion = Conexion.getConexion().getSQLConexion();
	            statement = conexion.prepareStatement("SELECT MAX(idSeguro) as UltimoID FROM seguros");
	            rs = statement.executeQuery();
	            
	            if (rs.next()) {
	                ultimoID = rs.getInt("UltimoID");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	  
	            try {
	                if (rs != null) rs.close();
	                if (statement != null) statement.close();
	                if (conexion != null) conexion.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		return ultimoID;
	}
	
	public List<Seguros> listarPorTipo(int tipoSeguroId) {
        List<Seguros> lista = new ArrayList<>();
        ////////
        return lista;
    }
	
}
