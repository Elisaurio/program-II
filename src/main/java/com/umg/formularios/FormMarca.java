package com.umg.formularios;

import com.umg.casofacturacion.Marca;
import com.umg.edu.DAO.MarcaDAO;

import javax.swing.*;
import java.awt.*;

public class FormMarca extends JFrame {

    private JTextField txtNombre;
    private final MarcaDAO marcaDAO = new MarcaDAO();

    public FormMarca() {
        setTitle("Registro de Marcas");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarMarca());
        panel.add(btnGuardar);

        add(panel);
    }

    private void guardarMarca() {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio.");
            return;
        }

        boolean exito = marcaDAO.insertar(new Marca(0, nombre));
        JOptionPane.showMessageDialog(this, exito ? "Marca guardada con éxito." : "Error al guardar la marca.");
        if (exito) txtNombre.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormMarca().setVisible(true));
    }
}