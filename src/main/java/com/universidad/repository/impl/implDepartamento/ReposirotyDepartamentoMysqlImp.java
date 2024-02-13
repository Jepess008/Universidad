package com.universidad.repository.impl.implDepartamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryDepartamento;
import com.universidad.repository.models.Departamento;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class ReposirotyDepartamentoMysqlImp implements RepositoryDepartamento {

     private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    private Departamento crearDepartamento(ResultSet rs) throws SQLException {
        Departamento departamento = new Departamento();
        departamento.setId_departamento(rs.getInt("ID_DEPARTAMENTO"));
        departamento.setNombre_departamento(rs.getString("NOMBRE"));
                
        return departamento;

    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> listDepartamentos = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTAMENTO")) {
            while (rs.next()) {
                listDepartamentos.add(crearDepartamento(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDepartamentos;
    }

    @Override
    public Departamento porNombre(String nombre) {
       Departamento departamento = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM DEPARTAMENTO WHERE nombre=?")) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    departamento = crearDepartamento(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento;
    }

    @Override
    public void crear(Departamento departamento) {
        String sql = "INSERT INTO DEPARTAMENTO(NOMBRE) VALUES(?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, departamento.getNombre_departamento());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Departamento departamento) {
        String sql = "UPDATE DEPARTAMENTO SET NOMBRE=? WHERE ID_DEPARTAMENTO=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, departamento.getNombre_departamento());
            stmt.setInt(2, departamento.getId_departamento());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Departamento departamento) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM DEPARTAMENTO WHERE ID_DEPARTAMENTO=?")) {
            stmt.setInt(1, departamento.getId_departamento());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
