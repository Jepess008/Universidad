package com.universidad.repository.impl.implEstudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.universidad.repository.RepositoryEstudiante;
import com.universidad.repository.models.Estudiante;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class ReposirotyEstudianteMysqlImpl implements RepositoryEstudiante {
    
    private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> listEstudiantes = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONA WHERE TIPO_PERSONA = 'ESTUDIANTE'")) {
            while (rs.next()) {
                listEstudiantes.add(crearEstudiante(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEstudiantes;

    }

    @Override
    public void crear(Estudiante estudiante, int id_direccion, int id_ciudad) {
        String sql = "INSERT INTO PERSONA(TIPO_DOCUMENTO, DOCUMENTO, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, TELEFONO, FECHA_NACIMIENTO, GENERO, ID_DIRECCION, ID_CIUDAD, TIPO_PERSONA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estudiante.getTipo_documento());
            stmt.setString(2, estudiante.getDocumento());
            stmt.setString(3, estudiante.getNombre1());
            stmt.setString(4, estudiante.getNombre2());
            stmt.setString(5, estudiante.getApellido1());
            stmt.setString(6, estudiante.getApellido2());
            stmt.setString(7, estudiante.getTelefono());
            stmt.setDate(8, java.sql.Date.valueOf(estudiante.getFecha_nacimiento()));
            stmt.setString(9, estudiante.getGenero());
            stmt.setInt(10, estudiante.getDireccion());
            stmt.setInt(11,estudiante.getCiudad() );
            stmt.setString(12,estudiante.getTipo());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private Estudiante crearEstudiante(ResultSet rs) throws SQLException {
        Estudiante estudiante = new Estudiante();
        estudiante.setId_persona(rs.getInt("ID_PERSONA"));
        estudiante.setTipo_documento(rs.getString("TIPO_DOCUMENTO"));
        estudiante.setDocumento(rs.getString("DOCUMENTO"));
        estudiante.setNombre1(rs.getString("NOMBRE1"));
        estudiante.setNombre2(rs.getString("NOMBRE2"));
        estudiante.setApellido1(rs.getString("APELLIDO1"));
        estudiante.setApellido2(rs.getString("APELLIDO2"));
        estudiante.setTelefono(rs.getString("TELEFONO"));
        estudiante.setFecha_nacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
        estudiante.setGenero(rs.getString("GENERO"));
        estudiante.setDireccion(rs.getInt("ID_DIRECCION"));
        estudiante.setCiudad(rs.getInt("ID_CIUDAD"));
        estudiante.setTipo(rs.getString("TIPO_PERSONA"));
        
        return estudiante;

    }

    @Override
    public Estudiante porDocumento(String documento) {
        Estudiante estudiante = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PERSONA WHERE TIPO_PERSONA = 'ESTUDIANTE' AND documento=?")) {
            stmt.setString(1, documento);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    estudiante = crearEstudiante(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public void editar(Estudiante estudiante) {
        String sql = "UPDATE PERSONA SET DOCUMENTO=?, NOMBRE1=?, NOMBRE2=?, APELLIDO1=?, APELLIDO2=?, TELEFONO=?, GENERO=?, ID_DIRECCION=?, ID_CIUDAD=? WHERE ID_PERSONA=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estudiante.getDocumento());
            stmt.setString(2, estudiante.getNombre1());
            stmt.setString(3, estudiante.getNombre2());
            stmt.setString(4, estudiante.getApellido1());
            stmt.setString(5, estudiante.getApellido2());
            stmt.setString(6, estudiante.getTelefono());
            stmt.setDate(7,java.sql.Date.valueOf(estudiante.getFecha_nacimiento()));
            stmt.setString(7,estudiante.getGenero());
            stmt.setInt(8, estudiante.getDireccion());
            stmt.setInt(9, estudiante.getCiudad());
            stmt.setInt(10, estudiante.getId_persona());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Estudiante estudiante) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM PERSONA WHERE ID_PERSONA=?")) {
            stmt.setInt(1, estudiante.getId_persona());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }   

}
