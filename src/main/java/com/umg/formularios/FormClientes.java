package com.umg.formularios;

import com.umg.casofacturacion.Cliente;
import com.umg.edu.DAO.ClienteDAO;

import javax.swing.*;
import java.awt.*;

public class FormClientes extends JFrame {

    private JTextField txtNit, txtNombre, txtApellidos, txtEmail;
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public FormClientes() {
        setTitle("Registro de Clientes");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        panel.add(new JLabel("NIT:"));
        txtNit = new JTextField();
        panel.add(txtNit);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panel.add(txtApellidos);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarCliente());
        panel.add(btnGuardar);

        add(panel);
    }

    private void guardarCliente() {
        String nombre = txtNombre.getText().trim();
        String apellidos = txtApellidos.getText().trim();

        if (nombre.isEmpty() || apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y apellidos son obligatorios.");
            return;
        }

        Cliente cliente = new Cliente(0, nombre, apellidos, txtNit.getText().trim(), txtEmail.getText().trim());
        boolean exito = clienteDAO.insertar(cliente);

        JOptionPane.showMessageDialog(this, exito ? "Cliente guardado con éxito." : "Error al guardar el cliente.");
        if (exito) limpiarCampos();
    }

    private void limpiarCampos() {
        txtNit.setText(""); txtNombre.setText(""); txtApellidos.setText(""); txtEmail.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormClientes().setVisible(true));
    }
}