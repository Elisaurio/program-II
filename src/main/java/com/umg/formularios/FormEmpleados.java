package com.umg.formularios;

import com.umg.casofacturacion.Empleado;
import com.umg.edu.DAO.EmpleadoDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class FormEmpleados extends JFrame {

    private JTextField txtIdPuesto, txtNombre, txtApellidos, txtFecha;
    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public FormEmpleados() {
        setTitle("Registro de Empleados");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        panel.add(new JLabel("ID Puesto:"));
        txtIdPuesto = new JTextField();
        panel.add(txtIdPuesto);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField();
        panel.add(txtApellidos);

        panel.add(new JLabel("Fecha (yyyy-MM-dd):"));
        txtFecha = new JTextField();
        panel.add(txtFecha);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarEmpleado());
        panel.add(btnGuardar);

        add(panel);
    }

    private void guardarEmpleado() {
        try {
            int idPuesto = Integer.parseInt(txtIdPuesto.getText().trim());
            String nombre = txtNombre.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            Date fecha = Date.valueOf(txtFecha.getText().trim());

            if (nombre.isEmpty() || apellidos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre y apellidos son obligatorios.");
                return;
            }

            boolean exito = empleadoDAO.insertar(new Empleado(0, nombre, apellidos, idPuesto, fecha));
            JOptionPane.showMessageDialog(this, exito ? "Empleado guardado con éxito." : "Error al guardar el empleado.");
            if (exito) limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de puesto debe ser un número.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener el formato yyyy-MM-dd.");
        }
    }

    private void limpiarCampos() {
        txtIdPuesto.setText(""); txtNombre.setText(""); txtApellidos.setText(""); txtFecha.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormEmpleados().setVisible(true));
    }
}