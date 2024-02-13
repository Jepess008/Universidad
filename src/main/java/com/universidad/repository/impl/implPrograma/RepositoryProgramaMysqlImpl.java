package com.universidad.repository.impl.implPrograma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryPrograma;
import com.universidad.repository.models.Programa;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryProgramaMysqlImpl implements RepositoryPrograma {

    private Connection getConnection() throws SQLException{
        return ConexionBDMysql.getInstance();
    }

    private Programa crearPrograma(ResultSet rs) throws SQLException {
        Programa programa = new Programa();
        programa.setId_programa(rs.getInt("ID_PROGRAMA"));
        programa.setNombre_programa(rs.getString("NOMBRE"));
        programa.setNivel(rs.getString("NIVEL"));
        programa.setCodigo_programa(rs.getString("CODIGO"));        
        return programa;

    }


    @Override
    public List<Programa> listar() {
        List<Programa> listProgramas = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PROGRAMA")) {
            while (rs.next()) {
                listProgramas.add(crearPrograma(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProgramas;
    }

    

    @Override
    public Programa porCodigo(String codigo) {
         Programa programa = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PROGRAMA WHERE codigo=?")) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    programa = crearPrograma(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programa;
    }

    @Override
    public void crear(Programa programa) {
        String sql = "INSERT INTO PROGRAMA(NOMBRE, NIVEL, CODIGO) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, programa.getNombre_programa());
            stmt.setString(2, programa.getNivel());
            stmt.setString(3, programa.getCodigo_programa());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Programa programa) {
        String sql = "UPDATE PROGRAMA SET NOMBRE=?, NIVEL=?, CODIGO=? WHERE ID_PROGRAMA=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, programa.getNombre_programa());
            stmt.setString(2, programa.getNivel());
            stmt.setString(3, programa.getCodigo_programa());
            stmt.setInt(4, programa.getId_programa());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Programa programa) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM PROGRAMA WHERE ID_PROGRAMA=?")) {
            stmt.setInt(1, programa.getId_programa());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Programa> listaProgramas() {
       List<Programa> listProgramas = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PROGRAMA")) {
            while (rs.next()) {
                listProgramas.add(crearPrograma(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProgramas;
    }
    
}
