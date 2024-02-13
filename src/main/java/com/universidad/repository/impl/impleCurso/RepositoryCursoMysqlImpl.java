package com.universidad.repository.impl.impleCurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryCurso;
import com.universidad.repository.models.Curso;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryCursoMysqlImpl implements RepositoryCurso {

    private Connection getConnection() throws SQLException{
        return ConexionBDMysql.getInstance();
    }

    private Curso crearCurso(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        curso.setId_curso(rs.getInt("ID_CURSO"));
        curso.setNombre_curso(rs.getString("NOMBRE"));
        curso.setGuia_catedra(rs.getString("GUIA_CATEDRA"));
        curso.setCodigo_curso(rs.getString("CODIGO"));
                
        return curso;

    }



    @Override
    public List<Curso> listar() {
        List<Curso> listCursos = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM CURSO")) {
            while (rs.next()) {
                listCursos.add(crearCurso(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCursos;
    }

    @Override
    public Curso porCodigo(String codigo) {
        Curso curso = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CURSO WHERE codigo=?")) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    curso = crearCurso(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public void crear(Curso curso) {
        String sql = "INSERT INTO CURSO(NOMBRE,GUIA_CATEDRA,CODIGO) VALUES(?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getGuia_catedra());
            stmt.setString(3, curso.getCodigo_curso());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Curso curso) {
        String sql = "UPDATE CURSO SET NOMBRE=?,GUIA_CATEDRA=?,CODIGO=? WHERE ID_CURSO=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombre_curso());
            stmt.setString(2, curso.getGuia_catedra());
            stmt.setString(3, curso.getCodigo_curso());
            stmt.setInt(4, curso.getId_curso());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Curso curso) {
          try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM CURSO WHERE ID_CURSO=?")) {
            stmt.setInt(1, curso.getId_curso());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Curso> listaCursos() {
         List<Curso> listCursos = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM CURSO")) {
            while (rs.next()) {
                listCursos.add(crearCurso(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCursos;
    }
    
    
}
