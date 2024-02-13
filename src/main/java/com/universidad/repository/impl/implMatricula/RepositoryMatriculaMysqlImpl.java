package com.universidad.repository.impl.implMatricula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryMatricula;
import com.universidad.repository.models.Matricula;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryMatriculaMysqlImpl implements RepositoryMatricula {

    private Connection getConnection() throws SQLException{
        return ConexionBDMysql.getInstance();
    }

    private Matricula crearMatricula(ResultSet rs) throws SQLException {
        Matricula matricula = new Matricula();
        matricula.setId_matricula(rs.getInt("ID_MATRICULA"));
        matricula.setId_estudiante(rs.getInt("ID_ESTUDIANTE"));
        matricula.setId_asignatura(rs.getInt("ID_ASIGNATURA"));
        matricula.setId_periodo(rs.getInt("ID_PERIODO"));
                
        return matricula;

    }

    @Override
    public List<Matricula> listar() {
         List<Matricula> listMatriculas = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM MATRICULA")) {
            while (rs.next()) {
                listMatriculas.add(crearMatricula(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMatriculas;
    }

    @Override
    public void matricular(Matricula matricula) {
        String sql = "INSERT INTO MATRICULA(ID_ESTUDIANNTE,ID_ASIGNATURA,ID_PERIODO) VALUES(?,?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula.getId_estudiante());
            stmt.setInt(2, matricula.getId_asignatura());
            stmt.setInt(3, matricula.getId_periodo());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
