package com.umg.formularios;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Sistema de Facturación - Menú");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton btnClientes = new JButton("Registrar Cliente");
        btnClientes.addActionListener(e -> new FormClientes().setVisible(true));

        JButton btnEmpleados = new JButton("Registrar Empleado");
        btnEmpleados.addActionListener(e -> new FormEmpleados().setVisible(true));

        JButton btnMarcas = new JButton("Registrar Marca");
        btnMarcas.addActionListener(e -> new FormMarca().setVisible(true));

        panel.add(btnClientes);
        panel.add(btnEmpleados);
        panel.add(btnMarcas);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}