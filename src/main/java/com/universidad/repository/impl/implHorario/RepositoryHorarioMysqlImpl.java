package com.universidad.repository.impl.implHorario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryHorario;
import com.universidad.repository.models.Horario;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryHorarioMysqlImpl implements RepositoryHorario {

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    private Horario crearHorario(ResultSet rs) throws SQLException {
        Horario horario = new Horario();
        horario.setId_horario(rs.getInt("ID_HORARIO"));
        horario.setDia(rs.getString("DIA"));
        horario.setInicio(rs.getString("INICIO"));
        horario.setFin(rs.getString("FINAL"));
        horario.setId_salon(rs.getInt("ID_SALON"));
        horario.setId_asignatura(rs.getInt("ID_ASIGNATURA"));
        return horario;

    }

    @Override
    public List<Horario> listar() {
        List<Horario> listHorarios = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM HORARIO")) {
            while (rs.next()) {
                listHorarios.add(crearHorario(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHorarios;
    }

    @Override
    public void crear(Horario horario, int id_asignatura, int id_salon) {
        String sql = "INSERT INTO HORARIO(DIA, INICIO, FINAL,ID_SALON, ID_ASIGNATURA) VALUES(?,?,?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, horario.getDia());
            stmt.setString(2, horario.getInicio());
            stmt.setString(3, horario.getFin());
            stmt.setInt(4, horario.getId_salon());
            stmt.setInt(5, horario.getId_asignatura());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



   
    
}
