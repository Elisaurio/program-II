package com.umg.edu.DAO;

import com.umg.casofacturacion.Marca;
import com.umg.casofacturacion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO {

    public boolean insertar(Marca marca) {
        String sql = "INSERT INTO marcas (nombre) VALUES (?)";
        try {
            Connection conn = ConexionDB.iniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, marca.getNombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar marca");
            e.printStackTrace();
            return false;
        }
    }

    public List<Marca> listar() {
        List<Marca> marcas = new ArrayList<>();
        String sql = "SELECT id_marca, nombre FROM marcas";
        try {
            Connection conn = ConexionDB.iniciarConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                marcas.add(new Marca(rs.getInt("id_marca"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar marcas");
            e.printStackTrace();
        }
        return marcas;
    }
}