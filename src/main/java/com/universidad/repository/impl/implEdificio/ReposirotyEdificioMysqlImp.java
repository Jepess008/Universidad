package com.universidad.repository.impl.implEdificio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.ReposirotyEdificio;

import com.universidad.repository.models.Edificio;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class ReposirotyEdificioMysqlImp implements ReposirotyEdificio{

    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    private Edificio crearEdificio(ResultSet rs) throws SQLException {
        Edificio edificio = new Edificio();
        edificio.setId_edificio(rs.getInt("ID_EDIFICIO"));
        edificio.setNombre_edificio(rs.getString("NOMBRE"));
                
        return edificio;

    }



    @Override
    public List<Edificio> listar() {
        List<Edificio> listEdificios = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM EDIFICIO")) {
            while (rs.next()) {
                listEdificios.add(crearEdificio(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEdificios;
    }

    @Override
    public Edificio porNombre(String nombre) {
        Edificio edificio = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EDIFICIO WHERE nombre=?")) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    edificio = crearEdificio(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return edificio;
    }

    @Override
    public void crear(Edificio edificio) {
        String sql = "INSERT INTO EDIFICIO(NOMBRE) VALUES(?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, edificio.getNombre_edificio());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Edificio edificio) {
        String sql = "UPDATE EDIFICIO SET NOMBRE=? WHERE ID_EDIFICIO=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, edificio.getNombre_edificio());
            stmt.setInt(2, edificio.getId_edificio());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Edificio edificio) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM EDIFICIO WHERE ID_EDIFICIO=?")) {
            stmt.setInt(1, edificio.getId_edificio());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
}
