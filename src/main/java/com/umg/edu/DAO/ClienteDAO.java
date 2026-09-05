package com.umg.edu.DAO;

import com.umg.casofacturacion.Cliente;
import com.umg.casofacturacion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nit, nombre, apellidos, email) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = ConexionDB.iniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar cliente");
            e.printStackTrace();
            return false;
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, nit, nombre, apellidos, email FROM clientes";
        try {
            Connection conn = ConexionDB.iniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("nit"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes");
            e.printStackTrace();
        }
        return clientes;
    }
}