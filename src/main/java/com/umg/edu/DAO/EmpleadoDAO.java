package com.umg.edu.DAO;

import com.umg.casofacturacion.Empleado;
import com.umg.casofacturacion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public boolean insertar(Empleado empleado) {
        String sql = "INSERT INTO empleados (id_puesto, nombre, apellidos, fecha_contratacion) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = ConexionDB.iniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empleado.getIdPuesto());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellidos());
            ps.setDate(4, empleado.getFechaContratacion());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar empleado");
            e.printStackTrace();
            return false;
        }
    }

    public List<Empleado> listar() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT id_empleado, id_puesto, nombre, apellidos, fecha_contratacion FROM empleados";
        try {
            Connection conn = ConexionDB.iniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empleados.add(new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("id_puesto"),
                        rs.getDate("fecha_contratacion")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar empleados");
            e.printStackTrace();
        }
        return empleados;
    }
}