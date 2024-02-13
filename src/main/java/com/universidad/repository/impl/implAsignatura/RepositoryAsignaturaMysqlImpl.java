package com.universidad.repository.impl.implAsignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryAsignatura;
import com.universidad.repository.models.Asignatura;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryAsignaturaMysqlImpl implements RepositoryAsignatura {

    private Connection getConnection() throws SQLException{
        return ConexionBDMysql.getInstance();
    }

     private Asignatura crearAsignatura(ResultSet rs) throws SQLException {
        Asignatura asignatura = new Asignatura();
        asignatura.setId_asignatura(rs.getInt("ID_ASIGNATURA"));
        asignatura.setNombre_asignatura(rs.getString("NOMBRE"));
        asignatura.setCreditos(rs.getInt("CREDITOS"));
        asignatura.setId_docente(rs.getInt("ID_DOCENTE"));
        asignatura.setId_programa(rs.getInt("ID_PROGRAMA"));
        asignatura.setId_curso(rs.getInt("ID_CURSO"));
        asignatura.setId_periodo(rs.getInt("ID_PERIODO"));
                
        return asignatura;

    }



    @Override
    public List<Asignatura> listar() {
        List<Asignatura> listAsignaturas = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ASIGNATURA")) {
            while (rs.next()) {
                listAsignaturas.add(crearAsignatura(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAsignaturas;
    }

    @Override
    public Asignatura porIdAsignatura(int id_asignatura) {
       Asignatura asignatura = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ASIGNATURA WHERE ID_ASIGNATURA=?")) {
            stmt.setInt(1, id_asignatura);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    asignatura = crearAsignatura(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignatura;
    }

    @Override
    public void crear(Asignatura asignatura, int id_docente, int id_programa, int id_curso, int id_periodo) {
        String sql = "INSERT INTO ASIGNATURA(NOMBRE,CREDITOS,ID_DOCENTE,ID_PROGRAMA,ID_CURSO,ID_PERIODO) VALUES(?,?,?,?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, asignatura.getNombre_asignatura());
            stmt.setInt(2, asignatura.getCreditos());
            stmt.setInt(3, asignatura.getId_docente());
            stmt.setInt(4, asignatura.getId_programa());
            stmt.setInt(5, asignatura.getId_curso());
            stmt.setInt(6, asignatura.getId_periodo());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Asignatura asignatura) {
        String sql = "UPDATE ASIGNATURA SET NOMBRE=?, CREDITOS=?, ID_DOCENTE=? WHERE ID_ASIGNATURA=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, asignatura.getNombre_asignatura());
            stmt.setInt(2, asignatura.getCreditos());
            stmt.setInt(3, asignatura.getId_docente());
            stmt.setInt(4, asignatura.getId_asignatura());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Asignatura asignatura) {
         try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM ASIGNATURA WHERE ID_ASIGNATURA=?")) {
            stmt.setInt(1, asignatura.getId_asignatura());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
