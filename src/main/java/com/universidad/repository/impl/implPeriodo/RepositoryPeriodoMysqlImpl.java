package com.universidad.repository.impl.implPeriodo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryPeriodo;
import com.universidad.repository.models.Periodo;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryPeriodoMysqlImpl implements RepositoryPeriodo {

    private Connection getConnection() throws SQLException{
        return ConexionBDMysql.getInstance();
    }

    private Periodo creaPeriodo(ResultSet rs) throws SQLException {
        Periodo periodo = new Periodo();
        periodo.setId_periodo(rs.getInt("ID_PERIODO"));
        periodo.setCodigo_periodo(rs.getString("CODIGO"));
                
        return periodo;

    }


    @Override
    public List<Periodo> listar() {
        List<Periodo> listPeriodos = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PERIODO")) {
            while (rs.next()) {
                listPeriodos.add(creaPeriodo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPeriodos;
    }

    @Override
    public Periodo porSemestre(String codigo) {
        Periodo periodo = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PERIODO WHERE codigo=?")) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    periodo = creaPeriodo(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return periodo;
    }

    @Override
    public void crear(Periodo periodo) {
        String sql = "INSERT INTO PERIODO(CODIGO) VALUES(?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, periodo.getCodigo_periodo());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Periodo periodo) {
        String sql = "UPDATE PERIODO SET CODIGO=? WHERE ID_PERIODO=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, periodo.getCodigo_periodo());
            stmt.setInt(2, periodo.getId_periodo());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    
}
