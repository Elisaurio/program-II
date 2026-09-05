package com.umg.casofacturacion;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CasoFacturacion {

    // Consulta la tabla empleados, instancia objetos Empleado y los devuelve
    public static List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT id_empleado, id_puesto, nombre, apellidos, fecha_contratacion FROM empleados";
        ResultSet rs = ConexionDB.ejecutarConsulta(sql);

        try {
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("id_empleado");
                    int idPuesto = rs.getInt("id_puesto");
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    Date fecha = rs.getDate("fecha_contratacion");

                    Empleado empleado = new Empleado(id, nombre, apellidos, idPuesto, fecha);
                    empleados.add(empleado);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer los resultados de empleados");
            e.printStackTrace();
        }

        return empleados;
    }

    public static void main(String[] args) {
        ConexionDB.iniciarConexion();

        System.out.println("---- Empleados registrados ----");
        List<Empleado> empleados = obtenerEmpleados();

        for (Empleado e : empleados) {
            System.out.println(e.describir());
        }

        // Demostración de Herencia + Polimorfismo:
        // Una lista de Persona puede contener tanto Cliente como Empleado.
        System.out.println("\n---- Demostración de polimorfismo (Persona) ----");
        List<Persona> personas = new ArrayList<>(empleados);
        personas.add(new Cliente(0, "Cliente", "DePrueba", "0000000-0", "prueba@correo.com"));

        for (Persona p : personas) {
            System.out.println(p.describir());
        }

        ConexionDB.cerrarConexion();
    }
}
