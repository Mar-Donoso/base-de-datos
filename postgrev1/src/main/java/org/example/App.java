package org.example;

import java.sql.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://postgres.c5wa80qc0pgs.us-east-1.rds.amazonaws.com/postgres";

        Properties properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "marcos2005");
        properties.setProperty("ssl", "false");

        MotorSQL motorSQL = new MotorSQL();

        try {
            motorSQL.connect(url, properties);
            String consulta = "SELECT * FROM user";
            motorSQL.ejecutarSentencia(consulta);

            ResultSet rs = motorSQL.getResultSet();
            while (rs.next()) {
                System.out.println("Hay registros!!!!");
                String name1 = rs.getString(1);
                System.out.println("Nombre=>" + name1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                motorSQL.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello World!");
    }
}
