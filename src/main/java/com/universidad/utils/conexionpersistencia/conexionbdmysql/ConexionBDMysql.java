package com.universidad.utils.conexionpersistencia.conexionbdmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.universidad.utils.Configuracion;


public class ConexionBDMysql {
    private static String url= Configuracion.obetenerValor("db.url");
    private static String username= Configuracion.obetenerValor("db.username");
    private static String password= Configuracion.obetenerValor("db.password");
    private static Connection connection;

    public static Connection getInstance() throws SQLException{
        
        return connection = DriverManager.getConnection(url, username, password);
    }
}
