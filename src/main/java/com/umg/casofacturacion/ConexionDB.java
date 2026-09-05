package com.umg.casofacturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/facturacion_db";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "@gui$qu3Z-10";

    private static Connection conexion = null;

    private ConexionDB() {
    }

    public static Connection iniciarConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("La conexión fue creada con éxito :D");
            }
        } catch (SQLException e) {
            System.err.println("Error al momento de hacer la conexión :C");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al momento de cerrar la conexión");
            e.printStackTrace();
        }
    }

    public static ResultSet ejecutarConsulta(String sql) {
        ResultSet rs = null;
        try {
            Connection conn = iniciarConexion();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Error al momento de ejecutar la consulta");
            e.printStackTrace();
        }
        return rs;
    }

    public static boolean ejecutarInstruccion(String sql) {
        try {
            Connection conn = iniciarConexion();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Instrucción ejecutada correctamente");
            return true;
        } catch (SQLException e) {
            System.err.println("Error al momento de ejecutar la instrucción");
            e.printStackTrace();
            return false;
        }
    }
}
