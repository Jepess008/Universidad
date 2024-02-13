package com.universidad.repository.impl.implDocente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.universidad.repository.RepositoryDocente;
import com.universidad.repository.models.Docente;
import com.universidad.utils.conexionpersistencia.conexionbdmysql.ConexionBDMysql;

public class RepositoryDocenteMysqlImpl implements RepositoryDocente{

     private Connection getConnection() throws SQLException {
        return ConexionBDMysql.getInstance();
    }

   

    @Override
    public List<Docente> listar() {
        List<Docente> listDocentes = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONA WHERE TIPO_PERSONA = 'DOCENTE'")) {
            while (rs.next()) {
                listDocentes.add(crearDocente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDocentes;
    }

    @Override
    public Docente porDocumento(String documento) {
        Docente docente = null;

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PERSONA WHERE TIPO_PERSONA = 'DOCENTE' AND documento=?")) {
            stmt.setString(1, documento);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    docente = crearDocente(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docente;
    }

    private Docente crearDocente(ResultSet rs) throws SQLException {
        Docente docente = new Docente();
        docente.setId_persona(rs.getInt("ID_PERSONA"));
        docente.setTipo_documento(rs.getString("TIPO_DOCUMENTO"));
        docente.setDocumento(rs.getString("DOCUMENTO"));
        docente.setNombre1(rs.getString("NOMBRE1"));
        docente.setNombre2(rs.getString("NOMBRE2"));
        docente.setApellido1(rs.getString("APELLIDO1"));
        docente.setApellido2(rs.getString("APELLIDO2"));
        docente.setTelefono(rs.getString("TELEFONO"));
        docente.setFecha_nacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
        docente.setGenero(rs.getString("GENERO"));
        docente.setDireccion(rs.getInt("ID_DIRECCION"));
        docente.setCiudad(rs.getInt("ID_CIUDAD"));
        docente.setTipo(rs.getString("TIPO_PERSONA"));
        
        return docente;

    }

    @Override
    public void crear(Docente docente, int id_direccion, int id_ciudad) {
        String sql = "INSERT INTO PERSONA(TIPO_DOCUMENTO, DOCUMENTO, NOMBRE1, NOMBRE2, APELLIDO1, APELLIDO2, TELEFONO, FECHA_NACIMIENTO, GENERO, ID_DIRECCION, ID_CIUDAD, TIPO_PERSONA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, docente.getTipo_documento());
            stmt.setString(2, docente.getDocumento());
            stmt.setString(3, docente.getNombre1());
            stmt.setString(4, docente.getNombre2());
            stmt.setString(5, docente.getApellido1());
            stmt.setString(6, docente.getApellido2());
            stmt.setString(7, docente.getTelefono());
            stmt.setDate(8, java.sql.Date.valueOf(docente.getFecha_nacimiento()));
            stmt.setString(9, docente.getGenero());
            stmt.setInt(10, docente.getDireccion());
            stmt.setInt(11,docente.getCiudad() );
            stmt.setString(12,docente.getTipo());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void editar(Docente docente) {
        String sql = "UPDATE PERSONA SET DOCUMENTO=?, NOMBRE1=?, NServiceDocente.listarDocente()OMBRE2=?, APELLIDO1=?, APELLIDO2=?, TELEFONO=?, GENERO=?, ID_DIRECCION=?, ID_CIUDAD=?, TIPO_DOCUMENTO=? WHERE ID_PERSONA=?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, docente.getDocumento());
            stmt.setString(2, docente.getNombre1());
            stmt.setString(3, docente.getNombre2());
            stmt.setString(4, docente.getApellido1());
            stmt.setString(5, docente.getApellido2());
            stmt.setString(6, docente.getTelefono());
            stmt.setDate(7,java.sql.Date.valueOf(docente.getFecha_nacimiento()));
            stmt.setString(7,docente.getGenero());
            stmt.setInt(8, docente.getDireccion());
            stmt.setInt(9, docente.getCiudad());
            stmt.setString(10, docente.getTipo_documento());
            stmt.setInt(11, docente.getId_persona());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(Docente docente) {
         try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM PERSONA WHERE ID_PERSONA=?")) {
            stmt.setInt(1, docente.getId_persona());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public List<Docente> listarDocentes() {
        List<Docente> listDocentes = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PERSONA WHERE TIPO_PERSONA = 'DOCENTE'")) {
            while (rs.next()) {
                listDocentes.add(crearDocente(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDocentes;
    }  
        
    
   
}
