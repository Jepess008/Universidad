package com.universidad.repository.impl.implSalon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositorySalon;
import com.universidad.repository.models.Salon;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositorySalonMysqlImpl implements RepositorySalon{

    private Connection getConnection() throws SQLException{
        return ConexionBDMysql.getInstance();
    }

    private Salon crearSalon(ResultSet rs) throws SQLException {
        Salon salon = new Salon();
        salon.setId_salon(rs.getInt("ID_SALON"));
        salon.setCupo(rs.getInt("CUPO"));
        salon.setId_edificio(rs.getInt("ID_EDIFICIO"));
        salon.setPiso(rs.getInt("ID_PISO"));
        salon.setSerial_salon(rs.getString("SERIAL_SALON"));        
        return salon;

    }

    @Override
    public List<Salon> listar() {
        List<Salon> listSalones = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM SALON")) {
            while (rs.next()) {
                listSalones.add(crearSalon(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSalones;
    }

    @Override
    public Salon porSalon(String serial_salon) {
        Salon salon = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SALON WHERE serial_salon=?")) {
            stmt.setString(1, serial_salon);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    salon = crearSalon(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salon;
    }

    @Override
    public void crear(Salon salon, int id_edificio) {
        String sql = "INSERT INTO SALON(CUPO,ID_EDIFICIO,ID_PISO,SERIAL_SALON) VALUES(?,?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salon.getCupo());
            stmt.setInt(2, salon.getId_edificio());
            stmt.setInt(3, salon.getPiso());
            stmt.setString(4, salon.getSerial_salon());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Salon salon) {
        String sql = "UPDATE SALON SET CUPO=? WHERE ID_SALON= ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, salon.getCupo());
            stmt.setInt(2, salon.getId_salon());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Salon salon) {
         try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM SALON WHERE ID_SALON=?")) {
            stmt.setInt(1, salon.getId_salon());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Salon> listarHorarios() {
        List<Salon> listSalones = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM SALON")) {
            while (rs.next()) {
                listSalones.add(crearSalon(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSalones;
    }
    

}
