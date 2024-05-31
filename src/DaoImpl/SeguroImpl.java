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

public class SeguroImpl implements SegurosDao {
    private static final String agregar = "call SPAgregarSeguros(?, ?, ?, ?, ?)";
    private static final String eliminar = "call SPEliminarSeguros(?)";
    private static final String modificar = "call SPModificarSeguros(?, ?, ?, ?, ?)";
    private static final String listar = "call SPMostrarSeguros()";

    @Override
    public boolean agregar(Seguros seguros) {
        boolean isInsertExitoso = false;
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             CallableStatement callst = conexion.prepareCall(agregar)) {
             
            callst.setInt(1, seguros.getId());
            callst.setString(2, seguros.getDescripcion());
            callst.setInt(3, seguros.getTipo().getId());
            callst.setFloat(4, seguros.getCostoContracion());
            callst.setFloat(5, seguros.getCostoAsegurado());
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
    public boolean eliminar(Seguros seguros_eliminar) {
        boolean isDeleteExitoso = false;
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             CallableStatement callst = conexion.prepareCall(eliminar)) {
             
            callst.setInt(1, seguros_eliminar.getId());
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
    public boolean modificar(Seguros seguros_modificar) {
        boolean SPExitoso = false;
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             CallableStatement callst = conexion.prepareCall(modificar)) {
             
            callst.setInt(1, seguros_modificar.getId());
            callst.setString(2, seguros_modificar.getDescripcion());
            callst.setInt(3, seguros_modificar.getTipo().getId());
            callst.setFloat(4, seguros_modificar.getCostoContracion());
            callst.setFloat(5, seguros_modificar.getCostoAsegurado());
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
    public List<Seguros> listar() {
        List<Seguros> seguros = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             CallableStatement statement = conexion.prepareCall(listar);
             ResultSet rs = statement.executeQuery()) {
             
            while (rs.next()) {
                seguros.add(getContratacion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conexion = Conexion.getConexion().getSQLConexion()) {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return seguros;
    }

    public Seguros getContratacion(ResultSet rs) throws SQLException {
        int ID = rs.getInt("ID");
        String nombre = rs.getString("Descripcion");
        int Idtipo = rs.getInt("Idtipo");
        String Descripcion = rs.getString("TP.descripcion");
        float CostoContracion = rs.getFloat("CostoContracion");
        float CostoAsegurado = rs.getFloat("CostoAsegurado");

        return new Seguros(ID, nombre, Idtipo, Descripcion, CostoContracion, CostoAsegurado);
    }

    @Override
    public int obtenerUltimoID() {
        int ultimoID = 0;
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             PreparedStatement statement = conexion.prepareStatement("SELECT MAX(idSeguro) as UltimoID FROM seguros");
             ResultSet rs = statement.executeQuery()) {
             
            if (rs.next()) {
                ultimoID = rs.getInt("UltimoID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ultimoID;
    }

    @Override
    public List<Seguros> listarPorTipo(int tipoSeguroId) {
        List<Seguros> seguros = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion().getSQLConexion();
             CallableStatement statement = conexion.prepareCall(listar);
             ResultSet rs = statement.executeQuery()) {
             
            while (rs.next()) {
                seguros.add(getContratacion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seguros;
    }
}
