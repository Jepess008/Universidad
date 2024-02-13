package com.universidad.repository.impl.implTarifas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryTarifas;
import com.universidad.repository.models.Tarifas;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;


public class RepositoryTarifasMysqlImpl implements RepositoryTarifas {

    private Connection getConnection() throws SQLException{
        return ConexionBDMysql.getInstance();
    }
    

     private Tarifas crearTarifa(ResultSet rs) throws SQLException {
        Tarifas tarifas = new Tarifas();
        tarifas.setId_tarifas(rs.getInt("ID_TARIFAS"));
        tarifas.setId_periodo(rs.getInt("ID_PERIODO"));
        tarifas.setId_programa(rs.getInt("ID_PROGRAMA"));
        tarifas.setValor_credito(rs.getInt("VALOR"));
        return tarifas;

    }

    @Override
    public List<Tarifas> listar() {
        List<Tarifas> listTarifas = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM TARIFAS")) {
            while (rs.next()) {
                listTarifas.add(crearTarifa(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTarifas;
    }

    @Override
    public Tarifas porIdTarifas(int id_tarifas) {
        Tarifas tarifa = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TARIFAS WHERE ID_TARIFAS=?")) {
            stmt.setInt(1, id_tarifas);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tarifa = crearTarifa(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarifa;
    }

    @Override
    public void crear(Tarifas tarifa, int id_periodo, int id_programa) {
        String sql = "INSERT INTO TARIFAS(ID_PERIODO,ID_PROGRAMA,VALOR) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tarifa.getId_periodo());
            stmt.setInt(2, tarifa.getId_programa());
            stmt.setInt(3, tarifa.getValor_credito());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Tarifas tarifa) {
        String sql = "UPDATE TARIFAS SET VALOR=? WHERE ID_TARIFAS= ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tarifa.getValor_credito());
            stmt.setInt(2, tarifa.getId_tarifas());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Tarifas tarifa) {
          try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM TARIFAS WHERE ID_TARIFAS=?")) {
            stmt.setInt(1, tarifa.getId_tarifas());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
