package org.example;

import java.sql.*;
import java.util.Properties;

public class MotorSQL {
    private Connection conexion;
    private Statement sentenciaSQL;
    private ResultSet resultSet;

    public void connect(String url, Properties properties) throws SQLException {
        conexion = DriverManager.getConnection(url, properties);
        if (conexion != null) {
            System.out.println("Conectado a la base de datos!");
        }
    }

    public void disconnect() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public void ejecutarSentencia(String consulta) throws SQLException {
        sentenciaSQL = conexion.createStatement();
        resultSet = sentenciaSQL.executeQuery(consulta);
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}